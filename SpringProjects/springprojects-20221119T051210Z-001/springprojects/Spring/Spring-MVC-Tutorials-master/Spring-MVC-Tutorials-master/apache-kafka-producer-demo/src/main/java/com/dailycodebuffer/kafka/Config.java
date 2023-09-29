package com.dailycodebuffer.kafka;


import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class Config
{
    @Autowired
    ProducerFactory<String,Book> producerFactory;

    @Autowired
    KafkaTemplate<String,Book> kafkaTemplate;

    private static final String TOPIC = "NewTopic";
   public Producer p;
    @Bean

    SmartLifecycle connector(ProducerFactory<String,Book> pf) {
        return new SmartLifecycle() {

            @Override
            public void stop() {
            }

            @Override   
            public void start() {
                
                System.out.println("Hello");
                p=pf.createProducer();
                System.out.println(p.partitionsFor("NewTopic1"));
                ProducerRecord pr=new ProducerRecord<>("NewTopic1",new Book("Shyam","5"));
                p.send(pr);
            //  kafkaTemplate.send(TOPIC,new Book("jai mata di","5000"));

            //   p.close();



            }

            @Override
            public boolean isRunning() {
                return false;
            }

        };
    }

}
