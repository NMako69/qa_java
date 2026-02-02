package com.example;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final Feline feline = new Feline();

    // Проверяем, что метод возвращает стандартный список еды хищника
    @Test
    public void shouldReturnMeatList() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    // Проверяем корректность возвращаемого семейства
    @Test
    public void shouldReturnFamilyName() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    // Проверяем получение количества котят без аргументов (по умолчанию 1)
    @Test
    public void shouldReturnDefaultKittensCount() {
        assertEquals(1, feline.getKittens());
    }

    // Проверяем получение количества котят с переданным аргументом
    @Test
    public void shouldReturnCustomKittensCount() {
        assertEquals(3, feline.getKittens(3));
    }
}
