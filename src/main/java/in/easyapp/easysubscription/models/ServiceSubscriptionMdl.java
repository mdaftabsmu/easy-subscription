package in.easyapp.easysubscription.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import in.easyapp.easysubscription.request.ServiceSubscriptionRequest;

@Document(collation= "serviceSubscription")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceSubscriptionMdl {

	@Id
	private String id;
	@Field("serviceId")
	private String serviceId;
	@Field("appId")
	private String appId;
	@Field("subscriptionPlan")
	private String subscriptionPlan;
	@Field("subscriptionKey")
	private String subscriptionKey;
	@Field("expiresOn")
	private long expiresOn;
	@Field("createdAt")
	private long createdAt;
	@Field("licenseKey")
	private String licenseKey;
	
	
	public ServiceSubscriptionMdl() {
		// TODO Auto-generated constructor stub
	}

	public ServiceSubscriptionMdl(ServiceSubscriptionRequest req,String licenseKey) {
		this.serviceId = req.getServiceId();
		this.appId = req.getAppId();
		this.subscriptionPlan = req.getSubscriptionPlan();
		this.subscriptionKey = req.getSubscriptionKey();
		this.expiresOn = req.getExpiresOn();
		this.createdAt = req.getCreatedAt();
		this.licenseKey = licenseKey;
	}

	public ServiceSubscriptionMdl(ServiceSubscriptionRequest req) {
		this.serviceId = req.getServiceId();
		this.appId = req.getAppId();
		this.subscriptionPlan = req.getSubscriptionPlan();
		this.subscriptionKey = req.getSubscriptionKey();
		this.expiresOn = req.getExpiresOn();
		this.createdAt = req.getCreatedAt();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	
	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	

	public String getLicenseKey() {
		return licenseKey;
	}

	public void setLicenseKey(String licenseKey) {
		this.licenseKey = licenseKey;
	}

	@Override
	public String toString() {
		return "ServiceSubscriptionRequestMdl [id=" + id + "]";
	}
	
	
}
