
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Controller {

  @FXML
  private TextArea taOutput;


  public void initialize() {

    final String JDBC_DRIVER = "org.h2.Driver";
    final String DB_URL = "jdbc:h2:./resources/HR";

    //  Database credentials
    final String USER = "";
    final String PASS = "";
    Connection conn = null;
    Statement stmt = null;

    try {
      // STEP 1: Register JDBC driver
      Class.forName(JDBC_DRIVER);
      //Class.forName(new org.h2.Driver());

      //STEP 2: Open a connection
      //conn = DriverManager.getConnection(DB_URL, USER, PASS);
      conn = DriverManager.getConnection(DB_URL);

      //STEP 3: Execute a query
      stmt = conn.createStatement();

      String sql = "SELECT * FROM JOBS";

      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        taOutput.appendText(rs.getString(1) + "\n");
      }

      // STEP 4: Clean-up environment
      stmt.close();
      conn.close();
    } catch (SQLException e) {
      taOutput.appendText(e.toString());
    } catch (ClassNotFoundException e) {
      taOutput.appendText(e.toString());
    }
  }
}
