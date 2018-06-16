import java.io.*;

/**
 * комммментарииииииййй Created by npolevoy on 05.11.2014.
 * Комент 2
 */
public class Main {
    public static void main(String[] array) throws IOException {


        System.out.println("Выберите первого бойца");

        //Gandalf gandalf = new Gandalf("Гендольф", 50, 20, 100);
       // Jedi jedi = new Jedi("Йода", 20, 80, 100);
       // Commando commando = new Commando("Путин", 3, 5, 150);

       Fighter fighter1 = SetFighter();
        System.out.println("Выберите второго бойца");
       Fighter fighter2 = SetFighter();


         fight(fighter1, fighter2);

    }

    public static void fight(Fighter fighter1, Fighter fighter2)
    {
        int sequence = 1;
        System.out.println("На боевую арену выходят "+fighter1.getName()+" и "+fighter2.getName());
        System.out.println("Бой!");


        while (fighter1.getHp()>=0 && fighter2.getHp()>=0)
        {
            System.out.println("---------------");
            if(sequence==1)
            {
                fighter2.setHp(fighter2.getHp()-fighter1.kick(fighter2));
                sequence = 2;
            }
            else
            {
                fighter1.setHp(fighter1.getHp()-fighter2.kick(fighter1));
                sequence = 1;
            }
        }
        System.out.println("---------------");
        if(fighter1.getHp()<=0)
        {System.out.println("Победил "+fighter2.getName());}
        else
        {System.out.println("Победил "+fighter1.getName());}

    }

    public static Fighter SetFighter()
    {
        Fighter fighter = null;
        int number = 0;
        String name;
        int strength;
        int agility;
        int hp;

        System.out.println("1   -  Джедай");
        System.out.println("2   -  Маг");
        System.out.println("3   -  Космодесантник");

        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        try {
            number  = Integer.parseInt(bufferedReader.readLine());


        switch(number)
        {
            case 1:
                System.out.println("Джедай, отличный выбор!");
                System.out.println("Как его зовут?");
                name = bufferedReader.readLine();
                System.out.println("Чему равна его сила?");
                strength = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Чему равна его ловкость?");
                agility = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Чему равно его здоровье?");
                hp = Integer.parseInt(bufferedReader.readLine());
                fighter = new Jedi(name, strength, agility, hp);
                break;
            case 2:
                System.out.println("Маг, отличный выбор!");
                System.out.println("Как его зовут?");
                name = bufferedReader.readLine();
                System.out.println("Чему равна его сила?");
                strength = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Чему равна его ловкость?");
                agility = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Чему равно его здоровье?");
                hp = Integer.parseInt(bufferedReader.readLine());
                fighter =  new Gandalf(name, strength, agility, hp);
                break;
            case 3:
                System.out.println("Космодесантник, отличный выбор!");
                System.out.println("Как его зовут?");
                name = bufferedReader.readLine();
                System.out.println("Как сильно пробивает его пулька?");
                strength = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Чему равна его ловкость?");
                agility = Integer.parseInt(bufferedReader.readLine());
                System.out.println("Чему равно его здоровье?");
                hp = Integer.parseInt(bufferedReader.readLine());
                fighter =  new Commando(name, strength, agility, hp);
                break;
            default:;
                System.out.println("Нет такого чувака");
                break;
            //fighter =  null;
        }


        } catch (IOException e) {
            e.printStackTrace();
            fighter = null;
        }
      return fighter;
    }

}
