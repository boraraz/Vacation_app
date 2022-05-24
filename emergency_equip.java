import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class emergency_equip extends JFrame{
    private JPanel emergencyEquip;
    private JButton backButton;
    private JButton saveButton;
    private JTextField name;
    private JTextField purpose;
    private JTextField SSN;

    public emergency_equip(){
        add(emergencyEquip);
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
                if(name.getText().isEmpty() || purpose.getText().isEmpty() || SSN.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter required information.","ERROR",JOptionPane.ERROR_MESSAGE);
                    name.setText("");
                    purpose.setText("");
                    SSN.setText("");
                    return;
                }
                try {
                    Statement stmnt = null;
                        String query = "insert into equip_operation (name, purpose, equip_pers_ssn) values('" + (name.getText()) + "','" + (purpose.getText()) + "'," + (SSN.getText()) + ")";
                        stmnt = strt.getConnection().createStatement();
                        stmnt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Values inserted successfully.");
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
                    a.printStackTrace();
                }
            }
        });

        setTitle("Emergency Equipment Adding Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
