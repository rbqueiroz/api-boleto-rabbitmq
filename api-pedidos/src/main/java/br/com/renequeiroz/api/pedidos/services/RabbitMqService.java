package br.com.renequeiroz.api.pedidos.services;

import br.com.renequeiroz.api.pedidos.entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqService {

    @Value("${rabbit.exchange.name}")
    String exchangeName;

    private final Logger logger = LoggerFactory.getLogger(RabbitMqService.class);
    private final RabbitTemplate rabbitTemplate;

    public RabbitMqService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public Pedido sendMessage(Pedido pedido) {
        logger.info("Pedido enviado para o RabbitMQ id: {} ", pedido.toString());
        rabbitTemplate.convertAndSend(exchangeName, "", pedido);


        return pedido;
    }
}
