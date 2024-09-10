package oi.springbootquickstart.course_api.topic;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service //This marks a Spring Service - This use singleton behind the seems and instead of creating a list every single time like we did in clip 16
public class TopicService {
    private List<Topic> topicsList = Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Description"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("JavaScript", "JavaScript", "JavaScript Description")
            );

    //We also need to create a method to return all the topicsList
    public List<Topic> getAllTopics(){
        return topicsList;
    }

    //This is a new method we created on Clip 18, that will take the id we provided in the Topic Controller using /topics/id
    public Topic getTopic(String id){
        return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }
}
