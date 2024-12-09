package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "DrBackend_bot";
    public static final String TOKEN = "7852307772:AAHugvzTZquRi4fNBs70vMCVRIHFb0nXJbs";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if(getMessageText().equals("/start")){
            sendTextMessageAsync("Hola fututo programador!");
        }
        if(getMessageText().contains("hola")){
            sendTextMessageAsync("Hola, cual es tu nombre...");
        }
        if(getMessageText().contains("me llamo")){
            sendTextMessageAsync("Mucho gusto, yo soy *Gato*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}