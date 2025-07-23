package com.csg.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoApp {
    private static final Logger logger = LogManager.getLogger(DemoApp.class);

    public static void main(String[] args) {
        try {
            InputStream is = DemoApp.class.getClassLoader()
                    .getResourceAsStream("META-INF/maven/com.csg/demo-app/pom.properties");
            Properties props = new Properties();
            props.load(is);
            String version = props.getProperty("version");
            logger.info("Demo Application Version: {}", version);
        } catch (IOException e) {
            logger.error("Error reading pom.properties file", e);
        }
        logger.info("Application started.");
        logger.debug("This is a debug message.");
        logger.warn("This is a warning.");
        logger.error("This is an error message.");
        logger.info("Application finished.");
    }
}
