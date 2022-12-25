build:
  mvn -DskipTests clean package

spi-app:
  java -classpath ./demo-app/target/demo-app-0.0.1-SNAPSHOT.jar:./service-api/target/service-api-0.0.1-SNAPSHOT.jar:./jar-1/target/jar-1-0.0.1-SNAPSHOT.jar com.chatchatabc.SPIApp
