public class MyMenuException extends Exception{
    public MyMenuException(String message) {
        super(message);
    }
}
class InvalidRangeException extends MyMenuException{
    public InvalidRangeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
