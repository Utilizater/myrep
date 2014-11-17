/**
 * Created by npolevoy on 05.11.2014.
 */
public class Gandalf extends Fighter {
    private String name;
    private int strength;
    private int agility;
    private int hp;

    public Gandalf(String name, int strength, int agility, int hp) {
        super(name, strength, agility, hp);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.hp = hp;
    }

    public int kick(Fighter fighter)
    {
        System.out.println(this.getName()+" бьет "+fighter.getName()+" своим мегопосохом");
        if(fighter.getOborot())
        {
            System.out.println(fighter.getName()+" уворачивается от посоха!");
            return 0;
        }
        else
        {
            System.out.println(this.getName()+" пробивает "+ fighter.getName()+" на "+strength+ " hp");
            return strength;
        }

    }

}