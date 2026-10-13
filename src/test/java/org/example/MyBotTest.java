package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * тестирует логику бота
 */
class MyBotLogicTest {

    /**
     * хранит объект логики бота, который проверяется в тестах
     */
    private final MyBotLogic myBotLogic = new MyBotLogic();

    /**
     * проверяет ответы бота на обычные текстовые сообщения
     *
     * @param input сообщение пользователя
     * @param expected ожидаемый ответ бота
     */
    @ParameterizedTest
    @CsvSource({
            "Добрый день!, 'Вы написали: Добрый день!'",
            "тест123, 'Вы написали: тест123'",
            "Как дела?, 'Вы написали: Как дела?'",
            "12345%?*, 'Вы написали: 12345%?*'"
    })
    void testEchoesOrdinaryText(String input, String expected) {
        Assertions.assertEquals(expected, myBotLogic.process(input));
    }
}

