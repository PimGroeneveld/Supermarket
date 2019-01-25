package test;

import main.supermarket.CashRegister;
import main.supermarket.ShoppingCart;
import main.supermarket.StockItem;
import main.visitor.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class CashRegisterTest {

    private Customer customer1;
    private List<StockItem> boughtItems;
    private ShoppingCart shoppingCart;
    private StockItem stockItem1;
    private StockItem stockItem2;
    private CashRegister cashRegister;

    @Before
    public void before() {
        shoppingCart = new ShoppingCart();
        customer1 = new Customer(200.00, shoppingCart);
        stockItem1 = new StockItem("Robijn", 3.00);
        stockItem2 = new StockItem("Brinta", 2.50);
        cashRegister = new CashRegister(500.00);
    }

    @Test
    public void cashRegisterCanChargeForProduct(){
        cashRegister.chargeCustomer(stockItem2, customer1);
        Assert.assertEquals(197.50, customer1.getWallet(), 0.0);
        Assert.assertEquals(502.50, cashRegister.getTill(), 0.0);
    }



}