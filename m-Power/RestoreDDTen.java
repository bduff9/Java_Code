/**
* RestoreDDTen.java, Created Jun 28, 2012, Copyright mrc ltd.
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

public class RestoreDDTen {

	private Logger log = Logger.getLogger(this.getClass());

	public static void main(String[] arg){
		new RestoreDDAuto().startCall(arg);
	}

	public void startCall(String[] arg) {
		int p1 = Integer.parseInt(arg[0]);
		if (p1 < 10) {
			int numDD = 10 - p1;
			String ddSql = "SELECT DICT FROM MRCWEBSITE.OLABUSERS T01 INNER JOIN MRCWEBSITE.OLABSIGN T02 ON T01.IDNUM = T02.ID ORDER BY OLDATE ASC FETCH FIRST " + numDD + " ROWS ONLY";
			Connection conn = null;
			try {
				//Get connection configured in m-power/mrcjava/web-inf/classes/spring-config.xml
				conn = MrcConnection.getConnection("as400_remote1");
				Statement stmt = conn.createStatement();
				stmt.execute(ddSql);
                                ResultSet rs = stmt.getResultSet();
				log.info(numDD + " dictionaries found.");
				stmt.close();
           		String dds = "";
			while (rs.next()) {
			   dds = rs.getString(1);
			   String cmd1="cmd /c c:\\backup\\restore_db.bat " + dds;
			   String cmd2="cmd /c c:\\backup\\restore_apps.bat " + dds;
				try {
					Runtime.getRuntime().exec(cmd1);
					System.out.println("Restoring " + dds);
					System.out.println("Running command " + cmd1);

					Runtime.getRuntime().exec(cmd2);
					System.out.println("Restoring " + dds);
					System.out.println("Running command " + cmd2);
				} catch (Exception sqle) {
					System.err.println("Error");
					sqle.printStackTrace();
				} finally {
					try {
					} catch (Exception error) {
						error.printStackTrace();
					}
				}
				System.out.println("Restoration of " + dds + " Completed!");
				String sql = "UPDATE MRCWEBSITE.OLABUSERS SET IDNUM = 0 WHERE DICT = '" + dds + "'";
				try {
					//Get connection configured in m-power/mrcjava/web-inf/classes/spring-config.xml
					//conn = MrcConnection.getConnection("as400_remote1");
					Statement stmt2 = conn.createStatement();
					int restored = stmt2.executeUpdate(sql);
					log.info(restored + " dictionaries restored.");
					stmt2.close();
				} catch (SQLException sqle) {
					log.error("sql = " + sql, sqle);
				} finally {
					try {
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}			
                       } catch (SQLException sqle) {
				log.error("sql = " + ddSql, sqle);
			} finally {
				try {
                                        conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			arg[1] = "" + numDD; //Fill with dd restored in here
		}
	}
}