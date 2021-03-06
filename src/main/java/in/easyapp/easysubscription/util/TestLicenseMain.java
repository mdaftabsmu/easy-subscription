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

	String licenseString = "8658da2f997553b66db7a34e7bdfcd0d9dfa6444c90161a1f9f67a4704a5706e4df93998b40d62051918401ebcbf57fcff7a35064aff40846ebf597e5a71209e7b97cd8d97ef5227170170d15f774b615ddede9bd4f8f170e421f1f14e605c8af3d047fe0c53c3834ed6f440aa566f2fed5abd914ae3828cac949edc3cb421b2ad60a688b495ba1f0c29f43f7cecd48e35aafa1699d9053c754ee3114554eedbcc1a96c5fc7d2f165ec0475be5ae16efc46867693adc0b3abb55f4a3aac6be1ba1be55e99be85d53d0ea8c2b76c0ac4458367327427ff56f665bf8dda36f3e914962feef98c6368ca0e660feedc97255e5e1640f656c4a73ef033feb872a23c4f515498dc2734d5c0b6e0599c8bd9e5ba5812d7a4d5fa3f881af0c6db16333deb390614f2494e1af0ce25f2ebddf491c430f7c17558d994700f9090dd75039010189e7d68b8d4559aadfb716b66ff06c3f03719af99865032db3d060063182286ac19e623e3f42db0528c93943aad9675cfb60ef6ea73754174637104a57f3941ec903b6f580833c3b574d290ff7a9970f4236a9d570c960bafff0e3601507ead507ff2a178d9f5b10a9468094c282b1";

	String publickey = "30819f300d06092a864886f70d010101050003818d003081893032301006072a8648ce3d02002EC311215SHA512withECDSA106052b81040006031e00045d48c0ebb64420d1fd8f8c3afaf3bf5f0bd5f0fba33b1e9b2843f413G02818100c799cd7ea0da75a477a6d2301a2dcc2f08cb01c81356e800bf4dabd569635544c828d0c60f793c0ab10b7b8c9e3f40944c8c881d562a045020257c1a4b0fb277ad323508100cf94933b45ffff2d79cd2b8a32ded7b24c98e1d8f99a2cec9c1c503RSA4102413SHA512withRSA230e3cae3a989f700eaac712bd9ca582c43bfad97bb08be20894e22d887577850203010001";

	String productID = "121";
	String productEdition = null;
	String productVersion = null;
	Date licenseExpireDate = new Date(1582564758163L);
	Date maintenanceExpireDate = null;

	License license = LicenseValidator.validate(
		licenseString,
		publickey,
		productID,
		null,
		null,
		null,
		null);
	System.out.println("Validating with all correct parameters: " + license.getValidationStatus());

	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date(1579972758163L));
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

	cal = Calendar.getInstance();
	cal.setTime(licenseExpireDate);
	cal.add(Calendar.DAY_OF_YEAR, 1);

	license = LicenseValidator.validate(
		licenseString,
		publickey,
		productID,
		productEdition,
		productVersion,
		cal.getTime(),
		null);
	System.out.println("Validating with local time 1 day later of validity period: " + license.getValidationStatus());


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
	 *       1); // For information on hardware ID method see user guide.
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
