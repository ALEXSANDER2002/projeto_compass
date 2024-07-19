package compass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import produto.util;
import produto.comida;
import produto.saude;
import projeto.lista;
import projeto.selecao;
import projeto.tamanho;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Listas para gerenciar abrigos, pedidos e centros de distribuição
        ArrayList<lista> toAddShelters = new ArrayList<>(); // Lista de abrigos aguardando validação
        ArrayList<lista> trustedShelters = new ArrayList<>(); // Lista de abrigos validados
        ArrayList<selecao> selecaos = new ArrayList<>(); // Lista de pedidos
        ArrayList<tamanho> tamanhos = new ArrayList<>(); // Lista de centros de distribuição

        // Inicializa centros de distribuição e abrigos
        inicializarCentrosDistribuicao(tamanhos);
        inicializarAbrigos(toAddShelters, trustedShelters);

        int entry = -1;
        while (entry != 0) {
            exibirMenuPrincipal();
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry) {
                case 1:
                    handleManager(sc, toAddShelters, trustedShelters);
                    break;
                case 2:
                    handleShelter(sc, toAddShelters, trustedShelters, selecaos);
                    break;
                case 3:
                    handleCenter(sc, tamanhos, selecaos);
                    break;
            }
        }
        sc.close();
    }

    private static void inicializarCentrosDistribuicao(ArrayList<tamanho> tamanhos) {
        tamanhos.add(new tamanho("Centro de Distribuição Esperança", "Av. Boqueirão", 2450, "RS", 92032 - 420));
        tamanhos.add(new tamanho("Centro de Distribuição Prosperidade", "Av. Borges de Medeiros", 1501, "RS", 90119 - 900));
        tamanhos.add(new tamanho("Centro de Distribuição Reconstrução", "R. Dr. Décio Martins Costa", 312, "RS", 94920 - 170));
    }

    private static void inicializarAbrigos(ArrayList<lista> toAddShelters, ArrayList<lista> trustedShelters) {
        toAddShelters.add(new lista("Felicidade", "Rua Nova Casa", "Joao", "(16) 91293-1092", "felicidadeabrigo@gmail.com", 100, 80));
        toAddShelters.add(new lista("Esperantina", "Rua Brasil Raiz", "Maria", "(16) 91234-1897", "esperantinaabrigo@gmail.com", 150, 100));
        trustedShelters.add(new lista("Novissimo", "Rua Governador", "Pedro", "(18) 96789-6970", "novissimoabrigo@gmail.com", 200, 120));
    }

    private static void exibirMenuPrincipal() {
        // Menu principal
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1 - Painel");
        System.out.println("2 - Abrigo");
        System.out.println("3 - Centro de Distribuição");
        System.out.println("0 - Sair");
    }

    // Gerencia a lógica do painel
    public static void handleManager(Scanner sc, ArrayList<lista> toAddShelters, ArrayList<lista> trustedShelters) {
        int entry = -1;

        while (entry != 0) {
            exibirMenuGerente();
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry) {
                case 1:
                    cadastrarAbrigo(sc, toAddShelters);
                    break;
                case 2:
                    verificarAbrigo(sc, toAddShelters, trustedShelters);
                    break;
                case 3:
                    recusarAbrigo(sc, toAddShelters);
                    break;
                case 4:
                    listarAbrigos(toAddShelters, trustedShelters);
                    break;
                case 5:
                    removerAbrigo(sc, trustedShelters);
                    break;
            }
        }
    }

    private static void exibirMenuGerente() {
        // Menu do gerente
        System.out.println("===== MENU GERENTE =====");
        System.out.println("1 - Cadastrar abrigo");
        System.out.println("2 - Verificar um Abrigo");
        System.out.println("3 - Recusar um abrigo");
        System.out.println("4 - Lista de abrigos");
        System.out.println("5 - Remover Abrigo");
        System.out.println("0 - Sair");
    }

    private static void cadastrarAbrigo(Scanner sc, ArrayList<lista> toAddShelters) {
        // Coleta informações para cadastrar um novo abrigo
        System.out.println("Digite o nome do abrigo:");
        String shelterName = sc.nextLine();

        System.out.println("Digite o endereço do abrigo:");
        String shelterAddress = sc.nextLine();

        System.out.println("Digite o gerente do abrigo:");
        String shelterManager = sc.nextLine();

        System.out.println("Digite o telefone do abrigo:");
        String shelterPhone = sc.nextLine();

        System.out.println("Digite o email do abrigo:");
        String shelterEmail = sc.nextLine();

        System.out.println("Digite a capacidade do abrigo:");
        int shelterCapacity = sc.nextInt();

        System.out.println("Digite a ocupação do abrigo:");
        int shelterOccupation = sc.nextInt();

        // Cria e adiciona o abrigo à lista de abrigos a serem verificados
        lista s = new lista(shelterName, shelterAddress, shelterManager, shelterPhone, shelterEmail, shelterCapacity, shelterOccupation);
        toAddShelters.add(s);

        System.out.println("Abrigo cadastrado com sucesso!");
    }

    private static void verificarAbrigo(Scanner sc, ArrayList<lista> toAddShelters, ArrayList<lista> trustedShelters) {
        // Exibe abrigos a serem verificados e permite ao gerente autorizar um deles
        int list = 1;

        System.out.println("Escolha um abrigo para autorizar:");
        for (lista x : toAddShelters) {
            System.out.println(list + " - " + x);
            list++;
        }

        int selectedShelter = sc.nextInt() - 1;
        trustedShelters.add(toAddShelters.get(selectedShelter));
        toAddShelters.remove(selectedShelter);
    }

    private static void recusarAbrigo(Scanner sc, ArrayList<lista> toAddShelters) {
        // Exibe abrigos a serem verificados e permite ao gerente recusar um deles
        int list = 1;

        System.out.println("Escolha um abrigo para recusar:");
        for (lista x : toAddShelters) {
            System.out.println(list + " - " + x);
            list++;
        }

        int selectedShelter = sc.nextInt() - 1;
        toAddShelters.remove(selectedShelter);
    }

    private static void listarAbrigos(ArrayList<lista> toAddShelters, ArrayList<lista> trustedShelters) {
        // Lista abrigos autorizados e a serem verificados
        int list = 1;

        System.out.println("Abrigos autorizados:");
        for (lista x : trustedShelters) {
            System.out.println(list + " - " + x);
            list++;
        }

        list = 1;
        System.out.println("Abrigos a serem verificados:");
        for (lista x : toAddShelters) {
            System.out.println(list + " - " + x);
            list++;
        }
    }

    private static void removerAbrigo(Scanner sc, ArrayList<lista> trustedShelters) {
        // Exibe abrigos autorizados e permite ao gerente remover um deles
        int list = 1;

        System.out.println("Escolha um abrigo para remover:");
        for (lista x : trustedShelters) {
            System.out.println(list + " - " + x);
            list++;
        }

        int selectedShelter = sc.nextInt() - 1;
        trustedShelters.remove(selectedShelter);

        System.out.println("Abrigo removido com sucesso!");
    }

    // Lógica da aba Abrigo
    public static void handleShelter(Scanner sc, ArrayList<lista> toAddShelters, ArrayList<lista> trustedShelters, ArrayList<selecao> orders) {
        int entry = -1;

        while (entry != 0) {
            // Seleciona um abrigo autorizado
            lista selectedShelter = selecionarAbrigo(sc, trustedShelters);

            exibirMenuAbrigo();
            entry = sc.nextInt();
            sc.nextLine();

            switch (entry) {
                case 1:
                    selectedShelter.addOrder(sc, orders);
                    System.out.println("Pedido adicionado: " + orders);
                    entry = -1;
                    break;
                case 2:
                    atualizarPopulacao(sc, selectedShelter);
                    break;
                case 3:
                    verInventario(selectedShelter);
                    break;
            }
        }
    }

    private static void exibirMenuAbrigo() {
        // Menu do abrigo
        System.out.println("===== MENU ABRIGO =====");
        System.out.println("1 - Solicitar doação");
        System.out.println("2 - Atualizar população");
        System.out.println("3 - Ver inventário");
        System.out.println("0 - Sair");
    }

    private static lista selecionarAbrigo(Scanner sc, ArrayList<lista> trustedShelters) {
        int list = 1;

        // Exibe a lista de abrigos autorizados
        System.out.println("Escolha um abrigo:");
        for (lista x : trustedShelters) {
            System.out.println(list + " - " + x);
            list++;
        }

        return trustedShelters.get(sc.nextInt() - 1);
    }

    private static void atualizarPopulacao(Scanner sc, lista selectedShelter) {
        // Atualiza a ocupação do abrigo selecionado
        System.out.println("Digite a nova ocupação do abrigo:");
        selectedShelter.setOccupation(sc.nextInt());
        sc.nextLine();
        System.out.println("Ocupação atualizada: " + selectedShelter);
    }

    private static void verInventario(lista selectedShelter) {
        // Exibe o inventário do abrigo selecionado
        System.out.println("Roupas:");
        for (util x : selectedShelter.getClothes()) {
            System.out.println(x);
        }
        System.out.println("Comidas:");
        for (comida x : selectedShelter.getFood()) {
            System.out.println(x);
        }
        System.out.println("Higiene:");
        for (saude x : selectedShelter.getHygiene()) {
            System.out.println(x);
        }
    }

    // Lógica da aba Centro de Distribuição
    public static void handleCenter(Scanner sc, ArrayList<tamanho> centers, ArrayList<selecao> orders) {
        int entry = -1;

        while (entry != 0) {
            // Seleciona um centro de distribuição
            tamanho selectedCenter = selecionarCentro(sc, centers);

            exibirMenuCentroDistribuicao();
            entry = sc.nextInt();

            switch (entry) {
                case 1:
                    selectedCenter.addDonation(sc, selectedCenter.getClothes(), selectedCenter.getFood(), selectedCenter.getHygiene());
                    break;
                case 2:
                    listarPedidos(orders);
                    break;
                case 3:
                    autorizarPedido(sc, selectedCenter, orders);
                    break;
                case 4:
                    recusarPedido(sc, orders);
                    break;
                case 5:
                    verInventario(selectedCenter);
                    break;
            }
        }
    }

    private static void exibirMenuCentroDistribuicao() {
        // Menu do centro de distribuição
        System.out.println("===== MENU CENTRO DE DISTRIBUIÇÃO =====");
        System.out.println("1 - Receber Doação");
        System.out.println("2 - Ver pedidos");
        System.out.println("3 - Autorizar pedido");
        System.out.println("4 - Recusar pedido");
        System.out.println("5 - Ver inventário");
        System.out.println("0 - Sair");
    }

    private static tamanho selecionarCentro(Scanner sc, ArrayList<tamanho> centers) {
        int list = 1;

        // Exibe a lista de centros de distribuição
        System.out.println("Escolha um centro:");
        for (tamanho x : centers) {
            System.out.println(list + " - " + x);
            list++;
        }

        return centers.get(sc.nextInt() - 1);
    }

    private static void listarPedidos(ArrayList<selecao> orders) {
        // Lista todos os pedidos
        System.out.println("Pedidos:");
        for (selecao x : orders) {
            System.out.println(x);
        }
    }

    private static void autorizarPedido(Scanner sc, tamanho selectedCenter, ArrayList<selecao> orders) {
        // Autoriza um pedido selecionado
        System.out.println("Escolha um pedido para autorizar:");
        listarPedidos(orders);

        selecao selectedOrder = orders.get(sc.nextInt() - 1);

        enviarProdutos(selectedCenter, selectedOrder);

        // Remove o pedido se não houver mais itens
        if (selectedOrder.getClothes() == null && selectedOrder.getFood() == null && selectedOrder.getHygiene() == null) {
            orders.remove(selectedOrder);
        }
    }

    private static void enviarProdutos(tamanho selectedCenter, selecao selectedOrder) {
        // Envia produtos do centro de distribuição para o abrigo
        enviarProduto(selectedCenter.getClothes(), selectedOrder.getClothes(), selectedOrder.getShelter().getClothes());
        enviarProduto(selectedCenter.getFood(), selectedOrder.getFood(), selectedOrder.getShelter().getFood());
        enviarProduto(selectedCenter.getHygiene(), selectedOrder.getHygiene(), selectedOrder.getShelter().getHygiene());
    }

    private static <T> void enviarProduto(ArrayList<T> centroProdutos, T pedidoProduto, ArrayList<T> abrigoProdutos) {
        // Move produtos do centro de distribuição para o abrigo
        Iterator<T> iterator = centroProdutos.iterator();
        while (iterator.hasNext()) {
            T x = iterator.next();
            if (x.equals(pedidoProduto)) {
                System.out.println(pedidoProduto.getClass().getSimpleName() + " enviado");
                abrigoProdutos.add(x);
                iterator.remove();
            }
        }
    }

    private static void recusarPedido(Scanner sc, ArrayList<selecao> orders) {
        // Recusa um pedido selecionado
        System.out.println("Escolha um pedido para recusar:");
        listarPedidos(orders);

        int selectedOrder = sc.nextInt() - 1;
        orders.remove(selectedOrder);

        System.out.println("Pedido removido com sucesso!");
    }

    private static void verInventario(tamanho selectedCenter) {
        // Exibe o inventário do centro de distribuição
        System.out.println("Roupas:");
        for (util x : selectedCenter.getClothes()) {
            System.out.println(x);
        }
        System.out.println("Comidas:");
        for (comida x : selectedCenter.getFood()) {
            System.out.println(x);
        }
        System.out.println("Higiene:");
        for (saude x : selectedCenter.getHygiene()) {
            System.out.println(x);
        }
    }
}
