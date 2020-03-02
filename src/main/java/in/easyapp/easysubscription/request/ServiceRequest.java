package in.easyapp.easysubscription.request;

import java.util.List;


public class ServiceRequest {
	private String serviceId;
	private String description;
	private String urlMapping;
	private String[] licensedMethods; 
	private List<SubscriptionPlanRequest> plans;

	public ServiceRequest() {
		// TODO Auto-generated constructor stub
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlMapping() {
		return urlMapping;
	}

	public void setUrlMapping(String urlMapping) {
		this.urlMapping = urlMapping;
	}

	public String[] getLicensedMethods() {
		return licensedMethods;
	}

	public void setLicensedMethods(String[] licensedMethods) {
		this.licensedMethods = licensedMethods;
	}

	public List<SubscriptionPlanRequest> getPlans() {
		return plans;
	}

	public void setPlans(List<SubscriptionPlanRequest> plans) {
		this.plans = plans;
	}
}
