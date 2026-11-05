package creational.factorymethod.staticfactory;

public class Pedido {
    private final StatusPedido status;

    private Pedido(StatusPedido status) {
        this.status = status;
    }

    // Static Factory Methods com nomes descritivos
    public static Pedido novoPedido() {
        return new Pedido(StatusPedido.CRIADO);
    }

    public static Pedido rascunho() {
        return new Pedido(StatusPedido.RASCUNHO);
    }
}
