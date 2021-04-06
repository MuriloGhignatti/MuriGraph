package heuristic_searches;

import exceptions.NoSuchVertexException;
import exceptions.VertexAlreadyExistsException;
import interfaces.IAdjacency;
import interfaces.IGraph;
import interfaces.IVertex;

import java.util.*;

public class AStar<T> {

    private final Map<T, Double> heuristicValue;
    private final IGraph<T> graph;

    public AStar(Map<T, Double> heuristicValue, IGraph<T> graph) {
        this.heuristicValue = heuristicValue;
        this.graph = graph;
    }

    public AStar(IGraph graph) {
        this(new HashMap<>(), graph);
    }

    public AStar() {
        this(new HashMap<>(), null);
    }

    public void addHeuristicValue(T vertexInformation, Double value) throws VertexAlreadyExistsException {
        if (heuristicValue.containsKey(vertexInformation)) {
            StringBuilder messageError = new StringBuilder("Vertex ");
            messageError.append(vertexInformation);
            messageError.append(" with the value of ");
            messageError.append(heuristicValue.get(vertexInformation));
            throw new VertexAlreadyExistsException(messageError.toString());
        }
        heuristicValue.put(vertexInformation, value);
    }

    public void addHeuristicValue(IVertex<T> vertex, Double value) throws VertexAlreadyExistsException {
        addHeuristicValue(vertex.getInformation(), value);
    }
}
