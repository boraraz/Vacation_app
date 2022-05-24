import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class add_equip_person extends JFrame {
    private JPanel addEquipPerson;
    private JButton backButton;
    private JButton saveButton;
    private JTextField SSN;
    private JTextField surname;
    private JTextField phone;
    private JTextField name;

    public add_equip_person(){
        add(addEquipPerson);

        Root strt = new Root();

        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manager_page mngr = new manager_page();
                        mngr.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        saveButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(phone.getText().length()!= 10) {
                            JOptionPane.showMessageDialog(null,"Phone number must contain 10 numbers.","ERROR",JOptionPane.ERROR_MESSAGE);
                            phone.setText("");
                            return;
                        }
                        try {
                            Statement stmnt = null;
                            String query = "insert into equip_person (ssn, eqp_name, eqp_surname, eqp_phone) values("+(SSN.getText())+",'"+(name.getText())+"','"+(surname.getText())+"','"+(phone.getText())+"')";
                            stmnt = strt.getConnection().createStatement();
                            stmnt.executeUpdate(query);

                            String pass = "select password from equip_person where ssn ="+(SSN.getText())+"";
                            stmnt = strt.getConnection().createStatement();
                            ResultSet user_pass = stmnt.executeQuery(pass);
                            while(user_pass.next()) {
                                JOptionPane.showMessageDialog(null, "" + (user_pass.getInt("password")) + " is the password.");
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                            a.printStackTrace();
                        }
                        SSN.setText("");
                        name.setText("");
                        surname.setText("");
                        phone.setText("");
                    }
                }
        );

        setTitle("Equipment Person Adding Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
