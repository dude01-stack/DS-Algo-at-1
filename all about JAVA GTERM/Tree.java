
public class Tree {
	private String species;
	private String genus;
	private char category;
	private short age;
	private int quantity;
	private float heightInMtrs;
	private boolean threatenedSpecies;

	public Tree(String species, String genus, char category, short age, float heightInMtrs, boolean threatenedSpecies) {
		this.species = species;
		this.genus = genus;
		this.category = category;
		this.age = age;
		this.quantity = 0;
		this.heightInMtrs = heightInMtrs;
		this.threatenedSpecies = threatenedSpecies;
	}

	public String getSpecies() {
		String species;
		return this.species;
	}

	public void setSpecies(String species) {
		if (species!=null && !species.isBlank())
		this.species = species;
	}

	public String getGenus() {
		String genus;
		return this.genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public char getCategory() {
		char category;
		return this.category;
	}

	public void setCatgeory(char category) {
		this.category = category;
	}

	public short getAge() {
		short age;
		return this.age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public int getQuantity() {
		int quantity;
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getHeightInMtrs() {
		float heightInMtrs;
		return this.heightInMtrs;
	}

	public void setHeightInMtrs(float heightInMtrs) {
		this.heightInMtrs = heightInMtrs;
	}

	public boolean getThreatenedSpecies() {
		boolean threatenedSpecies;
		return this.threatenedSpecies;
	}

	public void setThreatenedSpecies(boolean threatenedSpecies) {
		this.threatenedSpecies = threatenedSpecies;
	}

}
