package graph;

import exceptions.AdjacencyAlreadyExistsException;
import exceptions.NoSuchAdjacencyException;
import interfaces.IAdjacency;
import interfaces.IVertex;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Vertex<T> implements IVertex<T> {

    private T information;
    private String label;
    private Map<T, IAdjacency<T>> adjacencies;

    public Vertex(T information, Map<T, IAdjacency<T>> adjacencies, String label){
        this.information = information;
        this.adjacencies = adjacencies;
        this.label = label;
    }

    public Vertex(T information, String label){
        this(information, null, label);
    }

    public Vertex(T information){
        this(information, null, null);
    }

    public Vertex(IVertex<T> vertexToCopyFrom){
        this(vertexToCopyFrom.getInformation(), vertexToCopyFrom.getMapAdjacencies(), vertexToCopyFrom.getLabel());
    }

    @Override
    public void setInformation(T information) {
        this.information = information;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public IAdjacency<T> getAdjacencie(T destinationVertexInformation) throws NoSuchAdjacencyException {
        if(!adjacencies.containsKey(destinationVertexInformation)){
            StringBuilder errorMessage = new StringBuilder("Vertex ");
            errorMessage.append(information);
            errorMessage.append(" doesn't have any adjacency with ");
            errorMessage.append(destinationVertexInformation);
            throw new NoSuchAdjacencyException(errorMessage.toString());
        }
        return adjacencies.get(destinationVertexInformation);
    }

    @Override
    public IAdjacency<T> getAdjacencie(IVertex<T> destinationVertexInformation) throws NoSuchAdjacencyException {
        return getAdjacencie(destinationVertexInformation.getInformation());
    }

    @Override
    public Collection<IAdjacency<T>> getAdjacencies() {
        return adjacencies.values();
    }

    @Override
    public int getAdjacenciesSize() {
        return adjacencies.size();
    }

    @Override
    public Map<T, IAdjacency<T>> getMapAdjacencies() {
        return adjacencies;
    }

    @Override
    public T getInformation() {
        return information;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void addAdjacency(T info, IAdjacency<T> adjacency) {
        if(adjacencies == null)
            adjacencies = new HashMap<>();
        adjacencies.put(info, adjacency);
    }

    @Override
    public void addAdjacency(IAdjacency<T> adjacency) throws AdjacencyAlreadyExistsException {
        if(adjacencies == null)
            adjacencies = new HashMap<>();
        if(existAdjacency(adjacency)){
            StringBuilder errorMessageStringBuilder = new StringBuilder("Adjacency with information ");
            errorMessageStringBuilder.append(adjacency.getDestinationInformation());
            errorMessageStringBuilder.append(" already exists");
            throw new AdjacencyAlreadyExistsException(errorMessageStringBuilder.toString());
        }
        adjacencies.put(adjacency.getDestinationInformation(), adjacency);
    }

    @Override
    public void addAdjacency(IVertex<T> vertex) throws AdjacencyAlreadyExistsException {
        addAdjacency(new Adjacency<>(this, vertex));
    }

    @Override
    public boolean existAdjacency(IAdjacency<T> adjacency) {
        return existAdjacency(adjacency.getDestinationInformation());
    }

    @Override
    public boolean existAdjacency(IVertex<T> vertex) {
        return existAdjacency(vertex.getInformation());
    }

    @Override
    public boolean existAdjacency(T information) {
        if(!hasAnyAdjacency())
            return false;
        return adjacencies.containsKey(information);
    }

    @Override
    public boolean hasAnyAdjacency() {
        return adjacencies != null && adjacencies.size() != 0;
    }

    @Override
    public void removeAdjacency(IAdjacency<T> adjacency) throws NoSuchAdjacencyException {
        removeAdjacency(adjacency.getDestinationInformation());
    }

    @Override
    public void removeAdjacency(IVertex<T> vertex) throws NoSuchAdjacencyException {
        removeAdjacency(vertex.getInformation());
    }

    @Override
    public void removeAdjacency(T information) throws NoSuchAdjacencyException {
        if(!existAdjacency(information)){
            StringBuilder errorMessageStringBuilder = new StringBuilder("Adjacency with information ");
            errorMessageStringBuilder.append(information);
            errorMessageStringBuilder.append(" doesn't exist on the graph");
            throw new NoSuchAdjacencyException(errorMessageStringBuilder.toString());
        }
        adjacencies.remove(information);
    }
}
