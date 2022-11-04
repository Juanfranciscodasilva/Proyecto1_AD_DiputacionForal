Proyecto Gestión de Campamentos Diputación Foral de Álava
============================

Esta aplicación está pensada para realizar una tarea de gestión interna de campamentos ofrecidos al público a través de la Diputación Foral de Álava.

La funcionalidad de la aplicación se basará en la gestión de los diferentes campamentos registrados y de las inscripciones de las personas que soliciten entrar en los mismos.

# Requerimientos

* JDK 18
* JCalendar-1.14.jar

![prueba](https://drive.google.com/uc?export=view&id=1qI3ephsJrl7jbyaHlQQqvo4_-7klQpd8)

#  Índice de contenidos 
* [Contenido 1](#foo)
* * [Contenido 1](#item1)
* [Contenido 2](#item2)
* [Contenido 3](#item3)
* [Contenido 4](#item4)

The `etc` directory contains the configuration files and directories that need to be copied to `/etc/cas/config`.
```bash
/usr/bin/sudo ./build.sh copy
```

# Build

To see what commands are available to the build script, run:

```bash
./build.sh help
```

To package the final web application, run:

```bash
./build.sh package
```

To update `SNAPSHOT` versions run:

```bash
./build.sh package -U
```

# Foo

- Create a keystore file `thekeystore` under `/etc/cas`. Use the password `changeit` for both the keystore and the key/certificate entries.
```bash
./build.sh gencert
```

- Ensure the keystore is loaded up with keys and certificates of the server.

On a successful deployment via the following methods, CAS will be available at:

* `http://cas.server.name:8080/cas`
* `https://cas.server.name:8443/cas`

## Executable WAR

Run the CAS web application as an executable WAR.

```bash
./build.sh run
```

## Spring Boot

Run the CAS web application as an executable WAR via Spring Boot. This is most useful during development and testing.

```bash
./build.sh bootrun
```

### Warning!

Be careful with this method of deployment. `bootRun` is not designed to work with already executable WAR artifacts such that CAS server web application. YMMV. Today, uses of this mode ONLY work when there is **NO OTHER** dependency added to the build script and the `cas-server-webapp` is the only present module. See [this issue](https://github.com/apereo/cas/issues/2334) and [this issue](https://github.com/spring-projects/spring-boot/issues/8320) for more info.

<a name="item1"/>
### Contenido 1

[para arriba](#Indice-de-contenidos)


## Spring Boot App Server Selection

There is an app.server property in the `pom.xml` that can be used to select a spring boot application server.
It defaults to `-tomcat` but `-jetty` and `-undertow` are supported. 
It can also be set to an empty value (nothing) if you want to deploy CAS to an external application server of your choice.

```xml
<app.server>-tomcat<app.server>
```

## Windows Build

If you are building on windows, try `build.cmd` instead of `build.sh`. Arguments are similar but for usage, run:  

```
build.cmd help
```

## External

Deploy resultant `target/cas.war`  to a servlet container of choice.


## Command Line Shell

Invokes the CAS Command Line Shell. For a list of commands either use no arguments or use `-h`. To enter the interactive shell use `-sh`.

```bash
./build.sh cli
```
