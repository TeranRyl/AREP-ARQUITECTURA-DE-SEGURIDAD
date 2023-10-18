# APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES
Una aplicacion web segura utilizando Java desplegada en AWS con los siguientes requerimientos:

1. Permitir un acceso seguro desde el browser a la aplicación. Es decir, garantizar autenticación, autorización e integridad de usuarios.
   
2. Tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.

## Instrucciones para ejecutar

A continuacion, dejo respectivas instrucciones para correr el proyecto adecuadamente tras obtener la direccion a este repositorio GitHub. Igualmente, mas abajo dejare evidencia detallada para garantizar que se entienda su implementacion. La aplicacion debe usarse para fines de prueba y desarrollo.

### Requisitos previos

Para descargar la aplicacion, ya estando aqui, se necesita un equipo de computo con las siguientes caracteristicas:

```
- Java 17 instalado (si cuenta con otra version, probablemente deba hacer la respectiva modificacion en el archivo "pom.xml")

- Maven instalado

- Conexion a internet

- Explorador web

(RECOMENDACION) Tener todo actualizado
```

### Instalando localmente

Paso a paso

```
1. Descargar el codigo: Bajar el .ZIP correspondiente al repositorio.

2. Extraer el contenido del archivo comprimido.

3. Abrir el directorio "AREP-ARQUITECTURA-DE-SEGURIDAD-master" como un proyecto en su IDE de preferencia.

4. Editar la clase "SecureSpark1" como se muestra a continuacion:
```
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/7bec1867-13a8-4ad6-9947-7508a3bb7c98)
```
5. Editar la clase "SecureSpark2" como se muestra a continuacion:
```
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/df60652d-43a5-491e-ab26-2afa3ac669f5)
```
6. Guardar el proyecto.

7. Abrir el Shell de su preferencia.

8. Desde el Shell, muevase a la ubicacion donde extrajo el archivo .ZIP (es decir, deberia estar dentro de la carpeta llamada  "AREP-ARQUITECTURA-DE-SEGURIDAD-master").

9. Desde el Shell, escriba "mvn clean install" (este comando compila el proyecto Java y copiara sus dependencias en el directorio "target" en formato ".jar".

10. Desde el Shell, escriba 'java -cp "target/classes;target/dependency/*" co.edu.escuelaing.app.SecureSpark1' para ejecutar el primer servicio. Deberia ver un algo como esto:
```
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/38d1110f-bb04-403d-81b2-ae006472534b)
```

11. Inicie otra pestaña Shell. Desde esta, ubiquese en el directorio raiz del proyecto (dentro de "AREP-ARQUITECTURA-DE-SEGURIDAD-master") y escriba 'java -cp "target/classes;target/dependency/*" co.edu.escuelaing.app.SecureSpark2' para ejecutar el segundo servicio. Deberia ver algo asi:
```
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/a0ddb437-d89f-48ca-b8d1-c7534ca9bf0b)

```
12. Abra su explorador web de preferencia y busque en una pestaña incognita lo siguiente:
```   
   - [https://localhost:5001/myPC](https://localhost:5001/myPC) - Invocacion primer servicio seguro.
   - [https://localhost:5002/myPC](https://localhost:5002/myPC) - Invocacion segundo servicio seguro.
   - [https://localhost:5001/yourPC](https://localhost:5001/yourPC)- Invocacion segundo servicio seguro desde el puerto 5001.
   - [https://localhost:5002/yourPC](https://localhost:5002/yourPC)- Invocacion primer servicio seguro desde el puerto 5002.

```
NOTA: Una vez haya terminado, puede cerrar cada servicio encendido presionando, desde el Shell, "CTRL" + "C" repetidas veces y el servidor se apagara enseguida.
```



## Evaluacion

### Prueba de acceso seguro desde el browser a la aplicacion web funcional

#### Invocacion primer servicio seguro

LOCAL:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/d0d7262f-2e2b-4dfe-b209-22a0b089ce64)

AWS:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/28d226b2-3a5e-4417-b4c4-6b3f958478a7)



#### Invocacion segundo servicio seguro

LOCAL:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/86ad3199-fea5-44ca-8b05-f6496176ec92)

AWS:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/8cd73224-e568-458c-bf29-59ffb279ec50)



#### Invocacion segundo servicio seguro desde el puerto 5001

LOCAL:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/a95d00ac-158a-436c-a204-292c5bdd6f03)

AWS:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/98b65baa-bbfd-49e2-8c2d-6a7110c314e5)



#### Invocacion primer servicio seguro desde el puerto 5002

LOCAL:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/1ce6cc71-3608-4577-ac6b-3fb72faf6027)

AWS:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/9e8f399a-9cab-4f42-add5-6ce81cebfce5)



### Certificados generados

#### Primer servicio

LOCAL:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/fa649fbd-45ac-4d5a-9fee-eb1cef033e8b)
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/fcb53e09-6fcb-42af-a2be-9c26ff893915)

AWS:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/8602c26c-69fe-4baf-8cc8-3bd5ae85e0ea)
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/6973b63b-5bde-40d9-8563-b5cd2195eb55)

#### Segundo servicio

LOCAL:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/2dc4eaf5-9efc-4c54-9434-6f0cb6783de2)
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/65aba9a2-8790-43ee-81da-b04f81164c3c)



AWS:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/387f3725-4001-4ee0-a83b-ff9d613f854b)
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/d25b0c43-bf73-4ee7-8586-d619c7bf51ea)




### Prueba de demostracion de despliegue de la aplicacion web segura realizada utilizando EC2 (AWS):

https://youtu.be/b6Fxg4I4Mrg


## Implementacion

