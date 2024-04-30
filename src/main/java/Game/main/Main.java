package Game.main;

import Game.Views.AnsiColors;
import Game.Views.Names;
import Game.Views.View;
import Game.units.*;


import java.util.Random;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Person> team1;
    public static ArrayList<Person> team2;
    public static ArrayList<Person> teamAll;
    public static void main(String[] args) {

        team1 = newTeam(1, 1);
        team2 = newTeam(10,2);
        teamAll = new ArrayList<Person>(20);
        teamAll.addAll(team1);
        teamAll.addAll(team2);

        teamAll.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.initiative- o2.initiative;
            }
        });

        Scanner in = new Scanner(System.in);

        while (isNotLooser(team1) && isNotLooser(team2)) {
            View.view();
            for (Person p : teamAll) {

                if (team1.contains(p)) {
                    p.step(team2, team1);
                } else {
                    p.step(team1, team2);
                }
            }
            in.nextLine();
        }
        View.view();
        if (isNotLooser(team1)) System.out.print("Green side win!");
        else System.out.print("Blue side win!");
    }

    private static String getName(){
        String s = String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
        return s;
    }

        private static ArrayList<Person> newTeam(int k, int numberTeam) {

            ArrayList<Person> team = new ArrayList<Person>(10);
            Random rand = new Random();
            for (int i = 1; i < 11; i++) {

                int var = rand.nextInt(0, 9);
                switch (var) {
                    case 1:
                        team.add(new Crossbowman(getName(),k,i,numberTeam));
                        break;
                    case 2:
                        team.add(new Balista(getName(),k,i,numberTeam));
                        break;
                    case 3:
                        team.add(new Rogue(getName(),k,i,numberTeam));
                        break;
                    case 4:
                        team.add(new Swordsman(getName(),k,i,numberTeam));
                        break;
                    case 5:
                        team.add(new Pikeman(getName(),k,i,numberTeam));
                        break;
                    case 6:
                        team.add(new Warlock(getName(),k,i,numberTeam));
                        break;
                    case 7:
                        team.add(new Doctor(getName(),k,i,numberTeam));
                        break;

                    default:
                        team.add(new Farmer(getName(),k,i,numberTeam));
                        break;
                }
            }
            return team;
        }

        private static boolean isNotLooser (ArrayList<Person> team){
            int count=0;
            for (int i = 0; i < team.size(); i++) {
                if (team.get(i).isDead()) count++;
            }
            if (count == team.size()) return false;
            return true;
        }

    }


