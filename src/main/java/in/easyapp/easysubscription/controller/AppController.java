package in.easyapp.easysubscription.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.response.ProjectResponse;
import in.easyapp.easysubscription.response.ServiceSubscriptionResponse;
import in.easyapp.easysubscription.service.AppService;


@CrossOrigin
@RestController
public class AppController {
	
	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/apps", method = RequestMethod.POST)
    public ProjectResponse createProject(@RequestBody ProjectRequest app, Principal principal) {
		try {
			return appService.createApp(app);
		} catch (RequestException e) {
			e.printStackTrace();
		}
		return null;
    }

    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public List<ProjectResponse> getProjectsByUserId(@RequestParam(value = "createdBy", required = false) String createdBy,
                                                Principal principal) {
    	try {
			return appService.getApps(createdBy);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }

    @RequestMapping(value = "/apps/{appId}", method = RequestMethod.GET)
    public ProjectResponse getProjectsByAppId(Principal principal,@PathVariable("appId") String appId) {
        try {
			return appService.getProjectById(appId);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }


    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/subscription", method = RequestMethod.POST)
    public ServiceSubscriptionResponse subscribeServiceForAppId(Principal principal,@PathVariable("appId") String appId,
                                                        @PathVariable("serviceId") String serviceId,
                                                        ServiceSubscriptionRequest subcn) {
    	/*ServiceSubscriptionResponse subscription = new ServiceSubscriptionResponse();
        subscription.setAppId(appId);
        subscription.setServiceId(serviceId);
        if(subcn.getSubscriptionPlan() != null && !subcn.getSubscriptionPlan().isEmpty())
            subscription.setSubscriptionPlan(subcn.getSubscriptionPlan());
        return subscription;*/
    	
    	try {
			return appService.subscribeServiceForAppId(appId,serviceId,subcn);
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }

    @RequestMapping(value = "/apps/{appId}/services", method = RequestMethod.GET)
    public List<ServiceSubscriptionResponse> getServicesForAppId(Principal principal,@PathVariable("appId") String appId) {
        /*List<ServiceSubscriptionResponse> subscriptions = new ArrayList<>();
        for (int i = 0; i < 3 ; i++){
        	ServiceSubscriptionResponse subscription = new ServiceSubscriptionResponse();
            subscription.setAppId(appId);
            subscription.setServiceId("TestService_"+i);
            subscriptions.add(subscription);
        }
        return subscriptions;*/
    	
    	return appService.getServiceForAppId(appId);
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/subscription", method = RequestMethod.PUT)
    public LicenseResponse updateServiceLicense(Principal principal,@PathVariable("appId") String appId,
                                                @PathVariable("serviceId") String serviceId,
                                                ServiceSubscriptionRequest subcn) {
        return appService.updateServiceLicense(appId,serviceId,subcn);
    }

}
