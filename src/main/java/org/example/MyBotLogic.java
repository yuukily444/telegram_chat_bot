package org.example;

/**
 * логика тг бота
 */
public class MyBotLogic {

    /**
     * обрабатывает содержимое сообщения, затем возвращает ответ
     */
    public String process(String text) {

        if (text.equals("/help")) {
            return "Я - эхо-бот. Повторю то, что вы напишите.";
        }

        return "Вы написали: " + text;
    }

    /**
     * приветствие (должно выдавать после /start)
     */
    public String getHello() {
        return "Здравствуйте! Отправьте мне любое текстовое сообщение.";
    }
}