package co.edu.escuelaing.app;

import static spark.Spark.port;
import static spark.Spark.*;

public class SecureSpark2 {

    public static void main(String[] args) {
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath truststorePassword);
        secure("keystore/ecikeystore2.p12", "pwd123", null, null);
        get("/myPC", (req, res) -> "Hello World, My PC is: PC2");
        get("/yourPC", (req, res) -> SecureURLReader.secureURL(getRemoteUrl(), getRemoteKey(), "pwd123"));
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5002;
    }

    static String getRemoteUrl(){
        if(System.getenv("URL") != null){
            return System.getenv("URL");
        }
        return "https://localhost:5001/myPC";
    }

    static String getRemoteKey() {
        if (System.getenv("KEY") != null) {
            return System.getenv("KEY");
        }
        return "keystore/myTrustStore1.p12";
    }
}