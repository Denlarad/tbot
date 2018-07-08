import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApiContextInitializer.init();

        //

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new DanilDoeBot());
        } catch(TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
