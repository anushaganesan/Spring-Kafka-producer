package com.anusha.Springbootkafkaproducer.resources;


import com.anusha.Springbootkafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafkaexample")
public class UserResource {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "KAFKA_PRODUCE_EXAMPLE";


    //example  to publish the string - name
      /* @GetMapping("/publish/{name}")
        public String publish(@PathVariable("name") String name){

           kafkaTemplate.send(TOPIC, name);

        return "Message published successfully";

       }*/

       //example to publish a JSON

    @GetMapping("/publish/json/{name}")
    public String publishJSON(@PathVariable("name") String name){

           kafkaTemplate.send(TOPIC,new User(name,45));

        return "JSON published successfully";
    }

}




