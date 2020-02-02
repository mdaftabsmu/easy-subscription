package in.easyapp.easysubscription.request;

public class LicenseRequest {
	private String appId;
    private String serviceId;
    private int  validForDays = 180;
    private String userId;
    private String licenseKey;
    private boolean  activationRequired  =false;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public int getValidForDays() {
        return validForDays;
    }

    public void setValidForDays(int validForDays) {
        this.validForDays = validForDays;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public boolean isActivationRequired() {
        return activationRequired;
    }

    public void setActivationRequired(boolean activationRequired) {
        this.activationRequired = activationRequired;
    }
}
