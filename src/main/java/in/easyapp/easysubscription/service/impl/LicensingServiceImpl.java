package in.easyapp.easysubscription.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.license4j.License;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.models.LicenseMdl;
import in.easyapp.easysubscription.repository.LicensingRepository;
import in.easyapp.easysubscription.request.LicenseRequest;
import in.easyapp.easysubscription.response.LicenseKeyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.service.LicensingService;
import in.easyapp.easysubscription.util.Licence4jUtil;

@Service
public class LicensingServiceImpl implements LicensingService{

	@Autowired
	private LicensingRepository licensingRepository;
	
	
	@Override
	public LicenseKeyResponse generateLicense(LicenseRequest req) {
		LicenseMdl mdl = new LicenseMdl();
		mdl.setActivationRequired(true);
		mdl.setAppId(req.getAppId());
		mdl.setCreatedAt(new Date());
		mdl.setLicenseKey(req.getLicenseKey());
		mdl.setServiceId(req.getServiceId());
		mdl.setUserId(req.getUserId());
		mdl.setValidForDays(req.getValidForDays());
		License validateResponse = null; 
		if(req.getServiceId()=="service_id_1" && req.getValidForDays()==360) {
			
		}else if(req.getServiceId()=="service_id_1" && req.getValidForDays()==180) {
			
		}else {
			String licenseStringToValidate = Licence4jUtil.generateLicence("1571158624658934459511571158529822");
			if(licenseStringToValidate!=null && !licenseStringToValidate.isEmpty()) {
				validateResponse = Licence4jUtil.validate(PUBLIC_KEY, licenseStringToValidate, mdl.getServiceId());
			}
			mdl.setLicenseKey(validateResponse.getLicenseString());
		}
		licensingRepository.save(mdl);
		//return new LicenseKeyResponse(validateResponse.getLicenseString(),licenseRequest.getUserId());
		return new LicenseKeyResponse(mdl);
	}

	@Override
	public List<LicenseResponse> getLicenses(String appId, String serviceId) throws RequestException {
		if(appId == null || appId.isEmpty()|| serviceId == null || serviceId.isEmpty()) {
			return convertMdlToResp(licensingRepository.findAll());
		}
		List<LicenseMdl> list  = licensingRepository.findAllByAppIdAndServiceId(appId,serviceId);
		return convertMdlToResp(list);
	}

	private List<LicenseResponse> convertMdlToResp(List<LicenseMdl> list) throws RequestException {
		if(list ==null || list.isEmpty()) {
			throw new RequestException("License Not found in db");
		}
		List<LicenseResponse> resp  = new ArrayList<LicenseResponse>();
		for(LicenseMdl mdl : list) {
			resp.add(new LicenseResponse(mdl));
		}
		return resp;
	}

	@Override
	public LicenseResponse activateLicense(String appId, String serviceId) throws RequestException {
		if(appId == null || serviceId == null) {
			throw new RequestException("Invalid AppId and ServiceId");
		}
		return null;
	}

	@Override
	public LicenseResponse validateLicense(String appId, String serviceId) throws RequestException {
		if(appId == null || serviceId == null) {
			throw new RequestException("Invalid AppId and ServiceId");
		}
		LicenseMdl mdl = licensingRepository.findByAppIdAndServiceId(appId, serviceId);
		if(mdl == null) {
			throw new RequestException("License not found in db");
		}
		License validate = Licence4jUtil.validate(PUBLIC_KEY, String.valueOf(mdl.getValidForDays()), mdl.getServiceId());
		
		if(validate!= null && validate.getActivationStatus().equals(VALID)) {
			return new LicenseResponse(appId,serviceId,VALID);
		}
		
		return new LicenseResponse(appId,serviceId,IN_VALID);
	}

}
