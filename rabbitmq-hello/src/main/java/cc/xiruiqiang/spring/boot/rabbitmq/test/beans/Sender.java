package cc.xiruiqiang.spring.boot.rabbitmq.test.beans;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	public void send() {
		String context="hello "+new Date();
		System.out.println(context);
		this.rabbitTemplate.convertAndSend("hello",context);
	}
}
