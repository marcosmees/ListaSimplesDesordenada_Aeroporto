// Classe contendo os metodos para realizar as operacoes do programa

public class Metodo {

    private Aeroportos aeroportos;
    private Voos voos;

    public Metodo() throws Exception {
        aeroportos = new Aeroportos();
        voos = new Voos();
    }

    // Método para adicionar os dados predefinidos na lista de aeroportos
    public void infoPreDefAeroporto() throws Exception {

        aeroportos.cadastrarAeroporto("Belo Horizonte", "CNF");
        aeroportos.cadastrarAeroporto("Brasilia", "BSB");
        aeroportos.cadastrarAeroporto("Rio de Janeiro", "GIG");
        aeroportos.cadastrarAeroporto("Salvador", "SSA");
        aeroportos.cadastrarAeroporto("Sao Paulo", "GRU");
        
    }
    public void infoPreDefVoo() throws Exception{

        voos.cadastrarVoo("CNF", "SSA", 123);
        voos.cadastrarVoo("CNF", "GIG", 456);
        voos.cadastrarVoo("CNF", "GRU", 789);
        voos.cadastrarVoo("SSA", "CNF", 890);
    }

    public void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("============ MENU ============");
            System.out.println("1. Cadastrar Aeroporto");
            System.out.println("2. Cadastrar Voo");
            System.out.println("3. Remover Voo");
            System.out.println("4. Listar Voos de um Aeroporto");
            System.out.println("5. Sair");
            System.out.println("==============================");
            System.out.print("Digite a opcao desejada: ");

            try {
                opcao = Teclado.getUmInt();

                switch (opcao) {
                    case 1:
                        cadastrarAeroporto();
                        System.out.println();
                        break;
                    case 2:
                        cadastrarVoo();
                        System.out.println();
                        break;
                    case 3:
                        removerVoo();
                        System.out.println();
                        break;
                    case 4:
                        listarVoos();
                        System.out.println();
                        break;
                    case 5:
                        sair();
                        break;
                    default:
                        System.out.println("\nOpcao invalida. Por favor, digite uma opcao valida.\n");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nOpcao invalida. Por favor, digite uma opcao valida.\n");
            }
        } while (opcao != 5);
    }

    private void cadastrarAeroporto() throws Exception {
        System.out.print("Digite o nome do aeroporto: ");
        String nome = Teclado.getUmString();
        
        String codigo;
        boolean codigoValido = false;
        do {
            System.out.print("Digite o código do aeroporto (três letras maiúsculas): ");
            codigo = Teclado.getUmString();
            if (codigo.matches("[A-Z]{3}")) {
                codigoValido = true;
            } else {
                System.out.println("Código inválido. Digite novamente.\n");
            }
        } while (!codigoValido);

        aeroportos.cadastrarAeroporto(nome, codigo);
        System.out.println("Aeroporto cadastrado com sucesso!\n");
    }

    private void cadastrarVoo() throws Exception {
        System.out.println(aeroportos.listarAeroportos()+ "\n");

        String origem;
        String destino;
        
        do {
            System.out.println("\nDigite o código do aeroporto de origem (três letras maiúsculas):");
            origem = Teclado.getUmString().toUpperCase();
            
            if (origem.length() != 3 || !origem.matches("[A-Z]{3}")) {
                System.out.println("Código do aeroporto de origem inválido. Deve conter três letras maiúsculas.");
            }
        } while (origem.length() != 3 || !origem.matches("[A-Z]{3}"));

        do {
            System.out.println("\nDigite o código do aeroporto de destino (três letras maiúsculas):");
            destino = Teclado.getUmString().toUpperCase();
            
            if (destino.length() != 3 || !destino.matches("[A-Z]{3}")) {
                System.out.println("Código do aeroporto de destino inválido. Deve conter três letras maiúsculas.");
            }
        } while (destino.length() != 3 || !destino.matches("[A-Z]{3}"));

        System.out.println("\nDigite o número do voo:");
        int numero = Teclado.getUmInt();

        Aeroporto aeroportoOrigem = aeroportos.encontrarAeroporto(origem);
        Aeroporto aeroportoDestino = aeroportos.encontrarAeroporto(destino);

        if (aeroportoOrigem == null) {
            System.out.println("Aeroporto de origem não encontrado");
        } else if (aeroportoDestino == null) {
            System.out.println("Aeroporto de destino não encontrado");
        } else {
            if (aeroportoOrigem.buscarVooEmAeroporto(origem, numero)) {
                System.out.println("Já existe um voo com esse número no aeroporto de origem");
            } else {
                voos.cadastrarVoo(origem, destino, numero);
                System.out.println("Voo cadastrado com sucesso");
            }
            
        }
    }

    private void removerVoo() {
        // Lógica para remover um voo
    }
     
    private void listarVoos() {
    }
        /*
        //fazer digitar
        String origem;

        do {
            System.out.println("Digite o código do aeroporto de origem (três letras maiúsculas):");
            origem = Teclado.getUmString().toUpperCase();

            if (origem.length() != 3 || !origem.matches("[A-Z]{3}")) {
                System.out.println("Código do aeroporto inválido. Deve conter três letras maiúsculas.");
            }
        } while (origem.length() != 3 || !origem.matches("[A-Z]{3}"));

        Aeroporto aeroportoOrigem = aeroporto.buscarAeroporto(origem);

        if (aeroportoOrigem == null) {
            System.out.println("Aeroporto de origem não encontrado");
        } else {
            voo.listarVoos(aeroportoOrigem);
        }
    }
*/
    private void sair() {
        System.out.println("\nEncerrando o programa...\nObrigado por utilizar o software da AER company.\n");
    }
}
