# Manual de despliegue de la aplicación de gestión de libros

**Proyecto:** AdrianOthman

## 1. Introducción

En este documento se explica cómo instalar y poner en funcionamiento la aplicación de gestión de libros. Esta permite realizar distintas operaciones con los libros, como añadirlos, consultarlos, modificarlos o eliminarlos.

## 1.2 Preparación de la máquina virtual

- Aquí estare usando una MV limpia como referencia

### 1.3. Estado inicial

Aqui mandare capturas de que la MV está recien creada y que no hay trampas ni cartón.

**Captura 1.** Estado inicial de la máquina virtual.
![.](imagenes/image.png)

### 1.4. Comprobar el sistema operativo

Aquí compruebo que el sistema operativo está instalado y su versión.

**Captura 2.** Información del SO de la máquina virtual.

![.](imagenes/2.png)

## 2. Instalación de Java JDK

Java es necesario para compilar y ejecutar la aplicación.

### 2.1. Descargar e instalar Java

Primero se accede a la página oficial de descarga de Java y se descarga una versión del JDK compatible con el proyecto, en este caso es el JDK 26.0.2.

Para instalarlo seguimos estos pasos:

- Abre este enlace [Java 26.0.2.1](https://www.oracle.com/java/technologies/javase/jdk26-archive-downloads.html)


**Captura 3.** Descarga o instalación del JDK.

- Dale click al último y se descargará un archivo ![.](imagenes/3.png)

- Abres el .msi y le das a next todo el rato, aquí le das a "Sí" y esperas a que se instale

![.](imagenes/4.png)

## Con esto ya tienes  *Java* instalado

## 3. Instalación de Git

Git se utiliza para descargar el proyecto desde su repositorio y obtener sus archivos.

### 3.1. Descargar e instalar Git

Entras en la página oficial de [Git](https://git-scm.com/install/windows) y descargas el instalador para Windows. Le das al primero, ejecutas y le das a siguiente todo el rato.

![.](imagenes/5.png)

### 3.2. Comprobar que se ha instalado correctamente

Una vez finalizado la instalación, abres una terminal y ejecutas esto:

```cmd
git --version
```
- Te tendria que aparecer así:

![.](imagenes/6.png)

## 4. Instalación de NetBeans

NetBeans será el entorno utilizado para abrir el proyecto y ejecutar la aplicación.

### 4.1. Descargar e instalar NetBeans

Descargas [NetBeans](https://netbeans.apache.org/front/main/download/nb31/) desde su página oficial. Hay que elegir una versión compatible con el JDK instalado y con la versión de Java que utiliza el proyecto.

Le das al primero, descargas el .zip y extraes todo![.](imagenes/7.png)
![.](imagenes/8.png)

Al finalizar abres la carpeta, vas a netbeans, bin y ejecutas netbeans64.exe para que se instala todo bien.
![.](imagenes/9.png)

## 5. Instalación y configuración de MySQL

MySQL se utiliza para guardar los libros en una base de datos y poder realizar las operaciones desde la aplicación.

### 5.2. Instalar Visual Studio

Por alguna razón tienes que instalar primero Visual Studio para instalar MySQL Community Server, vas a esta [página](https://visualstudio.microsoft.com/insiders/?rwnlp=es) y descargas la version de Windows. ![.](imagenes/15.png)
Ejecutas el instalador y le das a next todo el rato.

### 5.1. Instalar MySQL Server

Descargas [MySQL Server](https://dev.mysql.com/downloads/mysql/?platform&os=3/) desde su página oficial y se inicia el instalador de windows. ![.](imagenes/10.png) 

Le das al primero, le das a seguir con mi descarga, ejecutas el instalador y le das a siguiente.

Ahora sigues estos pasos:
![.](imagenes/12.png)
![.](imagenes/13.png)
![.](imagenes/14.png)
Ejecutas, y una vez terminado de momento le das a siguiente todo el rato.

Aquí pones la contraseña que quieras, por ejemplo, yo he puesto "root". ![.](imagenes/16.png)

Luego ejecutas todo lo que te pida y ya esta. ![.](imagenes/17.png)

### 5.2. Abrir MySQL Workbench

Abres MySQL Workbench y sigues estos pasos para ver si esta ejecutado correctamente.

En la página principal bajas un poco y le das click a la base de datos.![.](imagenes/18.png)

Ahora te pedirá la contraseña que has puesto anteriormente y le das a guardas contraseña para no volver a ponerla mas. ![.](imagenes/19.png)

## 6. Github

En este paso tienes que entrar en Github y copiar la URL del repositorio.

Entras al proyecto ya compartido, le das a "Code" y copias desde HTTPS. ![.](imagenes/21.png)

## 7. Descargar el proyecto

### 7.1. Clonar el repositorio

Una vez todo hecho tenemos que ir a NetBeans y clonar el repositorio.

Para ello le damos a Team-Git-Clone...
![.](imagenes/20.png)

Aquí pegamos la URL del repositorio de Github, ponemos nuestro usuario y contraseña, y dejamos la ruta tal cual esta. ![.](imagenes/22.png)

A partir de aqui le das a next y ya tendrias el proyecto en Netbeans.

### 7.2. Instalar las librerias

Cuando ya tengamos el proyecto vamos a libreries, click derecho y Add JAR/Folder.

Aqui añadimos ambos archivos y ya las tendremos añadidas. ![.](imagenes/23.png)