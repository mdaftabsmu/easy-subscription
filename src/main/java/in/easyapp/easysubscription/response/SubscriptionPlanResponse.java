package in.easyapp.easysubscription.response;

import in.easyapp.easysubscription.models.SubscriptionPlanMdl;

public class SubscriptionPlanResponse implements EasyResponse {
	 private String planName;
	    private String planDescription;
	    private int validityInDays;
	    private float  price;

	    public SubscriptionPlanResponse(SubscriptionPlanMdl plan) {
	    	planName = plan.getPlanName();
	    	planDescription = plan.getPlanDescription();
	    	validityInDays = plan.getValidityInDays();
	    	price =plan.getPrice();
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
	}
