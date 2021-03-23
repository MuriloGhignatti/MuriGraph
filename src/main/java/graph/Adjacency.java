package graph;

import interfaces.IAdjacency;
import interfaces.IVertex;

public class Adjacency<T> implements IAdjacency<T> {

    private String label;
    private IVertex<T> vertex;
    private double weight;

    public Adjacency(String label, IVertex<T> vertex, double weight){
        this.label = label;
        this.vertex = vertex;
        this.weight = weight;
    }

    public Adjacency(String label, IVertex<T> vertex){
        this(label, vertex, 0.0);
    }

    public Adjacency(IVertex<T> vertex, double weight){
        this(null, vertex, weight);
    }

    public Adjacency(IVertex<T> vertex){
        this(null, vertex, 0.0);
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setVertex(IVertex<T> vertex) {
        this.vertex = vertex;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public T getInformation() {
        return vertex.getInformation();
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public IVertex<T> getVertex() {
        return vertex;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
