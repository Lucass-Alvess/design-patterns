package creational.abstractfactory;

public class BotaoClaro implements Botao{

    @Override
    public void renderizar() {
        System.out.println("Renderizando botão com fundo branco e texto preto.");
    }
}
