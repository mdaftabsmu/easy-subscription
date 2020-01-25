package in.easyapp.easysubscription.util;
/*
 * Save this code in a file named as TestLicenseMain.java.
 * Add License4J Runtime Library then run.
 */

import com.license4j.License;
import com.license4j.LicenseValidator;
import java.util.Calendar;
import java.util.Date;

public class TestLicenseMain {

	public static void main(String[] args) {

	String licenseString = "ab54cbf61a86c2f233677c23d2997119c5de299bb7e2788c21c448a52bc21c8e1e16bb10a935c7b82f680434fed06cf3ca5d72ff99164225afe5fc36a34e850dff0945460528adee0027812e403c293fb4586834f5c2ccb4015062802337999d70e15f905d67e605328e8aa9beb5ff8a1eb07bdebe932d9b3e4e63efe05afdabc3e60291ca3f7422899bca5acbb9607e892959b79bb2c259ef94dfde1ba6baa6fd4a631f0f79c48a355c28c68a674890f568a7524f34336220d683c752c6c997f3747ea9dcaf8c91ab06ccccd3761adf409074c57336164854d096b24c506595573a8a2c13d4c33a293f2fd1191ab2da461b8449d6066b28fc1ba70bb7301893da4e6d5689ac72ea48864732aa7229b3d04ec768c95d324bf2d4a84605ea916411dbd723260763df01de51e990328d8a96ba28964cd2820c584c3acf20766525e1ca24d73f84c1b9abf149c992cec619a4f4f419bb2914bea683aeca9f7e643d73526cea50eba6ad9b1caab5dde2896b5ce7242a39e1cfa28c5c307e7449d6c28cbe9d9d2976e2cba27dc66b99795929c167256c9a9b81d757c993db6998db5f";

	String publickey = "30819f300d06092a864886f70d010101050003818d003081893032301006072a8648ce3d02002EC311215SHA512withECDSA106052b81040006031e000447c643bca9b9ea0a215d76926f9c27d5001634615d394f520164f678G02818100a61e2b55bb89fbfb155aeca2f643b71c87073868d3f261cd030b939798893309cc46a0a5729bf025e710aecad0e954cdae7949f685a80ae471f0c37303748e3c18dde9abb2b441cd941fded8d3f841b852f5fe1067ccad3a5083e493a269383103RSA4102413SHA512withRSA5a8991cf932938aa38ca940c06ffced34d8cfa8f6d881fde275b11b47c8d6ba90203010001";

	String productID = "121";
	String productEdition = null;
	String productVersion = null;
	Date licenseExpireDate = null;
	Date maintenanceExpireDate = null;

	License license = LicenseValidator.validate(
		licenseString,
		publickey,
		productID,
		productEdition,
		productVersion,
		null,
		null);
	System.out.println("Validating with all correct parameters: " + license.getValidationStatus());

	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date(1579971306547L));
	cal.add(Calendar.DAY_OF_YEAR, 1);

	license = LicenseValidator.validate(
		licenseString,
		publickey,
		productID,
		productEdition,
		productVersion,
		cal.getTime(),
		null);
	System.out.println("Validating with all correct parameters (date set 1 day after generation date time): " + license.getValidationStatus());


	license = LicenseValidator.validate(
		licenseString,
		publickey,
		"incorrect-id",
		productEdition,
		productVersion,
		null,
		null);
	System.out.println("Validating with incorrect product id ('incorrect-id'): " + license.getValidationStatus());

	cal = Calendar.getInstance();
	cal.setTime(new Date());
	cal.add(Calendar.HOUR_OF_DAY, 48);

	license = LicenseValidator.validate(
		licenseString,
		publickey,
		productID,
		productEdition,
		productVersion,
		cal.getTime(),
		null);
	System.out.println("Validating with incorrect local time: " + license.getValidationStatus());


	license = LicenseValidator.validate(
		licenseString,
		publickey,
		productID,
		productEdition,
		productVersion,
		null,
		null);
	System.out.println("Validating before activation: " + license.getValidationStatus());


	// Auto activate license.
	License activatedLicense = LicenseValidator.autoActivate(license, "http://localhost:8080/algas/");
	System.out.println("License Activation Status: " + activatedLicense.getActivationStatus());

	/**
	 * NOTICE
	 *
	 * In your software product, you should save activated license string
	 * into a file on customer's disk; then validate on each software
	 * startup.
	 *
	 * Use the following method to get activated license string and save it
	 * to a license file:
	 * <pre>
	 * String myActivatedLicenseString = activatedLicense.getLicenseString();
	 * </pre>
	 *
	 * Then on each software startup use following validate method to validate it:
	 * 
	 * <pre>
	 * License licenseOnDisk = LicenseValidator.validate(
	 *       myActivatedLicenseString,
	 *       publickey,
	 *       null,
	 *       null,
	 *       null,
	 *       14); // For information on hardware ID method see user guide.
	 * </pre>
	 *
	 * Depending on validation status of the license saved on disk either
	 * allow to run your software or display a message to customer (e.g.
	 * license is invalid or license is expired etc). Following is a switch
	 * block for testing validation status.
	 * <pre>
	 * switch (licenseOnDisk.getValidationStatus()) {
	 *   case LICENSE_VALID:
	 *       // the activated license is valid, no problem, run the software.
	 *       break;
	 *   case LICENSE_EXPIRED:
	 *       // the activated license is expired, display a message to customer and do not allow software run.
	 *       JOptionPane.showMessageDialog(null, "Your license expired, get a new license.");
	 *       break;
	 *   //case XXX: // Put all other ValidationStatus codes here you need.
	 *   //   break;
	 *   default:
	 *       // not reachable if you put all your alternative validation status codes.
	 *       break;
	 * }
	 * </pre>
	 */

	}
}
