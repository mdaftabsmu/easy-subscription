package in.easyapp.easysubscription.exception;

public class AppServiceException extends RuntimeException {
    private int statusCode;

    public AppServiceException(int statusCode){
        super();
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return this.statusCode;
    }
}
