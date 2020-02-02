package in.easyapp.easysubscription.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.easyapp.easysubscription.exception.DataNotFoundException;
import in.easyapp.easysubscription.exception.LicenceException;
import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;
import in.easyapp.easysubscription.response.EasyError;
import in.easyapp.easysubscription.response.EasyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.response.ProjectResponse;
import in.easyapp.easysubscription.response.ServiceSubscriptionResponse;
import in.easyapp.easysubscription.service.AppService;


@CrossOrigin
@RestController
public class AppController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);
	
	@Autowired
	private AppService appService;
	
	@RequestMapping(value = "/apps", method = RequestMethod.POST)
    public ResponseEntity<EasyResponse> createProject(@RequestBody ProjectRequest app, Principal principal) {
		try {
			LOGGER.debug("AppController - {}", "Entry");
			return ResponseEntity.ok(appService.createApp(app));
		} catch (RequestException e) {
			e.printStackTrace();
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new EasyError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
    }

    @RequestMapping(value = "/apps", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectResponse>> getProjectsByUserId(@RequestParam(value = "createdBy", required = false) String createdBy,
                                                Principal principal) throws RequestException {
    	LOGGER.debug("AppController - {}", "Entry");
    		return ResponseEntity.ok(appService.getApps(createdBy));
		
    	
    }

    @RequestMapping(value = "/apps/{appId}", method = RequestMethod.GET)
    public ResponseEntity<EasyResponse> getProjectsByAppId(Principal principal,@PathVariable("appId") String appId) {
        try {
        	LOGGER.debug("AppController - {}", "Entry");
        	return ResponseEntity.ok( appService.getProjectById(appId));
		} catch (RequestException e) {
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new EasyError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
    }


    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/subscription", method = RequestMethod.POST)
    public ResponseEntity<EasyResponse> subscribeServiceForAppId(Principal principal,@PathVariable("appId") String appId,
                                                        @PathVariable("serviceId") String serviceId,
                                                        ServiceSubscriptionRequest subcn) {
    	try {
    		LOGGER.debug("AppController - {}", "Entry");
    		return ResponseEntity.ok(appService.subscribeServiceForAppId(appId,serviceId,subcn));
		} catch (RequestException | LicenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new EasyError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
    }

    @RequestMapping(value = "/apps/{appId}/services", method = RequestMethod.GET)
    public List<ServiceSubscriptionResponse> getServicesForAppId(Principal principal,@PathVariable("appId") String appId) throws RequestException, DataNotFoundException {
    	LOGGER.debug("AppController - {}", "Entry");
			return appService.getServiceForAppId(appId);
		
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/subscription", method = RequestMethod.PUT)
    public ResponseEntity<EasyResponse> updateServiceLicense(Principal principal,@PathVariable("appId") String appId,
                                                @PathVariable("serviceId") String serviceId,
                                                ServiceSubscriptionRequest subcn) {
        try {
        	LOGGER.debug("AppController - {}", "Entry");
        	return ResponseEntity.ok(appService.updateServiceLicense(appId,serviceId,subcn));
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new EasyError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
    }

}
