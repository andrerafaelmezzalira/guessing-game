run-web:
	mvn exec:java -Dexec.mainClass="org.example.guessing.web.MainWeb"

run-desktop:
	mvn exec:java -Dexec.mainClass="org.example.guessing.desktop.MainDesktop"

install:
	mvn clean install

package:
	mvn clean package

test:
	mvn clean test