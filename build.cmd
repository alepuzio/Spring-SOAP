REM mvn spring-boot:run -DenvTarget=personal-dev
REM mvn spring-boot:run -P=personal-dev -f ../../../../pom.xml -e -X
REM del  C:\Users\apuzielli\Documents\personale\mio-github\java\spring-soap\spring_soap\target\spring_soap-1.0-SNAPSHOT.zip

mvn spring-boot:run -P=test -f pom.xml "-Dname=prova_name_da_maven" -e -X
