import java.util.Random;

/**
 * Created by npolevoy on 05.11.2014.
 */
public class Commando extends Fighter {
    private String name;
    private int strength;
    private int agility;
    private int hp;

    public Commando(String name, int strength, int agility, int hp) {
        super(name, strength, agility, hp);
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.hp = hp;
    }

    public int kick(Fighter fighter)
    {
        Random random = new Random();
        int damage = 0;
        int a;
        System.out.println(this.getName()+" дает очередь по "+fighter.getName());

        for (int i = 0; i < 6; i++)
        {
            if(fighter.getOborot())
            {
                System.out.println(fighter.getName()+" уворачивается от пули!");
            }
            else
            {
               a = random.nextInt(strength)+1;
                System.out.println(this.getName()+" простреливает "+ fighter.getName()+" на "+a+ " hp");
            damage = damage + a;
            }
        }

        return damage;
    }



}
