package in.easyapp.easysubscription.controller;

import org.springframework.web.bind.annotation.*;

import in.easyapp.easysubscription.request.LicenseRequest;
import in.easyapp.easysubscription.response.LicenseKeyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class LicensingController {

    @RequestMapping(value = "/licenses", method = RequestMethod.POST)
    public LicenseKeyResponse generateLicense(@RequestBody LicenseRequest license) {
        return new LicenseKeyResponse();
    }

    @RequestMapping(value = "/licenses", method = RequestMethod.GET)
    public List<LicenseResponse> getLicenses(@RequestParam(value = "appId", required = false) String appId,
                                     @RequestParam(value = "serviceId", required = false) String serviceId) {
        List<LicenseResponse> licList = new ArrayList<>();
        licList.add(new LicenseResponse());
        return licList;
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/activate", method = RequestMethod.POST)
    public LicenseResponse activateLicense(@PathVariable("appId") String appId,
                                      @PathVariable("serviceId") String serviceId) {
        LicenseResponse res =  new LicenseResponse();
        res.setStatus("ACTIVATED");
        return res;
    }

    @RequestMapping(value = "/apps/{appId}/services/{serviceId}/validate", method = RequestMethod.POST)
    public LicenseResponse validateLicense(@PathVariable("appId") String appId,
                                      @PathVariable("serviceId") String serviceId) {
        LicenseResponse res =  new LicenseResponse();
        res.setStatus("VALID");
        return res;
    }
}
