package in.easyapp.easysubscription.response;

import java.util.List;


public class ServiceResponse {
	private String serviceId;
    private String description = "...";
    private String urlMapping = "/xx/..";
    private String[] licensedMethods = {"GET","POST", "PUT", "DELETE"};
    private List<SubscriptionPlanResponse> plans;

    public ServiceResponse(){
        this.serviceId = "TestService";
    }

    public ServiceResponse(String serviceId){
        this.serviceId = serviceId;
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

    public List<SubscriptionPlanResponse> getPlans() {
        return plans;
    }

    public void setPlans(List<SubscriptionPlanResponse> plans) {
        this.plans = plans;
    }
}
