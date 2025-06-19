Zipkin :

1) download zipkin jar from below maven path 

https://mvnrepository.com/artifact/io.zipkin/zipkin-server/2.24.0

2) run the below jar

E:\Software>java -jar zipkin-server-2.24.0-exec.jar

3) After run the jar check the  below URL

http://localhost:9411/zipkin/


application.yml config :

  zipkin:
    base-url: http://localhost:9411/

  sleuth:
    sampler:
      probability: 1.0
	  
	  

pom.xml:

		<!-- Zipkin -->
		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-tracing-bridge-brave</artifactId>
		</dependency>
		<dependency>
			<groupId>io.zipkin.reporter2</groupId>
			<artifactId>zipkin-reporter-brave</artifactId>
		</dependency>