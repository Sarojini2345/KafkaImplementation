package com.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KakaConsumerService {
	
	Logger log=LoggerFactory.getLogger(KakaConsumerService.class);
	
/*	@KafkaListener(topics = "topic-kafka",groupId="consumers-group")
	public void consumer(String msg) {
		log.info("Consumer consumes the msg "+msg);
	}*/
	
	@KafkaListener(topics = "topic-kafka",groupId="consumers-group",topicPartitions = {@TopicPartition(topic="topic-kafka",partitions = {"2"})})
	public void consumer(String msg) {
		log.info("Consumer consumes the msg "+msg);
	}

}