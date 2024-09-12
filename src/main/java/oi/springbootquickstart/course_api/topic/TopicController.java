package oi.springbootquickstart.course_api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * On Clip 18, we implemented another method using @RequestMapping and @PathVariable annotation.
     * We also add a new method call getTopic in the TopicService.java Class and call it in the Return of this method
     * @param id
     * @return
     */
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.getTopic(id);
    }

    /**
     * On Clip 19, we implemented another method but this time a Post Request where we are going to create a new topic
     * We also will use @RequestBody annotation to send a Topic object and Spring will convert it into a Topic JSON
     * We also used PostMan we send a Topic JSON object in the body of the request and add a Header with Key: Content-Type and Value: application/json so Postman will know that we are sending an object
     */
    //@PostMapping("/topics") //We can also use @PostMapping annotation - This is not part of Clip# 19
    @RequestMapping(method= RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    /**
     * On Clip 20, we implemented another method but this time a PUT and DELETE Request where we are going to update a new topic
     * We also will use @RequestBody annotation to send a Topic object, Spring will convert it into a Topic JSON and also use @PathVariable to pass the JSON id
     * We also used PostMan:
     * - For PutMapping a Topic JSON object in the body of the request + the id of the JSON we want to replace.
     * We had to add a Header with Key: Content-Type and Value: application/json so Postman will know that we are sending an object
     * - For DeleteMapping we made a request with the id, we implemented a logic to find the JSON and delete it from the List
     */

    //@PutMapping("/topics/{id}") //We can also use @PutMapping annotation - This is not part of Clip# 20
    @RequestMapping(method= RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id, topic);
    }

    //@DeleteMapping("/topics/{id}") //We can also use @DeleteMapping annotation - This is not part of Clip# 20
    @RequestMapping(method= RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id){
        topicService.deleteTopic(id);
    }
}
