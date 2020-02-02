package in.easyapp.easysubscription.response;

public class EasyError implements EasyResponse {
	
	private int code;
	private String errorMsg;
	
	public EasyError() {
		// TODO Auto-generated constructor stub
	}

	public EasyError(int code, String errorMsg) {
		super();
		this.code = code;
		this.errorMsg = errorMsg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	

}
