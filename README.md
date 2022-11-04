Proyecto Gestión de Campamentos Diputación Foral de Álava
============================

Esta aplicación está pensada para realizar una tarea de gestión interna de campamentos ofrecidos al público a través de la Diputación Foral de Álava.

La funcionalidad de la aplicación se basará en la gestión de los diferentes campamentos registrados y de las inscripciones de las personas que soliciten entrar en los mismos.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

#  Índice de Contenidos 
* [Información técnica](#información-técnica)
    * [Requerimientos](#requerimientos)
    * [Almacenamiento](#almacenamiento)
    * [A tener en cuenta](#a-tener-en-cuenta)
* [Estructura](#estructura)
    * [Login](#login)
    * [Registro](#registro)
    * [Ventana principal](#ventana-principal)
        * [Pestaña campamentos](#pestaña-campamentos)
            * [Crear campamento](#crear-campamento)
            * [Modificar campamento](#modificar-campamento)
            * [Eliminar campamento](#eliminar-campamento)
            * [Ver campamento](#ver-campamento)
            * [Ver inscripciones campamento](#ver-inscripciones-campamento)
        * [Pestaña personas](#pestaña-personas)
            * [Inscribir persona](#inscribir-persona)
            * [Retirar persona????](#retirar-persona)
            * [Exportar XML personas????](#exportar-xml-personas)
            * [Inscribir XML personas????](#inscribir-xml-personas)
            * [Ver campamentos inscritos](#ver-campamentos-inscritos)
        * [Pestaña salir](#pestaña-salir)
            * [Cerrar sesión](#cerrar-sesión)
            * [salir](#salir)
---

# Información Técnica
---
## Requerimientos

* JDK 18
* JCalendar-1.14.jar

## Almacenamiento

Se lleva a cabo en ficheros .dat en los cuales se hará la escritura directa de los objetos serializables.
* campamentos.dat
* personas.dat
* campamentoPersona.dat
* usuarios.dat

## A tener en cuenta
Las vistas están hechas basadas en JFrame desde Netbeans, es posible que para visualizar de manera acertada su diseñador se necesite dicho IDE.

---
# Estructura
---

## Login

El login se compone del campo usuario y contraseña desde el cual se accederá a la aplicación. Esta será la ventana inicial de la aplicación al ejecutarla.

Para iniciar sesión se deberán de indicar un usuario y una contraseña registradas en el sistema, en caso de que no se propicien credenciales válidas informará de ello a través de una etiqueta roja.

Consta de un botón de registrar que redirige a otra ventana para poder registrar nuevos usuarios.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

## Registro

El registro consta de un formulario sencillo donde se pide un usuario + confirmación y una contraseña + confirmación.

Para que un usuario se pueda registrar deberán coincidir usuario/confirmarUsuario y contraseña/confirmarContraseña, además, el usuario deberá ser único entre los registrados, por lo que se validará que no exista el usuario.

Contiene etiquetas rojas para informar de las validaciones que no pase el formulario a la hora de registrar.

Una vez registrado un usuario, la ventana se encargará de volver al login.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

## Ventana Principal
---
La ventana principal consta de: un menú con diferentes pestañas para navegar por la aplicación, de un título y de botones para cerrar sesión o salir definitivamente de la aplicación (parar su ejecución).

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

## Pestaña Campamentos

### Crear Campamento
La ventana de crear campamentos consta de un formulario que recogerá datos del campamento:
* Nombre
* Lugar
* Fecha de inicio
* Fecha de fin
* Capacidad

Esta ventana validará que no haya datos vacíos, que la fecha de inicio no sea posterior a la de fin y que la capacidad sea un numero entero mayor a cero. Para ello consta de etiquetas rojas que se mostrarán en función de las validaciones que no pase el formulario a la hora de crear el campamento.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

### Modificar Campamento
Este enlace redirige a una ventana intermedia donde se seleccionará el campamento a modificar. Dicha ventana está compuesta por un desplegable con los distintos campamentos donde se puede seleccionar uno y se mostrarán los datos de dicho campamento seleccionado. 

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

Una vez seleccionado un campamento se podrá dar a "Modificar" y llevará a la siguiente ventana.

La siguiente ventana, como la de "Crear Campamento" consta de los campos necesarios a rellenar para modificar el campamento.

Nuevamente se hacen las validaciones de que no estén vacíos los campos, que la fecha inicial no sea posterior a la final, y que la capacidad sea un número entero mayor a cero, con un añadido de que la capacidad no sea menor al número de personas ya inscritas en dicho campamento.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

### Eliminar Campamento
Al igual que en "Modificar Campamento" este enlace redirige a una ventana intermedia donde se seleccionará el campamento a eliminar. Dicha ventana está compuesta por un desplegable con los distintos campamentos donde se puede seleccionar uno y se mostrarán los datos de dicho campamento seleccionado. 

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

Una vez seleccionado un campamento se podrá dar a "Eliminar". Paso seguido aparecerá un mensaje de confirmación para eliminar el campamento.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

### Ver Campamento
Este enlace redirige a una ventana intermedia donde se seleccionará el campamento del que se quieren ver los daots. Dicha ventana está compuesta por un desplegable con los distintos campamentos.

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

### Ver Inscripciones Campamento

TODO

## Pestaña Personas

### Inscribir persona

TODO

### Retirar persona

TODO

### Exportar XML personas

TODO

### Inscribir XML personas

TODO

### Ver Campamentos Inscritos

TODO

## Pestaña Salir

### Cerrar Sesión
Al hacer click en esta pestaña se cerrará la sesión y se volverá al login de la aplicación.

### Salir
Al hacer click en esta pestaña se cerrará la aplicación deteniendo su ejecución.
