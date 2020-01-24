package in.easyapp.easysubscription.models;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import in.easyapp.easysubscription.request.ProjectRequest;

@Document(collation= "project")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectRequestMdl {
	@Id
	private String id;
	@Field("appId")
	private String appId;
	@Field("appName")
	private String appName ;
	@Field("description")
	private String description;
	@Field("createdBy")
	private String createdBy;
	@Field("isActive")
	private  boolean isActive = true;
	@Field("services")
	private List<ServiceSubscriptionRequestMdl> services;
	@Field("createdAt")
	private long createdAt = Date.from(Instant.now()).getTime();

	public ProjectRequestMdl(String id, String appId, String appName, String description, String createdBy,
			boolean isActive, List<ServiceSubscriptionRequestMdl> services, long createdAt) {
		super();
		this.id = id;
		this.appId = appId;
		this.appName = appName;
		this.description = description;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.services = services;
		this.createdAt = createdAt;
	}
	public ProjectRequestMdl(ProjectRequest mdl,List<ServiceSubscriptionRequestMdl> services) {
		this.appId = mdl.getAppId();
		this.appName = mdl.getAppName();
		this.description= mdl.getDescription();
		this.createdBy = mdl.getCreatedBy();
		this.isActive = true;
		this.services = services;
		this.createdAt = Date.from(Instant.now()).getTime();
	}

	public ProjectRequestMdl(ProjectRequest mdl) {
		this.appId = mdl.getAppId();
		this.appName = mdl.getAppName();
		this.description= mdl.getDescription();
		this.createdBy = mdl.getCreatedBy();
		this.isActive = true;
		this.createdAt = Date.from(Instant.now()).getTime();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProjectRequestMdl(){
	}

	public List<ServiceSubscriptionRequestMdl> getServices() {
		return services;
	}

	public void setServices(List<ServiceSubscriptionRequestMdl> services) {
		this.services = services;
	}

	public ProjectRequestMdl(int count){
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

	public boolean getActive() {
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

	@Override
	public String toString() {
		return "ProjectRequestMdl [id=" + id + "]";
	}
	
	

}
