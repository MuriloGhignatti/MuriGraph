package exceptions;

public class VertexAlreadyExistsException extends Exception{

    public VertexAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
