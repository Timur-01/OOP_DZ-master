package Game.units;

import java.util.ArrayList;

public class Farmer extends Person {



        public Farmer(String name, int x, int y, int numberTeam){

            super( name,10,  new int[]{0,0},5, x, y, numberTeam, 7);

        }


    @Override
    public void step(ArrayList<Person> teamProtivnic, ArrayList<Person> team) {
            if (this.curHp == 0) return;
            status ="Stand";
    }



}

