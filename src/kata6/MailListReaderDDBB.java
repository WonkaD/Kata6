package kata6;

import java.sql.*;
import java.util.ArrayList;

public class MailListReaderDDBB {

    public static ArrayList<String> read() throws ClassNotFoundException {
        ArrayList<String> mailList = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\WonkaD\\Documents\\NetBeansProjects\\Kata5\\kata5");

            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM MAILS");
            while (rs.next()) {
                mailList.add(rs.getString("MAIL"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return mailList;
    }
}
