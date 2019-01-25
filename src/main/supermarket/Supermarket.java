package main.supermarket;

import main.visitor.Customer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class Supermarket {

    private String name;
    private CashRegister cashRegister;
    private List<StockItem> stockItemList;
    private DayOfWeek dayOfWeek;

    // helaas net niet aan de korting toegkomen. Heb de day of week er in weten te krijgen en was net van plan aan de korting methode te beginnen
    public Supermarket(String name, CashRegister cashRegister, List<StockItem> stockItemList) {
        this.name = name;
        this.cashRegister = cashRegister;
        this.stockItemList = stockItemList;
        this.dayOfWeek = LocalDate.now().getDayOfWeek();
    }

    public void handlePayment(StockItem item, Customer customer){
        cashRegister.chargeCustomer(item, customer);  // tested
        stockItemList.remove(item); // tested
        customer.removeItemFromCart(item); // tested
        customer.addItemToBoughtItems(item); // tested
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public List<StockItem> getStockItemList() {
        return stockItemList;
    }

    public void setStockItemList(List<StockItem> stockItemList) {
        this.stockItemList = stockItemList;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
}
