REM  https://spring.io/guides/gs/producing-web-service/

echo "develop"
curl --header "content-type: text/xml" -d @request.xml http://localhost:8080/ws

echo "test"
curl --header "content-type: text/xml" -d @request.xml http://localhost:8081/ws

echo "produzione"
curl --header "content-type: text/xml" -d @request.xml http://localhost:8082/ws