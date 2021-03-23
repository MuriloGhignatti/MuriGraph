package interfaces;

import java.util.Collection;

public interface IVertex<T>{

    //Setters section
    void setInformation(T information);
    void setLabel(String label);

    //Getters section
    T getInformation();
    String getLabel();
    Collection<IAdjacency<T>> getAdjacencies();

    //Edges section
    void addAdjacency(T info, IAdjacency<T> adjacency);
    void addAdjacency(IAdjacency<T> adjacency);
    void addAdjacency(IVertex<T> vertex);

    boolean existAdjacency(IAdjacency<T> adjacency);
    boolean existAdjacency(IVertex<T> vertex);
    boolean existAdjacency(T information);

    boolean hasAnyAdjacency();

    void removeAdjacency(IAdjacency<T> adjacency);
    void removeAdjacency(IVertex<T> vertex);
    void removeAdjacency(T info);

}
