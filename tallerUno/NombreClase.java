public class NombreClase {

    private NombreClase() {
    }

    private static class Holder {
        private static final NombreClase INSTANCIA = new NombreClase();
    }

    public static NombreClase getInstancia() {
        return Holder.INSTANCIA;
    }
}

