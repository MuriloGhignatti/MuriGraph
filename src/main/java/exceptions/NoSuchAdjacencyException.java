package exceptions;

public class NoSuchAdjacencyException extends Exception{
    public NoSuchAdjacencyException(String errorMessage){
        super(errorMessage);
    }
}
