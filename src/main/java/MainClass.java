import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class MainClass {
    public static void main(String args[]){
        ApiContextInitializer.init();
        TelegramBotsApi telegkramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new AssinaPraMimBot());

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
