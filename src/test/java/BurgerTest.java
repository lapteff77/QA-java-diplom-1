import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger = new Burger();
    int index;
    int newIndex;
    private static final float delta = 0;

    @Before
    public void movList() {
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "test sauce", 100));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "test cream", 200));
        burger.ingredients.add(new Ingredient(IngredientType.SAUCE, "test chili", 300));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "Test cutlet", 100));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "Test dinosaur", 200));
        burger.ingredients.add(new Ingredient(IngredientType.FILLING, "Test sausage", 300));
    }

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientTest() {
        int index = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int newIndex = burger.ingredients.size();
        assertEquals(index, (newIndex - 1));
    }

    @Test
    public void removeIngredientTest() {
        int index = burger.ingredients.size() - 1;
        burger.removeIngredient(index);
        int newIndex = burger.ingredients.size();
        assertEquals(index, newIndex);
    }

    @Test
    public void moveIngredientTest() {
        index = 1;
        newIndex = 2;
        Ingredient expected = burger.ingredients.get(index);
        burger.moveIngredient(index, newIndex);
        Ingredient actualOne = burger.ingredients.get(newIndex);
        Ingredient actualTwo = burger.ingredients.get(index);
        assertEquals(expected, actualOne);
        assertNotEquals(expected, actualTwo);
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(10F);
        float actual = burger.getPrice();
        float expected = 1220F;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Супер");
        boolean actual = burger.getReceipt().contains("Супер");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @After
    public void reMovList() {
        burger.ingredients.clear();
    }
}


