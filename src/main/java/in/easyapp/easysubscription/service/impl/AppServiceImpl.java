package in.easyapp.easysubscription.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.license4j.License;

import in.easyapp.easysubscription.exception.DataNotFoundException;
import in.easyapp.easysubscription.exception.LicenceException;
import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.models.ProjectMdl;
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
	
	@Autowired
	private CommonBean commonBean;

	@Override
	public ProjectResponse createApp(ProjectRequest app) throws RequestException {
		if(app == null) {
			throw new RequestException("Invalid app request");
		}
		List<ServiceSubscriptionMdl> services  = new ArrayList<ServiceSubscriptionMdl>();
		for(ServiceSubscriptionRequest req : app.getServices()) {
			services.add(new ServiceSubscriptionMdl(req));
		}
		ProjectMdl mdl = appRepository.insert(new ProjectMdl(app,services));
		return new ProjectResponse(mdl);
	}

	@Override
	public List<ProjectResponse> getApps(String createdBy) throws RequestException {
		try {
		if(createdBy == null || createdBy.isEmpty()) {
			List<ProjectMdl> list = appRepository.findAll();
			return convertMdlToResp(list);
		}
		List<ProjectMdl> list = appRepository.findAllByCreatedBy(createdBy);
		return  convertMdlToResp(list);
		}catch(Exception e) {
			e.printStackTrace();
		}
		throw new RequestException();
		
	}

	private List<ProjectResponse> convertMdlToResp(List<ProjectMdl> list) throws RequestException {
		if(list==null ||list.isEmpty()) {
			throw new RequestException("App details not found");
		}
		List<ProjectResponse> resps = new ArrayList<ProjectResponse>();
		for(ProjectMdl mdl : list) {
			resps.add(new ProjectResponse(mdl));
		}
		return resps;
	}

	@Override
	public ProjectResponse getProjectById(String appId) throws RequestException {
		if(appId == null || appId.isEmpty()) {
			throw new RequestException("Invalid App ids");
		}
		ProjectMdl mdl  = appRepository.findByAppId(appId);
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
		
		String licence = Licence4jUtil.generateLicence(commonBean.getEasyServiceProductId());
		if(licence == null || licence.isEmpty() ) {
			throw new LicenceException("Unable to create License");
		}
		ServiceSubscriptionMdl mdl = serviceSubRepository.save(new ServiceSubscriptionMdl(subcn,licence));
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
	public LicenseResponse updateServiceLicense(String appId, String serviceId, ServiceSubscriptionRequest subcn) throws RequestException {
		if(appId == null || appId.isEmpty()||serviceId == null || serviceId.isEmpty()|| subcn ==null) {
			throw new RequestException("Invalid request");
		}
		ProjectMdl appMdl = appRepository.findByAppId(appId);
		if(appMdl == null || appMdl.getServices() == null) {
			throw new RequestException("App Id not found in db");
		}
		boolean flag  =  false;
		for(ServiceSubscriptionMdl service : appMdl.getServices()){
			if(service.getServiceId().equals(serviceId)) {
				if(service.getExpiresOn()<new Date().getTime() && !service.getIsActive()) {
					String licence = Licence4jUtil.generateLicence(commonBean.getEasyServiceProductId());
					if(licence == null || licence.isEmpty() ) {
						throw new RequestException("Unable to create License");
					}
					serviceSubRepository.save(new ServiceSubscriptionMdl(subcn,licence));
				}else {
					String licence = Licence4jUtil.generateLicence(commonBean.getEasyServiceProductId());
					if(licence == null || licence.isEmpty() ) {
						throw new RequestException("Unable to create License");
					}
					serviceSubRepository.save(new ServiceSubscriptionMdl(subcn,service.getExpiresOn(),licence));
				}
				flag = true;
				break;
			}
		}
		LicenseResponse res  = new LicenseResponse();
		res.setAppId(appId);
		res.setServiceId(serviceId);
		if(flag) {
			res.setStatus("SUCCESS");
		}else {
			res.setStatus("UN-SUCCESS");
		}
		return res;
	}

}
