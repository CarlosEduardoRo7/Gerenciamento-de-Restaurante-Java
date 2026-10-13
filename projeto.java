import java.util.Scanner;
import java.time.LocalDateTime;

// Superclasse
class Usuario {
    public int ID;
    public String nome;
    public String CPF;
    public String telefone;

    public Usuario(int ID, String nome, String CPF, String telefone) {
        this.ID = ID;
        this.nome = nome;
        this.CPF = CPF;
        this.telefone = telefone;
    }

    public void mostrarDados() {
        System.out.println("\n----- INFORMAÇÕES CADASTRADAS ------");
        System.out.println("ID:       " + ID);
        System.out.println("Nome:     " + nome);
        System.out.println("CPF:      " + CPF);
        System.out.println("telefone: " + telefone);
    }
}

// Subclasse Cliente
class Cliente extends Usuario {
    public int idade;

    public Cliente(int ID, String nome, String CPF, String telefone, int idade) {
        super(ID, nome, CPF, telefone);
        this.idade = idade;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Idade:    " + idade);
    }
}

// Subclasse Funcionário
class Funcionario extends Usuario {
    public double salario;
    public String cargo;

    public Funcionario(int ID, String nome, String CPF, String telefone, double salario, String cargo) {
        super(ID, nome, CPF, telefone);
        this.salario = salario;
        this.cargo = cargo;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Cargo:    " + cargo);
        System.out.println("Salario:  R$ " + salario);
    }
}

public class projeto {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opc = 0;
        int ID_geral = 0;

        // Arrays de Clientes
        int[] ID_array = new int[10];
        String[] nome_array = new String[10];
        String[] CPF_array = new String[10];
        String[] telefone_array = new String[10];
        int[] idade_array = new int[10];

        // Arrays de Funcionários
        int ID_geral_func = 0;
        int[] ID_funcionario = new int[10];
        String[] nome_func_array = new String[10];
        String[] CPF_func_array = new String[10];
        String[] telefone_func_array = new String[10];
        String[] cargo_array = new String[10];
        double[] salario_array = new double[10];

        // Arrays de Produtos
        int ID_geral_prod = 0;
        int[] ID_produto = new int[10];
        String[] nome_prod_array = new String[10];
        String[] categoria_prod_array = new String[10];
        double[] valor_prod_array = new double[10];
        int[] estoque_prod_array = new int[10];

        // Arrays de Vendas
        int ID_geral_venda = 0;
        int[] ID_venda = new int[10];
        String[] cliente_venda_array = new String[10];
        String[] prod_venda_array = new String[10];
        int[] qtd_venda_array = new int[10];
        double[] valor_total_venda = new double[10];
        LocalDateTime[] data_venda_array = new LocalDateTime[10];

