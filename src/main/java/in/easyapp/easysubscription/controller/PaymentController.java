package in.easyapp.easysubscription.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.easyapp.easysubscription.request.SubscnOrderRequest;

@CrossOrigin
@RestController
public class PaymentController {
    private static boolean ok = true;
    static synchronized void toggleOK(){
        ok = !ok;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.POST)
    public ResponseEntity<String> createPaymentOrder(Principal principal,SubscnOrderRequest order){
        return ResponseEntity.status(201).body("{\"id\":\"order_id_XYZ\"}");
    }

    @RequestMapping(value = "/confirmPayment", method = RequestMethod.POST)
    public ResponseEntity<String> confirmPayment(@RequestParam(value = "orderId", required = true) String orderId,
                                                 @RequestParam(value = "token", required = true) String token,
                                                 @RequestParam(value = "channel", required = true) String channel){
        if(ok) {
            return ResponseEntity.ok("{ \"message\":\"order confirmed\"}");
        }else {
            return ResponseEntity.status(400).body("{ \"message\":\"order confirmed\"}");
        }
    }

    @RequestMapping(value = "/toggleConfirmation", method = RequestMethod.GET)
    public ResponseEntity<String> toggle(Principal principal){
        toggleOK();
        String state = "";
        state += ok;
        return ResponseEntity.ok(state);
    }
}
