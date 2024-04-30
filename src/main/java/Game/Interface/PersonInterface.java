package Game.Interface;
import Game.units.Person;

import java.util.ArrayList;

public interface PersonInterface {
    void step(ArrayList<Person> teamProtivnic, ArrayList<Person> team);
    String getInfo();
}
