package in.easyapp.easysubscription.response;

import java.util.ArrayList;
import java.util.List;

import in.easyapp.easysubscription.models.ServiceMdl;
import in.easyapp.easysubscription.models.SubscriptionPlanMdl;


public class ServiceResponse implements EasyResponse{
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

    public ServiceResponse(ServiceMdl mdl) {
    	serviceId = mdl.getServiceId();
    	description = mdl.getDescription();
    	urlMapping = mdl.getUrlMapping();
    	licensedMethods = mdl.getLicensedMethods();
    	List<SubscriptionPlanResponse> planRes = new ArrayList<SubscriptionPlanResponse>();
    	 for(SubscriptionPlanMdl plan : mdl.getPlans()) {
    		 planRes.add(new SubscriptionPlanResponse(plan));
    	 }
    	 plans = planRes;
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
