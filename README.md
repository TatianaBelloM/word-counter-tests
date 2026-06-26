Cómo ejecutar el proyecto?



cd ..\wordcounter-automation

# Ejecutar con Chrome (default)
mvn clean verify

# Ejecutar con Firefox
mvn clean verify "-Dwebdriver.driver=firefox"

# Ejecutar con Edge
mvn clean verify "-Dwebdriver.driver=edge"
