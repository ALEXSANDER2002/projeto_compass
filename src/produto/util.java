package produto;

import java.util.Objects;

public class util{
	
	String description;
	corpo size;
	corpo gender;
	
	public util() {}

	public util(String description, corpo size, corpo gender) {
		super();
		this.description = description;
		this.size = size;
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public corpo getSize() {
		return size;
	}

	public void setSize(corpo size) {
		this.size = size;
	}

	public corpo getGender() {
		return gender;
	}

	public void setGender(corpo gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "descriçao: " + description + ", tamanho: " + size + ", genero: " + gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, gender, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		util other = (util) obj;
		return Objects.equals(description, other.description) && gender == other.gender && size == other.size;
	}

	
	
}
