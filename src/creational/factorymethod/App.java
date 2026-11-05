package creational.factorymethod;

public class App {
    public static void main(String[] args) {
        // O cliente escolhe a fábrica apropriada ou a recebe via injeção de dependência
        NotificacaoFactory factory = new EmailNotificacaoFactory();
        factory.processarEnvio("Seu código de acesso é 1234");

        // Troca de canal sem mudar o fluxo de processamento
        factory = new SmsNotificacaoFactory();
        factory.processarEnvio("Seu código de acesso é 1234");
    }
}
