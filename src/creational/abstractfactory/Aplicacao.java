package creational.abstractfactory;

public class Aplicacao {
    private final Botao botao;
    private final Janela janela;

    // A fábrica é injetada (Inversão de Dependência)
    public Aplicacao(GUIFactory factory) {
        this.botao = factory.criarBotao();
        this.janela = factory.criarJanela();
    }

    public void iniciar() {
        janela.exibir(botao);
    }

    public static void main(String[] args) {
        // A escolha da fábrica ocorre na inicialização (ex: por arquivo de config)
        GUIFactory factory = new TemaEscuroFactory();
        Aplicacao app = new Aplicacao(factory);
        app.iniciar();
    }
}
