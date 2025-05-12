import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Movie implements Serializable {

    private static final long serialVersionUID = 4404087943572037389L;

    String movieName;

    String id;

    String[] showTimes = new String[4];

    String[] Stage = new String[4];

    int[] Seats = new int[4];

    public int counter = 0;

    public List<String> moviesList = new ArrayList<>();

    public Movie(String name, String id) {
        this.movieName = name;
        this.id = id;
    }

    public Movie(){}

    static public void save(Movie movie){
        try{
            FileOutputStream fileOut = new FileOutputStream("Movies\\" + movie.movieName +".ser");
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Out.writeObject(movie);
            fileOut.close();
            Out.close();
        }catch (IOException e){
            e.getStackTrace();
        }
    }

    static public void addTime(Movie movie, String time, String Stage){
        movie.showTimes[movie.counter] = time;
        movie.Stage[movie.counter] = Stage;
        //movie.Seats[movie.counter] = 100;
        if(movie.counter < 6)
            movie.counter++;
    }

    public static String getTime(String movieName, int index) {
        Movie m = new Movie();
        try (ObjectInputStream In = new ObjectInputStream(new FileInputStream("Movies\\" + movieName + ".ser"))){
            m = (Movie) In.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return m.showTimes[index];
    }

    public static String getStage(String movieName, int index) {
        Movie m = new Movie();
        try {
            FileInputStream fileIn = new FileInputStream("Movies\\" + movieName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            m = (Movie) in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return m.Stage[index];
    }

    public static String getMovieName(String movieName) {
        String a = "";
        try {
            FileInputStream fileIn = new FileInputStream("D:\\JPROs\\NewCinema\\Movies\\" + movieName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Movie m = (Movie) in.readObject();
            fileIn.close();
            in.close();
            a = m.movieName;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return a;
    }

    public static int getSeats(String movieName, int index) {
        Movie m = null;
        try {
            FileInputStream fileIn = new FileInputStream("D:\\JPROs\\NewCinema\\Movies\\" + movieName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            m = (Movie) in.readObject();
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return m.Seats[index];
    }

    public static List<String> getMoviesList(){
        Movie movie;
        try(ObjectInputStream In = new ObjectInputStream(new FileInputStream("Movies\\Movies.ser"))){
            movie = (Movie) In.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movie.moviesList;
    }
    public static List<String> getDate(String movieName){
        List<String> date = new ArrayList<>();
        for(int i = 0 ; i < 4 ; i++){
            String Date = Movie.getTime(movieName, i) + ", Stage : " + Movie.getStage(movieName, i);
            date.add(Date);
        }
        return date;
    }

    public static void setMoviesList(String movieName){
        try{
            FileInputStream fileIn = new FileInputStream("Movies\\Movies.ser");
            ObjectInputStream In = new ObjectInputStream(fileIn);
            Movie m = (Movie) In.readObject();
            m.moviesList.add(movieName);
            fileIn.close();
            In.close();
            FileOutputStream fileOut = new FileOutputStream("Movies\\Movies.ser");
            ObjectOutputStream Out = new ObjectOutputStream(fileOut);
            Out.writeObject(m);
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
