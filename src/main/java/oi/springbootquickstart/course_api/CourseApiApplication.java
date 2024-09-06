package oi.springbootquickstart.course_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //This is annotation that indicate that this is the main SpringBoot class that actually contains the main method.
public class CourseApiApplication {

	public static void main(String[] args) {
		//The next line indicates to Spring Boot to start the application, create a server container and host the application in the container and run it for us.
		//The SpringApplication.run() takes 2 arguments: the main class we annotated on top + args that we passed in the main method
		SpringApplication.run(CourseApiApplication.class, args);
	}

}
