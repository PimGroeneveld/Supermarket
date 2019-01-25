package test;

import main.supermarket.CashRegister;
import main.supermarket.ShoppingCart;
import main.supermarket.StockItem;
import main.supermarket.Supermarket;
import main.visitor.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.pipe.AAShapePipe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SupermarketTest {

    private Customer customer1;
    private List<StockItem> stock;
    private List<StockItem> boughtItems;
    private ShoppingCart shoppingCart;
    private StockItem stockItem1;
    private StockItem stockItem2;
    private StockItem stockItem3;
    private StockItem stockItem4;
    private StockItem stockItem5;
    private CashRegister cashRegister;
    private Supermarket supermarket;
    private DayOfWeek date;

    @Before
    public void before(){
        shoppingCart = new ShoppingCart();
        customer1 = new Customer(200.00, shoppingCart);
        stockItem1 = new StockItem("Robijn", 3.00);
        stockItem2 = new StockItem("Brinta", 2.50);
        stockItem3 = new StockItem("Chinese groenten", 5.00);
        stockItem4 = new StockItem("Kwark", 2.00);
        stockItem5 = new StockItem("Luiers", 10.00);
        stock = new ArrayList<>();
        cashRegister = new CashRegister(500.00);
        supermarket = new Supermarket("The Five Items", cashRegister, stock);

        stock.add(stockItem1);
        stock.add(stockItem2);

        customer1.addItemToCart(stockItem1);
        customer1.addItemToCart(stockItem2);

        date = LocalDate.now().getDayOfWeek();
    }

    @Test
    public void supermarketCanAddStock(){
        stock.add(stockItem3);
        Assert.assertEquals(3, stock.size());
    }

    @Test
    public void supermarketCanRemoveStock(){
        stock.remove(stockItem2);
        Assert.assertEquals(1, stock.size());
    }

    @Test
    public void supermarketCanHandlePayment(){
        supermarket.handlePayment(stockItem1, customer1);
        Assert.assertEquals(1, supermarket.getStockItemList().size());
        Assert.assertEquals(503, cashRegister.getTill(), 0.0);
        Assert.assertEquals(1, customer1.countItemsInCart());
        Assert.assertEquals(1, customer1.getBoughtItems().size());
    }

    @Test
    public void canGetDayOfWeek(){
        Assert.assertEquals("FRIDAY", supermarket.getDayOfWeek().toString());
    }


}