package exceptions;

public class AdjacencyAlreadyExistsException extends Exception{
    public AdjacencyAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
