package burger.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestParametrizedPriceBurger {

    private final float priceBun;
    private final float priceFirstIngredient;
    private final float priceSecondIngredient;
    private final float priceThirdIngredient;
    private final float priceFourthIngredient;
    private final float expectedCalculatedPrice;

    private Burger burger;

    public TestParametrizedPriceBurger(float priceBun, float priceFirstIngredient, float priceSecondIngredient, float priceThirdIngredient, float priceFourthIngredient, float expectedCalculatedPrice) {
        this.priceBun = priceBun;
        this.priceFirstIngredient = priceFirstIngredient;
        this.priceSecondIngredient = priceSecondIngredient;
        this.priceThirdIngredient = priceThirdIngredient;
        this.priceFourthIngredient = priceFourthIngredient;
        this.expectedCalculatedPrice = expectedCalculatedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getDataPrice() {
        return new Object[][] {
                {5.05F, 20.2F, 30.3F, 40.4F, 50F, 151F},
                {0F, 0F, 0F, 0F, 0F, 0F},
                {3F, 0F, 10F, 0F, 5F, 21F}
        };
    }

    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient1 = Mockito.mock(Ingredient.class);
    Ingredient ingredient2 = Mockito.mock(Ingredient.class);
    Ingredient ingredient3 = Mockito.mock(Ingredient.class);
    Ingredient ingredient4 = Mockito.mock(Ingredient.class);

    @Before
    public void createBurger() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient4);
    }

    @Test
    public void checkingCalculatedPriceBurger() {
        Mockito.when(bun.getPrice()).thenReturn(priceBun);
        Mockito.when(ingredient1.getPrice()).thenReturn(priceFirstIngredient);
        Mockito.when(ingredient2.getPrice()).thenReturn(priceSecondIngredient);
        Mockito.when(ingredient3.getPrice()).thenReturn(priceThirdIngredient);
        Mockito.when(ingredient4.getPrice()).thenReturn(priceFourthIngredient);
        float actualCalculatedPrice = burger.getPrice();
        System.out.println(actualCalculatedPrice);
        assertEquals("Рассчитанная стоимость не совпадает с ожидаемой", expectedCalculatedPrice, actualCalculatedPrice, 0.00F);
    }
}
