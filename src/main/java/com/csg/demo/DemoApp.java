package com.csg.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoApp {
    private static final Logger logger = LogManager.getLogger(DemoApp.class);

    public static void main(String[] args) {
        logger.info("Application started.");
        logger.debug("This is a debug message.");
        logger.warn("This is a warning.");
        logger.error("This is an error message.");
        logger.info("Application finished.");
    }
}
