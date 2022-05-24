import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class emergency_info extends JFrame{
    private JPanel emergencyInfo;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox comboBox1;
    private JTextField phone;
    private JTextField lockNum;

    public emergency_info(){
        add(emergencyInfo);
        Root strt = new Root();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operation_selection oprt = new operation_selection();
                oprt.setVisible(true);
                setVisible(false);
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(phone.getText().isEmpty() || lockNum.getText().isEmpty() || comboBox1.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null,"Please enter required information.","ERROR",JOptionPane.ERROR_MESSAGE);
                    lockNum.setText("");
                    phone.setText("");
                    comboBox1.setSelectedIndex(0);
                    return;
                }
                try {
                    Statement stmnt = null;
                    String pass = "select activity_id from individualActivity where activity_name = '"+(comboBox1.getSelectedItem())+"' ";
                    stmnt = strt.getConnection().createStatement();
                    ResultSet act_id = stmnt.executeQuery(pass);
                    while(act_id.next()) {
                        int id = act_id.getInt("activity_id");

                        String query = "insert into emergencyInfo (emer_lock, emer_phone, activity_id) values(" + (lockNum.getText()) + ",'" + (phone.getText()) + "'," + (id) + ")";
                        stmnt = strt.getConnection().createStatement();
                        stmnt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Values inserted successfully.");
                    }
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                    a.printStackTrace();
                }
            }
        });

        setTitle("Emergency Information Adding Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
