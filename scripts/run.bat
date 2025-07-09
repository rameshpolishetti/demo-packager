@echo off
cd /d "%~dp0\.."

java -cp "target/demo-app-1.0-SNAPSHOT.jar:target/lib/log4j-api-2.20.0.jar:target/lib/log4j-core-2.20.0.jar" com.csg.demo.DemoApp

pause
