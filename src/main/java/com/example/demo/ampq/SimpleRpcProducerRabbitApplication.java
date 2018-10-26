package com.example.demo.ampq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.example.demo.model.InvestmentLoan;

import org.springframework.amqp.core.Queue;

@EnableScheduling
@SpringBootApplication
public class SimpleRpcProducerRabbitApplication {

	private final RabbitTemplate template;

	@Autowired
	public SimpleRpcProducerRabbitApplication(RabbitTemplate template) {
		this.template = template;
	}

	// @Scheduled(fixedRate = 1000)
	public void sendMessage(InvestmentLoan list) {
		String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());

		this.template.convertAndSend("investmentloans", list.toString());
	}

	@Bean
	public Queue queue() {
		return new Queue("investmentloans", false);
	}
}
