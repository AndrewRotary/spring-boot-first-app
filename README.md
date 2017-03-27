<h1>Quick start a Spring Boot project</h1>
Step 1: Create a new project Spring Initializr in Intellij Idea <br>
Step 2: Choose dependencies <br>
Step 3: Create a web controller<br>
Step 4: Create Thymeleaf view<br>
Step 5: Run the project.<br>
<ul>
  <li>
  <h3>Configure datasource/JPA</h3>
  Set dependencies for: <br>
    spring-boot-starter-data-jpa <br>
    postgresql
  </li>
   <li>
  <h3>Cofigure application.properties file</h3>
  Various properties can be specified inside your centralized application.properties file ex: </br>
    spring.datasource.url=jdbc:postgresql://localhost:5432/example <br>
    spring.datasource.username=user<br>
    spring.datasource.password=psw<br>
  </li>
   <li>
  <h3>Advantages using Spring Data JPA</h3>
      <ul>
        <li>interface-only repositories, using method names to infer queries automatically</li>
        <li>@Query annotation to define the query that an interface method should return</li>
        <li>automatic handling of Pageable queries</li>
        <li>base classes for standard crud repositories</li>
        <li>Example using Spring Data JPA: <br>
        public interface StudentRepository extends CrudRepository<Student, Long> { <br>
	      public void save(Student student); <br>
        }<br>
        </li>
      </ul>
  </li>
   <li>
  <h3>Setting the Profiles</h3>
  Spring Boot allows you to have one common configuration file (application.properties) and then multiple other files, each specific to a profile (application-${profile}.properties).
For instance: <br>
application.properties - Common configuration <br>
application-dev.properties - Configuration for dev profile <br>
application-prod.properties - Configuration for prod profiles <br>
To switch profiles you can use one of the following options: <br>
JVM property: -Dspring.profiles.active=prod <br>
Change in aplication.properties specific profile ex spring.profiles.active = dev or spring.profiles.active = prod
  </li>
</ul>
