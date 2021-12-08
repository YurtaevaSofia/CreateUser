import java.io.Serializable;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestObject implements Serializable {

    public String email = randomString()+"@gmail.com";
    public String name =  randomString();
    public int [] tasks = new int [] {12};
    public int [] companies = new int [] {36, 37};
    public String hobby = "Стрельба из лука, Настолки";
    public String aderes = "адрес 1";
    public String name1 = "Тестовый, ясен пень";
    public String surname1 = "Иванов";
    public String fathername1 = "Петров";
    public String cat = "Маруся";
    public String dog = "Ушастый";
    public String parrot = "Васька";
    public String cavy = "Кто ты?";
    public String hamster = "Хомяк";
    public String squirrel = "Белая горячка";
    public String phone = "333 33 33";
    public String inn = "123456789012";
    public String gender =  "m";
    public Date birthdate = new SimpleDateFormat( "dd.MM.yyyy" ).parse( "01.01.1995" );
    public Date date_start =  new SimpleDateFormat( "dd.MM.yyyy" ).parse( "11.11.2000" );




    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();


    public static String randomString(){
        StringBuilder sb = new StringBuilder(10);
        for(int i = 0; i < 10; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public TestObject() throws ParseException {
    }



}
