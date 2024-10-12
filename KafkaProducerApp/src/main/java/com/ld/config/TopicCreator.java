package com.ld.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicCreator {
	@Bean
	public NewTopic createTopic() {
		return new NewTopic("topic-kafka", 5, (short) 1);
	}
}
