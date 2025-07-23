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
# Install WiX Toolset from https://www.firegiant.com/wixtoolset/

# Generate exe installer
jpackage --type exe --app-version 1.0.0 --copyright "copyright" --description "Demo Application" --input build --name DemoApp --main-jar demo-app-1.0-SNAPSHOT.jar --main-class com.csg.demo.DemoApp --icon src/main/resources/app-icon.ico --license-file LICENSE.txt --win-dir-chooser --win-menu --win-shortcut --win-shortcut-prompt --verbose
```

### deb - Linux

```bash
# WSL environment on Windows
sudo apt-get update
sudo apt-get install fakeroot   # Install, if required by jpackage
jpackage \
  --type deb \
  --app-version 1.0.0 \
  --copyright "copyright" \
  --description "Demo Application" \
  --input build \
  --name DemoApp \
  --main-jar demo-app-1.0-SNAPSHOT.jar \
  --main-class com.csg.demo.DemoApp \
  --icon src/main/resources/app-icon.png \
  --license-file LICENSE.txt \
  --linux-package-name demoapp \
  --linux-rpm-license-type "Apache 2.0" \
  --verbose

# Inspect generated deb package
dpkg-deb -c demoapp_1.0.0_amd64.deb  # List contents
dpkg-deb -x demoapp_1.0.0_amd64.deb tmpfolder # Extract contents

# Install
sudo mkdir -p /usr/share/desktop-directories # Required in WSL
sudo dpkg -i demoapp_1.0.0_amd64.deb
sudo apt-get install -f # fix if there are any missing dependencies
dpkg -l # list installed apps
dpkg -L demoapp # lists files installed by the package

# Run
cd /opt/demoapp/bin
./DemoApp

# Uninstall
sudo dpkg -r demoapp
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