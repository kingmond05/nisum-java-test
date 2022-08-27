# nisum-java-test
Nisum Evaluation for Java Developer
Por Ramón Matos

# Cómo correr la aplicación

 - Clonar repositorio del branch **"main"** o descargar archivo **".zip"**
 - En la carpeta raíz del proyecto correr el siguiente comando:

```

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