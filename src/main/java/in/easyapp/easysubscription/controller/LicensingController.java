package in.easyapp.easysubscription.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.LicenseRequest;
import in.easyapp.easysubscription.response.EasyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.service.LicensingService;

@CrossOrigin
@RestController
public class LicensingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LicensingController.class);
			
	@Autowired
	private LicensingService licensingService;
	
    @RequestMapping(value = "/licenses", method = RequestMethod.POST)
    public ResponseEntity<EasyResponse> generateLicense(Principal principal,@RequestBody LicenseRequest license) throws RequestException {
    	LOGGER.debug("LicensingController - {}", "Entry");
    	return ResponseEntity.ok(licensingService.generateLicense(license));
    }

    @RequestMapping(value = "/licenses", method = RequestMethod.GET)
    public ResponseEntity<List<LicenseResponse>> getLicenses(Principal principal,@RequestParam(value = "appId", required = false) String appId,
                                     @RequestParam(value = "serviceId", required = false) String serviceId) throws RequestException {
    	LOGGER.debug("LicensingController - {}", "Entry");
    	return ResponseEntity.ok(licensingService.getLicenses(appId,serviceId));
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/activate", method = RequestMethod.POST)
    public ResponseEntity<EasyResponse> activateLicense(Principal principal,@PathVariable("appId") String appId,
                                      @PathVariable("serviceId") String serviceId) throws RequestException {
    	LOGGER.debug("LicensingController - {}", "Entry");
			return ResponseEntity.ok(licensingService.activateLicense(appId,serviceId));
    }

    
    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/validate", method = RequestMethod.POST)
    public ResponseEntity<EasyResponse> validateLicense(Principal principal,@PathVariable("appId") String appId,
                                      @PathVariable("serviceId") String serviceId) throws RequestException {
    	LOGGER.debug("LicensingController - {}", "Entry");
    		return ResponseEntity.ok(licensingService.validateLicense(appId,serviceId));
    }
}
