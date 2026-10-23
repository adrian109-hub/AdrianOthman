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