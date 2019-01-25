package main.supermarket;

import main.visitor.Customer;

public class CashRegister {

    private double till;

    public CashRegister(double till) {
        this.till = till;
    }

    public double getTill() {
        return till;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public void chargeCustomer(StockItem item, Customer customer){
        customer.payForItem(item);
        double itemPrice = item.getItemPrice();
        this.till += itemPrice;
    }
}
