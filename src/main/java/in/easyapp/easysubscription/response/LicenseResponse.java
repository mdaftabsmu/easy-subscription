package in.easyapp.easysubscription.response;

public class LicenseResponse {
    private String appId = "appId_1";
    private String serviceId = "serviceId_1";
    private String status = "SUCCESS";

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
