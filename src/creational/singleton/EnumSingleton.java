package creational.singleton;

public enum EnumSingleton {

    // Instância única criada e gerenciada nativamente pela JVM
    INSTANCE;

    private String configurationValue;

    // O construtor de um enum é privado por padrão
    EnumSingleton() {
        this.configurationValue = "Configuração Inicial Padrão";
        System.out.println("Inicializando EnumSingleton...");
    }

    public String getConfigurationValue() {
        return configurationValue;
    }

    public void setConfigurationValue(String configurationValue) {
        this.configurationValue = configurationValue;
    }

    public void executeOperation(String message) {
        System.out.println("Enum executando: " + message + " | Config: " + configurationValue);
    }
}
