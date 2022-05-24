import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class mass_activity extends JFrame{
    private JPanel massActivity;
    private JButton backButton;
    private JButton saveButton;
    private JComboBox hour_combo;
    private JPanel Calendr;
    private JComboBox activity;
    private JLabel availability;
    private JDateChooser datechoose;
    private Calendar cld;

    public mass_activity(){
        add(massActivity);
        Root strt = new Root();
        cld = Calendar.getInstance();
        datechoose =new JDateChooser(cld.getTime());
        Calendr.add(datechoose);




        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activity_page actPge = new activity_page();
                actPge.setVisible(true);
                setVisible(false);
            }
        });

        hour_combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(hour_combo.getSelectedItem());
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat datefrmt = new SimpleDateFormat("dd/MM/yyyy");
                String dt = datefrmt.format(datechoose.getDate());
                System.out.println(dt);
            }
        });

        setTitle("Mass Activity Page");
        setResizable(true);
        setSize(600,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
