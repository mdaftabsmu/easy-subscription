package in.easyapp.easysubscription.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.license4j.License;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.models.LicenseMdl;
import in.easyapp.easysubscription.models.ProjectMdl;
import in.easyapp.easysubscription.models.ServiceMdl;
import in.easyapp.easysubscription.repository.AppRepository;
import in.easyapp.easysubscription.repository.LicensingRepository;
import in.easyapp.easysubscription.repository.ServiceRepository;
import in.easyapp.easysubscription.request.LicenseRequest;
import in.easyapp.easysubscription.response.LicenseKeyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.service.LicensingService;
import in.easyapp.easysubscription.util.Licence4jUtil;

@Service
public class LicensingServiceImpl implements LicensingService{

	private static final Logger LOGGER = LoggerFactory.getLogger(LicensingServiceImpl.class);
	
	@Autowired
	private LicensingRepository licensingRepository;
	
	@Autowired
	private CommonBean commonBean;
	
	@Autowired
	private AppRepository appRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	@Override
	public LicenseKeyResponse generateLicense(LicenseRequest req) throws RequestException {
		if(req == null) {
			throw new RequestException("Invalid license request");
		}
		LOGGER.debug("LicensingServiceImpl - {}", req.getAppId());
		if(req.getAppId() ==null || req.getAppId().isEmpty()) {
			throw new RequestException("Invalid App Id");
		}
		ProjectMdl byAppId = appRepository.findByAppId(req.getAppId());
		if(req.getServiceId()==null || req.getServiceId().isEmpty()) {
			throw new RequestException("Invalid service Id");
		}
		ServiceMdl serviceMdl = serviceRepository.findByServiceId(req.getServiceId());
		if(byAppId ==null || serviceMdl == null) {
			throw new RequestException("Invalid App /Service Id");
		}
		LicenseMdl mdl = new LicenseMdl();
		mdl.setActivationRequired(true);
		mdl.setAppId(req.getAppId());
		mdl.setCreatedAt(new Date());
		mdl.setLicenseKey(req.getLicenseKey());
		mdl.setServiceId(req.getServiceId());
		mdl.setUserId(req.getUserId());
		mdl.setValidForDays(req.getValidForDays());
		License validateResponse = null; 
		if(req.getServiceId()==commonBean.getTwelveServiceId() && req.getValidForDays()==360) {
			LOGGER.debug("LicensingServiceImpl - {}","Default - 360 days");
		}else if(req.getServiceId()==commonBean.getSixServiceId() && req.getValidForDays()==180) {
			LOGGER.debug("LicensingServiceImpl - {}","Default - 180 days");
		}else {
			LOGGER.debug("LicensingServiceImpl - {}","Default - 90 days");
			String licenseStringToValidate = Licence4jUtil.generateLicence(commonBean.getEasyServiceProductId());
			if(licenseStringToValidate!=null && !licenseStringToValidate.isEmpty()) {
				validateResponse = Licence4jUtil.validate(commonBean.getPublicKey(), licenseStringToValidate, mdl.getServiceId());
			}
			LOGGER.debug("LicensingServiceImpl - {}",validateResponse.getActivationStatus());
			mdl.setLicenseKey(validateResponse.getPublicKey());
			mdl.setLicenseString(validateResponse.getLicenseString());
		}
		licensingRepository.insert(mdl);
		LOGGER.debug("LicensingServiceImpl - {}",mdl.getAppId());
		return new LicenseKeyResponse(mdl);
	}

	@Override
	public List<LicenseResponse> getLicenses(String appId, String serviceId) throws RequestException {
		if(appId == null || appId.isEmpty()|| serviceId == null || serviceId.isEmpty()) {
			return convertMdlToResp(licensingRepository.findAll());
		}
		LOGGER.debug("LicensingServiceImpl - {}",appId);
		List<LicenseMdl> list  = licensingRepository.findAllByAppIdAndServiceId(appId,serviceId);
		LOGGER.debug("LicensingServiceImpl - {}",serviceId);
		return convertMdlToResp(list);
	}

	private List<LicenseResponse> convertMdlToResp(List<LicenseMdl> list) throws RequestException {
		if(list ==null || list.isEmpty()) {
			throw new RequestException("License Not found in db");
		}
		LOGGER.debug("LicensingServiceImpl -license size {}",list.size());
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
		LOGGER.debug("LicensingServiceImpl Service id - {}",serviceId);
		LicenseMdl mdl = licensingRepository.findByAppIdAndServiceId(appId, serviceId);
		if(mdl == null) {
			throw new RequestException("License not found in db");
		}
		LOGGER.debug("LicensingServiceImpl ID - {}",mdl.getId());
		License license = Licence4jUtil.autoValidate(commonBean.getPublicKey(), mdl.getLicenseString(), serviceId);
		LicenseResponse res =  new LicenseResponse();
		res.setAppId(appId);
		res.setServiceId(serviceId);
		if(license.isActivationCompleted()) {
			  res.setStatus(ACTIVATED);
		}else {
			res.setStatus(IN_ACTIVATED);
		}
		return res;
	}

	@Override
	public LicenseResponse validateLicense(String appId, String serviceId) throws RequestException {
		if(appId == null || serviceId == null) {
			throw new RequestException("Invalid AppId and ServiceId");
		}
		LOGGER.debug("LicensingServiceImpl Service id - {}",serviceId);
		LicenseMdl mdl = licensingRepository.findByAppIdAndServiceId(appId, serviceId);
		if(mdl == null) {
			throw new RequestException("License not found in db");
		}
		License validate = Licence4jUtil.validate(commonBean.getPublicKey(), mdl.getLicenseString(), mdl.getServiceId());
		
		if(validate!= null && validate.getValidationStatus().equals(VALID)) {
			return new LicenseResponse(appId,serviceId,VALID);
		}
		
		return new LicenseResponse(appId,serviceId,IN_VALID);
	}

}
