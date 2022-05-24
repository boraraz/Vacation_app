import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Root extends JFrame{
    private JLabel wlcm, who;
    private JButton manager, customer, animator;
    private static Connection connection;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        @Override
            public void run(){
            Start_screen strt = new Start_screen();
            strt.setVisible(true);
        }
        });
        String url = "jdbc:postgresql://localhost:5432/vacation_village";
        String username = "postgres";
        String password = "boraberk";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not connected to database","ERROR",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
