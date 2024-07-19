package projeto;

import produto.util;
import produto.comida;
import produto.saude;

public class selecao {
	
	
	util util;
	comida comida;
	saude saude;
	lista lista;
	
	public selecao(util util,  comida comida, saude saude, lista lista) {
		super();
		this.util = util;
		this.comida = comida;
		this.saude = saude;
		this.lista = lista;
	
	}
	
	

	public util getClothes() {
		return util;
	}



	public void setClothes(util util) {
		this.util = util;
	}



	public comida getFood() {
		return comida;
	}



	public void setFood(comida comida) {
		this.comida = comida;
	}



	public saude getHygiene() {
		return saude;
	}



	public void setHygiene(saude saude) {
		this.saude = saude;
	}



	public lista getShelter() {
		return lista;
	}



	public void setShelter(lista lista) {
		this.lista = lista;
	}

	

	@Override
	public String toString() {
		return "Pedido = \nRoupas: " + util + "\nComida: " + comida + "\nHigiene: " + saude;
	}
	
		
	}
	
