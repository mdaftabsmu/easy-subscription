package in.easyapp.easysubscription.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.models.ProjectRequestMdl;
import in.easyapp.easysubscription.models.ServiceSubscriptionRequestMdl;
import in.easyapp.easysubscription.repository.AppRepository;
import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.response.ProjectResponse;
import in.easyapp.easysubscription.response.ServiceSubscriptionResponse;
import in.easyapp.easysubscription.service.AppService;

@Service
public class AppServiceImpl implements AppService {
	
	@Autowired
	private AppRepository appRepository;

	@Override
	public ProjectResponse createApp(ProjectRequest app) throws RequestException {
		if(app == null) {
			throw new RequestException("Invalid app request");
		}
		List<ServiceSubscriptionRequestMdl> services  = new ArrayList<ServiceSubscriptionRequestMdl>();
		for(ServiceSubscriptionRequest req : app.getServices()) {
			services.add(new ServiceSubscriptionRequestMdl(req));
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

	@Override
	public ServiceSubscriptionResponse subscribeServiceForAppId(String appId, String serviceId,
			ServiceSubscriptionRequest subcn) throws RequestException {
		if(appId == null || appId.isEmpty()||serviceId == null || serviceId.isEmpty()|| subcn ==null) {
			throw new RequestException("Invalid request");
		}
		
		
		return null;
	}

	@Override
	public List<ServiceSubscriptionResponse> getServiceForAppId(String appId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LicenseResponse updateServiceLicense(String appId, String serviceId, ServiceSubscriptionRequest subcn) {
		// TODO Auto-generated method stub
		return null;
	}

}
