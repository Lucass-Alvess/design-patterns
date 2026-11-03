package creational.prototype;

public class Documento implements Prototype<Documento> {
    private String titulo;
    private String conteudo;

    public Documento(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    // Construtor de cópia
    public Documento(Documento outro) {
        this.titulo = outro.titulo;
        this.conteudo = outro.conteudo;
    }

    @Override
    public Documento clonar() {
        return new Documento(this);
    }

    // Getters e setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
}