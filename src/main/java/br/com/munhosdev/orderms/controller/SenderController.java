package br.com.munhosdev.orderms.controller;

import br.com.munhosdev.orderms.domain.Teste;
import br.com.munhosdev.orderms.listener.dto.OrderCreatedEvent;
import br.com.munhosdev.orderms.service.RabbitMQSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/send")
public class SenderController {

    @Autowired
    private RabbitMQSendService rabbitMQSendService;

    @PostMapping("/order")
    public void sendOrder(@RequestBody OrderCreatedEvent orderCreatedEvent) {
        rabbitMQSendService.sendOrderCreatedMessage(orderCreatedEvent);
    }

    @PostMapping("/teste")
    public void teste(@RequestBody Teste message){
        rabbitMQSendService.sendTesteMessage(message);
    }


}
