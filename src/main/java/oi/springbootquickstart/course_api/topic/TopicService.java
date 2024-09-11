package oi.springbootquickstart.course_api.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service //This marks a Spring Service - This use singleton behind the seems and instead of creating a list every single time like we did in clip 16
public class TopicService {
    //On clip 19, we need to initialize correctly using new Keyword so the List can be mutable if we only use Arrays.asList() it makes the list immutable
    private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Description"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("JavaScript", "JavaScript", "JavaScript Description")
    ));

    //We also need to create a method to return all the topicsList
    public List<Topic> getAllTopics(){
        return topicsList;
    }

    //This is a new method we created on Clip 18, that will take the id we provided in the Topic Controller using /topics/id
    public Topic getTopic(String id){
        return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    //Once the Post request was created in the Controller now we can add the new topic into the topicsList List
    public void addTopic(Topic topic) {
        topicsList.add(topic);
    }
}
