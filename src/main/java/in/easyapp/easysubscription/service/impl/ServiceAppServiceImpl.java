package in.easyapp.easysubscription.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.models.ServiceMdl;
import in.easyapp.easysubscription.models.SubscriptionPlanMdl;
import in.easyapp.easysubscription.repository.ServiceRepository;
import in.easyapp.easysubscription.request.ServiceRequest;
import in.easyapp.easysubscription.request.SubscriptionPlanRequest;
import in.easyapp.easysubscription.response.ServiceResponse;
import in.easyapp.easysubscription.service.ServiceAppService;

@Service
public class ServiceAppServiceImpl implements ServiceAppService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAppServiceImpl.class);
	
	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public ServiceResponse create(ServiceRequest serviceRequest) throws RequestException {
		if(serviceRequest == null) {
			LOGGER.error("Invalid request");
			throw new RequestException("Invalid request");
		}
		LOGGER.debug("Request data : "+serviceRequest.getServiceId());
		ServiceMdl model  = new ServiceMdl();
		model.setCreateAt(new Date());
		model.setIsActive(true);
		model.setDescription(serviceRequest.getDescription());
		model.setLicensedMethods(serviceRequest.getLicensedMethods());
		model.setUrlMapping(serviceRequest.getUrlMapping());
		List<SubscriptionPlanMdl> sMdl = new ArrayList<SubscriptionPlanMdl>();
		for(SubscriptionPlanRequest plan : serviceRequest.getPlans()) {
			sMdl.add(new SubscriptionPlanMdl(plan.getPlanName(), plan.getPlanDescription(),plan.getValidityInDays(),
					plan.getPrice(), plan.getServiceId(), new Date(), true));
		}
		model.setPlans(sMdl);
		ServiceMdl save = serviceRepository.save(model);
		return new ServiceResponse(save);
	}

	@Override
	public List<ServiceResponse> getServices(String appId) {
		// Need to discuss
		/*if(appId != null && !appId.isEmpty()) {
			serviceRepository.findByAppId(appId);
		}*/
		List<ServiceResponse> resps = new ArrayList<ServiceResponse>();
		List<ServiceMdl> lists = serviceRepository.findAll();
		for(ServiceMdl mdl : lists) {
			resps.add(new ServiceResponse(mdl));
		}
		return resps;
	}

	@Override
	public ServiceResponse getService(String serviceId) throws RequestException {
		if(serviceId == null || serviceId.isEmpty()) {
			throw new RequestException("Invalid service id");
		}
		LOGGER.info("Service id  : "+serviceId);
		ServiceMdl mdl = serviceRepository.findByServiceId(serviceId);
		if(mdl == null) {
			throw new RequestException("Service not found in db");
		}
		return new ServiceResponse(mdl);
	}

}
