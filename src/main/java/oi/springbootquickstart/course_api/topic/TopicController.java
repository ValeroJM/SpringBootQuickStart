package oi.springbootquickstart.course_api.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("/topics")
    public List<Topic> getAllTopic(){
        /**
         * We are returning a hardcode list of topics that we created using Array.asList()
         * Once we call http://localhost:8080/topics --> The list will be return as a JSON List out of the box and Spring Boot will do that for me
         */
        return Arrays.asList(
                new Topic("Spring", "Spring Framework", "Spring Framework Description"),
                new Topic("Java", "Core Java", "Core Java Description"),
                new Topic("JavaScript", "JavaScript", "JavaScript Description")
                );
    }
}
