package creational.builder;

public class Usuario {
    // Campos obrigatórios
    private final String nome;
    private final String email;

    // Campos opcionais
    private final String telefone;
    private final boolean ativo;

    // Construtor privado: impede instanciação direta
    private Usuario(Builder builder) {
        this.nome = builder.nome;
        this.email = builder.email;
        this.telefone = builder.telefone;
        this.ativo = builder.ativo;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public boolean isAtivo() { return ativo; }

    // Builder estático interno
    public static class Builder {
        private final String nome;
        private final String email;
        private String telefone;
        private boolean ativo = true; // valor default

        // Campos obrigatórios no construtor do Builder
        public Builder(String nome, String email) {
            this.nome = nome;
            this.email = email;
        }

        public Builder telefone(String telefone) {
            this.telefone = telefone;
            return this; // Permite chamadas encadeadas (Fluent API)
        }

        public Builder ativo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        // Validação de invariantes antes da criação
        public Usuario build() {
            if (this.nome == null || this.email == null) {
                throw new IllegalStateException("Nome e email são obrigatórios");
            }
            return new Usuario(this);
        }
    }
}

