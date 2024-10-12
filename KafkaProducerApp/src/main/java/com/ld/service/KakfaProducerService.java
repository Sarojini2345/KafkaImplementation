package com.ld.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;



@Service
public class KakfaProducerService {
	
	@Autowired
	private KafkaTemplate<String, Object> template;
	
	public void sendMessageToTopic(String message,int partition) {
		CompletableFuture<SendResult<String,Object>> future=template.send("topic-kafka", partition, null, message);
		future.whenComplete((result,ex)->{
		  if(ex==null) {
			  System.out.println("sent message "+message+" with offset "+result.getRecordMetadata());
		  }
		  else {
			  System.out.println("Unable to send message "+message);
		  }
		});
	}
}