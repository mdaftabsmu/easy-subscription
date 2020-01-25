package in.easyapp.easysubscription.response;

import in.easyapp.easysubscription.models.ServiceSubscriptionMdl;

public class ServiceSubscriptionResponse {

	private String serviceId ;
	private String appId ;
	private String subscriptionPlan ;
	private String subscriptionKey ;
	private long expiresOn;
	private long createdAt;
	
	public ServiceSubscriptionResponse() {
		// TODO Auto-generated constructor stub
	}

	public ServiceSubscriptionResponse(String serviceId, String appId, String subscriptionPlan, String subscriptionKey,
			long expiresOn, long createdAt) {
		super();
		this.serviceId = serviceId;
		this.appId = appId;
		this.subscriptionPlan = subscriptionPlan;
		this.subscriptionKey = subscriptionKey;
		this.expiresOn = expiresOn;
		this.createdAt = createdAt;
	}

	public ServiceSubscriptionResponse(ServiceSubscriptionMdl mdl) {
		this.serviceId = mdl.getServiceId();
		this.appId = mdl.getAppId();
		this.subscriptionPlan = mdl.getSubscriptionPlan();
		this.subscriptionKey = mdl.getSubscriptionKey();
		this.expiresOn = mdl.getExpiresOn();
		this.createdAt = mdl.getCreatedAt();
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public long getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(long expiresOn) {
		this.expiresOn = expiresOn;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSubscriptionPlan() {
		return subscriptionPlan;
	}

	public void setSubscriptionPlan(String subscriptionPlan) {
		this.subscriptionPlan = subscriptionPlan;
	}

	public String getSubscriptionKey() {
		return subscriptionKey;
	}

	public void setSubscriptionKey(String subscriptionKey) {
		this.subscriptionKey = subscriptionKey;
	}

	/*
	 * public String getLicenseKey() { return licenseKey; }
	 * 
	 * public void setLicenseKey(String licenseKey) { this.licenseKey = licenseKey;
	 * }
	 */

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
}
