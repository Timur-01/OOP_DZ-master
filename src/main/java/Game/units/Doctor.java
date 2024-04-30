package Game.units;

import java.util.ArrayList;
import java.util.Comparator;

public class Doctor extends Witch{
    public Doctor(String name, int x, int y, int numberTeam)
    {
        super(name, 10, new int[]{-1,-3}, 2, 10, x, y, numberTeam, 1);
    }


    @Override
    public void step(ArrayList<Person> teamProtivnic, ArrayList<Person> team) {
        if(mana <= 0) return;
        if (super.findeDamagePerson(team).hp == super.findeDamagePerson(team).curHp) return;

        else {
            super.findeDamagePerson(team).getDamage(damage[0]);
            mana += damage[0];
            if (super.findeDamagePerson(team).curHp > super.findeDamagePerson(team).curHp)
                super.findeDamagePerson(team).curHp = super.findeDamagePerson(team).hp;
        }

    }
}
