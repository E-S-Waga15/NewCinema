import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame {
    private JLabel userName;
    private JTextField NameText;
    private JLabel password;
    private JTextField passwordText;
    private JLabel confirm;
    private JTextField confirmTiext;
    private JButton SignUp;
    private JPanel SiignUp;
    private JPanel Cinema;
    private JLabel CinemaName;
    private JLabel Photo;

    public SignUp(){
        setContentPane(SiignUp);
        setTitle("fefe Abdo");
        setSize(800, 400);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean a = false;
                String name=  NameText.getText();
                String pass=  passwordText.getText();
                String pass2= confirmTiext.getText();
                if(pass.equals(pass2)){
                    a = true;
                    User.signIn(name, pass);
                    MovieList movieList = new MovieList(name);
                    setVisible(false);
                    movieList.setVisible(a);
                }
                else {JOptionPane.showMessageDialog(null,"wrong password !!!");}
            }
        });
    }
}
