package in.easyapp.easysubscription.controller;

import org.springframework.web.bind.annotation.*;

import in.easyapp.easysubscription.exception.AppServiceException;
import in.easyapp.easysubscription.response.ServiceResponse;
import in.easyapp.easysubscription.response.SubscriptionPlanResponse;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ServiceController {


    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public List<ServiceResponse> getServices(Principal principal,@RequestParam(value = "appId", required = false) String appId) {
        List<ServiceResponse> srvList = new ArrayList<>();
        ServiceResponse mdl_1 = new ServiceResponse("Service_1");
        mdl_1.setDescription("This is dummy service 1");
        List<SubscriptionPlanResponse> plans = new ArrayList<>();
        String[] plElem = {"GOLD", "SILVER", "DEDICATED"};
        float price = 1200;

        for(int i=0; i< 3; i++) {
            SubscriptionPlanResponse plan = new SubscriptionPlanResponse();
            plan.setPlanName(plElem[i]);
            plan.setPlanDescription("High Throughput. Validity till 360 days");
            plan.setPrice(price);
            plan.setValidityInDays(180);
            plans.add(plan);
            price = price + 300;
        }
        mdl_1.setPlans(plans);
        srvList.add(mdl_1);
        if(appId == null || appId.isEmpty()) {
            List<SubscriptionPlanResponse> plans2 = new ArrayList<>();
            ServiceResponse mdl_2 = new ServiceResponse("LittleBigNameServiceID_00011");
            for(int i=0; i< 3; i++) {
                SubscriptionPlanResponse plan = new SubscriptionPlanResponse();
                plan.setPlanName(plElem[i]);
                plan.setPlanDescription("Secured High Throughput. Validity till 360 days");
                plan.setPrice(price);
                plan.setValidityInDays(360);
                plans2.add(plan);
                price = price + 300;
            }
            mdl_2.setPlans(plans2);
            srvList.add(mdl_2);
        }
        return srvList;
    }

    @RequestMapping(value = "/services/{serviceId}", method = RequestMethod.GET)
    public ServiceResponse getServiceById(Principal principal,@PathVariable("serviceId") String serviceId) {
        String[] plElem = { "GOLD", "SILVER", "DEDICATED" };
        if(serviceId.equals("Service_1")){
            ServiceResponse mdl_1 = new ServiceResponse("Service_1");
            mdl_1.setDescription("This is dummy service 1");
            List<SubscriptionPlanResponse> plans = new ArrayList<>();

            float price = 1200;
            for(int i=0; i< 3; i++) {
                SubscriptionPlanResponse plan = new SubscriptionPlanResponse();
                plan.setPlanName(plElem[i]);
                plan.setPlanDescription("High Throughput. Validity till 360 days");
                plan.setPrice(price);
                plan.setValidityInDays(180);
                plans.add(plan);
                price = price + 300;
            }
            mdl_1.setPlans(plans);
            return mdl_1;
        }
        else if(serviceId.equals("LittleBigNameServiceID_00011")) {
            List<SubscriptionPlanResponse> plans2 = new ArrayList<>();
            ServiceResponse mdl_2 = new ServiceResponse("LittleBigNameServiceID_00011");
            float price = 2100;
            for(int i=0; i< 3; i++) {
                SubscriptionPlanResponse plan = new SubscriptionPlanResponse();
                plan.setPlanName(plElem[i]);
                plan.setPlanDescription("Secured High Throughput. Validity till 360 days");
                plan.setPrice(price);
                plan.setValidityInDays(360);
                plans2.add(plan);
                price = price + 300;
            }
            mdl_2.setPlans(plans2);
            return mdl_2;
        }
        else {
            throw new AppServiceException(404);
        }
    }
}
