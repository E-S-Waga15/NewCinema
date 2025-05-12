import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JLabel Name;
    private JLabel password;
    private JTextField UserNameTXT;
    private JTextField PassWordTXT;
    private JButton signIn;
    private JPanel SignIn;
    private JButton singup;
    private JLabel creat;
    private JLabel CinemaName;
    private JPanel Cinema;
    private JLabel Photo;

    public GUI(){
        setContentPane(SignIn);
        setTitle("ROZA Cinema - LogIn");
        setSize(800, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        singup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean a= true;
             SignUp singup = new SignUp();
             setVisible(false);
             singup.setVisible(a);
            }
        });
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean a;
                String name = UserNameTXT.getText();
                String pass = PassWordTXT.getText();
                a = User.logIn(name, pass);
                if(a){
                    MovieList movieList = new MovieList(name);
                    setVisible(false);
                    movieList.setVisible(a);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Wrong user name or password !!");
                }
                //
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
