package com.kafka.example.producer.controllers;


import com.kafka.example.producer.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class Controller {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplateUser;


    private static final String TOPIC = "Kafka_Example_String";
    private static final String TOPIC_USER = "Kafka_Example_User";
    @GetMapping("/publish/{message}")
    public String publish(@PathVariable("message")  String message){


         kafkaTemplate.send(TOPIC,message);

         return "Published Successfully \t\t"+ message;
     }


    @GetMapping("publishUser/{name}")
    public String publishJson(@PathVariable String name){



        kafkaTemplateUser.send(TOPIC_USER,new User(name,25));

        return "Published Successfully";
     }
}
