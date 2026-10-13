package org.example;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;
import org.telegram.telegrambots.meta.generics.TelegramClient;

/**
 * Главный класс бота
 */
public class Main {

    /**
     * Запускает тг бота
     */
    public static void main(String[] args) {
        String botToken = System.getenv("BOT_TOKEN");

        try (TelegramBotsLongPollingApplication application =
                     new TelegramBotsLongPollingApplication()) {

            TelegramClient client = new OkHttpTelegramClient(botToken);
            MyBot bot = new MyBot(client);

            application.registerBot(botToken, bot);

            System.out.println("Бот запущен");
            Thread.currentThread().join();

        } catch (Exception exception) {
            System.err.println(
                    "Ошибка при запуске бота: " + exception.getMessage()
            );
        }
    }
}