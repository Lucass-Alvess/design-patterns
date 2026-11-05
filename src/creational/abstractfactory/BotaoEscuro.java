package creational.abstractfactory;

public class BotaoEscuro implements Botao {

    @Override
    public void renderizar() {
        System.out.println("Renderizando botão com fundo cinza escuro e texto branco.");
    }
}
