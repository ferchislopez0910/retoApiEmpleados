# BackEnd: API EMPLEADOS #

### ¿Para qué este repostirio? ###
Implementación una interfaz API para crear, actualizar, editar los empleados de la compañia

### ¿Cómo se configura? ###
	Comando de instalación:
		- maven clean install
	Control de dependencia: Maven
	BackEnd: JDK: Java 17
	Archivo de propiedades: application.yml

	----------------------------------------------------------------
	Tecnologías-utilizadas:
		FrameWork: org.springframework.boot 2.6.4
		OpenAPI: V3 Swagger
		BD: 
			spring-boot-starter-data-jpa
			mysql-connector-java
			org.hibernate.orm

### TODO ###
	- Crear rol USER
	- Crear los test unitarios
	- Crear Controller Vacunación (filtro por tipo de vacuna y filtrar por fecha)
	- validación de nombres y apellidos para que no permita numeros y caracteres especiales
	- Control de excepciones
### Change log ###