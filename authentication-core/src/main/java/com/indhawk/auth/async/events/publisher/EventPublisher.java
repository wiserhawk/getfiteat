package com.indhawk.auth.async.events.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.indhawk.auth.model.Auth;

@Component
public class EventPublisher {
	
	private static final Logger LOG = LoggerFactory.getLogger(EventPublisher.class);
	
	/*@Autowired
	private AmqpTemplate rabbitTemplate;

	
	@Value("${rabbitmq.exchange}")
	public String exchange;
	
	@Value("${rabbitmq.routing.key}")
	public String rountingKey;
	
	public void publish(Auth auth) {
		rabbitTemplate.convertAndSend(exchange, rountingKey, auth);
		LOG.info("Event published for User Auth Queue. Message={}", auth);
	}*/
}
