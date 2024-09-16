package oi.springbootquickstart.course_api.topic;

import org.springframework.data.repository.CrudRepository;

//On Clip#29 we created an interface TopicRepository and extends the CrudRepository providing the data types we will work with Topic and String
public interface TopicRepository extends CrudRepository<Topic, String> {

    //getAllTopics()
    //getTopic(Sring id)
    //updateTopic(Topic t)
    //deleterTopic(String id)
}
