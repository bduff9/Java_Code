/*
 * MacTest.java    
 *
 */

 
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MacTest {

    
    public static void main(String[] args) {
 
		String cmd = "javac  -classpath \"/m-power/mrcjava/WEB-INF/lib/log4j-1.2.9.jar:/m-power";
		cmd += "/mrcjava/WEB-INF/lib/mrc-field-conversion-exampl";
		cmd += "e.jar:/m-power/mrcjava/WEB-INF/lib/mrcapps.jar:/m-power/mrcjava/WEB-INF/li";
		cmd += "b/mrcfop.jar:/m-power/mrcjava/WEB-INF/lib/mrcjs11.jar:/m-power/mrcjava/WEB";
		cmd += "-INF/lib/spring.jar:.:/m-power/mrcjava/WEB-INF/lib/mrcjs11.jar:/m-power/proddata/lib/servlet.jar\"";
		cmd += " MRCISSUES/I00010s.java";
		String[] env = null;
		File dir = new File("/m-power/mrcjava/WEB-INF/classes");
		System.out.println(execCmd(cmd, env, dir));

    }
   
    static String execCmd(String cmd, String[] env, File dir) {

        String msg = null;
        String msgerr = "<b> Error executing: " + cmd + ": </b><br><br>";

        try {
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd, env, dir);

            /** Catch errors */
            InputStream stderr = proc.getErrorStream();
            InputStreamReader isr = new InputStreamReader(stderr);
            BufferedReader br = new BufferedReader(isr);
            String line = "";

            while ((line = br.readLine()) != null) {
                msgerr += "  " + line + " <br>";
            }

            int exitVal = proc.waitFor();

            if (exitVal > 0) {
                msg = msgerr;
            }
 

        } catch (java.io.IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        return msg;
    }



}
