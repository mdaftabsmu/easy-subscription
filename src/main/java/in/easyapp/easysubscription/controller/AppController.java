package in.easyapp.easysubscription.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.response.ProjectResponse;
import in.easyapp.easysubscription.response.ServiceSubscriptionResponse;


@CrossOrigin
@RestController
public class AppController {
	
	
	
	@RequestMapping(value = "/apps", method = RequestMethod.POST)
    public ProjectResponse createProject(@RequestBody ProjectRequest app, Principal principal) {

		ProjectResponse mdl = new ProjectResponse();
        mdl.setAppName(app.getAppName());
        mdl.setCreatedBy(app.getCreatedBy());
        mdl.setDescription(app.getDescription());
        mdl.setActive(true);
        return mdl;
    }

    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public List<ProjectResponse> getProjectsByUserId(@RequestParam(value = "createdBy", required = false) String createdBy,
                                                Principal principal) {
        List<ProjectResponse> srvList = new ArrayList<>();
        srvList.add(new ProjectResponse(1));
        if(createdBy == null || createdBy.isEmpty())
            srvList.add(new ProjectResponse(2));

        return srvList;
    }

    @RequestMapping(value = "/apps/{appId}", method = RequestMethod.GET)
    public ProjectResponse getProjectsByAppId(@PathVariable("appId") String appId) {
        return new ProjectResponse();
    }


    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/subscription", method = RequestMethod.POST)
    public ServiceSubscriptionResponse subscribeServiceForAppId(@PathVariable("appId") String appId,
                                                        @PathVariable("serviceId") String serviceId,
                                                        ServiceSubscriptionRequest subcn) {
    	ServiceSubscriptionResponse subscription = new ServiceSubscriptionResponse();
        subscription.setAppId(appId);
        subscription.setServiceId(serviceId);
        if(subcn.getSubscriptionPlan() != null && !subcn.getSubscriptionPlan().isEmpty())
            subscription.setSubscriptionPlan(subcn.getSubscriptionPlan());
        return subscription;
    }

    @RequestMapping(value = "/apps/{appId}/services", method = RequestMethod.GET)
    public List<ServiceSubscriptionResponse> getServicesForAppId(@PathVariable("appId") String appId) {
        List<ServiceSubscriptionResponse> subscriptions = new ArrayList<>();
        for (int i = 0; i < 3 ; i++){
        	ServiceSubscriptionResponse subscription = new ServiceSubscriptionResponse();
            subscription.setAppId(appId);
            subscription.setServiceId("TestService_"+i);
            subscriptions.add(subscription);
        }
        return subscriptions;
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/subscription", method = RequestMethod.PUT)
    public LicenseResponse updateServiceLicense(@PathVariable("appId") String appId,
                                                @PathVariable("serviceId") String serviceId,
                                                ServiceSubscriptionRequest subcn) {
        return new LicenseResponse();
    }

}
