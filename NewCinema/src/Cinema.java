import java.io.*;

public class Cinema implements Serializable {
    private static final long serialVersionUID = 4404087943572037389L;

    String stageName = "";
    String[][] Date = new String[7][6]; // Renamed Date to date (lowercase d)

    public Cinema(String stageName) {
        this.stageName = stageName;
    }

    public Cinema(){}

    public static void save(Cinema cinema) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Stage\\" + cinema.stageName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(cinema);
            fileOut.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setMovie(Movie movie, String day, String hour, String movieName, String stage) {
        int d, h;
        d = h = 1;
        switch (day){
            case "Sunday": d = 0 ; break;
            case "Monday": d = 1 ; break;
            case "Tuesday": d = 2 ; break;
            case "Wednesday": d = 3 ; break;
            case "Thursday": d = 4 ; break;
            case "Friday": d = 5 ; break;
            case "Saturday": d = 6 ; break;
        }
        switch (hour){
            case "12:00 PM": h = 0 ; break;
            case "14:00 PM": h = 1 ; break;
            case "16:00 PM": h = 2 ; break;
            case "18:00 PM": h = 3 ; break;
            case "20:00 PM": h = 4 ; break;
            case "22:00 PM": h = 5 ; break;
        }
        try {
            FileInputStream fileIn = new FileInputStream("Stage\\" + stage + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Cinema m = (Cinema) in.readObject();
            if(m != null){
                if(m.Date[d][h] == null){
                    m.Date[d][h] = movieName; // Modified from Date to date (lowercase d)
                    Cinema.save(m);
                }
                else {
                    System.out.println("This time (Day : " + day + ", Hour : " + hour + ", at Stage : " + stage + ") has been taken :(");
                }
            }
            fileIn.close();
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        String Time = "Day : " + day + ", Hour : " + hour;
        Movie.addTime(movie, Time, stage);
    }
}