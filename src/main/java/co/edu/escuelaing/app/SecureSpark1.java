package co.edu.escuelaing.app;

import static spark.Spark.port;
import static spark.Spark.*;

/**
 * Clase principal que configura y ejecuta el primer servicio seguro.
 * @author juan.teran
 */
public class SecureSpark1 {

    public static void main(String[] args) {
        port(getPort());
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath truststorePassword);
        secure("keystores/aws/ecikeystore3.p12", "pwd123", null, null);
        get("/myPC", (req, res) -> "Hello World, PC is: PC1");
        get("/yourPC", (req, res) -> SecureURLReader.secureURL(getRemoteUrl(), getRemoteKey(), "pwd123"));
    }

    /**
     * Obtiene el puerto del servicio desde una variable de entorno o usa 5002 como valor predeterminado.
     * @return El puerto del servicio.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5001;
    }


    /**
     * Obtiene la URL remota desde una variable de entorno o usa una URL predeterminada.
     * @return La URL remota.
     */
    static String getRemoteUrl(){
        if(System.getenv("URL") != null){
            return System.getenv("URL");
        }
        return "https://ec2-54-172-249-4.compute-1.amazonaws.com:5002/myPC";
    }


    /**
     * Obtiene la clave remota desde una variable de entorno o usa una clave predeterminada.
     * @return La clave remota.
     */
    static String getRemoteKey() {
        if (System.getenv("KEY") != null) {
            return System.getenv("KEY");
        }
        return "keystores/aws/myTrustStore4.p12";
    }
}