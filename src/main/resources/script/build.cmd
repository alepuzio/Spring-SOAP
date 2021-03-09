REM mvn spring-boot:run -DenvTarget=personal-dev
REM mvn spring-boot:run -P=personal-dev -f ../../../../pom.xml -e -X

mvn package -P=dev -f ../../../../pom.xml 