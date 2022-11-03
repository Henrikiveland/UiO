import java.util.*;
//OPPGAVE 3
public class Dijkstra {

    static HashMap<Actor, Edge> dijkstra(HashMap<String, Actor> actors, Actor from, Actor to){
        HashMap<Actor, Edge> parents = new HashMap<Actor, Edge>();
        PriorityQueue<Actor> queue = new PriorityQueue<Actor>();
        Actor v = null;
        Actor u = null;

        for (Actor actor : actors.values()) {
            actor.setCost(Double.POSITIVE_INFINITY);
            actor.visited = false;
        }

        from.setCost(0.0);
        queue.add(from);

        while (!queue.isEmpty()){
            v = queue.poll();
            if (v == to) return parents;
            v.visited = true;

            for (Edge edge : v.edges) {
                u = edge.getOtherActor(v);
                
                if(!u.visited && (v.tempCost + edge.weight) < u.tempCost){
                    u.setCost(v.tempCost + edge.weight);
                    queue.add(u);
                    parents.put(u, edge);
                }
            }
        }
        return parents;
     }

     static LinkedHashMap<Actor, Movie> dijkstraShortestPath(HashMap<String, Actor> actors, Actor from, Actor to){
        HashMap<Actor, Edge> parents = dijkstra(actors, from, to);
        Actor v = to;
        LinkedHashMap<Actor, Movie> path = new LinkedHashMap<Actor, Movie>();
        while (parents.get(v) != null){
            path.put(v, parents.get(v).movie);
            v = parents.get(v).getOtherActor(v);
        }
        return path;
     }
}
