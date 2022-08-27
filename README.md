# nisum-java-test
Nisum Evaluation for Java Developer
Por Ramón Matos

# Cómo correr la aplicación

 - Clonar repositorio del branch **"main"** o descargar archivo **".zip"**
 - En una terminal (o CMD) navegar a la carpeta raíz reciente clonada o descargada
 - En la carpeta raíz del proyecto correr el siguiente comando:

```
mvn clean package

```

Deberá traer un resultado parecido al siguiente si fue **satisfactorio**:

```sh
[INFO] Replacing main artifact with repackaged archive
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  26.941 s
[INFO] Finished at: 2022-08-27T04:32:51-04:00
[INFO] ------------------------------------------------------------------------
```

  - Navegar a la carpeta llamada **"target"** en el directorio raíz de la aplicación y ejecutar el comando
 ```sh
  java -jar javaevaluation-0.0.1-SNAPSHOT.jar
  
 ``` 
  - Para ejecutar con una configuración externa deberá crear un archivo **".properties"** con el siguiente contenido y los valores deseados:
  
  ```
#Server info
server.port=8080

#Jpa Config
spring.jpa.hibernate.ddl-auto= update
spring.jpa.show-sql= true
spring.jpa.database= HSQL

#Input validation messages and config
inputvalidation.existingemailerrortext=El correo ya fue registrados
inputvalidation.passwordregex=XXX

  ```
  
  - Una vez se tenga el archivo configurado correr el siguiente comando **reemplazando** la ruta y nombre de archivo (ejecutar dentro de la carpeta "target")
  ```
  java -jar javaevaluation-0.0.1-SNAPSHOT.jar --spring.config.location=file:///Users/home/config/jdbc.properties
  
  ```
  Nota: Ruta a reemplazar: "/Users/home/config/jdbc.properties" dentro del comando
  
  - Con un cliente HTTP como Postman puede importar el siguiente comando o ejecutar directamente en una terminal (con CURL instalado), con esto se probará la creación de un usuario
 
```
curl --location --request POST 'http://localhost:8080/api/v1/user' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=942D6EAE252583E3324BE0628928A075' \
--data-raw '{
    "name": "Ramon Matos",
    "email": "ramonmatos05@gmail.com",
    "password": "w3Unpocodet0d0",
    "phones": [
        {
            "number": "8095347100",
            "citycode": "1",
            "countrycode": "57"
        },
        {
            "number": "8098600805",
            "citycode": "1",
            "countrycode": "57"
        }
    ]
}'
```

# Scripts para crear tablas en HSQLDB

## Tabla de usuarios

```sql
CREATE TABLE users (
   id VARCHAR(250)  NOT NULL,
   name VARCHAR (80),
   email VARCHAR (128),
   password VARCHAR (128),
   created DATETIME,
   modified DATETIME,
   last_login DATETIME,
   state BIT,
   token VARCHAR (400),
   PRIMARY KEY (id)
); 
```

## Tabla de teléfonos
```sql
CREATE TABLE phones (
   number VARCHAR (20) NOT NULL,
   countrycode VARCHAR (128),
   citycode VARCHAR (128),
   userid VARCHAR(250),
   PRIMARY KEY (number)
); 
```

Nota: se utilizó para fines de pruebas el HSQLDB embebido en Springboot.

# Tech

 - Springboot
 - Maven
 - JPA con Hibernate
 - DB InMemory HSQLDB
 