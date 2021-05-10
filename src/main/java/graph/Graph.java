package graph;

import exceptions.AdjacencyAlreadyExistsException;
import exceptions.NoSuchAdjacencyException;
import exceptions.NoSuchVertexException;
import exceptions.VertexAlreadyExistsException;
import interfaces.IAdjacency;
import interfaces.IGraph;
import interfaces.IVertex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Graph<T> implements IGraph<T> {
    private Map<T, IVertex<T>> vertexes;
    private boolean directed;
    private boolean weighted;

    public Graph(Map<T, IVertex<T>> vertexes, boolean directed, boolean weighted){
        this.vertexes = vertexes;
        this.directed = directed;
        this.weighted = weighted;
    }

    public Graph(boolean directed, boolean weighted){
        this(new HashMap<>(), directed, weighted);
    }

    public Graph(Graph<T> graphToCopyFrom){
        this(graphToCopyFrom.vertexes, graphToCopyFrom.directed, graphToCopyFrom.weighted);
    }

    @Override
    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    @Override
    public void setInformation(T sourceVertexInformation, T information) throws NoSuchVertexException {
        getVertex(sourceVertexInformation).setInformation(information);
    }

    @Override
    public void setVertexes(Map<T, IVertex<T>> vertexes) {
        this.vertexes = vertexes;
    }

    @Override
    public void setWeighted(boolean weighted) {
        this.weighted = weighted;
    }

    @Override
    public boolean getDirected() {
        return this.directed;
    }

    @Override
    public IVertex<T> getVertex(T information) throws NoSuchVertexException {
        if(!existVertex(information)){
            StringBuilder errorMessageStringBuilder = new StringBuilder("Vertex ");
            errorMessageStringBuilder.append(information.toString());
            errorMessageStringBuilder.append(" doesn't exist on the graph");
            throw new NoSuchVertexException(errorMessageStringBuilder.toString());
        }
        return vertexes.get(information);
    }

    @Override
    public Collection<IVertex<T>> getVertexes() {
        return vertexes.values();
    }

    @Override
    public int getVertexesSize() {
        return vertexes.size();
    }

    @Override
    public boolean getWeighted() {
        return this.weighted;
    }

    @Override
    public void addVertex(T information) throws VertexAlreadyExistsException {
        addVertex(information, "");
    }

    @Override
    public void addVertex(T information, String label) throws VertexAlreadyExistsException {
        if(existVertex(information)){
            StringBuilder errorMessageStringBuilder = new StringBuilder("Vertex ");
            errorMessageStringBuilder.append(information);
            errorMessageStringBuilder.append(" already exists in the graph");
            throw new VertexAlreadyExistsException(errorMessageStringBuilder.toString());
        }
        vertexes.put(information, new Vertex<>(information, label));
    }
        

    @Override
    public void addVertex(IVertex<T> vertex) throws VertexAlreadyExistsException {
        if(existVertex(vertex)){
            StringBuilder errorMessageStringBuilder = new StringBuilder("Vertex ");
            errorMessageStringBuilder.append(vertex.getInformation());
            errorMessageStringBuilder.append(" already exists in the graph");
            throw new VertexAlreadyExistsException(errorMessageStringBuilder.toString());
        }
        vertexes.put(vertex.getInformation(), vertex);
    }

    @Override
    public double[][] getAdjacencyMatrix() {
        double[][] adjacencyMatrix = new double[getVertexesSize()][getVertexesSize()];
        List<IVertex<T>> localVertexes = new ArrayList<>(getVertexes());
        for(int vertexIndexLine = 0; vertexIndexLine < localVertexes.size(); vertexIndexLine++){
            for(int vertexIndexColumn = 0; vertexIndexColumn < localVertexes.size(); vertexIndexColumn++){
                adjacencyMatrix[vertexIndexLine][vertexIndexColumn] = localVertexes.get(vertexIndexLine).existAdjacency(localVertexes.get(vertexIndexColumn)) ? 1 : 0;
            }
        }
        return adjacencyMatrix;
    }

    @Override
    public void createAdjacency(T sourceVertexInformation, T destinationVertexInformation, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        if(!existVertex(sourceVertexInformation) || !existVertex(destinationVertexInformation)){
            StringBuilder errorMessageStringBuilder = new StringBuilder();
            if(!existVertex(sourceVertexInformation) && !existVertex(destinationVertexInformation))
                errorMessageStringBuilder.append("Vertexes ").append(sourceVertexInformation).append(" and ").append(destinationVertexInformation);
            else
                errorMessageStringBuilder.append("Vertex").append(!existVertex(sourceVertexInformation) ? sourceVertexInformation : destinationVertexInformation);
            errorMessageStringBuilder.append("doesn't exist on the graph");
            throw new NoSuchVertexException(errorMessageStringBuilder.toString());
        }
        IVertex<T> sourceVertex = getVertex(sourceVertexInformation);
        sourceVertex.addAdjacency(new Adjacency<>(label, sourceVertex, getVertex(destinationVertexInformation), weight));
        if(!directed)
            getVertex(destinationVertexInformation).addAdjacency(new Adjacency<>(label, getVertex(destinationVertexInformation), sourceVertex, weight));
    }

    @Override
    public void createAdjacency(T sourceVertex, T destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, label, 0.0);
    }

    @Override
    public void createAdjacency(T sourceVertex, T destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, weight);
    }

    @Override
    public void createAdjacency(T sourceVertex, T destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, 0.0);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex.getInformation(), destinationVertex.getInformation(), label, weight);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, label, 0.0);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, weight);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, 0.0);
    }

    @Override
    public void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex.getInformation(), label, weight);
    }

    @Override
    public void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, label, 0.0);
    }

    @Override
    public void createAdjacency(T sourceVertex, IVertex<T> destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, weight);
    }

    @Override
    public void createAdjacency(T sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, 0.0);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, String label, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex.getInformation(), destinationVertex, label, weight);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, String label) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, label, 0.0);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, T destinationVertex, double weight) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, weight);
    }

    @Override
    public void createAdjacency(IVertex<T> sourceVertex, T destinationVertex) throws NoSuchVertexException, AdjacencyAlreadyExistsException {
        createAdjacency(sourceVertex, destinationVertex, null, 0.0);
    }

    @Override
    public boolean existVertex(T information) {
        return vertexes.containsKey(information);
    }

    @Override
    public boolean existVertex(IVertex<T> vertex) {
        return existVertex(vertex.getInformation());
    }

    //TODO Study a better implementation for this
    @Override
    public void generatePajekFile(String fileName) {
        System.out.println("Generating Pajek File");
        File file = new File(fileName.endsWith(".net") ? fileName : fileName + ".net");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("*Vertices " + getVertexesSize());
            bufferedWriter.newLine();
            Collection<IVertex<T>> localVertexes = getVertexes();
            for (IVertex<T> currentVertex : localVertexes) {
                bufferedWriter.write(currentVertex.getInformation().toString());
                bufferedWriter.newLine();
            }

            if (directed)
                bufferedWriter.write("*Arcs");
            else
                bufferedWriter.write("*Edges");
            bufferedWriter.newLine();
            for (IVertex<T> currentVertex : localVertexes) {
                if (currentVertex.hasAnyAdjacency())
                    for (IAdjacency<T> currentAdjacency : currentVertex.getAdjacencies()) {
                        bufferedWriter.write(currentVertex.getInformation() + " " + currentAdjacency.getDestinationInformation() + " " + currentAdjacency.getWeight());
                        bufferedWriter.newLine();
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO Study a better implementation for this
    @Override
    public void generateGraphmlFile(String fileName) {
        System.out.println("Gerando Arquivo Graphml");
        File file = new File(fileName.endsWith(".graphml") ? fileName : fileName + ".graphml");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        HashMap<String, Integer> verticesIds = new HashMap<>();
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            //SettingUp xml
            bufferedWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            bufferedWriter.newLine();
            bufferedWriter.write("<graphml>");
            bufferedWriter.write("<graph id=\"Graph\" uidGraph=\"3\" uidEdge=\"10002\">");
            int id = 0;
            Collection<IVertex<T>> localVertexes = getVertexes();
            for (IVertex<T> currentVertex : localVertexes) {
                verticesIds.put(currentVertex.getInformation().toString(), id);
                bufferedWriter.write(formatNodeGraphmlString(0, 0, id++, currentVertex.getInformation().toString(), ""));
                bufferedWriter.newLine();
            }

            id = 1000;
            for (IVertex<T> currentVertex : localVertexes) {
                if (currentVertex.hasAnyAdjacency())
                    for (IAdjacency<T> currentAdjacency : currentVertex.getAdjacencies()) {
                        bufferedWriter.write(formatEdgeGraphmlString(verticesIds.get(currentVertex.getInformation().toString()), verticesIds.get(currentAdjacency.getDestinationInformation().toString()), weighted, currentAdjacency.getWeight(), weighted, id++, "", ""));
                        bufferedWriter.newLine();
                    }
            }
            bufferedWriter.write("</graph>");
            bufferedWriter.write("</graphml>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null)
                    bufferedWriter.close();
                if (fileWriter != null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String formatNodeGraphmlString(int positionX, int positionY, int id, String mainText, String upText) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<node").append(" positionX=").append("\"" + positionX + "\"").append(" positionY=").append("\"" + positionY + "\"").append(" id=").append("\"" + id + "\"").append(" mainText=").append("\"" + mainText + "\"").append(" upText=").append("\"" + upText + "\"").append(" ></node>");
        return stringBuilder.toString();
    }

    private String formatEdgeGraphmlString(int sourceId, int targetId, boolean isDirect, double weight, boolean useWeight, int id, String text, String upText){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<edge").append(" source=").append("\"" + sourceId + "\"").append(" target=").append("\"" + targetId + "\"").append(" isDirect=").append("\"" + isDirect + "\"").append(" weight=").append("\"" + weight + "\"").append(" useWeight=").append("\"" + useWeight + "\"").append(" id=").append("\"" + id + "\"").append(" text=").append("\"" + text + "\"").append(" upText=").append("\"" + upText + "\"").append(" arrayStyleStart=\"\" arrayStyleFinish=\"\" model_width=\"4\" model_type=\"0\" model_curvedValue=\"0.1\" ></edge>");
        return stringBuilder.toString();
    }

    //TODO implement this function properly
    @Override
    public void loadPajekFile(String fileName) {

    }

    @Override
    public void printAdjacencies(IVertex<T> vertex) {
        if(!vertex.hasAnyAdjacency())
            System.out.println(new StringBuilder("The vertex ").append(vertex.getInformation()).append(" doesn't has any adjacency").toString());
        else
            for(IAdjacency<T> currentAdjacency: vertex.getAdjacencies())
                System.out.println(new StringBuilder(vertex.getInformation().toString()).append("->").append(currentAdjacency.getDestinationInformation()));
    }

    @Override
    public void printAdjacencies(T information) throws NoSuchVertexException {
        printAdjacencies(getVertex(information));
    }

    @Override
    public void removeVertex(T information) throws NoSuchVertexException{
        if(!existVertex(information)){
            StringBuilder errorMessageStringBuilder = new StringBuilder("Vertex ");
            errorMessageStringBuilder.append(information);
            errorMessageStringBuilder.append(" doesn't exist on the graph");
            throw new NoSuchVertexException(errorMessageStringBuilder.toString());
        }
        vertexes.remove(information);
    }

    @Override
    public void removeVertex(IVertex<T> vertex) throws NoSuchVertexException{
        removeVertex(vertex.getInformation());
    }

    @Override
    public void removeAdjacency(T sourceVertex, T destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException {
        getVertex(sourceVertex).removeAdjacency(destinationVertex);
    }

    @Override
    public void removeAdjacency(T sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException {
        removeAdjacency(sourceVertex, destinationVertex.getInformation());
    }

    @Override
    public void removeAdjacency(IVertex<T> sourceVertex, T destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException {
        removeAdjacency(sourceVertex.getInformation(), destinationVertex);
    }

    @Override
    public void removeAdjacency(IVertex<T> sourceVertex, IVertex<T> destinationVertex) throws NoSuchVertexException, NoSuchAdjacencyException {
        removeAdjacency(sourceVertex.getInformation(), destinationVertex.getInformation());
    }

    @Override
    public void searchDepth(T information) throws NoSuchVertexException {
        searchDepth(getVertex(information));
    }

    @Override
    public void searchIterativeDepth(IVertex<T> sourceVertex, int maxDepth) {
        Set<T> visited = new HashSet<>();
        searchIterativeDepth(sourceVertex, 0, maxDepth, visited);
    }

    @Override
    public void searchLimitedDepth(T sourceVertexInformation, T destinationVertexInformation) throws NoSuchVertexException {
        searchLimitedDepth(getVertex(sourceVertexInformation), getVertex(destinationVertexInformation));
    }

    @Override
    public void searchLimitedDepth(IVertex<T> sourceVertex, IVertex<T> destinationVertex) {
        searchLimitedDepth(sourceVertex, destinationVertex, new HashSet<>());
    }

    private void searchLimitedDepth(IVertex<T> sourceVertex, IVertex<T> destinationVertex, Set<T> visited){
        visited.add(sourceVertex.getInformation());
        System.out.println(sourceVertex.getInformation());

        for(IAdjacency<T> adjacency: sourceVertex.getAdjacencies()){
            if(visited.contains(destinationVertex.getInformation()))
                return;
            if(!visited.contains(adjacency.getDestinationInformation()))
                searchLimitedDepth(adjacency.getDestinationVertex(), destinationVertex, visited);
        }
    }

    private void searchIterativeDepth(IVertex<T> sourceVertex, int currentDepth, int maxDepth, Set<T> visited){
        visited.add(sourceVertex.getInformation());
        if(currentDepth != maxDepth){
            for(IAdjacency<T> adjacency: sourceVertex.getAdjacencies()){
                if(!visited.contains(adjacency.getDestinationInformation()))
                    searchIterativeDepth(adjacency.getDestinationVertex(), currentDepth + 1, maxDepth, visited);
            }
            System.out.println(sourceVertex.getInformation());
        }
        else if(currentDepth == maxDepth){
            System.out.println(sourceVertex.getInformation());
            return;
        }
    }

    @Override
    public void searchDepth(IVertex<T> sourceVertex) {
        Set<T> visited = new HashSet<>();
        searchDepth(sourceVertex, visited);
    }

    @Override
    public void searchIterativeDepth(T sourceVertexInformation, int maxDepth) throws NoSuchVertexException {
        searchIterativeDepth(getVertex(sourceVertexInformation), maxDepth);
    }

    private void searchDepth(IVertex<T> sourceVertex, Set<T> visited){
        visited.add(sourceVertex.getInformation());
        System.out.println(sourceVertex.getInformation());
        for(IAdjacency<T> adjacency: sourceVertex.getAdjacencies()){
            if(!visited.contains(adjacency.getDestinationInformation()))
                searchDepth(adjacency.getDestinationVertex(), visited);
        }
    }

    @Override
    public void searchWidth(T information) throws NoSuchVertexException {
        searchWidth(getVertex(information));
    }

    @Override
    public void searchWidth(IVertex<T> sourceVertex) {
        Queue<IVertex<T>> linkedList = new LinkedList<>();
        Set<T> visited = new HashSet<>();

        visited.add(sourceVertex.getInformation());
        linkedList.add(sourceVertex);
        IVertex<T> currentVertex;
        while(!linkedList.isEmpty()){
            currentVertex = linkedList.poll();
            if(currentVertex.hasAnyAdjacency()){
                for(IAdjacency<T> currentAdjacency: currentVertex.getAdjacencies()){
                    if(!visited.contains(currentAdjacency.getDestinationInformation())){
                        visited.add(currentAdjacency.getDestinationInformation());
                        System.out.println(currentAdjacency.getDestinationInformation());
                        linkedList.add(currentAdjacency.getDestinationVertex());
                    }
                }
                linkedList.poll();
            }
        }
    }
}
