package sb.bisht.microservice.orderservice.consumers;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import sb.bisht.microservice.orderservice.entity.Order;
import sb.bisht.microservice.orderservice.repository.OrderRepository;
import sb.bisht.microservice.orderservice.util.StringToObject;
//import sb.bisht.toObject.StringToObject;

@Component
public class OrderPlacedConsumers {

    @Autowired
    OrderRepository orderRepository;

    @KafkaListener(topics = "${message.topic.name}", groupId = "foo")
    public void receive(ConsumerRecord<String, Order> consumerRecord) throws Exception {
        System.out.println("-->" + String.valueOf(consumerRecord.value()) + " " + consumerRecord.toString());
        Order order = (Order) StringToObject.fromString(String.valueOf(consumerRecord.value()), Order.class);
        System.out.println("Order about to be created " + order.getUserId()+" "+order.getOrder()+" "+order.getPrice());

        orderRepository.save(order);
    }
}
