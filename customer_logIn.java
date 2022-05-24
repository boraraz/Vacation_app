import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class customer_logIn extends JFrame{
    private JButton backButton;
    private JButton logInButton;
    private JTextField phone_num;
    private JPasswordField passwordField;
    private JPanel LogIn_scrn;

    public JTextField getPhone_num() {
        return phone_num;
    }

    public customer_logIn(){
        add(LogIn_scrn);

        Root strt = new Root();

        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Start_screen strt = new Start_screen();
                        strt.setVisible(true);
                        setVisible(false);
                    }
                }
        );
        logInButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Statement stmnt = strt.getConnection().createStatement();
                            String query = "select * from customer";
                            ResultSet rs = stmnt.executeQuery(query);
                            while(rs.next()){
                                if(passwordField.getText().isEmpty() || phone_num.getText().isEmpty()){
                                    JOptionPane.showMessageDialog(null, "Please enter the required information","ERROR",JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                                if(Integer.parseInt(passwordField.getText()) == rs.getInt("password") && rs.getString("customer_phone").equals(phone_num.getText())){
                                    activity_page actp = new activity_page();
                                    actp.setVisible(true);
                                    setVisible(false);
                                }

                                else{
                                    JOptionPane.showMessageDialog(null, "Password or phone number is wrong","ERROR",JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }

                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                            a.printStackTrace();
                        }
                    }
                }
        );

        setTitle("Customer Log In");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
