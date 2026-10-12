package org.example;

import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * Класс тг бота
 */
public class MyBot implements LongPollingSingleThreadUpdateConsumer {

    /**
     * Клиент для отправки сообщений
     */
    private final TelegramClient client;

    /**
     *  Логика бота
     */
    private final MyBotLogic logic;

    /**
     * Конструктор бота
     */
    public MyBot(TelegramClient client) {
        this.client = client;
        this.logic = new MyBotLogic();
    }

    /**
     * Обработка сообщения пользователя
     */
    public void consume(Update update) {
        if (update.hasMessage()) {
            long chatId = update.getMessage().getChatId();
            String msg = update.getMessage().getText();
            String answer = logic.process(msg);
        }
    }
}