package creational.abstractfactory;

public class JanelaClara implements Janela {

    @Override
    public void exibir(Botao botao) {
        System.out.println("Exibindo janela com paleta clara.");
        botao.renderizar();
    }
}
