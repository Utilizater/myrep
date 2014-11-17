import java.util.Random;

/**
 * Created by npolevoy on 05.11.2014.
 */
public abstract class Fighter {
    private String name;
    private int strength;
    private int agility;
    private int hp;

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Fighter(String name, int strength, int agility, int hp) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.hp = hp;
    }

    public boolean getOborot() {
        Random random = new Random();
        if((random.nextInt(100)+1)>agility)
        return false;
        else return true;
    }

    public int getStrength() {

        return strength;
    }

    public int getHp() {

        return hp;
    }

    public String getName() {

        return name;
    }

    public abstract int kick(Fighter fighter);
}
