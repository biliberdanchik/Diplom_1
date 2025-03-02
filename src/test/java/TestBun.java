import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {

    private final String BUN_NAME = "Флюоресцентная булка R2-D3";
    private final float PRICE = 50.50F;
    private Bun bun;

    @Before
    public void createBun() {
        bun = new Bun(BUN_NAME, PRICE);
    }

    @Test
    public void checkingGetNameBun() {
        assertEquals("Возвращенное имя не совпадает с ожидаемым", BUN_NAME, bun.getName());

    }

    @Test
    public void checkingGetPriceBun() {
        assertEquals("Возвращенная цена не совпадает с ожидаемой", PRICE, bun.getPrice(), 0.001F);
    }

}
