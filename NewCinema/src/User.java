import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

    private static final long serialVersionUID = 4404087943572037389L;
    String userName;

    String passWord;

    List<Ticket> ticket = new ArrayList<>();

    public static void signIn(String name, String passWord){
        User user = new User();
        user.userName = name;
        user.passWord = passWord;
        try{
            FileOutputStream fileOut = new FileOutputStream("Users\\" + name + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(user);
            fileOut.close();
            out.close();
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    public static boolean logIn(String name, String passWord){
        boolean login = false;
        try{
            FileInputStream fileIn = new FileInputStream("Users\\" + name + ".ser");
            ObjectInputStream In = new ObjectInputStream(fileIn);
            User user = (User) In.readObject();
            if(user.passWord.equals(passWord))
                login = true;
            else
                System.out.println("Wrong password !!!");
            fileIn.close();
            In.close();
        }catch (FileNotFoundException e){
            System.out.println("Wrong user name !!!!");
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return login;
    }

    public static void addTicket(Ticket t, String name){
        User user;
        try(ObjectInputStream In = new ObjectInputStream(new FileInputStream("Users\\" + name + ".ser"))){
            user = (User) In.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        user.ticket.add(t);
        try{
            FileOutputStream fileOut = new FileOutputStream("Users\\" + user.userName + ".ser");
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Out.writeObject(user);
            fileOut.close();
            Out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getTicket(String name){
        List<String> tickets = new ArrayList<>();
        try(ObjectInputStream In = new ObjectInputStream(new FileInputStream("Users\\" + name + ".ser"))) {
            User user = (User) In.readObject();
            for(Ticket a : user.ticket){
                tickets.add(a.getId());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return tickets;
    }
}
