
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SERGIO
 */
public class ConexionBDDSinglaton {
    protected Connection conn;
    
    private final String DRIVE ="com.mysql.cj.jdbc.Driver";
    private final String URL ="jdbc:mysql://localhost:3306/amunicipalidad";
    private final String USER ="root";
    private final String PASS ="";
    
    public void conectar(){
        try{
            conn=DriverManager.getConnection(URL,USER,PASS);
            Class.forName(DRIVE);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("error" + e.getMessage());
        }
    }
}
