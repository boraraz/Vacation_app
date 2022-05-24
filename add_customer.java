import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class add_customer extends JFrame {
    private JPanel addCustomer;
    private JButton backButton;
    private JButton saveButton;
    private JTextField vvid;
    private JTextField name;
    private JTextField age;
    private JTextField room;
    private JTextField phone;

    public add_customer(){
        add(addCustomer);

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
                            String query = "insert into customer(vacation_village_id, customer_name, customer_age, room_num, customer_phone) values("+(vvid.getText())+",'"+(name.getText())+"',"+(age.getText())+","+(room.getText())+","+(phone.getText())+")";
                            stmnt = strt.getConnection().createStatement();
                            stmnt.executeUpdate(query);

                            String pass = "select password from customer where vacation_village_id ="+(vvid.getText())+"";
                            stmnt = strt.getConnection().createStatement();
                            ResultSet user_pass = stmnt.executeQuery(pass);
                            while(user_pass.next()) {
                                JOptionPane.showMessageDialog(null, "" + (user_pass.getInt("password")) + " is the password.");
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                            a.printStackTrace();
                        }

                        vvid.setText("");
                        name.setText("");
                        age.setText("");
                        room.setText("");
                        phone.setText("");
                    }
                }
        );

        setTitle("Customer Adding Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