### Arquitectura de seguridad

La aplicación web distribuida consta de tres partes principales: dos aplicaciones Spark Java (SecureSpark1 y SecureSpark2) y una clase SecureURLReader, que se encarga de la seguridad de la comunicación entre estas dos aplicaciones.

**SecureSpark1 y SecureSpark2:**
Ambas aplicaciones están implementadas en Spark Java, una tecnologia Java que funciona como servidor. Estas aplicaciones proporcionan dos endpoints cada una: `/myPC` y `/yourPC`. Cada uno de estos endpoints devuelve una respuesta en forma de cadena. Además, las aplicaciones se configuran con una capa de seguridad SSL/TLS utilizando un keystore y confirman la identidad de las partes involucradas en la comunicación.

En particular, ambas aplicaciones utilizan el método `secure` para habilitar SSL/TLS en la comunicación. La configuración de SSL/TLS incluye la ubicación de un keystore y su contraseña. El keystore se proporciona como un archivo en formato PKCS12 ("ecikeystore1.p12" y "ecikeystore2.p12" para SecureSpark1 y SecureSpark2 respectivamente), y la contraseña asociada. No se utiliza un truststore explícito en estas aplicaciones.

Los métodos `getRemoteUrl` y `getRemoteKey` obtienen las URL y las rutas de los truststores de las variables de entorno o utilizan valores predeterminados si no se proporciona ninguna.

**SecureURLReader:**
La clase SecureURLReader es responsable de manejar la seguridad en la comunicación entre las dos aplicaciones. Utiliza un truststore para verificar la autenticidad de los certificados en la comunicación SSL/TLS. 

1. Lee un truststore ("myTrustStore1.p12" o "myTrustStore2.p12") y su contraseña desde un archivo proporcionado y lo carga. El truststore contiene certificados de confianza que se utilizan para verificar la autenticidad de los certificados presentados por las partes con las que se comunica.

2. Inicializa un TrustManagerFactory con el truststore cargado.

3. Inicializa un SSLContext con el TrustManagerFactory para crear un contexto SSL que utiliza los certificados del truststore para verificar los certificados del servidor remoto.

4. Establece el contexto SSL como el contexto predeterminado para todas las conexiones en la aplicación.

5. Llama al método `readURL` para realizar una solicitud a una URL segura (proporcionada como argumento). La solicitud se realiza a través de una conexión SSL/TLS con la configuración segura proporcionada por el SSLContext.

6. El método `readURL` recopila la información de encabezado de la respuesta HTTP y lee el cuerpo del mensaje, mostrando la información en la consola.

La arquitectura de seguridad en esta aplicación se centra en la comunicación segura a través de SSL/TLS y en la autenticación de las partes mediante certificados y truststores. Los truststores se utilizan para garantizar que los certificados presentados por las partes en la comunicación sean confiables y se ajusten a las políticas de seguridad definidas. En este escenario, se utiliza la herramienta "keytool" de Java para generar y administrar los truststores y certificados necesarios. Además, la aplicación Spark Java se configura para usar SSL/TLS en la comunicación, lo que aumenta la seguridad de la transferencia de datos entre las dos aplicaciones.


![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/e19357e5-b0af-4c7e-95f1-0f82e9a51153)

### Escalabilidad

La arquitectura de seguridad del proyecto se basa en la configuracion de seguridad SSL/TLS, que proporciona una capa de cifrado segura para las comunicaciones web. Esta arquitectura se podria escalar para incorporar un nuevo **Servicio de Autenticación y Autorización.** Un servicio dedicado que manejaria la autenticación de usuarios y la autorización de sus acciones en la aplicación. Esto incluiría la gestión de contraseñas, tokens de acceso y control de roles y permisos. El servicio de autenticacion permitiria a los usuarios registrarse, iniciar sesion y gestionar sus cuentas, lo cual puede incluir la autenticacion de dos factores y la gestion de contraseñas.

Esta incorporacion seria una estrategia eficaz para mejorar la funcionalidad y seguridad de la aplicacion, pues permite una gestion mas efectiva de los recursos y una mejor adaptacion a las necesidades cambiantes de los usuarios y de los negocios. Ademas, por la base de seguridad SSL/TLS de la arquitectura, seria sencillo incorporar el servicio y garantizar consistencia en la seguridad de toda la aplicacion web.

### AWS


Keypairs para conexion segura a las instancias:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/34851e68-0171-4bd7-97b2-3f2094972846)


Instancias funcionando:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/8564b0a8-d0f7-454b-8dce-276d4a81a460)


Resumen de informacion de las instancias:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/43a26107-0801-4143-8f0d-622e7e85a1a7)

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/1a97e6a1-c570-45b2-9aad-0971de25ba93)



Grupo de seguridad (reglas de acceso a sus puertos) de las instancias:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/182ccae8-9403-4b5c-ab74-0df970dd82e6)

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/ab5e92bf-43ff-498f-ac73-abca84fec2ab)




## Construido con

* [Java](https://www.oracle.com/co/java/) - Backend
* [Maven](https://maven.apache.org/) - Gestion de ciclo de vida, codigo fuente y dependencias
* [Git/Github](https://git-scm.com/) - Almacenar el codigo fuente
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE para desarrollo

## Autores

* **Juan Francisco Teran** - *Trabajo total* - [TeranRyl](https://github.com/TeranRyl)

## Licencia

Este proyecto tiene la licencia GNU General Public License v3.0; consulte el archivo [LICENSE](LICENSE.txt) para obtener más información.

## Reconocimientos

* PurpleBooth - Plantilla para hacer un buen README
* Luis Daniel Benavides - Preparacion para el taller e introduccion al tema

