package graph;

import interfaces.IAdjacency;
import interfaces.IVertex;

public class Adjacency<T> implements IAdjacency<T> {

    private String label;
    private IVertex<T> sourceVertex;
    private IVertex<T> destinationVertex;
    private double weight;

    public Adjacency(String label, IVertex<T> sourceVertex, IVertex<T> destinationVertex, double weight){
        this.label = label;
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
        this.weight = weight;
    }

    public Adjacency(String label, IVertex<T> sourceVertex, IVertex<T> destinationVertex){
        this(label, sourceVertex, destinationVertex, 0.0);
    }

    public Adjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, double weight){
        this(null, sourceVertex, destinationVertex, weight);
    }

    public Adjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex){
        this(sourceVertex, destinationVertex, 0.0);
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setDestinationVertex(IVertex<T> destinationVertex) {
        this.destinationVertex = destinationVertex;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public T getDestinationInformation() {
        return destinationVertex.getInformation();
    }

    @Override
    public IVertex<T> getSourceVertex() {
        return sourceVertex;
    }

    @Override
    public T getSourceVertexInformation() {
        return sourceVertex.getInformation();
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public IVertex<T> getDestinationVertex() {
        return destinationVertex;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
