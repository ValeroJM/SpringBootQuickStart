package oi.springbootquickstart.course_api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {
    /**
     * To use the Service class - in our case TopicService.java we need to:
     * 1. Create a private member variable
     * 2. We need to tell Spring to injected using the annotation @Autowired
     */
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopic(){
        /**
         * We are returning a hardcode list of topics that we created using Array.asList()
         * Once we call http://localhost:8080/topics --> The list will be return as a JSON List out of the box and Spring Boot will do that for me
         */

        /**
         * On Clip 17 we create a service class TopicSevice.java, move all the JSON courses List, Autowired the class in the Controller and create a method to return all the courses from TopicService.java class
         * To use the return correctly we need to call the service instance we autowired and call the method
         * Like below:
         * topicService.getAllTopics()
         */
        return topicService.getAllTopics();
    }
}
