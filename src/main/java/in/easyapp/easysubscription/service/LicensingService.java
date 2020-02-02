package in.easyapp.easysubscription.service;

import java.util.List;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.LicenseRequest;
import in.easyapp.easysubscription.response.LicenseKeyResponse;
import in.easyapp.easysubscription.response.LicenseResponse;

public interface LicensingService extends Licence4jCommonConstants {

	LicenseKeyResponse generateLicense(LicenseRequest license) throws RequestException;

	List<LicenseResponse> getLicenses(String appId, String serviceId) throws RequestException;

	LicenseResponse activateLicense(String appId, String serviceId) throws RequestException;

	LicenseResponse validateLicense(String appId, String serviceId) throws RequestException;

}
