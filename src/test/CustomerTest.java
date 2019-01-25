package test;

import main.supermarket.ShoppingCart;
import main.supermarket.StockItem;
import main.visitor.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

    private Customer customer1;
    private List<StockItem> boughtItems;
    private ShoppingCart shoppingCart;
    private StockItem stockItem1;
    private StockItem stockItem2;

    @Before
    public void before(){
        shoppingCart = new ShoppingCart();
        boughtItems = new ArrayList<>();
        customer1 = new Customer(200.00, shoppingCart);
        stockItem1 = new StockItem("Robijn", 3.00);
        stockItem2 = new StockItem("Brinta", 2.50);
    }

    @Test
    public void customerHasWallet(){
        Assert.assertEquals(200.00, customer1.getWallet(), 0.0);
    }

    @Test
    public void customerCanAddItemsInShoppingcart(){
        customer1.addItemToCart(stockItem1);
        Assert.assertEquals(1, customer1.getShoppingCart().getItemsInCart().size());
    }

    @Test
    public void customerCanPay(){
        customer1.payForItem(stockItem1);
        Assert.assertEquals(197.00, customer1.getWallet(), 0.0);
    }

    @Test
    public void customerCanAddItemToBoughtItems(){
        customer1.addItemToBoughtItems(stockItem1);
        Assert.assertEquals(1, customer1.getBoughtItems().size());
    }

    @Test
    public void customerCanRemoveItemFromCart(){
        customer1.addItemToCart(stockItem1);
        customer1.addItemToCart(stockItem2);
        customer1.removeItemFromCart(stockItem1);
        Assert.assertEquals(1, customer1.countItemsInCart());
    }


}