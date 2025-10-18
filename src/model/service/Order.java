package model.service;

import model.entities.Client;
import model.entities.enums.Order_Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime moment;
    private Order_Status status;
    private Client client;

    List<OrderItem> orderItem = new ArrayList<>();

    //CONSTRUCTORS
    public Order() {
    }

    public Order(LocalDateTime moment, Order_Status status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    //GETS SETS
    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public Order_Status getStatus() {
        return status;
    }

    public void setStatus(Order_Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    //METHODS
    public void addOrderItem(OrderItem orderItem) {
        this.orderItem.add(orderItem);
    }

    public void removeOrderItem(OrderItem orderItem) {
        this.orderItem.remove(orderItem);
    }

    public Double totalPrice() {
        double sum = 0.0;
        for (OrderItem orderItem : orderItem) {
            sum += orderItem.subPrice();
        }
        return sum;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n").append("Order moment: ").append(moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:ss:mm"))).append("\n").append("Order status: ").append(status).append("\n")
                .append("Client: ").append(client).append("\n").append("Order Items: \n");

        for (OrderItem orderItem : orderItem) {
            sb.append(orderItem.getProduct().getName()).append(", Quantity: ").append(orderItem.getQuantity()).append(String.format(", Subtotal: %.2f\n", orderItem.subPrice()));
        }
        sb.append(String.format("Total Price: %.2f", totalPrice()));
        return sb.toString();
    }
}
