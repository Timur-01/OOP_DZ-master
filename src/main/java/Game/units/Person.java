package Game.units;
import Game.Interface.PersonInterface;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Person implements PersonInterface {
    protected float hp; // Здоровье
    protected float curHp; // Здоровье сейчас
    protected String name;
    protected int[] damage; //Урон
    protected int attack; //Сила удара

    protected Coordinats coordinats;

    protected int numberTeam;
    public int initiative;
    public String status;


    public Person(String name,float hp, int[] damage, int attack, int x, int y, int numberTeam, int initiative) {
        this.hp = this.curHp=hp;
        this.name = name;
        this.damage = damage;
        this.attack = attack;
        this.coordinats = new Coordinats(x,y);
        this.numberTeam = numberTeam;
        this.initiative = initiative;
        this.status ="Stand";
    }

    public int findNearest(ArrayList<Person> teamProtivnic){
        ArrayList<Person> notDeadTeam = new ArrayList<Person>();
        for (Person p : teamProtivnic) {
            if(!p.isDead()) notDeadTeam.add(p);
        }
        //if (notDeadTeam.size() == 0) return 0;
        int minR = this.coordinats.rastoynie(notDeadTeam.get(0).coordinats);
        int k = 0;

        for (int i = 1; i < notDeadTeam.size(); i++) {
            int R = this.coordinats.rastoynie(notDeadTeam.get(i).coordinats);
            if(R<minR) {
                minR = R;
                k = i;
            }
        }
        return k;
    }


    @Override
    public String getInfo(){

        return String.format(" %s %s %s \u2764: %s \u2661: %s \u2694: %s In: %s  X: %s Y: %s",this.getClass().getSimpleName(),this.name,
                this.status, this.hp, this.curHp, Arrays.toString(this.damage) , this.initiative, this.coordinats.x, this.coordinats.y);

    }
    protected void getDamage(float damage){
        this.curHp -= damage;
        if(this.curHp <= 0){
            this.status = "Die";
            this.curHp = 0;
        }
        if(this.curHp>this.hp) {
            this.curHp = this.hp;
        }
    }
    public int[] getCoords(){
        int[] coord = new int[2];
        coord[0] = this.coordinats.x;
        coord[1] = this.coordinats.y;

        return coord;
    }
    public float getHp(){
        return this.curHp;
    }

    public boolean isDead(){
        if (this.status == "Die") return true;
        return false;
    }
}
