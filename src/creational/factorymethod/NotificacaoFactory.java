package creational.factorymethod;

public abstract class NotificacaoFactory {

    // Factory Method: subclasses decidem qual produto instanciar
    protected abstract Notificacao criarNotificacao();

    // Lógica de negócio que depende do produto criado
    public void processarEnvio(String mensagem) {
        Notificacao notificacao = criarNotificacao();
        notificacao.enviar(mensagem);
    }
}
