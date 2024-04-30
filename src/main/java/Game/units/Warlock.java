package Game.units;

import java.util.ArrayList;

public class Warlock extends Witch{
    public Warlock(String name, int x, int y, int numberTeam) {

        super(name, 10, new int[]{1,5}, 2, 10, x, y, numberTeam, 4);
    }


    @Override
    public void step(ArrayList<Person> teamProtivnic, ArrayList<Person> team) {
        if(mana <= 0) return;
        super.findeDamagePerson(teamProtivnic).getDamage(damage[0]);
        mana -= damage[0];

    }
}
