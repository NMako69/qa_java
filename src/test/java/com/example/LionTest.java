package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    // Проверяем, что у самца грива есть (hasMane = true)
    @Test
    public void shouldHaveManeForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    // Проверяем, что у самки гривы нет (hasMane = false)
    @Test
    public void shouldNotHaveManeForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    // Проверяем, что при неверном указании пола конструктор бросает исключение
    @Test(expected = Exception.class)
    public void shouldThrowExceptionForInvalidSex() throws Exception {
        new Lion("Невалидный", feline);
    }

    // Проверяем, что метод getKittens возвращает данные, полученные от мока Feline
    @Test
    public void shouldReturnKittensCount() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    // Проверяем, что метод getFood вызывает метод зависимого класса с нужным параметром
    @Test
    public void shouldCallGetFoodWithPredatorArgument() throws Exception {
        Lion lion = new Lion("Самка", feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
