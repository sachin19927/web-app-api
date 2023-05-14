package com.service.developersjourneysource.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducer {

	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendMessageToBukcet(String message){
        log.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send("library-kafka-bucket", message);
    }
}
