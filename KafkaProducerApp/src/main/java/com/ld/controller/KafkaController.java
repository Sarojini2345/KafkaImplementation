package com.ld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ld.service.KakfaProducerService;

@RestController
@RequestMapping("api/v1/producer")
public class KafkaController {

	@Autowired
	private KakfaProducerService publisher;
	
/*	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){
		try {
			for(int i=0;i<1000;i++) {
			publisher.sendMessageToTopic(message+": "+i);
			}
			return ResponseEntity.ok("message sent successfully");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}*/
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage2(@PathVariable String message,@RequestParam Integer partition){
		try {
			publisher.sendMessageToTopic(message, partition);
			return ResponseEntity.ok("message sent successfully");
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}
}
