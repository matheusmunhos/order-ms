package br.com.munhosdev.orderms.service;

import br.com.munhosdev.orderms.domain.Teste;
import br.com.munhosdev.orderms.listener.dto.OrderCreatedEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.munhosdev.orderms.config.RabbitMQConfig.MUNHOSDEV_ORDER_TEST_QUEUE;
import static br.com.munhosdev.orderms.config.RabbitMQConfig.ORDER_CREATED_QUEUE;

@Service
@AllArgsConstructor
public class RabbitMQSendService {

    private final Logger logger = LoggerFactory.getLogger(RabbitMQSendService.class);
    private final RabbitTemplate rabbitTemplate;

    public void sendOrderCreatedMessage(OrderCreatedEvent event) {
        logger.info("Sending message to {}: {}", ORDER_CREATED_QUEUE, event);
        rabbitTemplate.convertAndSend(ORDER_CREATED_QUEUE, event);
    }

    public void sendTesteMessage(Teste teste) {
        logger.info("Sending message to {}: {}", MUNHOSDEV_ORDER_TEST_QUEUE, teste);
        rabbitTemplate.convertAndSend(MUNHOSDEV_ORDER_TEST_QUEUE, teste);
    }



}
