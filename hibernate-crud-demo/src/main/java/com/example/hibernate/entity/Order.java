
package com.example.hibernate.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders") // avoid using "order" as table name
public class Order {

    public enum Status { PENDING, PAID, SHIPPED, CANCELLED }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="order_date", nullable=false)
    private LocalDateTime orderDate = LocalDateTime.now();

    @Column(nullable=false, precision=12, scale=2)
    private BigDecimal total = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false, length=20)
    private Status status = Status.PENDING;

    // Many-to-One to Customer
    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name = "customer_id", nullable=false)
    private Customer customer;

    // Getters/Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "Order{id=" + id + ", orderDate=" + orderDate + ", total=" + total + ", status=" + status + "}";
    }
}
