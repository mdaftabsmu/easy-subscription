package in.easyapp.easysubscription.request;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ProjectRequest {
	private String appId;
	private String appName = "TestApp-Name";
	private String description ="....";
	private String createdBy = " ";
	private  boolean isActive = true;
	private List<ServiceSubscriptionRequest> services = new ArrayList<>();
	private long createdAt = Date.from(Instant.now()).getTime();

	public ProjectRequest(){
		this.appId = "appId_1";
	}

	public List<ServiceSubscriptionRequest> getServices() {
		return services;
	}

	public void setServices(List<ServiceSubscriptionRequest> services) {
		this.services = services;
	}

	public ProjectRequest(int count){
		this.appId = "appId_"+count;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

}
