package interfaces;

import exceptions.NoSuchVertexException;
import exceptions.VertexAlreadyExistsException;

import java.util.Collection;
import java.util.Map;

public interface IGraph<T> {

    void setDirected(boolean directed);

    void setInformation(T sourceVertexInformation, T information) throws NoSuchVertexException;

    void setVertexes(Map<T, IVertex<T>> vertexes);

    void setWeighted(boolean weighted);

    boolean getDirected();

    IVertex<T> getVertex(T information) throws NoSuchVertexException;

    Collection<IVertex<T>> getVertexes();

    int getVertexesSize();

    boolean getWeighted();

    void addNode(T information) throws VertexAlreadyExistsException;

    void addNode(IVertex<T> vertex) throws VertexAlreadyExistsException;

    double[][] getAdjacencyMatrix();

    void createAdjacency(T sourceVertex, T destinationVertex, String label, double weight) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, T destinationVertex, String label) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, T destinationVertex, double weight) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, T destinationVertex) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, String label, double weight) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, String label) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, double weight) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, String label, double weight) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, String label) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, double weight) throws NoSuchVertexException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, String label, double weight) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, String label) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, double weight) throws NoSuchVertexException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex) throws NoSuchVertexException;

    boolean existVertex(T information);

    boolean existVertex(IVertex<T> vertex);

    void generatePajekFile(String fileName);

    void generateGraphmlFile(String fileName);

    void loadPajekFile(String fileName);

    void printAdjacencies(IVertex<T> vertex);

    void printAdjacencies(T information) throws NoSuchVertexException;

    void removeNode(T information) throws NoSuchVertexException;

    void removeNode(IVertex<T> vertex) throws NoSuchVertexException;

    void removeAdjacency(T sourceVertex, T destinationVertex) throws NoSuchVertexException;

    void removeAdjacency(T sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException;

    void removeAdjacency(IVertex<T> sourceVertex, T destinationVertex) throws NoSuchVertexException;

    void removeAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException;

}
