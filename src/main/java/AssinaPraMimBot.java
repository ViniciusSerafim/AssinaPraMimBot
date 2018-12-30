import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class AssinaPraMimBot extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {
            System.out.println(update.getMessage().getText());
            System.out.println(update.getMessage().getFrom().x'());
    }

    public String getBotUsername() {
        return "AssinaPraMimBot";
    }

    public String getBotToken() {
        return "778993866:AAEYNH_D0pb9_fSip9NvYvhXaCRvqboDedg";
    }
}
