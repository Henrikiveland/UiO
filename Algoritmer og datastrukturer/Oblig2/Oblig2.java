import java.util.*;
import java.io.*;
class Oblig2{
    public static void main(String[] args) throws IOException {

        //HER STARTER OPPGAVE 1 
        // Tar tiden på alle oppgavene ved bruk av System.currentTimeMillis()
        long startTimeTot = System.currentTimeMillis();
        long startTime = System.currentTimeMillis();
        System.out.println("\nOppgave 1: \n");
        String N;
        HashMap<String, Movie> movies = new HashMap<String, Movie>();
        HashMap<String, Actor> actors = new HashMap<String, Actor>();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        //Leser inn filmer
        BufferedReader Mfile = new BufferedReader(new FileReader("movies.tsv"));
        while((N = Mfile.readLine()) != null){
            String[] biter = N.split("\t");
            movies.put(biter[0], new Movie(biter[0], biter[1], Double.parseDouble(biter[2])));
        }
        Mfile.close();

        //Leser inn skuespillere
        BufferedReader Afile = new BufferedReader(new FileReader("actors.tsv"));
        while((N = Afile.readLine()) != null){
            String[] biter = N.split("\t");
            Actor a = new Actor(biter[0], biter[1]);
            for (int j = 2; j < biter.length; j++) {
                Movie m = movies.get(biter[j]);
                if (m != null){
                    a.addMovies(m);
                    m.addActor(a);
                }
            }
            actors.put(biter[0], a);
        }
        Afile.close();

        //Lager kanter
        for (String mId : movies.keySet()) {
            Movie movie = movies.get(mId);
            for (int i = 0; i < movie.actors.size(); i++) {
                for (int j = i+1; j < movie.actors.size(); j++) {
                    Actor a1 = movie.actors.get(i);
                    Actor a2 = movie.actors.get(j); 
                    Edge edge = new Edge(movie, a1, a2);
                    a1.addEdge(edge);
                    a2.addEdge(edge);
                    edges.add(edge);
                }
            }
        }
        System.out.println("Nodes: " + actors.size());
        System.out.println("Edges: " + edges.size());

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        long tid1 = totalTime;
        System.out.println("\nTid brukt: "+tid1 + "ms\n");




        // HER STARTER OPPGAVE 2    
        startTime = System.currentTimeMillis();
        System.out.println("\nOppgave 2: \n");

        Actor a1 = actors.get("nm2255973");
        Actor a2 = actors.get("nm0000460");
        Actor a3 = actors.get("nm0424060");
        Actor a4 = actors.get("nm0000243");
        Actor a5 = actors.get("nm4689420");
        Actor a6 = actors.get("nm0000365");
        Actor a7 = actors.get("nm0000288");
        Actor a8 = actors.get("nm0001401");
        Actor a9 = actors.get("nm0031483");
        Actor a10 = actors.get("nm0931324");
        
        LinkedHashMap<Actor, Movie>  kortesteVei = Bfs.bfsShortestPath(a1, a2);
        List<Actor> reversedOrder = new ArrayList<Actor>(kortesteVei.keySet());
        //Lista kommer i feil rekkefolge, saa maa snu den
        Collections.reverse(reversedOrder);
        System.out.println(a1);
        for (Actor actor : reversedOrder) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a3, a4);
        reversedOrder = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a3);
        for (Actor actor : reversedOrder) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a5, a6);
        reversedOrder = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a5);
        for (Actor actor : reversedOrder) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a7, a8);
        reversedOrder = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a7);
        for (Actor actor : reversedOrder) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");

        kortesteVei = Bfs.bfsShortestPath(a9, a10);
        reversedOrder = new ArrayList<Actor>(kortesteVei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a9);
        for (Actor actor : reversedOrder) {
            System.out.println(kortesteVei.get(actor) +" "+ actor);
        }
        System.out.println("");


        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        long tid2 = totalTime;
        System.out.println("Tid brukt: "+tid2 + "ms\n");




        // HER STARTER OPPGAVE 3    
        startTime = System.currentTimeMillis();
        System.out.println("\nOppgave 3: \n");
        Double weight = 0.0;

        // Disse kommer ogsaa i feil rekkefolge, saa snur den for vi regner ut vekt og skriver ut.
        LinkedHashMap<Actor, Movie>  chillestevei = Dijkstra.dijkstraShortestPath(actors, a1, a2);
        reversedOrder = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a1);
        for (Actor actor : reversedOrder) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a3, a4);
        reversedOrder = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a3);
        for (Actor actor : reversedOrder) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a5, a6);
        reversedOrder = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a5);
        for (Actor actor : reversedOrder) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a7, a8);
        reversedOrder = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a7);
        for (Actor actor : reversedOrder) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;

        chillestevei = Dijkstra.dijkstraShortestPath(actors, a9, a10);
        reversedOrder = new ArrayList<Actor>(chillestevei.keySet());
        Collections.reverse(reversedOrder);
        System.out.println(a9);
        for (Actor actor : reversedOrder) {
            weight = weight + chillestevei.get(actor).weight;
            System.out.println(chillestevei.get(actor) +" "+ actor);
        }
        System.out.println("Total weight: "+weight);
        System.out.println("");
        weight = 0.0;


        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        long tid3 = totalTime;
        System.out.println("Tid brukt: "+ tid3 + "ms\n");




        //OPPGAVE 4
        startTime = System.currentTimeMillis();
        System.out.println("\nOppgave 4:\n");

        // Her er hashmappet usortert, saa vi finner den storste komponenten for vi printer ut og finner neste.
        HashMap<Integer ,Integer> components = Components.components(actors);
        int max = 0;
        while(!components.isEmpty()){
            for (int size : components.keySet()) {
                if(max < size){
                    max = size;
                }                
            }
            System.out.println("There are " + components.get(max) + " components of size " + max);
            components.remove(max);
            max = 0;
        }

        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        long tid4 = totalTime;
        System.out.println("\nTid brukt: "+tid4 + "ms\n");

        //SLUTT PAA OBLIGEN
        long endTimeTot   = System.currentTimeMillis();
        long totalTimeTot = endTimeTot - startTimeTot;
        long sluttTid = totalTimeTot;
        // Et lite sammendrag av alle tidene som oppgavene har brukt.
        System.out.println("\nTid brukt paa oppgave 1: "+tid1 + "ms");
        System.out.println("Tid brukt paa oppgave 2: "+tid2 + "ms");
        System.out.println("Tid brukt paa oppgave 3: "+tid3 + "ms");
        System.out.println("Tid brukt paa oppgave 4: "+tid4 + "ms");
        System.out.println("Tid brukt totalt: "+sluttTid + "ms\n");
    }
}
