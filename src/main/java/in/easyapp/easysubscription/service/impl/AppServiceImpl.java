package in.easyapp.easysubscription.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.license4j.License;

import in.easyapp.easysubscription.exception.DataNotFoundException;
import in.easyapp.easysubscription.exception.LicenceException;
import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.models.ProjectRequestMdl;
import in.easyapp.easysubscription.models.ServiceSubscriptionMdl;
import in.easyapp.easysubscription.repository.AppRepository;
import in.easyapp.easysubscription.repository.ServiceSubRepository;
import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.response.ProjectResponse;
import in.easyapp.easysubscription.response.ServiceSubscriptionResponse;
import in.easyapp.easysubscription.service.AppService;
import in.easyapp.easysubscription.util.Licence4jUtil;

@Service
public class AppServiceImpl implements AppService {
	
	@Autowired
	private AppRepository appRepository;
	
	@Autowired
	private ServiceSubRepository serviceSubRepository;

	@Override
	public ProjectResponse createApp(ProjectRequest app) throws RequestException {
		if(app == null) {
			throw new RequestException("Invalid app request");
		}
		List<ServiceSubscriptionMdl> services  = new ArrayList<ServiceSubscriptionMdl>();
		for(ServiceSubscriptionRequest req : app.getServices()) {
			services.add(new ServiceSubscriptionMdl(req));
		}
		ProjectRequestMdl mdl = appRepository.save(new ProjectRequestMdl(app));
		return new ProjectResponse(mdl);
	}

	@Override
	public List<ProjectResponse> getApps(String createdBy) throws RequestException {
		if(createdBy == null || createdBy.isEmpty()) {
			List<ProjectRequestMdl> list = appRepository.findAll();
			return convertMdlToResp(list);
		}
		List<ProjectRequestMdl> list = appRepository.findAllByCreatedBy(createdBy);
		return  convertMdlToResp(list);
		
	}

	private List<ProjectResponse> convertMdlToResp(List<ProjectRequestMdl> list) throws RequestException {
		if(list==null ||!list.isEmpty()) {
			throw new RequestException("App details not found");
		}
		List<ProjectResponse> resps = new ArrayList<ProjectResponse>();
		for(ProjectRequestMdl mdl : list) {
			resps.add(new ProjectResponse(mdl));
		}
		return resps;
	}

	@Override
	public ProjectResponse getProjectById(String appId) throws RequestException {
		if(appId == null || appId.isEmpty()) {
			throw new RequestException("Invalid App ids");
		}
		ProjectRequestMdl mdl  = appRepository.findByAppId(appId);
		if(mdl == null) {
			throw new RequestException("Project not found by this id : "+appId);
		}
		return new ProjectResponse(mdl);
	}
	
	// TO DO  -  appid and serviceId do required 
	
	
	@Override
	public ServiceSubscriptionResponse subscribeServiceForAppId(String appId, String serviceId,
			ServiceSubscriptionRequest subcn) throws RequestException, LicenceException {
		if(appId == null || appId.isEmpty()||serviceId == null || serviceId.isEmpty()|| subcn ==null) {
			throw new RequestException("Invalid request");
		}
		
		License validate = Licence4jUtil.validate(PUBLIC_KEY, subcn.getSubscriptionPlan(), subcn.getServiceId());
		
		if(validate == null || validate.getActivationStatus().equals(IN_VALID)) {
			throw new LicenceException("Invalid License details");
		}
		ServiceSubscriptionMdl mdl = serviceSubRepository.save(new ServiceSubscriptionMdl(subcn,validate.getLicenseKey().getTheKey()));
		return new ServiceSubscriptionResponse(mdl);
	}

	@Override
	public List<ServiceSubscriptionResponse> getServiceForAppId(String appId) throws RequestException, DataNotFoundException {
		if(appId == null || appId.isEmpty()) {
			throw new RequestException("Invalid App");
		}
		List<ServiceSubscriptionMdl> mdl = serviceSubRepository.findAllByAppId(appId);
		if(mdl == null || mdl.isEmpty()) {
			throw new DataNotFoundException("Data not found in database.");
		}
		List<ServiceSubscriptionResponse> res  =  new ArrayList<ServiceSubscriptionResponse>();
		for(ServiceSubscriptionMdl serviceSub : mdl) {
			res.add(new ServiceSubscriptionResponse(serviceSub));
		}
		return null;
	}

	@Override
	public LicenseResponse updateServiceLicense(String appId, String serviceId, ServiceSubscriptionRequest subcn) {
		// TODO Auto-generated method stub
		return null;
	}

}
