class Voo {
    private String codAeroportoOrigem;
    private String codAeroportoDestino;
    private int numeroVoo;

    public Voo(String codAeroportoOrigem, String codAeroportoDestino, int numeroVoo) {
        this.codAeroportoOrigem = codAeroportoOrigem;
        this.codAeroportoDestino = codAeroportoDestino;
        this.numeroVoo = numeroVoo;
    }

    public String getCodAeroportoOrigem() {
        return codAeroportoOrigem;
    }

    public String getCodAeroportoDestino() {
        return codAeroportoDestino;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    @Override
    public String toString() {
        return "Voo " + numeroVoo + " para " + codAeroportoDestino;
    }
}
