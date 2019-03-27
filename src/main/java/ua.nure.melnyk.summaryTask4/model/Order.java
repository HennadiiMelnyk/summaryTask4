package ua.nure.melnyk.summaryTask4.model;

import java.util.Objects;

/**
 * Order model
 */
public class Order {

    private int id;
    private String status;
    private String details;
    private int userId;


    public Order() {
    }

    public Order(int id, String status, String details, int userId) {
        this.id = id;
        this.status = status;
        this.details = details;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                Objects.equals(status, order.status) &&
                Objects.equals(details, order.details);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, status, details, userId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                ", userId=" + userId +
                '}';
    }
}
