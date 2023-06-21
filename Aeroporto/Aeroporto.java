public class Aeroporto {
    private String codAeroporto;
    private String nomeAeroporto;
    private ListaSimplesDesordenada<Voo> listaDeVoos;
    private Aeroportos aeroportos;

    public Aeroporto(String nomeAeroporto, String codAeroporto) {
        this.nomeAeroporto = nomeAeroporto;
        this.codAeroporto = codAeroporto;
        this.listaDeVoos = new ListaSimplesDesordenada<Voo>();
    }

    public Aeroporto(){}

    public String getCodAeroporto() {
        return codAeroporto;
    }

    public String getNomeAeroporto() {
        return nomeAeroporto;
    }

    public ListaSimplesDesordenada<Voo> getListaDeVoosDeUmAeroporto(){
        return this.listaDeVoos;
    }
    
    public void cadastrarVooDeUmAeroporto(Voo voo) throws Exception {
        this.listaDeVoos.guardeUmItemNoFinal(voo);
    }
    
    public void excluirVooDeUmAeroporto(String codOrigem, int numeroVoo) throws Exception {
        //Voo voo = buscarVoo(codOrigem, numeroVoo);
        //listaDeVoos.removaItemIndicado(voo);
    }


    public void listarVoosDeUmAeroporto() {

        int tamanho = this.listaDeVoos.getQuantidade();
        for (int i = 0; i < tamanho; i++) {
            try {
                Voo voo = this.listaDeVoos.getQualquerUm(i);
                System.out.println("Código Origem: " + voo.getCodAeroportoOrigem());
                System.out.println("Código Destino: " + voo.getCodAeroportoDestino());
                System.out.println("Número do Voo: " + voo.getNumeroVoo());
                System.out.println("---------------------");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //adicionar exeção para cod origem e numero do voo
    public boolean buscarVooEmAeroporto(String codOrigem, int numeroVoo) throws Exception {
        if(numeroVoo < 0)
            throw new Exception("O numero de voo deve ser um numero positivo");

        Aeroporto aeroporto = aeroportos.encontrarAeroporto(codOrigem);
        if(aeroporto == null)
            throw new Exception("Aeroporto inexistente");

        ListaSimplesDesordenada<Voo> listaDeVoosAer = aeroporto.getListaDeVoosDeUmAeroporto();

        int tamanho = listaDeVoosAer.getQuantidade();

        for (int i = 0; i < tamanho; i++) {

            Voo voo = listaDeVoosAer.getQualquerUm(i);
            if (voo.getCodAeroportoOrigem().equals(codOrigem) && voo.getNumeroVoo() == numeroVoo) {
                return true;
            }

        }
        throw new Exception("Voo não encontrado");
    }

    
    
}