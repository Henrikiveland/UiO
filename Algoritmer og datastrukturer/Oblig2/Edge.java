public class Edge {

    Movie movie;
    Actor actor1;
    Actor actor2;
    Double weight;

    Edge(Movie m, Actor a1, Actor a2){
        movie = m;
        actor1 = a1;
        actor2 = a2;
        weight = movie.weight;
    }

    Actor getOtherActor(Actor a){
        if (a == actor1){
            return actor2;
        }
        else if (a == actor2){
            return actor1;
        }
        else{
            return null;
        }
    }
}
