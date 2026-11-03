package creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class CatalogoPrototipos {
    private final Map<String, ConfiguracaoSistema> prototipos = new HashMap<>();

    public void registrar(String chave, ConfiguracaoSistema prototipo) {
        prototipos.put(chave, prototipo);
    }

    public ConfiguracaoSistema obter(String chave) {
        ConfiguracaoSistema prototipo = prototipos.get(chave);
        if (prototipo == null) {
            throw new IllegalArgumentException("Protótipo não encontrado para: " + chave);
        }
        return prototipo.clonar(); // Retorna sempre uma nova cópia independente
    }
}