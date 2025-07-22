# Demo Application
This is a POC demo application created to evaluate `cmake`, `jpackage` and `izpack` build tools for a Java-based application.

## Getting Started
To build and run this demo locally, follow the steps outlined below.
```bash
git clone git@github.com:rameshpolishetti/demo-packager.git
cd demo-packager
mvn clean package
java -cp "target/demo-app-1.0-SNAPSHOT.jar:target/lib/log4j-api-2.20.0.jar:target/lib/log4j-core-2.20.0.jar" com.csg.demo.DemoApp

```

## Package using jpackage

### exe - Windows

```bash
jpackage --type exe --input target --name DemoApp --main-jar demo-app-1.0-SNAPSHOT.jar --main-class com.csg.demo.DemoApp --icon src/main/resources/app-icon.ico --win-menu --win-shortcut
```

### icon
<img src="https://icons.iconarchive.com/icons/papirus-team/papirus-apps/48/gtk3-demo-icon.png" width="48" height="48">


## Package using cmake

### DEB - Ubuntu
```bash
mkdir build
cd build
cmake ../
cmake --build .
cpack -G DEB --config CPackConfig.cmake

# Install
sudo dpkg -i demo-app-1.0.0-Linux.deb

# UnInstall
sudo dpkg -r demoapp

# Inspect
dpkg -L demoapp
dpkg --contents demo-app-1.0.0-Linux.deb
```

### NSIS - Windows / exe

```bash
sudo apt update
sudo apt install nsis
makensis -version

cd Demo
mkdir build
cd build
cmake ../
cmake --build .
cpack -G NSIS --config CPackConfig.cmake
```

### DMG - Mac

```bash
```