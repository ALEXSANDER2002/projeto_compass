package projeto;

import java.util.ArrayList;
import java.util.Scanner;

import produto.util;
import produto.corpo;
import produto.comida;
import produto.comidinha;
import produto.saude;
import produto.ocupa;

public class lista {

    String name;
    String address;
    String manager;
    String phone;
    String email;
    Integer capacity;
    Integer occupied;

    ArrayList<util> util = new ArrayList<>();
    ArrayList<saude> saude = new ArrayList<>();
    ArrayList<comida> comida = new ArrayList<>();

    public lista() {
    }

    public lista(String name, String address, String manager, String phone, String email, Integer capacity,
            Integer occupied) {
        super();
        this.name = name;
        this.address = address;
        this.manager = manager;
        this.phone = phone;
        this.email = email;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getOccupied() {
        return occupied;
    }

    public void setOccupied(Integer occupied) {
        this.occupied = occupied;
    }

    public ArrayList<util> getClothes() {
        return util;
    }

    public void setClothes(ArrayList<util> util) {
        this.util = util;
    }

    public ArrayList<saude> getHygiene() {
        return saude;
    }

    public void setHygiene(ArrayList<saude> saude) {
        this.saude = saude;
    }

    public ArrayList<comida> getFood() {
        return comida;
    }

    public void setFood(ArrayList<comida> comida) {
        this.comida = comida;
    }

    @Override
    public String toString() {
        return "Nome: " + name + " (" + (occupied * 100 / capacity) + "%)";
    }

    public void addOrder(Scanner sc, ArrayList<selecao> selecaos) {

        util c = new util();
        comida f = new comida();
        saude h = new saude();

        int entry = -1;

        while (entry != 4) {
            
            System.out.println("Selecione uma opção de pedido:");
            System.out.println("1 - Roupas");
            System.out.println("2 - Comida");
            System.out.println("3 - Produtos de Higiene");
            System.out.println("4 - Finalizar Pedido");
            System.out.println("0 - Cancelar");
            entry = sc.nextInt(); sc.nextLine();
            
            switch (entry) {

                case 1:
                    corpo clothesGender = null;
                    corpo clothesSize = null;

                    System.out.println("Digite a descrição da roupa:");
                    String clothesDesciption = sc.nextLine().toLowerCase();

                    System.out.println("Escolha o gênero da roupa:");
                    System.out.println("1 - Masculino");
                    System.out.println("2 - Feminino");
                    
                    entry = sc.nextInt(); sc.nextLine();
                    
                    if (entry == 1) {
                        clothesGender = corpo.MASC;
                    } else if (entry == 2) {
                        clothesGender = corpo.FEM;
                    }

                    System.out.println("Escolha o tamanho da roupa:");
                    System.out.println("1 - PP");
                    System.out.println("2 - P");
                    System.out.println("3 - M");
                    System.out.println("4 - G");
                    System.out.println("5 - GG");
                    
                    int size = sc.nextInt(); sc.nextLine();

                    if (size == 1) {
                        clothesSize = corpo.P;
                    } else if (size == 2) {
                        clothesSize = corpo.PP;
                    } else if (size == 3) {
                        clothesSize = corpo.M;
                    } else if (size == 4) {
                        clothesSize = corpo.G;
                    } else if (size == 5) {
                        clothesSize = corpo.GG;
                    }

                    c = new util(clothesDesciption, clothesSize, clothesGender);

                    break;

                case 2:
                    comidinha foodMeasure = null;

                    System.out.println("Digite a descrição da comida:");
                    String foodDescription = sc.nextLine().toLowerCase();

                    System.out.println("Escolha a medida da comida:");
                    System.out.println("1 - KG");
                    System.out.println("2 - L");
                    
                    entry = sc.nextInt(); sc.nextLine();

                    if (entry == 1) {
                        foodMeasure = comidinha.KG;
                    } else if (entry == 2) {
                        foodMeasure = comidinha.L;
                    }

                    System.out.println("Digite a validade da comida (dd/MM/yyyy):");
                    String foodExpire = sc.nextLine();

                    System.out.println("Digite a quantidade de comida:");
                    Integer foodQuantity = sc.nextInt();

                    f = new comida(foodDescription, foodMeasure, foodExpire, foodQuantity);

                    break;

                case 3:
                    ocupa hygieneItem = null;

                    System.out.println("Digite a descrição do produto de higiene:");
                    String hygieneDescription = sc.nextLine().toLowerCase();

                    System.out.println("Escolha o item de higiene:");
                    System.out.println("1 - Sabão");
                    System.out.println("2 - Escova");
                    System.out.println("3 - Pasta de Dente");
                    System.out.println("4 - Absorvente");
                    
                    entry = sc.nextInt(); sc.nextLine();

                    if (entry == 1) {
                        hygieneItem = ocupa.SOAP;
                    } else if (entry == 2) {
                        hygieneItem = ocupa.BRUSH;
                    } else if (entry == 3) {
                        hygieneItem = ocupa.PASTE;
                    } else if (entry == 4) {
                        hygieneItem = ocupa.TAMPON;
                    }

                    h = new saude(hygieneDescription, hygieneItem);

                    break;

                case 4:
                    selecao o = new selecao(c, f, h, this);
                    selecaos.add(o);
                    System.out.println("Pedido finalizado com sucesso.");
                    break;

                case 0:
                    System.out.println("Pedido cancelado.");
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }
}
