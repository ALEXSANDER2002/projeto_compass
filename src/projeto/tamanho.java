package projeto;

import java.util.ArrayList;
import java.util.Scanner;

import produto.util;
import produto.corpo;
import produto.comida;
import produto.comidinha;
import produto.saude;
import produto.ocupa;

public class tamanho {

    // Informações gerais
    private String name;
    private String address;
    private Integer number;
    private String state;
    private Integer cep;

    private ArrayList<util> util = new ArrayList<>();
    private ArrayList<saude> saude = new ArrayList<>();
    private ArrayList<comida> comida = new ArrayList<>();

    public tamanho() {
    }

    public tamanho(String name, String address, Integer number, String state, Integer cep) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.state = state;
        this.cep = cep;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
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

    public void addDonation(Scanner sc, ArrayList<util> _clothes, ArrayList<comida> _food, ArrayList<saude> _hygiene) {
        int entry = -1;
        while (entry != 4) {
            System.out.println("Selecione o tipo de item recebido: \n1 - Roupas\n2 - Comida\n3 - Higiene\n4 - Finalizar \n0 - Cancelar");
            entry = sc.nextInt();
            sc.nextLine();
            switch (entry) {
                case 1:
                    util c = getClothesDetails(sc);
                    if (c != null) _clothes.add(c);
                    break;
                case 2:
                    comida f = getFoodDetails(sc);
                    if (f != null) _food.add(f);
                    break;
                case 3:
                    saude h = getHygieneDetails(sc);
                    if (h != null) _hygiene.add(h);
                    break;
                case 4:
                    System.out.println("Operação finalizada com sucesso.");
                    break;
                case 0:
                    System.out.println("Operação cancelada pelo usuário.");
                    return;
            }
        }
    }

    private util getClothesDetails(Scanner sc) {
        System.out.println("Informe a descrição da roupa:");
        String description = sc.nextLine().toLowerCase();
        
        System.out.println("Informe o gênero da roupa:\n1 - Masculino\n2 - Feminino");
        corpo gender = sc.nextInt() == 1 ? corpo.MASC : corpo.FEM;
        sc.nextLine();
        
        System.out.println("Informe o tamanho da roupa:\n1 - PP\n2 - P\n3 - M\n4 - G\n5 - GG");
        corpo size = corpo.values()[sc.nextInt() - 1];
        sc.nextLine();
        
        return new util(description, size, gender);
    }

    private comida getFoodDetails(Scanner sc) {
        System.out.println("Informe a descrição da comida:");
        String description = sc.nextLine().toLowerCase();
        
        System.out.println("Informe a unidade de medida da comida:\n1 - KG\n2 - L");
        comidinha measure = sc.nextInt() == 1 ? comidinha.KG : comidinha.L;
        sc.nextLine();
        
        System.out.println("Informe a data de validade da comida (dd/MM/yyyy):");
        String expire = sc.nextLine();
        
        System.out.println("Informe a quantidade de comida:");
        int quantity = sc.nextInt();
        sc.nextLine();
        
        return new comida(description, measure, expire, quantity);
    }

    private saude getHygieneDetails(Scanner sc) {
        System.out.println("Informe a descrição do produto de saude:");
        String description = sc.nextLine().toLowerCase();
        
        System.out.println("Selecione o item de saude:\n1 - Sabão\n2 - Escova\n3 - Pasta\n4 - Absorvente");
        ocupa item = ocupa.values()[sc.nextInt() - 1];
        sc.nextLine();
        
        return new saude(description, item);
    }

    @Override
    public String toString() {
        return name;
    }
}
