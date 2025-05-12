import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tickets extends JFrame{
    private JComboBox comboBox1;
    private JLabel Tickets;
    private JButton Unbook;
    private JButton back;
    private JPanel Cinema;
    private JLabel CinemaName;
    private JPanel Cancel;
    private JLabel Photo;

    String name = "";

    String Id = "";

    public Tickets(String name){
        setContentPane(Cancel);
        setTitle("fefe Abdo");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        this.name += name;
        comboBox1.setModel(new DefaultComboBoxModel<>(User.getTicket(name).toArray(new String[0])));
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Id = (String) comboBox1.getSelectedItem();
            }
        });
        Unbook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Ticketing.unBook(name, Id);
                    JOptionPane.showMessageDialog(null,"Ticket canceled successfully\nRestart the program to update the changes");

                }catch (Exception m){
                    System.out.println("Unbook problem");
                }
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MovieList movieList = new MovieList(name);
                movieList.setVisible(true);
            }
        });
    }
}
