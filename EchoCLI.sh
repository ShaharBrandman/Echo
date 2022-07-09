export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
mvn package
sudo java -cp target/Echo-1.0-SNAPSHOT.jar com.echo.program.EchoCLI NETWORK_ID 69 NODE_ID