package in.easyapp.easysubscription.request;

import java.time.Instant;
import java.util.Date;

public class ServiceSubscriptionRequest {

	private String serviceId = "TestService";
	private String appId = "appId_1";
	private String subscriptionPlan = "free";
	private String subscriptionKey = "agfkjuyoi.33178ghkjf.asd";
	// private String licenseKey =
	// "iuefifoesfj21epoj.fhaiwf9-28j.fuuihjbb7347yoihfygybki";
	private long expiresOn = Date.from(Instant.now()).getTime() + 7776000;
	private long createdAt = Date.from(Instant.now()).getTime();

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
