cmake_minimum_required(VERSION 3.26)
project(DemoApp)

# Define install paths
set(INSTALL_BIN_DIR bin)
set(INSTALL_LIB_DIR lib)
set(INSTALL_CONFIG_DIR config)

# Install the main JAR
install(FILES target/demo-app-1.0-SNAPSHOT.jar DESTINATION ${INSTALL_BIN_DIR} COMPONENT Core)

# Install dependency JARs
file(GLOB DEP_JARS "target/lib/*.jar")
install(FILES ${DEP_JARS} DESTINATION ${INSTALL_LIB_DIR} COMPONENT Dependencies)

# Install config file
install(FILES src/main/resources/log4j2.xml DESTINATION ${INSTALL_CONFIG_DIR} COMPONENT Core)

# Install launcher scripts
# install(FILES scripts/run.sh DESTINATION ${INSTALL_BIN_DIR} PERMISSIONS OWNER_EXECUTE GROUP_EXECUTE WORLD_EXECUTE)
install(FILES scripts/run.sh DESTINATION ${INSTALL_BIN_DIR} COMPONENT Launcher)
install(FILES scripts/run.bat DESTINATION ${INSTALL_BIN_DIR} COMPONENT Launcher)

install(FILES LICENSE.txt README.md DESTINATION doc COMPONENT Docs)

# Packaging configuration
set(CPACK_RESOURCE_FILE_LICENSE "${CMAKE_CURRENT_SOURCE_DIR}/LICENSE.txt")

set(CPACK_PACKAGE_NAME "DemoApp")
set(CPACK_PACKAGE_VERSION "1.0.0")
set(CPACK_PACKAGE_VENDOR "Demo Company")
set(CPACK_PACKAGE_CONTACT "demo@example.com")
# set(CPACK_GENERATOR "TGZ")  # Or use ZIP, DEB, RPM, NSIS, etc.

# Define components for packaging
set(CPACK_COMPONENTS_ALL Core Dependencies Launcher Docs)

# Optional: descriptions for each component
set(CPACK_COMPONENT_CORE_DESCRIPTION "Main DemoApp JAR")
set(CPACK_COMPONENT_DEPENDENCIES_DESCRIPTION "Required dependency libraries")
set(CPACK_COMPONENT_LAUNCHER_DESCRIPTION "Launcher script")
set(CPACK_COMPONENT_DOCS_DESCRIPTION "License and README")

# Optional: mark some components as required
set(CPACK_COMPONENT_CORE_REQUIRED TRUE)

# Optional: group components in installer UI
set(CPACK_COMPONENT_GROUP_APP_GROUP "DemoApp Components")
set(CPACK_COMPONENT_CORE_GROUP "APP_GROUP")
set(CPACK_COMPONENT_DEPENDENCIES_GROUP "APP_GROUP")
set(CPACK_COMPONENT_LAUNCHER_GROUP "APP_GROUP")
set(CPACK_COMPONENT_DOCS_GROUP "APP_GROUP")

# NSIS packaging setup
set(CPACK_GENERATOR "NSIS")
set(CPACK_NSIS_MODIFY_PATH ON)
set(CPACK_NSIS_DISPLAY_NAME "DemoApp Installer")
# set(CPACK_NSIS_INSTALLED_ICON_NAME "bin\\run.bat")
set(CPACK_RESOURCE_FILE_LICENSE "${CMAKE_CURRENT_SOURCE_DIR}/LICENSE.txt")
set(CPACK_RESOURCE_FILE_README "${CMAKE_CURRENT_SOURCE_DIR}/README.md")

# Use DEB for Debian package
set(CPACK_GENERATOR "DEB")
set(CPACK_DEBIAN_PACKAGE_MAINTAINER "Ramesh Polishetti")  # Required for DEB

include(CPack)

 