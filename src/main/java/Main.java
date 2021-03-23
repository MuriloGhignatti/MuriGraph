import exceptions.AdjacencyAlreadyExistsException;
import exceptions.NoSuchVertexException;
import exceptions.VertexAlreadyExistsException;
import graph.Graph;
import graph.Vertex;

public class Main {
    public static void main(String[] args) throws VertexAlreadyExistsException, AdjacencyAlreadyExistsException,
            NoSuchVertexException {
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

        System.out.println(graph.getVertexesSize());

        System.out.println("Search Width: ");
        graph.searchWidth("Curitiba");
        System.out.println("Search Depth: ");
        graph.searchDepth("Curitiba");
    }
}
