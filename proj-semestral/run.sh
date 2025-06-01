set -a
source ../.env
set +a
mvn clean package
mvn exec:java -Dexec.mainClass="org.example.Main"
