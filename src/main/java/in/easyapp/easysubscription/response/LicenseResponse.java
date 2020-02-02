package in.easyapp.easysubscription.response;

import in.easyapp.easysubscription.models.LicenseMdl;

public class LicenseResponse implements EasyResponse {
    private String appId;
    private String serviceId;
    private String status;

    public LicenseResponse() {
		// TODO Auto-generated constructor stub
	}
    
    public LicenseResponse(LicenseMdl mdl) {
		this.appId = mdl.getAppId();
		this.serviceId = mdl.getServiceId();
		this.status = "SUCCESS";
	}

	public LicenseResponse(String appId, String serviceId, String valid) {
		this.appId = appId;
		this.serviceId = serviceId;
		this.status =valid;
	}

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
