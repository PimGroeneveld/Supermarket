package main.supermarket;

import main.visitor.Customer;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<StockItem> itemsInCart;

    public ShoppingCart() {
        this.itemsInCart = new ArrayList<>();
    }

    public List<StockItem> getItemsInCart() {
        return itemsInCart;
    }

    public void addItemToCart(StockItem itemToPurchase) {
        this.itemsInCart.add(itemToPurchase);
    }

    public void removeItemFromCart(StockItem itemToPurchase) {
        this.itemsInCart.remove(itemToPurchase);
    }
}
