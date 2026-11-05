package creational.factorymethod;

public class SmsNotificacaoFactory extends NotificacaoFactory {

    @Override
    protected Notificacao criarNotificacao() {
        return new SmsNotificacao();
    }
}
