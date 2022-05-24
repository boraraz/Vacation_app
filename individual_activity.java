import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class individual_activity extends JFrame {
    private JPanel indivActiv;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox activityCombo;
    private JTextField age;
    private int cust_id;

    public individual_activity(){
        add(indivActiv);
        Root strt = new Root();
        customer_logIn cust = new customer_logIn();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activity_page actPge = new activity_page();
                actPge.setVisible(true);
                setVisible(false);
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = activityCombo.getSelectedIndex();

                if(index == 0 || age.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter required information.","ERROR",JOptionPane.ERROR_MESSAGE);
                    age.setText("");
                    activityCombo.setSelectedIndex(0);
                    return;
                }
                try {
                    Statement stmnt = strt.getConnection().createStatement();
                    String query = "select * from individualActivity";
                    ResultSet rs = stmnt.executeQuery(query);
                    while(rs.next()){
                        if(rs.getString("activity_name").equals(activityCombo.getSelectedItem()) && rs.getInt("age_requirement") > Integer.parseInt(age.getText())){
                            JOptionPane.showMessageDialog(null,"We are sorry! You are under age for this activity.","ERROR",JOptionPane.ERROR_MESSAGE);
                            age.setText("");
                            return;
                        }

                        else{
                            String get = "select * from customer where customer_phone = '"+(cust.getPhone_num())+"'";
                            ResultSet getRs = stmnt.executeQuery(get);
                            while(getRs.next()){
                                cust_id = getRs.getInt("vacation_village_id");
                                String add = "insert into appointment (customer_id, activity_id, animator_id) values ("+(cust_id)+","+(rs.getInt("activity_id"))+",'12345')";
                                stmnt.executeUpdate(add);
                            }
                        }

                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                    a.printStackTrace();
                }
            }
        });

        setTitle("Individual Activity Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
