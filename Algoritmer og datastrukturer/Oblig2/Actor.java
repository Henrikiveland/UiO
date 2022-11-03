import java.util.*;
public class Actor implements Comparable<Actor>{
    String id;
    String navn;
    ArrayList<Movie> movies = new ArrayList<Movie>();
    ArrayList<Edge> edges = new ArrayList<Edge>();
    Double tempCost;
    Boolean visited = false;
    Boolean visited2 = false;

    Actor(String i, String n){
        id = i;
        navn = n;
    }

    void addEdge(Edge e){
        edges.add(e);
    }

    void addMovies(Movie m){
        movies.add(m);
    }

    @Override
    public String toString() {
        return navn;
    }
    void setCost(Double cost){
        tempCost = cost;
    }

    @Override
    public int compareTo(Actor a) {

        if(tempCost ==  a.tempCost){
            return 0;
        }
        else if(tempCost  > a.tempCost){
            return 1;
        }
        else{
            return -1;
        }
    }
}
