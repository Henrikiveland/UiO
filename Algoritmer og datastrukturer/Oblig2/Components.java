import java.util.*;
//OPPGAVE 4
public class Components {

    static HashMap<Integer ,Integer> components(HashMap<String, Actor> a){
        ArrayList<Actor> actors  = new ArrayList<Actor>(a.values());
        HashMap<Integer ,Integer> comps = new HashMap<Integer ,Integer>(); // comps[storrelsen, antall komponenter med den storrelsen]
    
        ArrayList<Actor> list = new ArrayList<Actor>();
        Actor v = actors.get(0);
        Actor u = null;
        list.add(v);
        int teller = 0;

        for (Actor actor : actors) {
            actor.visited = false;
            actor.visited2 = false;
        }

        while(!(actors.isEmpty())){
            if(list.isEmpty()){
                if((comps.get(teller) == null)){
                    comps.put(teller, 1);
                }
                else{
                    comps.put(teller, comps.get(teller)+1);
                }
                teller = 0;
                v = actors.get(0);
                list.add(v);
            }
            v = list.remove(0);
            actors.remove(v);
            v.visited = true;

            for (Edge edge : v.edges) {
                u = edge.getOtherActor(v);
                if (!u.visited && !u.visited2 ){
                    list.add(u);
                    u.visited2 = true;
                }
            }
            teller++;
        }
        return comps;
    }
}