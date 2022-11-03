import java.util.*;

public class Movie {

    String name;
    String id;
    Double rate;
    Double weight;
    ArrayList<Actor> actors = new ArrayList<Actor>();

    Movie(String i, String n, Double r){
        name = n;
        id = i;
        rate = r;
        weight = 10.0-r;
    }

    @Override
    public String toString() {
        return "===[ "+name + " (" + rate + ") ] ===>";
    }

    void addActor(Actor a){
        actors.add(a);
    }
}