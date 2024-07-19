package produto;

import java.util.Objects;

public class comida {

	String description;
	comidinha measure;
	String expiration;
	int quantity;
	
	public comida() {}

	public comida(String description, comidinha foodMeasure, String expiration, int quantity) {
		super();
		this.description = description;
		this.measure = foodMeasure;
		this.expiration = expiration;
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public comidinha getMeasure() {
		return measure;
	}

	public void setMeasure(comidinha measure) {
		this.measure = measure;
	}

	public String getExpiration() {
		return expiration;
	}

	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "descricao: " + description + ", medida: " + measure + ", validade: " + expiration
				+ ", qunatidade: " + quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, expiration, measure, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		comida other = (comida) obj;
		return Objects.equals(description, other.description) && Objects.equals(expiration, other.expiration)
				&& measure == other.measure && quantity == other.quantity;
	}
	
	
	
}
