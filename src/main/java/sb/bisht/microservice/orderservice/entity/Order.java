package sb.bisht.microservice.orderservice.entity;

import sb.bisht.toObject.annotations.Required;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Required
    private Long userId;

    @Required
    @Column(name = "ordered_item")
    private String order;

    @Required
    private String price;

    @Temporal(TemporalType.DATE)
    private Date orderPlacedOn;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getOrderPlacedOn() {
        return orderPlacedOn;
    }

    public void setOrderPlacedOn(Date orderPlacedOn) {
        this.orderPlacedOn = orderPlacedOn;
    }

    @Override
    public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", order='" + order + '\'' +
                ", price='" + price + '\'' +
                ", orderPlacedOn=" + orderPlacedOn +
                '}';
    }
}
