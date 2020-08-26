package interfas;
// Importamos las clases de conexion a mysql y los drivers de sql
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class vistaConeccion extends javax.swing.JFrame {
    // Declaramos la conexion a mysql
    private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="eugenio";
    private static final String pass="123456";
    private static final String url="jdbc:mysql://localhost:3306/prueba";
    // Funcion que va conectarse a mi bd de mysql
    public void conector() {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                jLabel1.setText("Conexion establecida");
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            jLabel1.setText("Error de conexion" + e);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        conector();
    }                                           
}