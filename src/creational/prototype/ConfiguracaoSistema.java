package creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracaoSistema {

    private String nomeAmbiente;
    private int timeoutMs;
    private List<String> modulosHabilitados;

    public ConfiguracaoSistema(String nomeAmbiente, int timeoutMs, List<String> modulosHabilitados) {
        this.nomeAmbiente = nomeAmbiente;
        this.timeoutMs = timeoutMs;
        this.modulosHabilitados = modulosHabilitados != null ? new ArrayList<>(modulosHabilitados) : new ArrayList<>();
    }

    // Construtor de Cópia (Deep Copy)
    public ConfiguracaoSistema(ConfiguracaoSistema outro) {
        this.nomeAmbiente = outro.nomeAmbiente;
        this.timeoutMs = outro.timeoutMs;
        // Deep copy da lista: cria uma nova coleção com os mesmos elementos
        this.modulosHabilitados = new ArrayList<>(outro.modulosHabilitados);
    }

    public ConfiguracaoSistema clonar() {
        return new ConfiguracaoSistema(this);
    }

    public void adicionarModulo(String modulo) {
        this.modulosHabilitados.add(modulo);
    }

    public String getNomeAmbiente() { return nomeAmbiente; }
    public void setNomeAmbiente(String nomeAmbiente) { this.nomeAmbiente = nomeAmbiente; }
    public int getTimeoutMs() { return timeoutMs; }
    public List<String> getModulosHabilitados() { return modulosHabilitados; }

}
