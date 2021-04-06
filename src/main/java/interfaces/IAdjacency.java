package interfaces;

public interface IAdjacency<T>{

    //Setters section
    void setLabel(String label);
    void setDestinationVertex(IVertex<T> destinationVertex);
    void setWeight(double weight);

    //Getters section
    String getLabel();
    IVertex<T> getDestinationVertex();
    T getDestinationInformation();
    IVertex<T> getSourceVertex();
    T getSourceVertexInformation();
    double getWeight();
}
