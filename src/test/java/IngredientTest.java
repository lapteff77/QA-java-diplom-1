import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;
    private static final float delta = 0;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[] getIngredient() {
        return new Object[][]{
                {IngredientType.SAUCE, "Чили", 10.0F},
                {IngredientType.FILLING, "Шпинат", 12.5F},// передали тестовые данные
        };
    }

    @Test
    public void shouldIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actual = ingredient.getType();
        assertEquals(type, actual);
    }

    @Test
    public void shouldIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actual = ingredient.getName();
        assertEquals(name, actual);
    }

    @Test
    public void shouldIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actual = ingredient.getPrice();
        Assert.assertEquals(price, actual, delta);
    }
}

