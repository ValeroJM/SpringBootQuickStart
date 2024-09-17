package oi.springbootquickstart.course_api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service //This marks a Spring Service - This use singleton behind the seems and instead of creating a list every single time like we did in clip 16
public class TopicService {
    //On Clip#29 We are connecting our Repository Interface with our Service Layer by using @Autowired annotation
    @Autowired
    private TopicRepository topicRepository;

    //On Clip#29 we are updating the methods we have in this Service using CRUD operations from the interface we removed the old hard code list
    /*
    //On clip 19, we need to initialize correctly using new Keyword so the List can be mutable if we only use Arrays.asList() it makes the list immutable
    private List<Topic> topicsList = new ArrayList<>(Arrays.asList(
            new Topic("Spring", "Spring Framework", "Spring Framework Description"),
            new Topic("Java", "Core Java", "Core Java Description"),
            new Topic("JavaScript", "JavaScript", "JavaScript Description")
    ));
    */

    //We also need to create a method to return all the topicsList
    public List<Topic> getAllTopics(){
        //On Clip#29 we are updating the methods we have in this Service using CRUD operations from the interface
        //return topicsList; //This is the old implementation
        //To be able to return a list of topics: 1. We need to create a list of Topics:
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll().forEach(topicList::add); //2. The use the iterable In this way we are iterating all the topics and add it to the topicList
        return topicList;
    }

    //This is a new method we created on Clip 18, that will take the id we provided in the Topic Controller using /topics/id
    public Optional<Topic> getTopic(String id){
        //On Clip#29 we are updating the methods we have in this Service using CRUD operations from the interface
        //return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get(); //Old implementation
        return topicRepository.findById(id);
    }

    //Once the Post request was created in the Controller now we can add the new topic into the topicsList List
    public void addTopic(Topic topic) {
        //On Clip#29 we are updating the methods we have in this Service using CRUD operations from the interface
        //topicsList.add(topic); //This is the old implementation
        //This is the new implementation to save the new topic into the DB
        topicRepository.save(topic);
    }

    //Once the Put request was created in the Controller now we can set the update topic into the topicList List
    public void updateTopic(String id, Topic topic) {
        //On Clip#29 we are updating the methods we have in this Service using CRUD operations from the interface
        /* //Old implementation
        for (int i = 0; i < topicsList.size(); i++){
            Topic t = topicsList.get(i);
            if (t.getId().equals(id)){
                topicsList.set(i, topic);
                return;
            }
        }
         */
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        //On Clip#29 we are updating the methods we have in this Service using CRUD operations from the interface
        //topicsList.removeIf(t -> t.getId().equals(id)); //Old implementation
        topicRepository.deleteById(id);
    }
}
