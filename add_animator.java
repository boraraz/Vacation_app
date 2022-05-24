import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class add_animator extends JFrame{
    private JPanel addAnimator;
    private JButton backButton;
    private JButton saveButton;
    private JTextField emp_id;
    private JTextField phone;
    private JTextField exp_area;
    private JTextField name;

    public add_animator(){
        add(addAnimator);

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
                        try{
                            Statement stmnt = null;
                            String query = "insert into animator(emp_id, emp_name, emp_phone, expertise_area) values("+(emp_id.getText())+",'"+(name.getText())+"','"+(phone.getText())+"','"+(exp_area.getText())+"')";
                            stmnt = strt.getConnection().createStatement();
                            stmnt.executeUpdate(query);

                            String pass = "select password from animator where emp_id ="+(emp_id.getText())+"";
                            stmnt = strt.getConnection().createStatement();
                            ResultSet user_pass = stmnt.executeQuery(pass);
                            while(user_pass.next()) {
                                JOptionPane.showMessageDialog(null, "" + (user_pass.getInt("password")) + " is the password.");
                            }
                        } catch (Exception a) {
                            JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                            a.printStackTrace();
                        }
                        emp_id.setText("");
                        name.setText("");
                        exp_area.setText("");
                        phone.setText("");
                    }
                }
        );

        setTitle("Animator Adding Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
