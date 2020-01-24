package in.easyapp.easysubscription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.LicenseRequest;
import in.easyapp.easysubscription.response.LicenseKeyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.service.LicensingService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class LicensingController {
	/** 
	 * 
	 * 3 api in App controller
	 * 
	 * 
	 * */
	
	@Autowired
	private LicensingService licensingService;
	
    @RequestMapping(value = "/licenses", method = RequestMethod.POST)
    public LicenseKeyResponse generateLicense(Principal principal,@RequestBody LicenseRequest license) {
        return licensingService.generateLicense(license);
    }

    @RequestMapping(value = "/licenses", method = RequestMethod.GET)
    public List<LicenseResponse> getLicenses(Principal principal,@RequestParam(value = "appId", required = false) String appId,
                                     @RequestParam(value = "serviceId", required = false) String serviceId) {
    	try {
			return licensingService.getLicenses(appId,serviceId);
		} catch (RequestException e) {
			e.printStackTrace();
		}
    	return null;
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/activate", method = RequestMethod.POST)
    public LicenseResponse activateLicense(Principal principal,@PathVariable("appId") String appId,
                                      @PathVariable("serviceId") String serviceId) {
    	try {
			return licensingService.activateLicense(appId,serviceId);
		} catch (RequestException e) {
			e.printStackTrace();
		}
    	return null;
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/validate", method = RequestMethod.POST)
    public LicenseResponse validateLicense(Principal principal,@PathVariable("appId") String appId,
                                      @PathVariable("serviceId") String serviceId) {
    	try {
			return licensingService.validateLicense(appId,serviceId);
		} catch (RequestException e) {
			e.printStackTrace();
		}
    	
    	return null;
    }
}
