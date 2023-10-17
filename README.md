# APLICACIÓN DISTRIBUIDA SEGURA EN TODOS SUS FRENTES
Una aplicacion web segura utilizando Java y tecnologia Spark, desplegada en AWS con los siguientes requerimientos:

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
8. Abra su explorador web de preferencia y busque en una pestaña incognita lo siguiente:
```   
   - [https://localhost:5001/myPC](https://localhost:5001/myPC) - Invocacion primer servicio seguro.
   - [https://localhost:5002/myPC](https://localhost:5002/myPC) - Invocacion segundo servicio seguro.
   - [https://localhost:5001/yourPC](https://localhost:5001/yourPC)- Invocacion segundo servicio seguro desde el puerto 5001.
   - [https://localhost:5002/yourPC](https://localhost:5002/yourPC)- Invocacion primer servicio seguro desde el puerto 5002.




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

### Arquitectura

El proyecto que has proporcionado consta de varias partes que trabajan juntas para lograr un sistema de registro de mensajes distribuidos. La arquitectura general se puede dividir en tres componentes principales:

1. **Cliente HTTP (HttpRemoteCaller)**:
   - Este componente es una clase Java que realiza solicitudes HTTP a los servicios de registro. Se utiliza para enviar mensajes de registro a un servidor remoto.
   - El método `remoteHttpCall` toma una URL y un mensaje como entrada, realiza una solicitud HTTP GET a esa URL con el mensaje como parámetro y devuelve la respuesta del servidor.
   - La clase mantiene un arreglo de URLs de servicios de registro para implementar el equilibrio de carga entre múltiples servidores.

2. **Servidor Web (LogRoundRobin)**:
   - Este componente utiliza el marco web Spark para crear un servidor web simple. Spark es un marco web ligero para aplicaciones web en Java.
   - El servidor escucha en un puerto específico (que se puede configurar) y maneja las solicitudes HTTP entrantes.
   - El endpoint `/log` recibe las solicitudes GET con un parámetro "message" y utiliza la clase `HttpRemoteCaller` para enviar el mensaje a los servicios de registro remotos.

3. **Servicio de Registro (LogService)**:
   - Este componente es otro servidor web que escucha en un puerto diferente.
   - Utiliza MongoDB como base de datos para almacenar mensajes de registro junto con su fecha de registro.
   - El endpoint `/logservice` recibe las solicitudes GET con un parámetro "message", registra el mensaje en la base de datos y devuelve los últimos 10 mensajes registrados en formato JSON.

4. **Interfaz de Usuario (HTML/JavaScript)**:
   - Se proporciona una página HTML simple que contiene un formulario para que el usuario ingrese un mensaje.
   - Cuando el usuario hace clic en el botón "Submit", se ejecuta una función JavaScript que utiliza XMLHttpRequest para enviar el mensaje al servidor web principal (`LogRoundRobin`) a través de la ruta `/log`.

Por lo tanto, cuando un usuario ingresa un mensaje en la página HTML y hace clic en "Submit", el cliente web envía una solicitud GET al servidor `LogRoundRobin` a través de la ruta `/log`. El servidor `LogRoundRobin` utiliza la clase `HttpRemoteCaller` para redirigir la solicitud a uno de los servidores de registro (`LogService`) disponibles en un enfoque de equilibrio de carga de Round Robin. El servidor `LogService` registra el mensaje en una base de datos MongoDB y devuelve los últimos 10 mensajes registrados en formato JSON como respuesta.

Esta arquitectura permite escalar el sistema agregando más instancias de `LogService` y distribuyendo la carga de manera uniforme entre ellas para manejar un alto volumen de solicitudes de registro. Además, se proporciona una interfaz de usuario simple para interactuar con el sistema.

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/69bfae90-7121-447f-92a9-c22292062cdf)


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

