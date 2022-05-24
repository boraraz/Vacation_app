import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start_screen extends JFrame {
    private JPanel start_screen_1;
    private JLabel who, wlcm;
    private JButton customerButton, animatorButton, managerButton;

    public Start_screen() {
        add(start_screen_1);

        managerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        manager_page managerPage = new manager_page();
                        managerPage.setVisible(true);
                        setVisible(false);
                    }
                }
        );
        customerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        customer_logIn cstLog = new customer_logIn();
                        cstLog.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        animatorButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        animator_login anmtr = new animator_login();
                        anmtr.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        setTitle("Vacation Village");
        setVisible(true);
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
