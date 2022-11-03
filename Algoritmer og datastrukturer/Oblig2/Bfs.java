import java.util.*;
//OPPGAVE 2
public class Bfs {

    static HashMap<Actor, Edge> bfs(Actor from, Actor to){
        HashMap<Actor, Edge> parents = new HashMap<Actor, Edge>();
        Deque<Actor> queue = new LinkedList<Actor>();
        queue.add(from);
        Actor v = null;
        Actor u = null;
        parents.put(from, null);
        while (!queue.isEmpty()){
            v = queue.pollFirst();
            for (Edge edge : v.edges) {
                u = edge.getOtherActor(v);
                if (!parents.containsKey(u)){
                    parents.put(u, edge);
                    queue.add(u);
                }
                if (u == to){ // Naar vi finner skuespillern vi skal til, trenger vi ikke lete mer.
                    return parents;
                }
            }
        }
        return parents;
     }

     static LinkedHashMap<Actor, Movie> bfsShortestPath(Actor from, Actor to){
        HashMap<Actor, Edge> parents = bfs(from, to);
        Actor v = to;
        LinkedHashMap<Actor, Movie> path = new LinkedHashMap<Actor, Movie>();
        while (parents.get(v) != null){
            path.put(v, parents.get(v).movie);
            v = parents.get(v).getOtherActor(v);
        }
        return path;
     }
}
