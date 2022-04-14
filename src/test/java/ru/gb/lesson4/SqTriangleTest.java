package ru.gb.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson4.homework.SqTriangle;
import ru.gb.lesson4.homework.Triangle;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SqTriangleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Метод выполнится 1 раз перед всеми тестами");

    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Метод выполнится перед каждым тестом");
    }

    @Test
    @DisplayName("Проверка вводимых значений на соответствие условию a + b > c")
    void ifSumTwoSidesLessThirdIsTrue(){
        boolean result = SqTriangle.isValid(1, 2, 3);
        assertTrue(result);
    }
    @Test
    @DisplayName("Проверка вводимых значений на соответствие условию > 0")
    void giveNullSideWhenCallIsValidThenTrue(){
        boolean result = SqTriangle.isValid(0, 2, 3);
        assertTrue(result);
    }
    @Test
    @DisplayName("Проверка вводимых корректных значений на соответствие условию")
    void givenCorrectValueAllSidesWhenCallIsValidThenFalse(){
        boolean result = SqTriangle.isValid(2, 2, 3);
        assertFalse(result);
    }
    @Test
    @DisplayName("Тест на соответствие ожидаемого и действительного результатов")
    void commonEqualsIsValid(){
        assertEquals(true, SqTriangle.isValid(1,2,3));
        assertEquals(true, SqTriangle.isValid(0,2,3));
        assertEquals(false, SqTriangle.isValid(2,2,3));
    }

    @ParameterizedTest
    @DisplayName("@ValueSource позволяет использовать несколько значений" +
                 "для подстановки в переменной одного аргумента")
    @ValueSource(ints = {0,1,5,6})
    void givenNumbersWhenCallIsValidThenTrue(int args) {
        assertTrue(SqTriangle.isValid(args,2,3));
    }

    @ParameterizedTest
    @DisplayName("@CsvSource позволяет использовать несколько вариантов " +
                 "состоящих из пар 'ожидаемого результата + значений'")
    @CsvSource({"true, 0, 1, 2",
                "false, 3, 4, 5"})
    void givenPairsValueWhenCallIsValidThenTrueOrFalse(boolean expectedResult, int a, int b, int c){
        assertEquals(expectedResult, SqTriangle.isValid(a, b, c));
    }

    @ParameterizedTest
    @DisplayName("@MethodSource ")
    @MethodSource("triangleDataProvider")
    void catTest(Triangle triangle, String type) {
        assertEquals(type, triangle.getType());
    }

    private static Stream<Arguments> triangleDataProvider() {
        return Stream.of(
                Arguments.of(new Triangle("Равнобедренный"), "Равнобедренный"),
                Arguments.of(new Triangle("Разносторонний"), "Разносторонний"),
//                Arguments.of(new Triangle("Разносторонний"), "Равнобедренный"),
                Arguments.of(new Triangle("Равносторонний"), "Равносторонний")
        );
    }

    @AfterEach
    void afterEach() {
        System.out.println("Метод выполнится после каждого теста");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Метод выполнится 1 раз после всех тестов");
    }

}
