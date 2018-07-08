import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DanilDoeBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        String text = update.getMessage().getText();

        SendMessage response = new SendMessage();

        response.setReplyMarkup(getKeyboard());


        switch (text) {
            case "/start":
                response.setChatId(update.getMessage().getChatId())
                        .setText("Дарова");
                break;
            case "\uD83D\uDE02 Цитатку мне":
                String joke;

                try {
                    joke = BashUtil.getJoke();
                } catch (IOException e) {
                    joke = "Шутка не удалась!";
                }

                response.setChatId(update.getMessage().getChatId())
                        .setText(joke);
                break;
            case "Погода в Караганде сейчас":
                String weather;
                try {
                    weather = Weather.getWeather();
                } catch (IOException e) {
                    weather = "С погодой случилась аномалия...";
                }
                response.setChatId(update.getMessage().getChatId())
                        .setText(weather);
                break;

        }

        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "test_for_telegram_bot";
    }

    @Override
    public String getBotToken() {
        return "540058411:AAFGO6MiD_1kNByu3HW6z-k-OFGFvEZ7fHU";
    }

    private ReplyKeyboardMarkup getKeyboard() {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add("\uD83D\uDE02 Цитатку мне");
        keyboardRows.add(keyboardRow);

        keyboardRow = new KeyboardRow();
        keyboardRow.add("Погода в Караганде сейчас");
        keyboardRows.add(keyboardRow);

        keyboard.setKeyboard(keyboardRows);
        return keyboard;
    }
}
