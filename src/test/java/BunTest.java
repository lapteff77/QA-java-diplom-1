import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    String name = "Супер";
    float price = 2.40F;

    @Test
    public void bunTestName() {
        Bun bun = new Bun(name, price);
        String actual = bun.getName();
        assertEquals(name, actual);
    }

    @Test
    public void bunTestPrice() {
        Bun bun = new Bun(name, price);
        float actual = bun.getPrice();
        Assert.assertEquals(price, actual, 0);
    }
}


