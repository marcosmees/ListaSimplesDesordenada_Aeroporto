public class Voos {
    private ListaSimplesDesordenada<Voo> listaDeVoos;
    private Aeroportos aeroportos = new Aeroportos();
     
    public Voos() {
        this.listaDeVoos = new ListaSimplesDesordenada<>();
    }

    public void cadastrarVoo(String aeroportoDeOrigem, String aeroportoDeDestino, int numeroVoo) throws Exception {
        if(aeroportos.encontrarAeroporto(aeroportoDeOrigem) == null)
            throw new Exception("Aeroporto de origem inválido");
  
        if(aeroportos.encontrarAeroporto(aeroportoDeDestino) == null)
            throw new Exception("Aeroporto de destino inválido");
        
        try {
            Voo voo = new Voo(aeroportoDeOrigem, aeroportoDeDestino, numeroVoo);
            
            Aeroporto origem = aeroportos.encontrarAeroporto(aeroportoDeOrigem);
            if(!VooExistenteNaListaDeAeroportos(aeroportoDeOrigem, numeroVoo))
                origem.getListaDeVoosDeUmAeroporto().guardeUmItemNoFinal(voo);
            
        } catch (Exception e) {
            System.out.println("Voo não cadastrado");
        }
    }

    public Boolean VooExistenteNaListaDeAeroportos(String aeroportoDeOrigem, int numeroVoo) throws Exception{
       if(numeroVoo < 0)
            throw new Exception("O numero de voo deve ser um numero positivo");

        Aeroporto origem = aeroportos.encontrarAeroporto(aeroportoDeOrigem);
        if(origem == null)
            throw new Exception("Aeroporto inexistente");

        ListaSimplesDesordenada<Voo> listaParaPercorrer = origem.getListaDeVoosDeUmAeroporto();

        int tamanho = listaParaPercorrer.getQuantidade();

        for (int i = 0; i < tamanho; i++) {
            Voo voo = listaParaPercorrer.getQualquerUm(i);
            //No caso se o voo tiver cod de origem e cod de destino iguais ao voo comparado, mas numero difente,
            //pode ser que outra companhia tenha voo com o mesmo aeroporto de origem e de destino
            if (voo.getCodAeroportoOrigem().equals(aeroportoDeOrigem) && voo.getNumeroVoo() == numeroVoo) {
                return true;
            }
        }

        return false;
    }

    //preciso saber o cod do aeroporto para pegar a lista do mesmo
    public Voo buscarVooEmListaDeVoos(String codAeroporto, int numeroVoo) throws Exception{
        if(numeroVoo < 0)
            throw new Exception("O numero de voo deve ser um numero positivo");
            
        Aeroporto origem = aeroportos.encontrarAeroporto(codAeroporto);
        if(origem == null)
            throw new Exception("Aeroporto inexistente");

        ListaSimplesDesordenada<Voo> listaParaPercorrer = origem.getListaDeVoosDeUmAeroporto();

        int tamanho = listaParaPercorrer.getQuantidade();

        for (int i = 0; i < tamanho; i++) {
            Voo voo = listaParaPercorrer.getQualquerUm(i);
            if (voo.getCodAeroportoOrigem().equals(codAeroporto) && voo.getNumeroVoo() == numeroVoo) {
                return voo;
            }
        }
        throw new Exception("Voo não encontrado");
    }

    public void buscarListaDeVoosDeAeroporto(){

    }

    public void excluirVoo(String codAeroporto, String codOrigem, int numeroVoo) throws Exception {
        //Aeroporto aeroporto = buscarAeroporto(codAeroporto);
        //aeroporto.excluirVoo(codOrigem, numeroVoo);
    }

    public void listarVoos(String codAeroporto) throws Exception {
        //Aeroporto aeroporto = buscarAeroporto(codAeroporto);
        //aeroporto.listarVoos();
    }

    
}