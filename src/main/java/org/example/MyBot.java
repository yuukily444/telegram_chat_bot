package org.example;

import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
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

    public MyBot(TelegramClient client) {
        this.client = client;
        this.logic = new MyBotLogic();
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage()
                && update.getMessage().hasText()) {

            String chatId =
                    update.getMessage().getChatId().toString();

            String msg =
                    update.getMessage().getText();

            String answer =
                    logic.process(msg);

            SendMessage message =
                    new SendMessage(chatId, answer);

            try {
                client.execute(message);
            } catch (TelegramApiException exception) {
                System.err.println(
                        "Не удалось отправить сообщение: "
                                + exception.getMessage()
                );
            }
        }
    }
}