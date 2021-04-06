import exceptions.AdjacencyAlreadyExistsException;
import exceptions.NoSuchVertexException;
import exceptions.VertexAlreadyExistsException;
import graph.Graph;
import graph.Vertex;
import heuristic_searches.AStar;

public class Main {

    public static void main(String[] args) throws VertexAlreadyExistsException, AdjacencyAlreadyExistsException,
            NoSuchVertexException {
        ///*
        Graph<String> graph = new Graph<>(false, true);

        graph.addVertex("Doutor Ulysses");
        graph.addVertex("Cerro Azul");
        graph.addVertex("Tunas do Paraná");
        graph.addVertex("Rio Branco do Sul");
        graph.addVertex("Bocaiúva do Sul");
        graph.addVertex("Itaperuçu");
        graph.addVertex("Campo Magro");
        graph.addVertex("Almirante Tamandaré");
        graph.addVertex("Colombo");
        graph.addVertex("Campina Grande do Sul");
        graph.addVertex("Campo Largo");
        graph.addVertex("Curitiba");
        graph.addVertex("Pinhais");
        graph.addVertex("Quatro Barras");
        graph.addVertex("Piraquara");
        graph.addVertex("Balsa Nova");
        graph.addVertex("Araucária");
        graph.addVertex("Fazenda Rio Grande");
        graph.addVertex("São José dos Pinhais");
        graph.addVertex("Contenda");
        graph.addVertex("Quitandinha");
        graph.addVertex("Mandirituba");
        graph.addVertex("Tijucas do Sul");
        graph.addVertex("Agudos do Sul");

        Vertex<String> lapa = new Vertex<>("Lapa");
        Vertex<String> adrianopolis = new Vertex<>("Adrianópolis");

        graph.addVertex(lapa);
        graph.addVertex(adrianopolis);

        graph.createAdjacency("Doutor Ulysses",         "Cerro Azul",               47.8);
        graph.createAdjacency("Cerro Azul",             "Adrianópolis",             76.9);
        graph.createAdjacency("Adrianópolis",           "Tunas do Paraná",          54.5);
        graph.createAdjacency("Adrianópolis",           "Bocaiúva do Sul",          92.2);
        graph.createAdjacency("Cerro Azul",             "Tunas do Paraná",          33.9);
        graph.createAdjacency("Tunas do Paraná",        "Bocaiúva do Sul",          37.6);
        graph.createAdjacency("Cerro Azul",             "Rio Branco do Sul",        54.5);
        graph.createAdjacency("Rio Branco do Sul",      "Bocaiúva do Sul",          25.1);
        graph.createAdjacency("Bocaiúva do Sul",        "Campina Grande do Sul",    24.5);
        graph.createAdjacency("Bocaiúva do Sul",        "Colombo",                  25.4);
        graph.createAdjacency("Campina Grande do Sul",  "Colombo",                  19.9);
        graph.createAdjacency("Rio Branco do Sul",      "Itaperuçu",                6.80);
        graph.createAdjacency("Rio Branco do Sul",      "Almirante Tamandaré",      16.0);
        graph.createAdjacency("Rio Branco do Sul",      "Colombo",                  31.1);
        graph.createAdjacency("Itaperuçu",              "Campo Largo",              41.6);
        graph.createAdjacency("Itaperuçu",              "Campo Magro",              28.4);
        graph.createAdjacency("Itaperuçu",              "Almirante Tamandaré",      14.2);
        graph.createAdjacency("Almirante Tamandaré",    "Colombo",                  17.7);
        graph.createAdjacency("Colombo",                "Curitiba",                 12.8);
        graph.createAdjacency("Colombo",                "Pinhais",                  10.1);
        graph.createAdjacency("Pinhais",                "Quatro Barras",            18.5);
        graph.createAdjacency("Campina Grande do Sul",  "Quatro Barras",            34.1);
        graph.createAdjacency("Pinhais",                "Piraquara",                15.8);
        graph.createAdjacency("Quatro Barras",          "Piraquara",                10.2);
        graph.createAdjacency("Almirante Tamandaré",    "Curitiba",                 15.4);
        graph.createAdjacency("Curitiba",               "Piraquara",                22.6);
        graph.createAdjacency("Campo Magro",            "Almirante Tamandaré",      19.4);
        graph.createAdjacency("Curitiba",               "Pinhais",                  8.70);
        graph.createAdjacency("Campo Magro",            "Campo Largo",              20.6);
        graph.createAdjacency("Campo Magro",            "Curitiba",                 21.8);
        graph.createAdjacency("Campo Largo",            "Curitiba",                 29.8);
        graph.createAdjacency("Curitiba",               "Araucária",                28.3);
        graph.createAdjacency("Curitiba",               "São José dos Pinhais",     15.6);
        graph.createAdjacency("Fazenda Rio Grande",     "Curitiba",                 30.3);
        graph.createAdjacency("Araucária",              "Fazenda Rio Grande",       24.4);
        graph.createAdjacency("Fazenda Rio Grande",     "São José dos Pinhais",     25.3);
        graph.createAdjacency("Piraquara",              "São José dos Pinhais",     21.2);
        graph.createAdjacency("Campo Largo",            "Balsa Nova",               20.6);
        graph.createAdjacency("Campo Largo",            "Araucária",                26.8);
        graph.createAdjacency("Balsa Nova",             "Lapa",                     29.6);
        graph.createAdjacency("Lapa",                   "Contenda",                 26.3);
        graph.createAdjacency("Contenda",               "Quitandinha",              30.5);
        graph.createAdjacency("Lapa",                   "Quitandinha",              34.0);
        graph.createAdjacency("Quitandinha",            "Mandirituba",              26.3);
        graph.createAdjacency("Araucária",              "Quitandinha",              39.4);
        graph.createAdjacency("Quitandinha",            "Agudos do Sul",            32.0);
        graph.createAdjacency("Mandirituba",            "Agudos do Sul",            27.9);
        graph.createAdjacency("Fazenda Rio Grande",     "Mandirituba",              14.4);
        graph.createAdjacency("Araucária",              "Contenda",                 18.4);
        graph.createAdjacency("Balsa Nova",             "Contenda",                 20.9);
        graph.createAdjacency("Balsa Nova",             "Araucária",                37.4);
        graph.createAdjacency("Araucária",              "Mandirituba",              31.7);
        graph.createAdjacency("São José dos Pinhais",   "Mandirituba",              40.1);
        graph.createAdjacency("São José dos Pinhais",   "Tijucas do Sul",           49.4);
        graph.createAdjacency("Mandirituba",            "Tijucas do Sul",           47.5);
        graph.createAdjacency("Agudos do Sul",          "Tijucas do Sul",           19.6);

        //*/

        /*
        Graph<String> testGraph = new Graph<>(false, true);

        testGraph.addVertex("A");
        testGraph.addVertex("B");
        testGraph.addVertex("C");
        testGraph.addVertex("D");
        testGraph.addVertex("E");
        testGraph.addVertex("F");
        testGraph.addVertex("G");
        testGraph.addVertex("H");
        testGraph.addVertex("I");
        testGraph.addVertex("J");
        testGraph.addVertex("K");
        testGraph.addVertex("L");
        testGraph.addVertex("M");
        testGraph.addVertex("N");
        testGraph.addVertex("O");

        testGraph.createAdjacency("A",  "B",  2.0);
        testGraph.createAdjacency("A",  "C",  2.0);
        testGraph.createAdjacency("B",  "D",  2.0);
        testGraph.createAdjacency("B",  "E",  2.0);
        testGraph.createAdjacency("C",  "F",  2.0);
        testGraph.createAdjacency("C",  "G",  2.0);
        testGraph.createAdjacency("D",  "H",  2.0);
        testGraph.createAdjacency("D",  "I",  2.0);
        testGraph.createAdjacency("E",  "J",  2.0);
        testGraph.createAdjacency("E",  "K",  2.0);
        testGraph.createAdjacency("F",  "L",  2.0);
        testGraph.createAdjacency("F",  "M",  2.0);
        testGraph.createAdjacency("G",  "N",  2.0);
        testGraph.createAdjacency("G",  "O",  2.0);

        System.out.println("Iterativo com 0: ");
        testGraph.searchIterativeDepth("A", 0);
        System.out.println("Iterativo com 1: ");
        testGraph.searchIterativeDepth("A", 1);
        System.out.println("Iterativo com 2: ");
        testGraph.searchIterativeDepth("A", 2);
        System.out.println("Iterativo com 3: ");
        testGraph.searchIterativeDepth("A", 3);
        */

        /*
        Graph<String> testGraphRomenia = new Graph<>(false, true);

        testGraphRomenia.addVertex("Arad");
        testGraphRomenia.addVertex("Bucharest");
        testGraphRomenia.addVertex("Craiova");
        testGraphRomenia.addVertex("Drobeta");
        testGraphRomenia.addVertex("Eforie");
        testGraphRomenia.addVertex("Fagaras");
        testGraphRomenia.addVertex("Giurgiu");
        testGraphRomenia.addVertex("Hirsova");
        testGraphRomenia.addVertex("Iasi");
        testGraphRomenia.addVertex("Lugoj");
        testGraphRomenia.addVertex("Mehadia");
        testGraphRomenia.addVertex("Neamt");
        testGraphRomenia.addVertex("Oradea");
        testGraphRomenia.addVertex("Pitesti");
        testGraphRomenia.addVertex("Rimnicu Vilcea");
        testGraphRomenia.addVertex("Sibiu");
        testGraphRomenia.addVertex("Timisoara");
        testGraphRomenia.addVertex("Urziceni");
        testGraphRomenia.addVertex("Vaslui");
        testGraphRomenia.addVertex("Zerind");

        testGraphRomenia.createAdjacency("Oradea",          "Zerind",           71.00);
        testGraphRomenia.createAdjacency("Oradea",          "Sibiu",            151.0);
        testGraphRomenia.createAdjacency("Zerind",          "Arad",             75.00);
        testGraphRomenia.createAdjacency("Arad",            "Sibiu",            140.0);
        testGraphRomenia.createAdjacency("Arad",            "Timisoara",        118.0);
        testGraphRomenia.createAdjacency("Timisoara",       "Lugoj",            111.0);
        testGraphRomenia.createAdjacency("Lugoj",           "Mehadia",          70.00);
        testGraphRomenia.createAdjacency("Mehadia",         "Drobeta",          120.0);
        testGraphRomenia.createAdjacency("Craiova",         "Rimnicu Vilcea",   146.0);
        testGraphRomenia.createAdjacency("Craiova",         "Pitesti",          138.0);
        testGraphRomenia.createAdjacency("Rimnicu Vilcea",  "Sibiu",            80.00);
        testGraphRomenia.createAdjacency("Rimnicu Vilcea",  "Pitesti",          97.00);
        testGraphRomenia.createAdjacency("Sibiu",           "Fagaras",          99.00);
        testGraphRomenia.createAdjacency("Fagaras",         "Bucharest",        211.0);
        testGraphRomenia.createAdjacency("Pitesti",         "Bucharest",        101.0);
        testGraphRomenia.createAdjacency("Bucharest",       "Giurgiu",          90.00);
        testGraphRomenia.createAdjacency("Bucharest",       "Urziceni",         85.00);
        testGraphRomenia.createAdjacency("Urziceni",        "Hirsova",          98.00);
        testGraphRomenia.createAdjacency("Hirsova",         "Eforie",           86.00);
        testGraphRomenia.createAdjacency("Urziceni",        "Vaslui",           142.0);
        testGraphRomenia.createAdjacency("Vaslui",          "Iasi",             92.00);
        testGraphRomenia.createAdjacency("Iasi",            "Neamt",            87.00);

        AStar<String> aStar = new AStar<>(testGraphRomenia);

        aStar.addHeuristicValue("Arad",             366.0);
        aStar.addHeuristicValue("Bucharest",        0.000);
        aStar.addHeuristicValue("Craiova",          160.0);
        aStar.addHeuristicValue("Drobeta",          242.0);
        aStar.addHeuristicValue("Eforie",           161.0);
        aStar.addHeuristicValue("Fagaras",          176.0);
        aStar.addHeuristicValue("Giurgiu",          77.00);
        aStar.addHeuristicValue("Hirsova",          151.0);
        aStar.addHeuristicValue("Iasi",             226.0);
        aStar.addHeuristicValue("Lugoj",            244.0);
        aStar.addHeuristicValue("Mehadia",          241.0);
        aStar.addHeuristicValue("Neamt",            234.0);
        aStar.addHeuristicValue("Oradea",           380.0);
        aStar.addHeuristicValue("Pitesti",          100.0);
        aStar.addHeuristicValue("Rimnicu Vilcea",   193.0);
        aStar.addHeuristicValue("Sibiu",            253.0);
        aStar.addHeuristicValue("Timisoara",        329.0);
        aStar.addHeuristicValue("Urziceni",         80.00);
        aStar.addHeuristicValue("Vaslui",           199.0);
        aStar.addHeuristicValue("Zerind",           374.0);
        */
    }
}
