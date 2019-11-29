package com.indhawk.auth.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
//import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	/*@Value("${rabbitmq.queue}")
	public String rabbitmqQueue;
	
	@Value("${rabbitmq.exchange}")
	public String rabbitmqExchange;
	
	@Value("${rabbitmq.routing.key}")
	public String rabbitmqRoutingKey;
	
	@Bean
    Queue queue() {
        return new Queue(rabbitmqQueue);
    }
 
   
    @Bean
    Exchange exchange() {
        return new TopicExchange(rabbitmqExchange);
    }
 
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitmqRoutingKey);
    }*/
    
    /*@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}*/
    
   /* @Bean
	public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		//rabbitTemplate.setMessageConverter(jsonMessageConverter());
		return rabbitTemplate;
	}
    */

}
