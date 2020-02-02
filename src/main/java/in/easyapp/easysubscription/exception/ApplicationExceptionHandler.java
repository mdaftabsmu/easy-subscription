package in.easyapp.easysubscription.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler
{
    @ExceptionHandler(AppServiceException.class)
    public ResponseEntity<String> handle(AppServiceException e)
    {
        int statusCode = e.getStatusCode() == 0? 500: e.getStatusCode();
        return ResponseEntity.status(statusCode).body(e.getMessage());
    }
    
    @ExceptionHandler(RequestException.class)
    public ResponseEntity<String> handle(RequestException e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(e.getMessage());
    }
}
