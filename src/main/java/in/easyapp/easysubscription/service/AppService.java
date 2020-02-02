package in.easyapp.easysubscription.service;

import java.util.List;

import in.easyapp.easysubscription.exception.DataNotFoundException;
import in.easyapp.easysubscription.exception.LicenceException;
import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.ProjectRequest;
import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;
import in.easyapp.easysubscription.response.LicenseResponse;
import in.easyapp.easysubscription.response.ProjectResponse;
import in.easyapp.easysubscription.response.ServiceSubscriptionResponse;

public interface AppService extends Licence4jCommonConstants{

	ProjectResponse createApp(ProjectRequest app) throws RequestException;

	List<ProjectResponse> getApps(String createdBy) throws RequestException;

	ProjectResponse getProjectById(String appId) throws RequestException;

	ServiceSubscriptionResponse subscribeServiceForAppId(String appId, String serviceId,
			ServiceSubscriptionRequest subcn) throws RequestException, LicenceException;

	List<ServiceSubscriptionResponse> getServiceForAppId(String appId) throws RequestException, DataNotFoundException;

	LicenseResponse updateServiceLicense(String appId, String serviceId, ServiceSubscriptionRequest subcn) throws RequestException;


}
