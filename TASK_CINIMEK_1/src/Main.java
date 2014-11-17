import java.io.*;
import java.util.Properties;

/**
 * Created by npolevoy on 13.11.2014.
 */
public class Main {
    public static void main(String[] arr) throws IOException {
       Menu();
    }

    public static String GetAddress() throws IOException {
        InputStream fis;
        Properties properties = new Properties();
        fis = new FileInputStream("src/config");
        properties.load(fis);
        return properties.getProperty("address");
    }

    public static void Cash_In(String fileName) throws IOException {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        long account_number = 0;
        int amount = 0;
        while (true) {
            System.out.println("Введите номер счета");
            String st = bufferedReader.readLine();
            if (Check(st)) {
            account_number = Long.parseLong(st);
                if (String.valueOf(account_number).length() == 12) {

                    System.out.println("Введите сумму");
                    st = bufferedReader.readLine();
                    if (Check(st)){
                    amount = Integer.parseInt(st);
                        try {
                            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
                            try {
                                out.write("\n" + account_number + "Cash-In" + amount);
                            } finally {
                                out.close();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                     }
                    else {System.out.println("Для ввода доступны только цифры");}
                }
                else { System.out.println("Номер счета должен быть 12-ти значным");}
            }
            else {System.out.println("Для ввода доступны только цифры");}
        }
    }

    public static void Cash_Out(String fileName) throws IOException {
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        long account_number = 0;
        int amount = 0;
        while (true) {
            System.out.println("Введите номер счета");
            String st = bufferedReader.readLine();
            if (Check(st)) {
                account_number = Long.parseLong(st);
                if (String.valueOf(account_number).length() == 12) {

                    System.out.println("Введите сумму");
                    st = bufferedReader.readLine();
                    if (Check(st)){
                        amount = Integer.parseInt(st);
                        try {
                            BufferedWriter out = new BufferedWriter(new FileWriter(fileName, true));
                            try {
                                out.write("\n" + account_number + "Cash-Out" + amount);
                            } finally {
                                out.close();
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                    else {System.out.println("Для ввода доступны только цифры");}
                }
                else { System.out.println("Номер счета должен быть 12-ти значным");}
            }
            else {System.out.println("Для ввода доступны только цифры");}
        }
    }

    public static void PrintFiles(String adress) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader( new File(adress).getAbsoluteFile()));
        String s;
        while ((s = in.readLine()) != null)
        {System.out.println(s);}
    }

    public static void Get(String adress) throws IOException {
        System.out.println("Операции по какому счету хотите посмотреть?");
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);
        long account_number = 0;
        while (true) {

            System.out.println("Введите номер счета");
            String st = bufferedReader.readLine();
            if (Check(st))
            {
                account_number = Long.parseLong(st);

            if (String.valueOf(account_number).length() != 12) {
                System.out.println("Номер счета должен быть 12-ти значным");
            } else break;
          } else {System.out.println("Необходимо вводить только цифры");}
        }
        BufferedReader in = new BufferedReader(new FileReader( new File(adress).getAbsoluteFile()));
        String s;
        boolean b = false;
        while ((s = in.readLine()) != null)
        {
           String[] ar1= s.split("Cash-In");
           String[] ar2= s.split("Cash-Out");
           if(ar1[0].equals(String.valueOf(account_number)))
           {
               System.out.print("Тип операции - Cash-In.   ");
               System.out.println("Сумма - "+ar1[1]);
               b = true;
           }
           if(ar2[0].equals(String.valueOf(account_number)))
           {
               System.out.print("Тип операции - Cash-Out.   ");
               System.out.println("Сумма - "+ar2[1]);
               b = true;
           }
        }
        if(!b) {System.out.println("Информации по этому счету нет");}

    }

    public static void Menu() throws IOException {
        boolean b = true;
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        while (b) {
            System.out.println("Введите команду");
            System.out.println("1 - показать все содержимое БД");
            System.out.println("2 - провести операцию Cash_In");
            System.out.println("3 - провести операцию Cash_Out");
            System.out.println("4 - показать операции по счету");
            System.out.println("5 - покинуть программу");
            String st = bufferedReader.readLine();
            if (Check(st)) {

                switch (Integer.parseInt(st)) {
                    case 1:
                        PrintFiles(GetAddress());
                        break;
                    case 2:
                        Cash_In(GetAddress());
                        break;
                    case 3:
                        Cash_Out(GetAddress());
                        break;
                    case 4:
                        Get(GetAddress());
                        break;
                    case 5:
                        b = false;
                    break;
                    default:
                        System.out.println("Для ввода доступны только команды меню.");
                        break;
                }
            } else System.out.println("Для ввода доступны только команды меню.");
        }
    }

    public static boolean Check(String st)
    {
        try
        {Long.parseLong(st);
        return true;
        }
        catch (Exception e)
        {return false;}
    }

}

