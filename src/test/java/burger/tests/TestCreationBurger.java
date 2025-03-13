package burger.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestCreationBurger {

    private Burger burger;

    @Mock
    Ingredient ingredient;
    Ingredient ingredient1;
    Ingredient ingredient2;
    Ingredient ingredient3;

    @Before
    public void createBurger() {
        burger = new Burger();
    }

    @Test
    public void checkingAddIngredient() {
        burger.addIngredient(ingredient);
        assertTrue("Добавленный ингредиент отсутствует в списке", burger.ingredients.contains(ingredient));
    }

    @Test
    public void checkingRemoveIngredient() {
        burger.ingredients.add(ingredient1);
        int indexIngredient = burger.ingredients.indexOf(ingredient1);
        burger.removeIngredient(indexIngredient);
        assertFalse("Удаляемый ингредиент все еще в списке", burger.ingredients.contains(ingredient1));
    }

    @Test
    public void checkingMoveIngredient() {
        //Заполняем моками список ингредиентов
        burger.ingredients.add(ingredient);
        burger.ingredients.add(ingredient1);
        burger.ingredients.add(ingredient2);
        burger.ingredients.add(ingredient3);
        int oldSize = burger.ingredients.size();
        int indexOldPosition = burger.ingredients.indexOf(ingredient2);
        int indexNewPosition = 0;
        burger.moveIngredient(indexOldPosition, indexNewPosition);
        assertEquals("Элемент не переместился на заданную позицию", ingredient2 ,burger.ingredients.get(indexNewPosition));
        assertNotEquals("Элемент всё еще находится на старой позиции", ingredient2, burger.ingredients.get(indexOldPosition));
        assertEquals("Изменился размер списка ингредиентов", oldSize, burger.ingredients.size());
    }
}
