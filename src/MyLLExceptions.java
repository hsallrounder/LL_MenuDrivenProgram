public class MyLLExceptions extends Exception{
    public MyLLExceptions() {
    }
}
class EmptyListException extends MyLLExceptions{
    public EmptyListException() {}

    @Override
    public String getMessage() {
        return "Oops! List is Empty.";
    }
}
class InvalidInputException extends MyLLExceptions{
    public InvalidInputException() {
    }

    @Override
    public String getMessage() {
        return "Invalid Input.";
    }
}
class NoSuchValueException extends MyLLExceptions{
    public NoSuchValueException() {
    }

    @Override
    public String getMessage() {
        return "No such value present.";
    }
}
class PostionMismatchException extends MyLLExceptions{
    public PostionMismatchException() {
    }

    @Override
    public String getMessage() {
        return "Position starts from 1.";
    }
}

