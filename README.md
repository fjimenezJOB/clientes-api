# Cliente - Facturas API
Proyecto de práctica para hacer transacciones con SpringBoot.

All responses are returned in JSON format.
## EndPoints:
### EndPoints de Usuario:
1. Primero debemos crear un usuario a través de este EndPoint:
   - POST [/user/createUser](https://localhost:8080/user/createUser) -> Enviamos los parametros "username" (nombre de usuario) y "password" (contraseña del usuario).
2. Una vez el usuario esté creado nos autenticamos para que nos devuelva el token.
   - POST [/user/getAutentication](https://localhost:8080/user/getAutentication) -> Enviamos los parametros "username" y "password" que hemos creado anteriormente, nos devolverá un Bearer Token. Es el token que tenemos que copiar para autorizarnos en el resto de endpoints.

### EndPoints Clientes:
- GET [/cliente/list](https://localhost:8080/cliente/list) -> Nos devuelve la lista de clientes con sus pedidos. 🔒
- POST [/cliente/create](https://localhost:8080/cliente/create) : Creamos un cliente con uno o mas pedidos. 🔒


## DockerHub image:
https://hub.docker.com/repository/docker/fjimenezjob/clientes-pedidos-api

## URL Swagger:
http://localhost:8080/swagger-ui.html#/

## URL H2:
http://localhost:8080/h2-ui/login.jsp

## JDBC URL:
jdbc url: jdbc:h2:mem:testdb