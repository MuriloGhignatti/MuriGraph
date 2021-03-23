package graph;

import interfaces.IAdjacency;
import interfaces.IVertex;

import java.util.Collection;
import java.util.Map;

public class Vertex<T> implements IVertex<T> {

    private T information;
    private Map<T, IAdjacency<T>> adjacencies;

    public Vertex(T information, Map<T, IAdjacency<T>> adjacencies){
        this.information = information;
        this.adjacencies = adjacencies;
    }

    public Vertex(T information){
        this.information = information;
    }

    @Override
    public void setInformation(T information) {

    }

    @Override
    public void setLabel(String label) {

    }

    @Override
    public T getInformation() {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public Collection<IAdjacency<T>> getAdjacencies() {
        return adjacencies.values();
    }

    @Override
    public void addAdjacency(T info, IAdjacency<T> adjacency) {

    }

    @Override
    public void addAdjacency(IAdjacency<T> adjacency) {

    }

    @Override
    public void addAdjacency(IVertex<T> vertex) {

    }

    @Override
    public boolean existAdjacency(IAdjacency<T> adjacency) {
        return false;
    }

    @Override
    public boolean existAdjacency(IVertex<T> vertex) {
        return false;
    }

    @Override
    public boolean existAdjacency(T information) {
        return false;
    }

    @Override
    public boolean hasAnyAdjacency() {
        return adjacencies != null;
    }

    @Override
    public void removeAdjacency(IAdjacency<T> adjacency) {

    }

    @Override
    public void removeAdjacency(IVertex<T> vertex) {

    }

    @Override
    public void removeAdjacency(T info) {

    }
}
