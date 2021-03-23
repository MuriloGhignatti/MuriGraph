package interfaces;

public interface IAdjacency<T>{

    //Setters section
    void setLabel(String label);
    void setVertex(IVertex<T> vertex);
    void setWeight(double weight);

    //Getters section
    T getInformation();
    String getLabel();
    IVertex<T> getVertex();
    double getWeight();
}
