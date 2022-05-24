import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class activity_creation extends JFrame {
    private JPanel activityCreatement;
    private JButton backButton;
    private JButton saveButton;
    private JRadioButton massActivityRadioButton;
    private JRadioButton individualActivityRadioButton;
    private JTextField name;
    private JTextField link;
    private JTextField age;
    private JTextField capacity;
    private String selection;

    public activity_creation(){
        add(activityCreatement);
        Root strt = new Root();

        capacity.setEnabled(false);
        capacity.setBackground(Color.gray);
        age.setEnabled(false);
        age.setBackground(Color.gray);
        ButtonGroup group = new ButtonGroup();
        group.add(massActivityRadioButton);
        group.add(individualActivityRadioButton);


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
                if (selection == "indiv"){
                    try {
                        Statement stmnt = null;
                        String query = "insert into individualActivity(activity_name, age_requirement, internet_link) values('"+(name.getText())+"','"+(age.getText())+"','"+(link.getText())+"')";
                        stmnt = strt.getConnection().createStatement();
                        stmnt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Values inserted successfully");
                        name.setText("");
                        age.setText("");
                        link.setText("");
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Something went wrong","ERROR",JOptionPane.ERROR_MESSAGE);
                        a.printStackTrace();
                        return;
                    }
                }
                else if (selection == "mass") {
                    try {
                        Statement stmnt = null;
                        String query = "insert into massActivity(activity_name, capacity, internet_link) values('"+(name.getText())+"',"+(capacity.getText())+",'"+(link.getText())+"')";
                        stmnt = strt.getConnection().createStatement();
                        stmnt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Values inserted successfully");
                        name.setText("");
                        age.setText("");
                        link.setText("");
                    } catch (Exception a) {
                        JOptionPane.showMessageDialog(null, "Something went wrong","ERROR",JOptionPane.ERROR_MESSAGE);
                        a.printStackTrace();
                        return;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Please select a activity type","ERROR",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        });
        massActivityRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capacity.setEnabled(true);
                capacity.setBackground(Color.WHITE);
                age.setEnabled(false);
                age.setBackground(Color.gray);
                selection = "mass";
            }
        });
        individualActivityRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                capacity.setEnabled(false);
                capacity.setBackground(Color.gray);
                age.setEnabled(true);
                age.setBackground(Color.WHITE);
                selection = "indiv";
            }
        });

        setTitle("Activity Creation");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
