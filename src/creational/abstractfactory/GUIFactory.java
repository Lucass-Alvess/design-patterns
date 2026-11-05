package creational.abstractfactory;

// A Abstract Factory define os métodos para toda a família
public interface GUIFactory {
    Botao criarBotao();
    Janela criarJanela();
}
