package creational.factorymethod;

public class EmailNotificacaoFactory extends NotificacaoFactory {

    @Override
    protected Notificacao criarNotificacao() {
        return new EmailNotificacao();
    }
}
