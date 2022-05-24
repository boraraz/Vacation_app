import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class operation_selection extends JFrame {
    private JPanel operationSelection;
    private JButton backButton;
    private JButton activityCreatementButton;
    private JButton emergencyInformationButton;
    private JButton addEquipmentButton;

    public operation_selection(){
        add(operationSelection);
        Root strt = new Root();


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animator_login anmtr = new animator_login();
                anmtr.setVisible(true);
                setVisible(false);
            }
        });


        activityCreatementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activity_creation actvt = new activity_creation();
                actvt.setVisible(true);
                setVisible(false);
            }
        });
        emergencyInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emergency_info emerg = new emergency_info();
                emerg.setVisible(true);
                setVisible(false);
            }
        });
        addEquipmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               emergency_equip equip = new emergency_equip();
               equip.setVisible(true);
               setVisible(false);
            }
        });

        setTitle("Animator Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
