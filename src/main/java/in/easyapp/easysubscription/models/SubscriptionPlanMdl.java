package in.easyapp.easysubscription.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection= "easy_subscription_plan")
public class SubscriptionPlanMdl {
	@Id
	private String id;
	@Field("planName")
	private String planName;
	@Field("planDescription")
	private String planDescription;
	@Field("validityInDays")
	private int validityInDays;
	@Field("price")
	private float  price;
	@Field("serviceId")
	private String serviceId;
	@Field("createAt")
	private Date createAt;
	@Field("isActive")
	private boolean isActive;
	
	public SubscriptionPlanMdl() {
		// TODO Auto-generated constructor stub
	}

	public SubscriptionPlanMdl(String planName, String planDescription, int validityInDays, float price,
			String serviceId, Date createAt, boolean isActive) {
		this.planName = planName;
		this.planDescription = planDescription;
		this.validityInDays = validityInDays;
		this.price = price;
		this.serviceId = serviceId;
		this.createAt = createAt;
		this.isActive = isActive;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public int getValidityInDays() {
		return validityInDays;
	}

	public void setValidityInDays(int validityInDays) {
		this.validityInDays = validityInDays;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
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