package Game.units;
import java.util.ArrayList;

public abstract class Shooter extends Person {
    int range; // дальность выстрела
    int capacity; // количество выстрелов

    public Shooter(String name,float hp, int[] damage, int attack, int range, int capacity, int x, int y, int numberTeam, int initiative) {
        super( name, hp,  damage, attack, x, y, numberTeam, initiative);
        this.range = range;
        this.capacity = capacity;
    }
    @Override
    public void step(ArrayList<Person> teamProtivnic, ArrayList<Person> team) {
        if (this.curHp == 0) return;
        if (this.capacity == 0) return;

        int k = super.findNearest(teamProtivnic);
        teamProtivnic.get(k).getDamage((this.damage[1]+this.damage[0])/2);

       // for (int i = 0; i < team.size(); i++) {
         for(Person p: team){
            if (p.getClass() == Farmer.class && p.status.equals("Stand")){
                    //team.get(i).getClass().equals("Farmer") && team.get(i).status.equals("Stand")) {
                p.status.equals("Busy");
                if (this.capacity == 0) this.capacity +=1 ;

                return;
            }

        }
        this.capacity -= 1;
    }

    @Override
    public String getInfo() {
        return String.format("%s \u27B3: %s", super.getInfo(), this.capacity);
    }
}
