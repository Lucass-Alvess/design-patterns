package creational.singleton;

public class BillPughSingleton {

    // 1. Construtor privado impede instanciação externa com 'new'
    private BillPughSingleton() {
        System.out.println("Inicializando BillPughSingleton...");
    }

    // 2. Classe interna estática privada
    // A JVM NÃO carrega essa classe na memória até que o método getInstance() seja chamado
    private static class InstanceHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    // 3. Ponto de acesso global
    public static BillPughSingleton getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void executeOperation(String message) {
        System.out.println("BillPugh executando: " + message);
    }

}
