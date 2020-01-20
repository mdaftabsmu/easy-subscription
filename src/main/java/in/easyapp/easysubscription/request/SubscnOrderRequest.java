package in.easyapp.easysubscription.request;

public class SubscnOrderRequest {
	 private String serviceId;
	    private String appId;
	    private String subscriptionPlan;
	    private String subscriptionKey;
	    private long expiresOn;
	    private long createdAt;

	    public String getServiceId() {
	        return serviceId;
	    }

	    public void setServiceId(String serviceId) {
	        this.serviceId = serviceId;
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

	    public long getExpiresOn() {
	        return expiresOn;
	    }

	    public void setExpiresOn(long expiresOn) {
	        this.expiresOn = expiresOn;
	    }

	    public long getCreatedAt() {
	        return createdAt;
	    }

	    public void setCreatedAt(long createdAt) {
	        this.createdAt = createdAt;
	    }

}
