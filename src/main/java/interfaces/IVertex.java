package interfaces;

import exceptions.AdjacencyAlreadyExistsException;
import exceptions.NoSuchAdjacencyException;

import java.util.Collection;
import java.util.Map;

public interface IVertex<T>{

    //Setters section
    void setInformation(T information);
    void setLabel(String label);

    //Getters section
    IAdjacency<T> getAdjacencie(T destinationVertexInformation) throws NoSuchAdjacencyException;
    IAdjacency<T> getAdjacencie(IVertex<T> destinationVertexInformation) throws NoSuchAdjacencyException;
    Collection<IAdjacency<T>> getAdjacencies();
    int getAdjacenciesSize();
    Map<T, IAdjacency<T>> getMapAdjacencies();
    T getInformation();
    String getLabel();

    //Edges section
    void addAdjacency(T info, IAdjacency<T> adjacency);
    void addAdjacency(IAdjacency<T> adjacency) throws AdjacencyAlreadyExistsException;
    void addAdjacency(IVertex<T> vertex) throws AdjacencyAlreadyExistsException;

    boolean existAdjacency(IAdjacency<T> adjacency);
    boolean existAdjacency(IVertex<T> vertex);
    boolean existAdjacency(T information);

    boolean hasAnyAdjacency();

    void removeAdjacency(IAdjacency<T> adjacency) throws NoSuchAdjacencyException;
    void removeAdjacency(IVertex<T> vertex) throws NoSuchAdjacencyException;
    void removeAdjacency(T info) throws NoSuchAdjacencyException;

}
