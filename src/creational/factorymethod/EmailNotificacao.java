package creational.factorymethod;

public class EmailNotificacao implements Notificacao {

    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando Email: " + mensagem);
    }
}
