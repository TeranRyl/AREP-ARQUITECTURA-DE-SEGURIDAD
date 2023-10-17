# PATRONES ARQUITECTURALES
Una aplicacion web desplegada en AWS usando EC2 y Docker:

1. El servicio MongoDB es una instancia de MongoDB corriendo en un container de docker en una máquina virtual de EC2

2. LogService es un servicio REST que recibe una cadena, la almacena en la base de datos y responde en un objeto JSON con las 10 ultimas cadenas almacenadas en la base de datos y la fecha en que fueron almacenadas.
   
3. La aplicación web APP-LB-RoundRobin está compuesta por un cliente web y al menos un servicio REST. El cliente web tiene un campo y un botón y cada vez que el usuario envía un mensaje, este se lo envía al servicio REST y actualiza la pantalla con la información que este le regresa en formato JSON. El servicio REST recibe la cadena e implementa un algoritmo de balanceo de cargas de Round Robin, delegando el procesamiento del mensaje y el retorno de la respuesta a cada una de las tres instancias del servicio LogService.

## Instrucciones para ejecutar

A continuacion, dejo respectivas instrucciones para correr el proyecto adecuadamente tras obtener la direccion a este repositorio GitHub. Igualmente, mas abajo dejare evidencia detallada para garantizar que se entienda su implementacion. La aplicacion debe usarse para fines de prueba y desarrollo.

### Requisitos previos

Para descargar la aplicacion, ya estando aqui, se necesita un equipo de computo con las siguientes caracteristicas:

```
- Java 17 instalado (si cuenta con otra version, probablemente deba hacer la respectiva modificacion en el archivo "pom.xml")

- Maven instalado

- JavaScript instalado

- Conexion a internet

- Explorador web

- Docker 4.19+

- (RECOMENDACION) Tener todo actualizado
```

### Instalando

Paso a paso

```
1. Descargar el codigo: Bajar el .ZIP correspondiente al repositorio.

2. Extraer el contenido del archivo comprimido.

3. Abrir el Shell de su preferencia.

4. Desde el Shell, muevase a la ubicacion donde extrajo el archivo .ZIP (Deberia estar dentro de la carpeta llamada  "AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE-master").

5. Desde el Shell, escriba "mvn clean install" (este comando compila el proyecto y coloca el artefacto resultante en tu repositorio local de Maven).

6. Inicie Docker.

7. Desde el Shell, escriba "docker-compose up -d" para generar automáticamente la configuración Docker, los containers, instancias e imaegenes necesarias para desplegarlo utilizando Docker.

Deberia tener lo siguiente en su Docker.

Contenedores:

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/9a8499a4-f920-41a0-832b-2f7df5337748)

Imagenes:

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/518fa9e7-8eb5-47b7-a5c1-688b2942c819)

Volumenes:

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/dab963a1-5b3a-4ef2-9df0-48fc537e7d05)




8. Abra su explorador web de preferencia y busque en una pestaña incognita lo siguiente:
   
   - "localhost:35000" (SIN LAS COMILLAS) - Cliente web (RoundRobin).
   - "localhost:35001/logservice?message=*MENSAJE_DE_PRUEBA1*" (SIN LAS COMILLAS) - Servicio GET (LogService1)
   - "localhost:35002/logservice?message=*MENSAJE_DE_PRUEBA2*" (SIN LAS COMILLAS) - Servicio GET (LogService2)
   - "localhost:35003/logservice?message=*MENSAJE_DE_PRUEBA3*" (SIN LAS COMILLAS) - Servicio GET (LogService3)

```


## Evaluacion

Pruebas de app web funcionando:

Cliente web desde Docker:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/28d226b2-3a5e-4417-b4c4-6b3f958478a7)



Servicio GET 1 desde Docker:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/8cd73224-e568-458c-bf29-59ffb279ec50)



Servicio GET 2 desde Docker:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/98b65baa-bbfd-49e2-8c2d-6a7110c314e5)



Servicio GET 3 desde Docker:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/9e8f399a-9cab-4f42-add5-6ce81cebfce5)



Cliente web (RoundRobin) llamando a un servicio (LogServiceX) desde Docker:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/8602c26c-69fe-4baf-8cc8-3bd5ae85e0ea)
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/6973b63b-5bde-40d9-8563-b5cd2195eb55)



![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/387f3725-4001-4ee0-a83b-ff9d613f854b)
![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/d25b0c43-bf73-4ee7-8586-d619c7bf51ea)




Prueba de demostracion de despliegue de la aplicacion web realizada utilizando EC2 (AWS):

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


### Diagrama de clases

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/aa2e832e-f439-4cd9-9290-c080547f2177)




### DockerHub

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/5ecbd9ac-2b9f-4ec8-bf73-72ce943ad5c4)



### AWS


Keypair para conexion segura a la instancia:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/34851e68-0171-4bd7-97b2-3f2094972846)


Instancia funcionando:

![image](https://github.com/TeranRyl/AREP-ARQUITECTURA-DE-SEGURIDAD/assets/81679109/8564b0a8-d0f7-454b-8dce-276d4a81a460)


Resumen de informacion de la instancia:

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/0c5f86f9-17ef-46cb-9f70-2e3009674ff3)

Grupo de seguridad de la instancia (reglas de acceso a sus puertos)

![image](https://github.com/TeranRyl/AREP-PATRONES-ARQUITECTURALES-EN-LA-NUBE/assets/81679109/988de2e6-ca37-49d6-9304-320b45bcfc2e)




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

