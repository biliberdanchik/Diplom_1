package burger.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParametrizedReceiptLinesBurger {

    private final String bunName;
    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float priceBurger;

    private Burger burger;

    public TestParametrizedReceiptLinesBurger(String bunName, IngredientType ingredientType, String ingredientName, float priceBurger) {
        this.bunName = bunName;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.priceBurger = priceBurger;
    }

    @Parameterized.Parameters
    public static Object[][] getDataBurger() {
        return new Object[][] {
                {"black bun", IngredientType.SAUCE, "cheese", 520.50F},
                {"white bun", IngredientType.FILLING, "cutlet", 800.00F}
        };
    }

    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);

    @Before
    public void createBurger() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn(priceBurger);
    }

    @Test
    public void checkingFormatRowsReceipt() {
        String receipt = burger.getReceipt();
        String[] linesReceipt = receipt.split(System.lineSeparator());

        assertEquals("Первая строка с булочкой содержит ошибку", String.format("(==== %s ====)", bunName), linesReceipt[0]);
        assertEquals("Строка ингредиента содержит ошибку", String.format("= %s %s =", ingredientType.toString().toLowerCase(), ingredientName), linesReceipt[1]);
        assertEquals("Вторая строка с булочкой содержит ошибку", String.format("(==== %s ====)", bunName), linesReceipt[2]);
        assertEquals("Отсутствует пустая строка перед строкой с ценой", "", linesReceipt[3]);
        assertEquals("Ошибка в строке с ценой", String.format("Price: %f", priceBurger), linesReceipt[4]);
    }
}
