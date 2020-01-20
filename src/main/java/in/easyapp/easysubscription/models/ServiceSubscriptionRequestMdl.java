package in.easyapp.easysubscription.models;

import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collation= "serviceSubscription")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceSubscriptionRequestMdl {

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
	private long expiresOn = Date.from(Instant.now()).getTime() + 7776000;
	@Field("createdAt")
	private long createdAt = Date.from(Instant.now()).getTime();
	
	public ServiceSubscriptionRequestMdl() {
		// TODO Auto-generated constructor stub
	}

	public ServiceSubscriptionRequestMdl(String id, String serviceId, String appId, String subscriptionPlan,
			String subscriptionKey, long expiresOn, long createdAt) {
		super();
		this.id = id;
		this.serviceId = serviceId;
		this.appId = appId;
		this.subscriptionPlan = subscriptionPlan;
		this.subscriptionKey = subscriptionKey;
		this.expiresOn = expiresOn;
		this.createdAt = createdAt;
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

	@Override
	public String toString() {
		return "ServiceSubscriptionRequestMdl [id=" + id + "]";
	}
	
	
}
