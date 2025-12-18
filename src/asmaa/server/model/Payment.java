package asmaa.server.model;

import java.io.Serializable;

public class Payment implements Serializable {
    private int id;
    private double amount;
    private String method;
    private PaymentStatus status; // <-- correction ici

    public Payment() {}

    public Payment(int id, double amount, String method, PaymentStatus status) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}
