package in.easyapp.easysubscription.response;


import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import in.easyapp.easysubscription.models.ProjectRequestMdl;

public class ProjectResponse {
	private String appId;
	private String appName;
	private String description;
	private String createdBy;
	private  boolean isActive = true;
	private List<ServiceSubscriptionResponse> services;
	private long createdAt = Date.from(Instant.now()).getTime();

	public ProjectResponse(){
		this.appId = "appId_1";
	}

	public List<ServiceSubscriptionResponse> getServices() {
		return services;
	}

	public void setServices(List<ServiceSubscriptionResponse> services) {
		this.services = services;
	}

	public ProjectResponse(int count){
		this.appId = "appId_"+count;
	}

	public ProjectResponse(ProjectRequestMdl mdl) {
		this.appId = mdl.getAppId();
		this.appName = mdl.getAppName();
		this.description= mdl.getDescription();
		this.createdBy = mdl.getCreatedBy();
		this.isActive = mdl.getActive();
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

