package se.java.security.dto;

import java.util.List;
import java.util.Map;

public class OrderResponseDTO {

    private String id;
    private String customerId;
    private double totalAmount;
    private List<OrderItemDTO> items;
    private Map<String, String> quantities;
    private String createdAt;

    public OrderResponseDTO(String id, String customerId, double totalAmount, List<OrderItemDTO> items, Map<String, String> quantities, String createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.items = items;
        this.quantities = quantities;
        this.createdAt = createdAt;
    }

    public OrderResponseDTO() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Map<String, String> getQuantities() {
        return quantities;
    }

    public void setQuantities(Map<String, String> quantities) {
        this.quantities = quantities;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
