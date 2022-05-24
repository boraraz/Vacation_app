import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class activity_page extends JFrame{
    private JButton backButton;
    private JButton individualActivityButton;
    private JButton massActivityButton;
    private JPanel ActivityPanel;

    public activity_page(){
        add(ActivityPanel);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customer_logIn cstlog = new customer_logIn();
                cstlog.setVisible(true);
                setVisible(false);
            }
        });
        massActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mass_activity massAct = new mass_activity();
                massAct.setVisible(true);
                setVisible(false);
            }
        });
        individualActivityButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                individual_activity indiv = new individual_activity();
                indiv.setVisible(true);
                setVisible(false);
            }
        });

        setTitle("Activity Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
