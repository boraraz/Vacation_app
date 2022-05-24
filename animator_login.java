import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class animator_login extends JFrame {
    private JPanel animator_page;
    private JButton backButton;
    private JTextField phone;
    private JPasswordField password;
    private JButton logInButton;

    public animator_login(){
        add(animator_page);
        Root strt = new Root();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start_screen strtsc = new Start_screen();
                strtsc.setVisible(true);
                setVisible(false);
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement stmnt = strt.getConnection().createStatement();
                    String query = "select * from animator";
                    ResultSet rs = stmnt.executeQuery(query);
                    while(rs.next()){
                        if(password.getText().isEmpty() || phone.getText().isEmpty()){
                            JOptionPane.showMessageDialog(null, "Please enter the required information","ERROR",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if(Integer.parseInt(password.getText()) == rs.getInt("password") && rs.getString("emp_phone").equals(phone.getText())){
                            operation_selection oprt = new operation_selection();
                            oprt.setVisible(true);
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
        });

        setTitle("Animator Log In");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
