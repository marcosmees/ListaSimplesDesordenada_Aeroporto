public class Aeroportos {

    private ListaSimplesDesordenada<Aeroporto> listaDeAeroportos = new ListaSimplesDesordenada<>();

    public Aeroportos() {
    }
    
    public ListaSimplesDesordenada<Aeroporto> getListaAeroportos() {
        return listaDeAeroportos;
    }

    public int getTamanhoDaListaDeAeroportos(){
        int tamanhoDaLista = listaDeAeroportos.getQuantidade();
        return tamanhoDaLista;
    }

    public void cadastrarAeroporto(String nomeAeroporto, String codAeroporto) {
        try {
            Aeroporto aeroporto = new Aeroporto(nomeAeroporto, codAeroporto);
            listaDeAeroportos.guardeUmItemNoFinal(aeroporto);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar o aeroporto: " + e.getMessage());
        }
    }

    public String listarAeroportos() throws Exception {
        
        String ret = "Lista:\n";
        
        for(int i = 0 ; i != getTamanhoDaListaDeAeroportos(); i++){
            Aeroporto aeroporto = listaDeAeroportos.getQualquerUm(i);
            ret = ret + "Nome: " +aeroporto.getNomeAeroporto() + "    Código:" + aeroporto.getCodAeroporto() + "\n";
        }
        
        return ret;
            
    }

    public Aeroporto encontrarAeroporto(String codigo) throws Exception{    

        for(int i = 0; i != getTamanhoDaListaDeAeroportos(); i++){
            Aeroporto aeroporto = listaDeAeroportos.getQualquerUm(i);
            if(aeroporto.getCodAeroporto().equals(codigo)){
                return aeroporto;
            }
        }
        throw new Exception("Aeroporto não encontrado");
    }
}