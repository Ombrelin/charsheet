# Charsheet

Charsheet is a software to help a player create and manage his character sheet in a tabletop RPG. The RPG system is "Le donjon de Naheulbeuk".

## Features

* Create your character according to the RPG system's rules 
* Manage your character and it's evolutions using a nice UI.

## Screenshots

![image1](https://github.com/Ombrelin/charsheet/blob/master/screenshots/2020-05-15%2014_40_50-CharSheet.png?raw=true)
![image2](https://github.com/Ombrelin/charsheet/blob/master/screenshots/2020-05-15%2014_41_12-charsheet%20%E2%80%93%20README.md%20IntelliJ%20IDEA.png?raw=true)

## Downloads

* [Windows Installer](https://github.com/Ombrelin/charsheet/releases/download/1/charsheet-setup.exe)
* [Portable JAR](https://github.com/Ombrelin/charsheet/releases/download/1/charsheet-0.0.1-SNAPSHOT.jar)

## Build

Just run :

```
mvn clean package
```

## Run 

Once build, you can run the app by running :

```
java -jar ./target/charsheet-0.0.1-SNAPSHOT.jar
```

## Libraries used

- JavaFX
- [Spring Boot](https://github.com/spring-projects/spring-boot)
- [FxWeaver](https://github.com/rgielen/javafx-weaver)
- [JMetro](https://github.com/JFXtras/jfxtras-styles)
- [Java Discord RPC](https://github.com/MinnDevelopment/java-discord-rpc)
- [Project Lombok](https://github.com/rzwitserloot/lombok)

## Special Thanks

Special for [Pen of Chaos](http://www.penofchaos.com/) for creating ["Le Donjon de Naheulbeuk"](http://www.penofchaos.com/warham/donjon.htm) and ["Le Donjon de Naheulbeuk" Tabletop RPG](https://www.naheulbeuk.com/).
