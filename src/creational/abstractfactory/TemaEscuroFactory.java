package creational.abstractfactory;

// Fábrica Concreta 2: Cria exclusivamente elementos do Tema Escuro
public class TemaEscuroFactory implements GUIFactory {

    @Override
    public Botao criarBotao() {
        return new BotaoEscuro();
    }

    @Override
    public Janela criarJanela() {
        return new JanelaEscura();
    }
}
