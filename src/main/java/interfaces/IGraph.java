package interfaces;

import exceptions.AdjacencyAlreadyExistsException;
import exceptions.NoSuchAdjacencyException;
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

    void addVertex(T information) throws VertexAlreadyExistsException;

    void addVertex(IVertex<T> vertex) throws VertexAlreadyExistsException;

    double[][] getAdjacencyMatrix();

    void createAdjacency(T sourceVertex, T destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, T destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, T destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, T destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(T sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    void createAdjacency(IVertex<T> sourceVertex, T destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException;

    boolean existVertex(T information);

    boolean existVertex(IVertex<T> vertex);

    void generatePajekFile(String fileName);

    void generateGraphmlFile(String fileName);

    void loadPajekFile(String fileName);

    void printAdjacencies(IVertex<T> vertex);

    void printAdjacencies(T information) throws NoSuchVertexException;

    void removeVertex(T information) throws NoSuchVertexException;

    void removeVertex(IVertex<T> vertex) throws NoSuchVertexException;

    void removeAdjacency(T sourceVertex, T destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException;

    void removeAdjacency(T sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException;

    void removeAdjacency(IVertex<T> sourceVertex, T destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException;

    void removeAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException;

    void searchDepth(T information) throws NoSuchVertexException;

    void searchDepth(IVertex<T> sourceVertex);

    void searchWidth(T information) throws NoSuchVertexException;

    void searchWidth(IVertex<T> sourceVertex);
}
