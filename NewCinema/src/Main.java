import javax.swing.*;
import java.io.*;

public class Main implements Serializable{
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        long serialVersionUID = ObjectStreamClass.lookup(cinema.getClass()).getSerialVersionUID();
        GUI frame = new GUI();
    }
}