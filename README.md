# Demo Application

## Setup and Run

```bash
# Build
mvn clean package

# Run
java -cp "target/demo-app-1.0-SNAPSHOT.jar:target/lib/log4j-api-2.20.0.jar:target/lib/log4j-core-2.20.0.jar" com.csg.demo.DemoApp
```

## Package

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