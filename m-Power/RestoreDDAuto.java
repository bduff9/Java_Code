/**
* RestoreDDAuto.java, Created Jun 28, 2012, Copyright mrc ltd.
*/
/**
* Calls batch files located in c:\backup\restore.bat
* To be used in ONLINELAB data dictionary, passing in a Data Dictionary to be restored.
*
* @author BD
*/
package ONLINELAB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import com.mrc.dbo.MrcConnection;

public class RestoreDDAuto {

private Logger log = Logger.getLogger(this.getClass());

public static void main(String[] arg){
new RestoreDDAuto().startCall(arg);
}

public void startCall(String[] arg) {
String p1 = arg[0];
int p2 = Integer.parseInt(arg[1]);
if (p2 > 7) {
String cmd1="cmd /c c:\\backup\\restore_db.bat " + p1;
String cmd2="cmd /c c:\\backup\\restore_apps.bat " + p1;

try {
Runtime.getRuntime().exec(cmd1);
System.out.println("Restoring "+p1);
System.out.println("Running command " +cmd1);

Runtime.getRuntime().exec(cmd2);
System.out.println("Restoring "+p1);
System.out.println("Running command " +cmd2);
}
catch (Exception sqle) {
System.err.println("Error");
sqle.printStackTrace();
}
finally {
try {
} catch (Exception error) {
error.printStackTrace();
}
}
System.out.println("Restoration of "+p1+" Completed!");
String sql = "UPDATE MRCWEBSITE.OLABUSERS SET IDNUM = 0 WHERE DICT = '" + p1 + "'";
Connection conn = null;
try {
	//Get connection configured in m-power/mrcjava/web-inf/classes/spring-config.xml
	conn = MrcConnection.getConnection("as400_remote1");
	Statement stmt = conn.createStatement();
	int restored = stmt.executeUpdate(sql);
	log.info(restored + " dictionaries restored.");
	stmt.close();
} catch (SQLException sqle) {
	log.error("sql = " + sql, sqle);
} finally {
	try {
		conn.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
arg[2] = "1";
}
}
}