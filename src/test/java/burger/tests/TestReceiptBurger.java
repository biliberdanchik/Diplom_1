package burger.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestReceiptBurger {

    private Burger burger;

    //Моки для наполнения
    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);
    Ingredient ingredient1 = Mockito.mock(Ingredient.class);

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void checkingReceiptBurgerWithoutIngredient() {
        //Добавили только булочку
        burger.setBuns(bun);

        String receipt = burger.getReceipt();
        System.out.println(receipt);

        //Проверка кол-ва строк в чеке
        String[] linesReceipt = receipt.split(System.lineSeparator());
        assertEquals("В чеке бургера без ингредиентов число строк не равно 4", 4, linesReceipt.length);
        assertTrue("В первой и второй строке чека должны быть булки",
                Pattern.matches("\\(====\\s.*\\s====\\)", linesReceipt[0]) && Pattern.matches("\\(====\\s.*\\s====\\)", linesReceipt[1]));
    }

    @Test
    public void checkingReceiptBurgerWithSeveralIngredients() {
        //Стабы для получения тип ингредиента
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        //Сборка бургера
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);

        String receipt = burger.getReceipt();
        //Проверка кол-ва трок в чеке
        String[] linesReceipt = receipt.split(System.lineSeparator());
        System.out.println(receipt);
        assertEquals("В чеке бургера c двумя ингредиентами число строк не равно 6", 6, linesReceipt.length);
        assertTrue("Во второй и третьей строке чека должны быть ингредиенты",
                Pattern.matches("=\\s.*\\s=", linesReceipt[1]) && Pattern.matches("=\\s.*\\s=", linesReceipt[2]));
    }
}
