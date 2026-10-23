# Guía de instalación y uso

## Proyecto AdrianOthman --- Gestión de libros

Esta guía explica como preparar y ejecutar nuestro programa en otro
ordenador. La aplicacion permite guardar y consultar libros usando un
archivo de texto o una base de datos MySQL.

------------------------------------------------------------------------

## 1. ¿Qué necesitamos?

Antes de empezar, necesitamos tener:

-   **Java** instalado.
-   **NetBeans** para abrir y ejecutar el proyecto.
-   Las librerías que utiliza el programa.
-   **MySQL Workbench**, Para utilizar la base de
    datos.

Cuando usaremos MySQL, también necesitaremos los datos de conexion:
usuario y contraseña.

## 2. Abrir el proyecto

1.  Copiamos o descargamos la carpeta del proyecto.
2.  Abrimos NetBeans.
3.  Seleccionamos **Abrir proyecto** y buscamos la carpeta.
4.  Comprobamos que se hayan cargado las librerías.
5.  Revisamos que estén los archivos necesarios, como `libros.txt` y
    `sql/init.sql`.

Si aparece un error porque falta alguna librería, tendremos que añadir
el archivo JAR correspondiente al proyecto.

## 3. Guardar los libros en un archivo de texto

El programa puede utilizar el archivo `libros.txt` para guardar los
libros. Cada línea corresponde a un libro y los datos se separan con el
símbolo `^`.

El orden de los datos es el siguiente:

``` text
id^titulo^autor^precio^stock
```

Por ejemplo:

``` text
1^Don Quijote de la Mancha^Miguel de Cervantes^19.99^10
```

Es importante mantener el orden y los separadores para que el programa
pueda leer los datos correctamente.

## 4. Preparar la base de datos MySQL

Si queremos trabajar con MySQL, tenemos que preparar la base de datos:

1.  Iniciamos MySQL Server.
2.  Abrimos MySQL Workbench y nos conectamos al servidor.
3.  Abrimos el archivo `sql/init.sql`.
4.  Ejecutamos el script.
5.  Comprobamos que se han creado la base de datos
    `librorepositorymysql` y la tabla `libro`.

El script tambien puede incluir libros de ejemplo para probar el
programa.


## 5. Configurar la conexión con MySQL

Para que el programa pueda conectarse a la base de datos, utiliza un
archivo llamado `.env`.

1.  Copiamos el archivo `.env.example`.
2.  Creamos un archivo llamado `.env` en la ubicación que utiliza el
    programa.
3.  Escribimos los datos de nuestra conexión.

El archivo tendrá un formato parecido a este:

``` dotenv
DB_URL=jdbc:mysql://localhost:3306/librorepositorymysql
DB_USER=tu_usuario
DB_PASSWORD=tu_contrasena
```

Tenemos que cambiar `tu_contrasena` por la contraseña de nuestro usuario
de MySQL.

**Importante:** no debemos subir el archivo `.env` a GitHub, porque
contiene la contraseña. Por eso se añade a `.gitignore`. Para compartir
el proyecto usamos `.env.example`, que sirve como plantilla y no debe
contener contraseñas reales.

## 6. Ejecutar el programa

Cuando esté todo preparado:

1.  Abrimos el proyecto en NetBeans.
2.  Ejecutamos la clase principal `Main.java`.
3.  Esperamos a que aparezca el menú.
4.  Elegimos la opción que queramos utilizar.
5.  Seleccionamos el modo de archivo o el modo MySQL, según corresponda.

Para utilizar MySQL, el servidor tiene que estar iniciado y el archivo
`.env` debe tener los datos correctos.

## 7. Comprobar que funciona

Despues de iniciar el programa, podemos hacer unas comprobaciones
sencillas:

-   Ver si aparece el menú sin errores.
-   Consultar los libros que hay guardados.
-   Probar las opciones disponibles en el menú.
-   Añadir o modificar un libro, si el programa ofrece esa opción.
-   Volver a consultar los datos para comprobar que los cambios se han
    guardado.

Las capturas de pantalla y los resultados de estas pruebas se pueden
incluir en el apartado de pruebas del trabajo.

## 8. Problemas que pueden aparecer

  -----------------------------------------------------------------------
  Problema                            Qué podemos revisar
  ----------------------------------- -----------------------------------
  No conecta con MySQL                Que MySQL Server esté iniciado y
                                      los datos del archivo `.env` sean
                                      correctos.

  Falta una librería                  Que los archivos JAR necesarios
                                      estén añadidos en NetBeans.

  No encuentra `libros.txt`           Que el archivo esté en la ubicación
                                      que utiliza el programa.

  No aparecen libros en MySQL         Que se haya ejecutado
                                      `sql/init.sql` y que estemos usando
                                      la base de datos correcta.

  La contraseña no funciona           Que la contraseña del archivo
                                      `.env` coincida con la de MySQL.
                                      
  -----------------------------------------------------------------------
