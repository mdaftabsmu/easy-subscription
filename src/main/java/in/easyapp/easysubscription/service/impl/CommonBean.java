package in.easyapp.easysubscription.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommonBean {
	
	@Value("${YEAR_SERVICE_ID}")
	public  String twelveServiceId;
	@Value("${SIX_SERVICE_ID}")
	public  String sixServiceId;
	@Value("${EASY_SERVICE_PRODOCT_ID}")
	private String easyServiceProductId;
	@Value("${EASY_PUBLIC_KEY}")
	private String publicKey;
	
	
	public String getEasyServiceProductId() {
		return easyServiceProductId;
	}
	public void setEasyServiceProductId(String easyServiceProductId) {
		this.easyServiceProductId = easyServiceProductId;
	}
	public String getTwelveServiceId() {
		return twelveServiceId;
	}
	public void setTwelveServiceId(String twelveServiceId) {
		this.twelveServiceId = twelveServiceId;
	}
	public String getSixServiceId() {
		return sixServiceId;
	}
	public void setSixServiceId(String sixServiceId) {
		this.sixServiceId = sixServiceId;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	
	
	
	
	
	
	
	

}
