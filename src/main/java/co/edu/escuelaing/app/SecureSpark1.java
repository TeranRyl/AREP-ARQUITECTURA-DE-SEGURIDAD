package co.edu.escuelaing.app;

import static spark.Spark.port;
import static spark.Spark.*;

public class SecureSpark1 {

    public static void main(String[] args) {
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath truststorePassword);
        secure("keystores/aws/ecikeystore3.p12", "pwd123", null, null);
        get("/myPC", (req, res) -> "Hello World, PC is: PC1");
        get("/yourPC", (req, res) -> SecureURLReader.secureURL(getRemoteUrl(), getRemoteKey(), "pwd123"));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }

    static String getRemoteUrl(){
        if(System.getenv("URL") != null){
            return System.getenv("URL");
        }
        return "https://ec2-54-172-249-4.compute-1.amazonaws.com:5002/myPC";
    }

    static String getRemoteKey() {
        if (System.getenv("KEY") != null) {
            return System.getenv("KEY");
        }
        return "keystores/aws/myTrustStore4.p12";
    }
}