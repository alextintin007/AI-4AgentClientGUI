package contenidoSerializado;

import java.io.Serializable;
import java.util.Arrays;

public class PagosVentas implements Serializable {
    Pagos[] pagos;
    Ventas[] ventas;

    public PagosVentas(Pagos[] pagos, Ventas[] ventas) {
        this.pagos = pagos;
        this.ventas = ventas;
    }

    public Pagos[] getPagos() {
        return pagos;
    }

    public void setPagos(Pagos[] pagos) {
        this.pagos = pagos;
    }

    public Ventas[] getVentas() {
        return ventas;
    }

    public void setVentas(Ventas[] ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "PagosVentas{" +
                "pagos=" + Arrays.toString(pagos) +
                ", ventas=" + Arrays.toString(ventas) +
                '}';
    }
}
