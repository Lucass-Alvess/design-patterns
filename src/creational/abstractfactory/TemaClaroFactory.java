package creational.abstractfactory;

// Fábrica Concreta 1: Cria exclusivamente elementos do Tema Claro
public class TemaClaroFactory implements GUIFactory {

    @Override
    public Botao criarBotao() {
        return new BotaoClaro();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaClara();
    }
}
