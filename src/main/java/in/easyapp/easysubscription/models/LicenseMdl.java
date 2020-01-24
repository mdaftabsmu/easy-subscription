package in.easyapp.easysubscription.models;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


@Document(collation= "license")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LicenseMdl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	@Field("appId")
	private String appId ;
	@Field("serviceId")
	private String serviceId ;
	@Field("validForDays")
	private int  validForDays = 180;
	@Field("userId")
	private String userId;
	@Field("licenseKey")
	private String licenseKey ;
	@Field("activationRequired")
	private boolean  activationRequired ;
	@Field("created_at")
	private Date createdAt;
	

	public LicenseMdl() {
		// TODO Auto-generated constructor stub
	}

	public LicenseMdl(String appId, String serviceId, int validForDays, String userId, String licenseKey,
			boolean activationRequired) {
		this.appId = appId;
		this.serviceId = serviceId;
		this.validForDays = validForDays;
		this.userId = userId;
		this.licenseKey = licenseKey;
		this.activationRequired = activationRequired;
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

	public boolean getActivationRequired() {
		return activationRequired;
	}

	public void setActivationRequired(boolean activationRequired) {
		this.activationRequired = activationRequired;
	}
	

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "LicenseRequestMdl [appId=" + appId + ", userId=" + userId + "]";
	}  

}
