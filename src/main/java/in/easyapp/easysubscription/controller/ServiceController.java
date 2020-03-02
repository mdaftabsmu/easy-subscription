package in.easyapp.easysubscription.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.easyapp.easysubscription.exception.AppServiceException;
import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceRequest;
import in.easyapp.easysubscription.response.EasyError;
import in.easyapp.easysubscription.response.EasyResponse;
import in.easyapp.easysubscription.response.ServiceResponse;
import in.easyapp.easysubscription.response.SubscriptionPlanResponse;
import in.easyapp.easysubscription.service.ServiceAppService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private ServiceAppService serviceAppService; 
	
	@RequestMapping(value = "/service", method = RequestMethod.POST)
	public ResponseEntity<EasyResponse> create(@RequestBody ServiceRequest serviceRequest, Principal principal) {
		try {
			return ResponseEntity.ok(serviceAppService.create(serviceRequest));
		} catch (RequestException e) {
			e.printStackTrace();
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new EasyError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
	}
			
    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<ServiceResponse> getServices(Principal principal,@RequestParam(value = "appId", required = false) String appId) {
    	List<ServiceResponse> list  = serviceAppService.getServices(appId);
    	return list;

    }

    @RequestMapping(value = "/services/{serviceId}", method = RequestMethod.GET)
    public ResponseEntity<EasyResponse> getServiceById(Principal principal,@PathVariable("serviceId") String serviceId) {
    	try {
			return ResponseEntity.ok(serviceAppService.getService(serviceId));
		} catch (RequestException e) {
			e.printStackTrace();
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body(new EasyError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
		}
      
    }
}
