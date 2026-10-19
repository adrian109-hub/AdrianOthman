# AdrianOthman - Gestion de libros

Este proyecto es una aplicación Java que sirve para gestionar libros. Los datos se pueden guardar en un archivo de texto o en una base de datos MySQL.

## Requisitos

- Tener Java instalado.
- Tener NetBeans para abrir el proyecto.
- Tener MySQL instalado si se quiere usar la base de datos.

## Preparacion del proyecto

1. Abrir el proyecto en NetBeans.
2. Comprobar que Java esta configurado correctamente.
3. Añadir las librerías necesarias para que funcione el programa.
4. Crear el archivo `.env` copiando el contenido de `.env.example` y poner los datos de conexion a MySQL.
5. Si se quiere usar MySQL, ejecutar el archivo `sql/init.sql` para crear la base de datos y añadir unos libros de prueba.
6. Ejecutar la clase `Main.java`.

## Uso del programa

Cuando se inicia el programa, aparece un menú con las opciones disponibles para trabajar con los libros. Se puede elegir guardar los datos en un archivo o utilizar MySQL.

## Archivos añadidos

- `libros.txt`: contiene libros de prueba.
- `sql/init.sql`: sirve para preparar la base de datos.
- `.env.example`: ejemplo de la configuración de MySQL.
- `docs/manual_despliegue.md`: manual con los pasos para preparar y ejecutar el proyecto.
- `docs/manual_despliegue.pdf`: el mismo manual en PDF.
- `.gitignore`: indica qué archivos no se deben incluir en Git.

## Comprobaciones antes de entregar

Antes de entregar el proyecto, hay que comprobar que funciona correctamente, probar las opciones principales y añadir capturas de pantalla de su funcionamiento.