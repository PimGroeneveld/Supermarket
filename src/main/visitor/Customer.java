package main.visitor;

import main.supermarket.ShoppingCart;
import main.supermarket.StockItem;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private double wallet;
    private List<StockItem> boughtItems;
    private ShoppingCart shoppingCart;

    public Customer(double wallet, ShoppingCart shoppingCart) {
        this.wallet = wallet;
        this.boughtItems = new ArrayList<>();
        this.shoppingCart = shoppingCart;
    }

    public void payForItem(StockItem item){
        this.wallet -= item.getItemPrice();
    }

    public void addItemToCart(StockItem item){
        shoppingCart.addItemToCart(item);
    }

    public void removeItemFromCart(StockItem item){
        shoppingCart.removeItemFromCart(item);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int countItemsInCart(){
        return this.shoppingCart.getItemsInCart().size();
    }

    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public List<StockItem> getBoughtItems() {
        return boughtItems;
    }

    public void setBoughtItems(List<StockItem> boughtItems) {
        this.boughtItems = boughtItems;
    }

    public void addItemToBoughtItems(StockItem item){
        this.boughtItems.add(item);
    }

    public void removeItemFromBoughtItems(StockItem item){
        this.boughtItems.remove(item);
    }
}
