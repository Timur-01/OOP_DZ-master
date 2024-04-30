package Game.units;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class Witch extends Person {
    int mana;

    public Witch(String name,float hp, int[] damage, int attack, int mana, int x, int y, int numberTeam, int initiative) {
        super(name, hp, damage, attack, x, y, numberTeam, initiative);
        this.mana = mana;
    }


    @Override
    public String getInfo() {
        return String.format("%s \u2747: %s", super.getInfo(), this.mana);
    }

    public Person findeDamagePerson(ArrayList<Person> team){
        ArrayList<Person> damageSort = new ArrayList<Person>(10);
        damageSort = team;
        damageSort.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (int) ((o1.hp - o1.curHp) - (o2.hp - o2.curHp));
            }
        });
        return damageSort.get(0);
    }
}

