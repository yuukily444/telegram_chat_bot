package org.example;

/**
 * логика тг бота
 */
public class MyBotLogic {
    /**
     * обрабатывает содержимое сообщения, затем возвращает ответ
     */
    public String process(String text) {

        if (text.equals("/start")) {
            return "Здравствуйте! Отправьте мне любое текстовое сообщение.";
        }

        if (text.equals("/help")) {
            return "Я - эхо-бот. Повторю то, что вы напишите.";
        }

        return "Вы написали: " + text;
    }
}