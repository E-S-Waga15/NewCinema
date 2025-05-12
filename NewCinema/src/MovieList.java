import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieList extends JFrame{
    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JPanel ComboBox;
    private JLabel Movies;
    private JLabel Info;
    private JButton Book;
    private JButton Tickets;
    private JPanel Cinema;
    private JLabel CinemaName;
    private JLabel Photo;
    private String[] options1 = {"Option 1", "Option 2", "Option 3"};

    String name;

    String Date = "";

    String Stage = "";

    String Item = "";

    String Date2 = "";

    public MovieList(String name){
        this.name = name;
        setContentPane(ComboBox);
        setTitle("fefe Abdo");
        setSize(800, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comboBox1.setModel(new DefaultComboBoxModel<>(Movie.getMoviesList().toArray(new String[0])));
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Item = (String) comboBox1.getSelectedItem();
                comboBox2.setModel(new DefaultComboBoxModel<>(Movie.getDate(Item).toArray(new String[0])));
            }
        });
        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //int a;
                Date = (String) comboBox2.getSelectedItem();
                Stage = Character.toString(Date.charAt(Date.length() - 1));
                Date2 = Date.replace(",Stage : " + Stage, "");
            }
        });
        Book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String Id = Ticketing.ticketBook(name, Item, Date2, Stage);
                    JOptionPane.showMessageDialog(null,"Payment done\nYour card number : " + Id);
                }catch (Exception m){
                    System.out.println("Book problem");
                }
            }
        });
        Tickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tickets tickets = new Tickets(name);
                setVisible(false);
                tickets.setVisible(true);
            }
        });
    }
}
