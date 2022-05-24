import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class manager_page extends JFrame{
    private JPanel managerPage;
    private JButton backButton;
    private JButton customerButton;
    private JButton animatorButton;
    private JButton equipPersonButton;

    public manager_page(){
        add(managerPage);
        Root strt = new Root();
        backButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Start_screen strt = new Start_screen();
                        strt.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        animatorButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        add_animator adanmtr = new add_animator();
                        adanmtr.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        equipPersonButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        add_equip_person eqp = new add_equip_person();
                        eqp.setVisible(true);
                        setVisible(false);
                    }
                }
        );
        customerButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        add_customer adcstmr = new add_customer();
                        adcstmr.setVisible(true);
                        setVisible(false);
                    }
                }
        );

        setTitle("Manager Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
