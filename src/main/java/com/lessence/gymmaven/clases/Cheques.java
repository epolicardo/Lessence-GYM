package com.lessence.gymmaven.clases;

/**
 *
 * @author emiliano
 */
public class Cheques {

    private String idCheque;
    private String idCliente;
    private String Banco;
    private String Plaza;
    private String FechaCobro;
    private String Importe;

    public Cheques(String idCheque, String idCliente, String Banco, String Plaza, String FechaCobro, String Importe)
            {

    this.setIdCheque(idCheque);
    this.setIdCliente(idCliente);
    this.setBanco(Banco);
    this.setPlaza(Plaza);
    this.setFechaCobro(FechaCobro);
    this.setImporte(Importe);




    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    public String getFechaCobro() {
        return FechaCobro;
    }

    public void setFechaCobro(String FechaCobro) {
        this.FechaCobro = FechaCobro;
    }

    public String getImporte() {
        return Importe;
    }

    public void setImporte(String Importe) {
        this.Importe = Importe;
    }

    public String getPlaza() {
        return Plaza;
    }

    public void setPlaza(String Plaza) {
        this.Plaza = Plaza;
    }

    public String getIdCheque() {
        return idCheque;
    }

    public void setIdCheque(String idCheque) {
        this.idCheque = idCheque;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

}
