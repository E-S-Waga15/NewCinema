import java.io.*;
import java.util.Iterator;
import java.util.Objects;

public class Ticketing implements Serializable {

    private static final long serialVersionUID = 2053029141700394099L;

    public int Id = 0;
    public static String ticketBook(String name, String movieName, String date, String stage){
        int counter = Ticketing.readCounter();
        String Id = "";
        try{
            FileOutputStream fileOut = new FileOutputStream("Tickets\\" + Integer.toString(counter) + ".ser");
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Ticket ticket = new Ticket();
            ticket.id = counter;
            ticket.name = name;
            ticket.Stage = stage;
            ticket.date = date;
            ticket.movieName = movieName;
            Out.writeObject(ticket);
            fileOut.close();
            Out.close();
            FileInputStream fileIn = new FileInputStream("Users\\" + name + ".ser");
            ObjectInputStream In = new ObjectInputStream(fileIn);
            User user = (User) In.readObject();
            Id = Integer.toString(ticket.id);
            User.addTicket(ticket, name);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        counterInc();
        return Id;
    }

    public static void counterInc(){
        try{
            FileInputStream fileIn = new FileInputStream("counter.ser");
            ObjectInputStream In = new ObjectInputStream(fileIn);
            Ticket ticket = (Ticket) In.readObject();
            ticket.counter++;
            int c = ticket.counter;
            fileIn.close();
            In.close();
            FileOutputStream fileOut = new FileOutputStream("counter.ser");
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Out.writeObject(ticket);
            fileOut.close();
            Out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int readCounter(){
        int counter = 0;
        try{
            FileInputStream fileIn = new FileInputStream("counter.ser");
            ObjectInputStream In = new ObjectInputStream(fileIn);
            Ticket ticket = (Ticket) In.readObject();
            counter = ticket.counter;
            fileIn.close();
            In.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return counter;
    }


    public static void unBook(String name, String Id){
        try{
            FileInputStream fileIn = new FileInputStream("Users\\" + name + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            User user = (User) in.readObject();
            fileIn.close();
            in.close();

            System.out.println("Tickets before removal: " + user.ticket); // Debug: Print tickets before removal

            Iterator<Ticket> iterator = user.ticket.iterator();
            while (iterator.hasNext()) {
                Ticket t = iterator.next();
                if (t.getId().equals(Id)) {
                    iterator.remove();
                    System.out.println("Ticket with ID " + Id + " removed."); // Debug: Print when a ticket is removed
                    break; // Break out of the loop once the ticket is found and removed
                }
            }

            System.out.println("Tickets after removal: " + user.ticket); // Debug: Print tickets after removal

            FileOutputStream fileOut = new FileOutputStream("Users\\" + name + ".ser");
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Out.writeObject(user);
            fileOut.close();
            Out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
