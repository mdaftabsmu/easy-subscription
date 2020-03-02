package in.easyapp.easysubscription.models;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import in.easyapp.easysubscription.request.SubscriptionPlanRequest;

@Document(collection= "serviceMdl")
public class ServiceMdl {
	@Id
	private String id;
	@Field("serviceId")
	private String serviceId;
	@Field("description")
	private String description;
	@Field("urlMapping")
	private String urlMapping;
	@Field("licensedMethods")
	private String[] licensedMethods;
	@Field("plans")
	private List<SubscriptionPlanMdl> plans;
	@Field("createAt")
	private Date createAt;
	@Field("isActive")
	private boolean isActive;

	public ServiceMdl() {
		// TODO Auto-generated constructor stub
	}
	

	public ServiceMdl(String serviceId, String description, String urlMapping, String[] licensedMethods,
			List<SubscriptionPlanMdl> plans, Date createAt, boolean isActive) {
		super();
		this.serviceId = serviceId;
		this.description = description;
		this.urlMapping = urlMapping;
		this.licensedMethods = licensedMethods;
		this.plans = plans;
		this.createAt = createAt;
		this.isActive = isActive;
	}


	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlMapping() {
		return urlMapping;
	}

	public void setUrlMapping(String urlMapping) {
		this.urlMapping = urlMapping;
	}

	public String[] getLicensedMethods() {
		return licensedMethods;
	}

	public void setLicensedMethods(String[] licensedMethods) {
		this.licensedMethods = licensedMethods;
	}

	public List<SubscriptionPlanMdl> getPlans() {
		return plans;
	}

	public void setPlans(List<SubscriptionPlanMdl> plans) {
		this.plans = plans;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	

}
