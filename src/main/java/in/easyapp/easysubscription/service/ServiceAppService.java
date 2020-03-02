package in.easyapp.easysubscription.service;

import java.util.List;

import in.easyapp.easysubscription.exception.RequestException;
import in.easyapp.easysubscription.request.ServiceRequest;
import in.easyapp.easysubscription.response.ServiceResponse;

public interface ServiceAppService {

	ServiceResponse create(ServiceRequest serviceRequest) throws RequestException;

	List<ServiceResponse> getServices(String appId);

	ServiceResponse getService(String serviceId) throws RequestException;

}
