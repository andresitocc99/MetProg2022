package Task3;

public class City {

	
	public int id;
	public int supplie;
	
	public City (int id, int supplie) {
		this.id = id;
		this.supplie = supplie;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSupplie() {
		return supplie;
	}

	public void setSupplie(int supplie) {
		this.supplie = supplie;
	}
	
	public String toString () {
		return "Villge ID "+id+": takes "+supplie+" kilos.";
	}
	
}
