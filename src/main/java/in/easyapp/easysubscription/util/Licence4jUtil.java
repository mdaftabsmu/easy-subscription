package in.easyapp.easysubscription.util;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.license4j.License;
import com.license4j.LicenseValidator;

public class Licence4jUtil {

	private static RestTemplate restTemplate = new RestTemplate();

	public static String generateLicence(String productId) {
		try {
			final String baseUrl = "http://localhost:8080/algas/generate/"+productId;
			ResponseEntity<String> response = restTemplate.postForEntity(new URI(baseUrl),null,String.class);
			if(response !=null && response.getStatusCodeValue()==200) {
				return response.getBody(); 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static License validate(String publicKey,String licenseStringToValidate,String serviceId) {
		
		
		return LicenseValidator.validate(
				licenseStringToValidate, // REQUIRED - license string
				publicKey, // REQUIRED - public key
				serviceId, // REQUIRED - product id
				null, // product edition if needed
				null, // product version if needed
				null, // current date, null for current date
				null);
	}
	
	


	public static void main(String[] args) {
			String generateLicence = new Licence4jUtil().generateLicence("1579972601640624559011579972662820");
			System.out.println(generateLicence);
	}

}
