package in.easyapp.easysubscription.response;

import in.easyapp.easysubscription.models.LicenseMdl;

public class LicenseKeyResponse implements EasyResponse {
	private String licenseKey;
    private String userId;

    public LicenseKeyResponse(LicenseMdl mdl) {
		this.licenseKey = mdl.getLicenseKey();
		this.userId = mdl.getUserId();
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
}
