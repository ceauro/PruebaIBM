# PruebaIBM
Repositorio que contiene la prueba técnica de IBM

### ¿Cómo se configura? ###
	Control de dependencias: gradle
	Backend:
		Jersey 2.26 (JAX-RS)
		EclipseLink 2.7.1 (JPA)
		JDK: 1.8
	FrontEnd:
	Base datos
		SQLite (jdbc 3.21.0.1) 
	----------------------------------------
	Servidor de apliaciones:
		Local: Websphere Liberty 18.0.0.1
		
### Base de datos ###
	El archivo de base de datos debe de estar en la ruta (en caso de ser windows)
	C:/dbPedidos/

	Si se tiene Linux, hay que modificar el archivo persistence.xml y modificar la propiedad javax.persistence.jdbc.url con la nueva ruta:
	<property name="javax.persistence.jdbc.url" value="`aquí la nueva ruta`" />

### Servicios ###
	Hay tres servicios funcionales:
	
	- [GET]  http://localhost:9080/Pedidos/consulta/identificacion : Consulta el tipo de identificación parametrizada, retorna el siguiente json {"CC":"CÉDULA DE CIUDADANIA","CE":"CÉDULA DE EXTRANJERÍA"}
	- [GET]  http://localhost:9080/Pedidos/consulta/prendas : Consulta el tipo de prendas parametrizadas, retorna el siguiente json {"CF":"CAMISAS FORMALES","CH":"CHAQUETAS","PF":"PANTALONES FORMALES"}
	- [POST] http://localhost:9080/Pedidos/persistir/pedido?pedido=<json_pedido><json_pedido> : Persiste la información del pedido en la BD, en donde <json_pedido> es el json que contiene la información a ser persistida, la estructura del json debe ser la siguiente:
			{
				"nombre": "Pepito Perez",
				"tipoId": "CC",
				"identificacion": "98712435",
				"fechaEntrega": "2018/05/02 07:35",
				"direccion": "Calle 3434",
				"valor": "50000",
				"detalles": [{
						"tipoPrenda": "CF",
						"cantidad": "3"
					}, {
						"cantidad": "5",
						"tipoPrenda": "PF"
					}
				]
			}