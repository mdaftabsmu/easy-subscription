package in.easyapp.easysubscription.request;

public class LicenseRequest {
	private String appId = "appId_1";
    private String serviceId = "testService_1";
    private int  validForDays = 180;
    private String userId = "testUserId";
    private String licenseKey = "iuefifoesfj21epoj.fhaiwf9-28j.fuuihjbb7347yoihfygybki";
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
