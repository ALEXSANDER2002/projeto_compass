package produto;

import java.util.Objects;

public class saude {

	String description;
	ocupa item;
	
	public saude() {}

	public saude(String description, ocupa item) {
		super();
		this.description = description;
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ocupa getItem() {
		return item;
	}

	public void setItem(ocupa item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "descricao: " + description + ", Item: " + item;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		saude other = (saude) obj;
		return Objects.equals(description, other.description) && item == other.item;
	}

	

}
