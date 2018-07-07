import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class DanilDoeBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getChat().getFirstName());
        System.out.println(update.getMessage().getChat().getLastName());
        System.out.println(update.getMessage().getChat().getUserName());
        String text = update.getMessage().getText();
        System.out.println(text);

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(update.getMessage().getChatId())
                .setText("Ты написал: " + text);

        try {
            execute(sendMessage);
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
}
