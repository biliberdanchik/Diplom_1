import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class TestIngredient {

    private final IngredientType type = SAUCE;
    private final String name = "cheese";
    private final float price = 30.20F;
    private Ingredient ingredient;

    @Before
    public void createIngredient() {
        ingredient = new Ingredient(type, name, price);
    }

    @Test
    public void checkingGetTypeIngredient() {
        assertEquals("Возвращаемый тип несоответствует ожидаемому", type, ingredient.getType());
    }

    @Test
    public void checkingGetNameIngredient() {
        assertEquals("Возвращаемое имя несоответствует ожидаемому", name, ingredient.getName());
    }

    @Test
    public void checkingGetPriceIngredient() {
        assertEquals("Возвращаемая цена несоответствует ожидаемой", price, ingredient.getPrice(), 0.001F);
    }

}
