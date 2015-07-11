This project is not yet finished!

Description: Repository which enables to store your spending.

Technologies: Maven, Hibernate, Spring, Spring-data, Jackson, HSQLDB

RESTful API is exposed using Spring MVC in order to enable managing your spending.

1) Deploying on running Tomcat with loading test data
	mvn clean install -Ddev=true tomcat7:deploy-only
 
2) Running on embedded Tomcat (Tomcat 7)
	mvn clean install -Ddev=true tomcat7:run-war-only	