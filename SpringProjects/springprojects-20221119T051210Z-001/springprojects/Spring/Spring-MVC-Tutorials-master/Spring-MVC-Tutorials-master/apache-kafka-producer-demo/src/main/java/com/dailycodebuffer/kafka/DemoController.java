package com.dailycodebuffer.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    //@Autowired
    //KafkaTemplate<String,Book> kafkaTemplate;

    @Autowired
    Config config;

    private static final String TOPIC = "NewTopic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book)
    {
        ProducerRecord pr=new ProducerRecord<>("NewTopic",new Book("ram","5"));
        config.p.send(pr, new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if(e==null)
                {
                    System.out.println(recordMetadata.topic());
                    System.out.println(recordMetadata.partition());
                    System.out.println(recordMetadata.offset());
                    System.out.println(recordMetadata.timestamp());
                }
            }
        });
      //  kafkaTemplate.send(TOPIC, book);
        return "Published Successfully!";
        }
}