        do {
            // Menu Principal
            System.out.println("\n------ CONTROLE DO RESTAURANTE ------");
            System.out.println("[1] - Cadastrar");
            System.out.println("[2] - Pesquisar");
            System.out.println("[3] - Atualizar");
            System.out.println("[4] - Deletar");
            System.out.println("---------------------------------------");
            System.out.println("[5] - Ver Pedidos");
            System.out.println("[0] - Encerrar");
            System.out.println("---------------------------------------");
            System.out.println("Escolha:");
            opc = sc.nextInt();

            if (opc > 0 && opc <= 5) {

                switch (opc) {
                    case 1:
                        int opc2 = 0;

                        do {
                            // Menu de Cadastro
                            System.out.println("\n--------- OPÇÕES DE CADASTRO ---------");
                            System.out.println("[1] - Clientes");
                            System.out.println("[2] - Funcionários");
                            System.out.println("[3] - Pratos e Bebidas");
                            System.out.println("[4] - Vendas");
                            System.out.println("----------------------------------------");
                            System.out.println("[0] - Voltar");
                            System.out.println("----------------------------------------");
                            System.out.println("Escolha:");
                            opc2 = sc.nextInt();
                            sc.nextLine();

                            if (opc2 > 0 && opc2 < 5) {

                                if (opc2 == 1) {
                                    // Novo Cliente
                                    int ID = ID_geral + 1;

                                    System.out.println("\nDigite o nome do Cliente: ");
                                    String nome = sc.nextLine();

                                    System.out.println("\nDigite o CPF do Cliente: ");
                                    String CPF = sc.nextLine();

                                    System.out.println("\nDigite o telefone do Cliente: ");
                                    String telefone = sc.nextLine();

                                    System.out.println("\nDigite a idade do Cliente: ");
                                    int idade = sc.nextInt();
                                    sc.nextLine();

                                    if (idade <= 0 || idade > 120) {
                                        System.out.println("Erro, idade inválida.");
                                        break;
                                    }

                                    if (nome.trim().isEmpty() ||
                                            CPF.trim().isEmpty() ||
                                            telefone.trim().isEmpty()) {

                                        System.out.println("Erro, um ou mais campos estão em branco.");
                                        break;
                                    }

                                    Cliente cliente = new Cliente(ID, nome, CPF, telefone, idade);
                                    cliente.mostrarDados();

                                    ID_array[ID_geral] = ID;
                                    nome_array[ID_geral] = nome;
                                    CPF_array[ID_geral] = CPF;
                                    telefone_array[ID_geral] = telefone;
                                    idade_array[ID_geral] = idade;

                                    System.out.println("\nCliente cadastrado com sucesso!");
                                    ID_geral++;
                                    break;

                                } else if (opc2 == 2) {
                                    // Novo Funcionário
                                    int ID = ID_geral_func + 1;

                                    System.out.println("\nDigite o nome do Funcionário: ");
                                    String nome = sc.nextLine();

                                    System.out.println("\nDigite o CPF do Funcionário: ");
                                    String CPF = sc.nextLine();

                                    System.out.println("\nDigite o telefone do Funcionário: ");
                                    String telefone = sc.nextLine();

                                    System.out.println("\nDigite o cargo do funcionário: ");
                                    String cargo = sc.nextLine();

                                    System.out.println("\nDigite o salário do Funcionário: ");
                                    double salario = sc.nextDouble();

                                    if (salario < 0) {
                                        System.out.println("Erro, salário inválido.");
                                        break;
                                    }

                                    // Is empty verifica se a String ta vazia

                                    if (nome.trim().isEmpty() ||
                                            CPF.trim().isEmpty() ||
                                            telefone.trim().isEmpty() ||
                                            cargo.trim().isEmpty()) {

                                        System.out.println("Erro, um ou mais campos estão em branco.");
                                        break;
                                    }

                                    Funcionario funcionario = new Funcionario(ID, nome, CPF, telefone, salario, cargo);
                                    funcionario.mostrarDados();

                                    ID_funcionario[ID_geral_func] = ID;
                                    nome_func_array[ID_geral_func] = nome;
                                    CPF_func_array[ID_geral_func] = CPF;
                                    telefone_func_array[ID_geral_func] = telefone;
                                    cargo_array[ID_geral_func] = cargo;
                                    salario_array[ID_geral_func] = salario;

                                    System.out.println("\nFuncionário cadastrado com sucesso!");
                                    ID_geral_func++;
                                    break;

                                } else if (opc2 == 3) {
                                    // Novo Produto
                                    int ID = ID_geral_prod + 1;

                                    System.out.println("\nDigite o nome do Produto: ");
                                    String nome = sc.nextLine();

                                    System.out.println("\nDigite a categoria do Produto: ");
                                    System.out.println("Ex: Sobremesa, Tábuas...");
                                    String categoria = sc.nextLine();

                                    System.out.println("\nDigite o valor do Produto: ");
                                    double valor = sc.nextDouble();

                                    System.out.println("\nDigite o estoque do Produto: ");
                                    int estoque = sc.nextInt();

                                    if (nome.trim().isEmpty() || categoria.trim().isEmpty()) {
                                        System.out.println("Erro, nome ou categoria estão em branco.");
                                        break;
                                    }

                                    if (valor <= 0) {
                                        System.out.println("Erro, valor deve ser maior que zero.");
                                        break;
                                    }

                                    if (estoque < 0) {
                                        System.out.println("Erro, estoque não pode ser negativo.");
                                        break;
                                    }

                                    ID_produto[ID_geral_prod] = ID;
                                    nome_prod_array[ID_geral_prod] = nome;
                                    valor_prod_array[ID_geral_prod] = valor;
                                    categoria_prod_array[ID_geral_prod] = categoria;
                                    estoque_prod_array[ID_geral_prod] = estoque;

                                    System.out.println("\nID: " + ID);
                                    System.out.println("Nome: " + nome);
                                    System.out.println("Categoria: " + categoria);
                                    System.out.println("Valor: " + valor);
                                    System.out.println("Estoque: " + estoque);

                                    System.out.println("\nProduto cadastrado com Sucesso! ");

                                    ID_geral_prod++;
                                    break;

                                } else if (opc2 == 4) {
                                    // Cadastro de Vendas
                                    System.out.println("\nDigite o Nome do cliente para vincular à venda: ");
                                    String buscaCliente = sc.nextLine();
                                    boolean clienteValido = false;

                                    for (int i = 0; i < ID_geral; i++) {
                                        if (nome_array[i] != null && nome_array[i].equalsIgnoreCase(buscaCliente)) {
                                            clienteValido = true;
                                            break;
                                        }
                                    }

                                    if (!clienteValido) {
                                        System.out.println("\nCliente não encontrado.");
                                        break;
                                    }

                                    System.out.println("\nDigite o Nome do Prato: ");
                                    String buscaProd = sc.nextLine();
                                    int indexProd = -1;

                                    for (int i = 0; i < ID_geral_prod; i++) {
                                        if (nome_prod_array[i] != null
                                                && nome_prod_array[i].equalsIgnoreCase(buscaProd)) {
                                            indexProd = i;
                                            break;
                                        }
                                    }

                                    if (indexProd == -1) {
                                        System.out.println("\nProduto não cadastrado.");
                                        break;
                                    }

                                    System.out.println("\nDigite a quantidade: ");
                                    int qtdVenda = sc.nextInt();
                                    sc.nextLine();

                                    if (qtdVenda <= 0) {
                                        System.out.println("\nQuantidade inválida.");
                                        break;
                                    }

                                    if (estoque_prod_array[indexProd] < qtdVenda) {
                                        System.out.println("\nEstoque insuficiente. Unidades disponíveis: "
                                                + estoque_prod_array[indexProd]);
                                        break;
                                    }

                                    estoque_prod_array[indexProd] = estoque_prod_array[indexProd] - qtdVenda;

                                    int IDVenda = ID_geral_venda + 1;
                                    double total = valor_prod_array[indexProd] * qtdVenda;

                                    LocalDateTime dataVenda = LocalDateTime.now();

                                    ID_venda[ID_geral_venda] = IDVenda;
                                    cliente_venda_array[ID_geral_venda] = buscaCliente;
                                    prod_venda_array[ID_geral_venda] = nome_prod_array[indexProd];
                                    qtd_venda_array[ID_geral_venda] = qtdVenda;
                                    valor_total_venda[ID_geral_venda] = total;
                                    data_venda_array[ID_geral_venda] = dataVenda;

                                    System.out.println("\nID Venda: " + IDVenda);
                                    System.out.println("Cliente:  " + buscaCliente);
                                    System.out.println("Produto:  " + nome_prod_array[indexProd]);
                                    System.out.println("Qtd:      " + qtdVenda);
                                    System.out.println("Total:    R$ " + total);
                                    System.out.println("Data:    " + dataVenda);

                                    ID_geral_venda++;
                                    break;
                                }

                            } else {
                                if (opc2 != 0) {
                                    System.out.println("\nOpção Inválida, tente novamente");
                                } else {
                                    break;
                                }
                            }

                        } while (opc2 != 0);
                        break;

                    case 2:
                        int opc3 = 0;

                        do {
                            // Menu de Pesquisa
                            System.out.println("\n--------- OPÇÕES DE PESQUISA ---------");
                            System.out.println("[1] - Clientes");
                            System.out.println("[2] - Funcionários");
                            System.out.println("[3] - Pratos e Bebidas");
                            System.out.println("[4] - Vendas");
                            System.out.println("----------------------------------------");
                            System.out.println("[0] - Voltar");
                            System.out.println("----------------------------------------");
                            System.out.println("Escolha:");
                            opc3 = sc.nextInt();
                            sc.nextLine();

                            if (opc3 > 0 && opc3 <= 4) {

                                if (opc3 == 1) {
                                    // Pesquisa de Cliente
                                    System.out.println("\nDigite o Nome do cliente para pesquisa: ");
                                    String busca = sc.nextLine();
                                    boolean encontrado = false;

                                    for (int i = 0; i < ID_geral; i++) {
                                        if (nome_array[i] != null && nome_array[i].equalsIgnoreCase(busca)) {
                                            System.out.println("\nCliente Encontrado!");
                                            System.out.println("\nID: " + ID_array[i]);
                                            System.out.println("Nome: " + nome_array[i]);
                                            System.out.println("CPF: " + CPF_array[i]);
                                            System.out.println("telefone: " + telefone_array[i]);
                                            System.out.println("idade: " + idade_array[i]);
                                            encontrado = true;
                                            break;
                                        }
                                    }

                                    if (!encontrado) {
                                        System.out.println("\nCliente não encontrado.");
                                    }

                                } else if (opc3 == 2) {
                                    // Pesquisa de Funcionário
                                    System.out.println("\nDigite o Nome do Funcionário para pesquisa: ");
                                    String busca = sc.nextLine();
                                    boolean encontrado = false;

                                    for (int i = 0; i < ID_geral_func; i++) {
                                        if (nome_func_array[i] != null && nome_func_array[i].equalsIgnoreCase(busca)) {
                                            System.out.println("\nFuncionário Encontrado!");
                                            System.out.println("\nID: " + ID_funcionario[i]);
                                            System.out.println("Nome: " + nome_func_array[i]);
                                            System.out.println("CPF: " + CPF_func_array[i]);
                                            System.out.println("telefone: " + telefone_func_array[i]);
                                            System.out.println("Cargo: " + cargo_array[i]);
                                            System.out.println("Salário: R$ " + salario_array[i]);
                                            encontrado = true;
                                            break;
                                        }
                                    }

                                    if (!encontrado) {
                                        System.out.println("\nFuncionário não encontrado.");
                                    }
                                } else if (opc3 == 3) {
                                    // Pesquisa de Pratos e Bebidas
                                    System.out.println("\nDigite o Nome do Produto para pesquisa: ");
                                    String busca = sc.nextLine();
                                    boolean encontrado = false;

                                    for (int i = 0; i < ID_geral_prod; i++) {

                                        if (nome_prod_array[i] != null && nome_prod_array[i].equalsIgnoreCase(busca)) {
                                            System.out.println("\nProduto Encontrado!");
                                            System.out.println("\nID: " + ID_produto[i]);
                                            System.out.println("Nome: " + nome_prod_array[i]);
                                            System.out.println("Categoria: " + categoria_prod_array[i]);
                                            System.out.println("Valor: R$ " + valor_prod_array[i]);
                                            System.out.println("Estoque: " + estoque_prod_array[i]);
                                            encontrado = true;
                                            break;
                                        }
                                    }

                                    if (!encontrado) {
                                        System.out.println("\nProduto não encontrado.");
                                    }
                                } else if (opc3 == 4) {
                                    // Pesquisa de Vendas
                                    System.out.println("\nDigite o Nome do Cliente: ");
                                    String buscaVenda = sc.nextLine();
                                    boolean encontrado = false;

                                    for (int i = 0; i < ID_geral_venda; i++) {
                                        if (cliente_venda_array[i] != null
                                                && cliente_venda_array[i].equalsIgnoreCase(buscaVenda)) {
                                            System.out.println("----------------------------------");
                                            System.out.println("ID Venda: " + ID_venda[i]);
                                            System.out.println("Cliente:  " + cliente_venda_array[i]);
                                            System.out.println("Produto:  " + prod_venda_array[i]);
                                            System.out.println("Qtd:      " + qtd_venda_array[i]);
                                            System.out.println("Total:    R$ " + valor_total_venda[i]);
                                            System.out.println("Data:     " + data_venda_array[i]);
                                            System.out.println("----------------------------------");
                                            encontrado = true;
                                        }
                                    }

                                    if (!encontrado) {
                                        System.out.println("\nNenhuma venda encontrada para este cliente.");
                                    }
                                }
                            } else {
                                if (opc3 != 0) {
                                    System.out.println("\nOpção Inválida, tente novamente");
                                } else {
                                    break;
                                }
                            }

                        } while (opc3 != 0);
                        break;

                    case 3:
                        int opc4 = 0;

                        do {
                            System.out.println("\n--------- OPÇÕES DE ATUALIZAÇÃO ---------");
                            System.out.println("[1] - Clientes");
                            System.out.println("[2] - Funcionários");
                            System.out.println("[3] - Pratos e Bebidas");
                            System.out.println("----------------------------------------");
                            System.out.println("[0] - Voltar");
                            System.out.println("----------------------------------------");
                            System.out.println("Escolha:");
                            opc4 = sc.nextInt();
                            sc.nextLine();

                            if (opc4 == 1) {
                                System.out.println("\nDigite o Nome do Cliente para atualizar: ");
                                String buscaNome = sc.nextLine();
                                int index = -1;

                                for (int i = 0; i < ID_geral; i++) {
                                    if (nome_array[i] != null && nome_array[i].equalsIgnoreCase(buscaNome)) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    System.out.println(
                                            "\nDigite o novo nome do Cliente (Deixe em branco se não for mudar )");
                                    String novoNome = sc.nextLine();
                                    if (!novoNome.trim().isEmpty()) {
                                        nome_array[index] = novoNome;
                                    }

                                    System.out.println(
                                            "\nDigite o novo CPF do Cliente (Deixe em branco se não for mudar )");
                                    String novoCPF = sc.nextLine();
                                    if (!novoCPF.trim().isEmpty()) {
                                        CPF_array[index] = novoCPF;
                                    }

                                    System.out.println(
                                            "\nDigite o novo telefone do Cliente (Deixe em branco se não for mudar )");
                                    String novoTelefone = sc.nextLine();
                                    if (!novoTelefone.trim().isEmpty()) {
                                        telefone_array[index] = novoTelefone;
                                    }

                                    System.out.println(
                                            "\nDigite a nova idade do Cliente (Deixe em branco se não for mudar )");
                                    String novaIdadeStr = sc.nextLine();
                                    if (!novaIdadeStr.trim().isEmpty()) {
                                        idade_array[index] = Integer.parseInt(novaIdadeStr);
                                    }

                                    Cliente clienteAtu = new Cliente(ID_array[index], nome_array[index],
                                            CPF_array[index], telefone_array[index], idade_array[index]);
                                    clienteAtu.mostrarDados();
                                    System.out.println("\nCliente atualizado com sucesso!");
                                } else {
                                    System.out.println("\nCliente não encontrado.");
                                }

                            } else if (opc4 == 2) {
                                System.out.println("\nDigite o Nome do Funcionário para atualizar: ");
                                String buscaNome = sc.nextLine();
                                int index = -1;

                                for (int i = 0; i < ID_geral_func; i++) {
                                    if (nome_func_array[i] != null && nome_func_array[i].equalsIgnoreCase(buscaNome)) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    System.out.println(
                                            "\nDigite o novo nome do Funcionário (Deixe em branco se não for mudar )");
                                    String novoNome = sc.nextLine();
                                    if (!novoNome.trim().isEmpty()) {
                                        nome_func_array[index] = novoNome;
                                    }

                                    System.out.println(
                                            "\nDigite o novo CPF do Funcionário (Deixe em branco se não for mudar )");
                                    String novoCPF = sc.nextLine();
                                    if (!novoCPF.trim().isEmpty()) {
                                        CPF_func_array[index] = novoCPF;
                                    }

                                    System.out.println(
                                            "\nDigite o novo telefone do Funcionário (Deixe em branco se não for mudar )");
                                    String novoTelefone = sc.nextLine();
                                    if (!novoTelefone.trim().isEmpty()) {
                                        telefone_func_array[index] = novoTelefone;
                                    }

                                    System.out.println(
                                            "\nDigite o novo cargo do Funcionário (Deixe em branco se não for mudar )");
                                    String novoCargo = sc.nextLine();
                                    if (!novoCargo.trim().isEmpty()) {
                                        cargo_array[index] = novoCargo;
                                    }

                                    System.out.println(
                                            "\nDigite o novo salário do Funcionário (Deixe em branco se não for mudar )");
                                    String novoSalarioStr = sc.nextLine();
                                    if (!novoSalarioStr.trim().isEmpty()) {
                                        salario_array[index] = Double.parseDouble(novoSalarioStr);
                                    }

                                    Funcionario funcAtu = new Funcionario(ID_funcionario[index], nome_func_array[index],
                                            CPF_func_array[index], telefone_func_array[index], salario_array[index],
                                            cargo_array[index]);
                                    funcAtu.mostrarDados();
                                    System.out.println("\nFuncionário atualizado com sucesso!");
                                } else {
                                    System.out.println("\nFuncionário não encontrado.");
                                }

                            } else if (opc4 == 3) {
                                System.out.println("\nDigite o Nome do Produto para atualizar: ");
                                String buscaNome = sc.nextLine();
                                int index = -1;

                                for (int i = 0; i < ID_geral_prod; i++) {
                                    if (nome_prod_array[i] != null && nome_prod_array[i].equalsIgnoreCase(buscaNome)) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    System.out.println(
                                            "\nDigite o novo nome do Produto (Deixe em branco se não for mudar )");
                                    String novoNome = sc.nextLine();
                                    if (!novoNome.trim().isEmpty()) {
                                        nome_prod_array[index] = novoNome;
                                    }

                                    System.out.println(
                                            "\nDigite a nova categoria do Produto (Deixe em branco se não for mudar )");
                                    String novaCategoria = sc.nextLine();
                                    if (!novaCategoria.trim().isEmpty()) {
                                        categoria_prod_array[index] = novaCategoria;
                                    }

                                    System.out.println(
                                            "\nDigite o novo valor do Produto (Deixe em branco se não for mudar )");
                                    String novoValorStr = sc.nextLine();
                                    if (!novoValorStr.trim().isEmpty()) {
                                        valor_prod_array[index] = Double.parseDouble(novoValorStr);
                                    }

                                    System.out.println(
                                            "\nDigite o novo estoque do Produto (Deixe em branco se não for mudar )");
                                    String novoEstoqueStr = sc.nextLine();
                                    if (!novoEstoqueStr.trim().isEmpty()) {
                                        estoque_prod_array[index] = Integer.parseInt(novoEstoqueStr);
                                    }

                                    System.out.println("\nID: " + ID_produto[index]);
                                    System.out.println("Nome: " + nome_prod_array[index]);
                                    System.out.println("Categoria: " + categoria_prod_array[index]);
                                    System.out.println("Valor: " + valor_prod_array[index]);
                                    System.out.println("Estoque: " + estoque_prod_array[index]);
                                    System.out.println("\nProduto atualizado com sucesso!");
                                } else {
                                    System.out.println("\nProduto não encontrado.");
                                }
                            } else {
                                if (opc4 != 0) {
                                    System.out.println("\nOpção Inválida, tente novamente");
                                }
                            }
                        } while (opc4 != 0);
                        break;

                    case 4:
                        int opc5 = 0;
                        do {
                            System.out.println("\n--------- OPÇÕES DE EXCLUSÃO ---------");
                            System.out.println("[1] - Clientes");
                            System.out.println("[2] - Funcionários");
                            System.out.println("[3] - Pratos e Bebidas");
                            System.out.println("[4] - Vendas");
                            System.out.println("----------------------------------------");
                            System.out.println("[0] - Voltar");
                            System.out.println("----------------------------------------");
                            System.out.println("Escolha:");
                            opc5 = sc.nextInt();
                            sc.nextLine();

                            // Utilizei o "index" para não me perder, nessa altura o código já estava com
                            // muitas linhas

                            if (opc5 == 1) {
                                System.out.println("\nDigite o Nome do Cliente para deletar: ");
                                String buscaNome = sc.nextLine();
                                int index = -1;

                                for (int i = 0; i < ID_geral; i++) {
                                    if (nome_array[i] != null && nome_array[i].equalsIgnoreCase(buscaNome)) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    nome_array[index] = null;
                                    CPF_array[index] = null;
                                    telefone_array[index] = null;
                                    ID_array[index] = 0;
                                    idade_array[index] = 0;
                                    System.out.println("\nCliente deletado com sucesso!");
                                } else {
                                    System.out.println("\nCliente não encontrado.");
                                }

                            } else if (opc5 == 2) {
                                System.out.println("\nDigite o Nome do Funcionário para deletar: ");
                                String buscaNome = sc.nextLine();
                                int index = -1;

                                for (int i = 0; i < ID_geral_func; i++) {
                                    if (nome_func_array[i] != null && nome_func_array[i].equalsIgnoreCase(buscaNome)) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    nome_func_array[index] = null;
                                    CPF_func_array[index] = null;
                                    telefone_func_array[index] = null;
                                    cargo_array[index] = null;
                                    ID_funcionario[index] = 0;
                                    salario_array[index] = 0.0;
                                    System.out.println("\nFuncionário deletado com sucesso!");
                                } else {
                                    System.out.println("\nFuncionário não encontrado.");
                                }

                            } else if (opc5 == 3) {
                                System.out.println("\nDigite o Nome do Produto para deletar: ");
                                String buscaNome = sc.nextLine();
                                int index = -1;

                                for (int i = 0; i < ID_geral_prod; i++) {
                                    if (nome_prod_array[i] != null && nome_prod_array[i].equalsIgnoreCase(buscaNome)) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    nome_prod_array[index] = null;
                                    categoria_prod_array[index] = null;
                                    ID_produto[index] = 0;
                                    valor_prod_array[index] = 0.0;
                                    estoque_prod_array[index] = 0;
                                    System.out.println("\nProduto deletado com sucesso!");
                                } else {
                                    System.out.println("\nProduto não encontrado.");
                                }

                            } else if (opc5 == 4) {

                                System.out.println("\nVendas cadastradas:");

                                for (int i = 0; i < ID_geral_venda; i++) {
                                    if (ID_venda[i] != 0) {
                                        System.out.println(
                                                "ID: " + ID_venda[i] +
                                                        " | Cliente: " + cliente_venda_array[i] +
                                                        " | Produto: " + prod_venda_array[i] +
                                                        " | Total: R$ " + valor_total_venda[i]);
                                    }
                                }

                                System.out.println("\nDigite o ID da venda para deletar: ");
                                int buscaID = sc.nextInt();
                                sc.nextLine();

                                int index = -1;

                                for (int i = 0; i < ID_geral_venda; i++) {
                                    if (ID_venda[i] == buscaID) {
                                        index = i;
                                        break;
                                    }
                                }

                                if (index != -1) {
                                    ID_venda[index] = 0;
                                    cliente_venda_array[index] = null;
                                    prod_venda_array[index] = null;
                                    qtd_venda_array[index] = 0;
                                    valor_total_venda[index] = 0.0;
                                    data_venda_array[index] = null;

                                    System.out.println("\nVenda deletada com sucesso!");
                                } else {
                                    System.out.println("\nVenda não encontrada.");
                                }

                            } else {
                                if (opc5 != 0) {
                                    System.out.println("\nOpção Inválida, tente novamente");
                                }
                            }
                        } while (opc5 != 0);
                        break;
                    case 5:
                        System.out.println("\nVendas cadastradas:");

                        for (int i = 0; i < ID_geral_venda; i++) {
                            if (ID_venda[i] != 0) {
                                System.out.println(
                                        "ID: " + ID_venda[i] +
                                                " | Cliente: " + cliente_venda_array[i] +
                                                " | Produto: " + prod_venda_array[i] +
                                                " | Total: R$ " + valor_total_venda[i]);
                            }
                        }
                }

            } else {
                if (opc != 0) {
                    System.out.println("\nOpção Inválida, tente novamente");
                }
            }

        } while (opc != 0);

        sc.close();
        System.out.println("\nPrograma encerrado...\n");
    }
}