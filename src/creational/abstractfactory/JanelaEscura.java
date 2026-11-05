package creational.abstractfactory;

public class JanelaEscura implements  Janela {

    @Override
    public void exibir(Botao botao) {
        System.out.println("Exibindo janela com paleta escura.");
        botao.renderizar();
    }
}
