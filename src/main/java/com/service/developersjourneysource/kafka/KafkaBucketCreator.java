package com.service.developersjourneysource.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaBucketCreator {

	@Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("library-kafka-bucket")
                .build();
    }
}
