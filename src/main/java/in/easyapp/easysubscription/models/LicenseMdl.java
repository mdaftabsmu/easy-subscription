package in.easyapp.easysubscription.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Document(collation= "license")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseMdl {
	@Id
	private String id;
	@Field("appId")
	private String appId;
	@Field("serviceId")
    private String serviceId;
	@Field("validForDays")
    private int  validForDays = 180;
	@Field("userId")
    private String userId;
	@Field("licenseKey")
    private String licenseKey;
	@Field("activationRequired")
    private boolean  activationRequired  =false;

	public LicenseMdl() {
		// TODO Auto-generated constructor stub
	}
    public LicenseMdl(String id, String appId, String serviceId, int validForDays, String userId,
			String licenseKey, boolean activationRequired) {
		super();
		this.id = id;
		this.appId = appId;
		this.serviceId = serviceId;
		this.validForDays = validForDays;
		this.userId = userId;
		this.licenseKey = licenseKey;
		this.activationRequired = activationRequired;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
	@Override
	public String toString() {
		return "LicenseRequestMdl [id=" + id + "]";
	}
    
    
}
