import java.util.Scanner;

//The class is enabling the creation of objects needed for the program. This class has
//the name Arboretum, it could alternatively be called 'TreeLibrary' or
//TreeCatalogue' or 'TreeDatabase' as all describe the collection of data on trees.
//Without the class the program would not create the objects needed and would not run.
//This class can be expanded by adding other classes with different flora categories
//to create a multi-dimensional database of plants and trees, including locations, maps
//illustrations, breeding etc.
public class FrontEndConsole {

	private Scanner scn;
	
	private BackEnd backEnd;

	public FrontEndConsole(BackEnd backEnd) {
		this.scn = new Scanner(System.in);
		this.backEnd = backEnd;
		
		
		}
	public void showMenu(){
		String menu = "";
		menu += "Arboretum menu\n";
		menu += "~~~~~~~~~~~~~~~\n";
		menu += "[A]dd Tree\n";
		menu += "[M]odify Tree\n";
		menu += "[D]elete Tree\n";
		menu += "[S]how All Trees\n";
		menu += "Selection: ";
		
		String selection = getInputString(menu);
		
		while (!selection.isBlank()) {
		
			if (selection.equalsIgnoreCase("a"))
			addTreeOnConsole();
			else if (selection.equalsIgnoreCase("m"))
				modifyTreeOnConsole();
			else if (selection.equalsIgnoreCase("d"))
				deleteTreeOnConsole();
			else if (selection.equalsIgnoreCase("s"))
				showTreesOnConsole();
			else {
					System.out.println("Not an option");
				}
		} 
		selection = getInputString(menu);
	}

	public void showTreesOnConsole() {
		
		System.out.println();
		System.out.println("Tree Species\t Genus\t Category\t Age\t Quantity\t HeightInMtrs\t Threatened Species");

		String[] allData = this.backEnd.gatherAllData();
		int i = 0;
		while (i < allData.length) {
			System.out.println(allData[i]);
			i++;
		}
		System.out.println();
		showMenu();
		// BackEnd backEnd = new BackEnd();
		// FrontEndConsole ob= new FrontEndConsole(backEnd);
		//selection = getInputString(menu);
	}

	private String getInputString(String prompt) {
		System.out.println(prompt + ": ");
		String input = this.scn.nextLine();
		return input;
	}

	public void addTreeOnConsole() {
	
		String treeDetails = getInputString("Enter Tree Details: \\Species, Genus, Category D/C, Age, Quantity, Height In Mtrs, Threatened Species T/F");
		
			String[] treeBranch = treeDetails.split(",");

			String species = treeBranch[0];
			while (species.equals("")) {
				species = getInputString("Species: "+species+ "is not valid"); 
			}

			String genus = treeBranch[1];
			while (genus.equals("")) {
				genus = getInputString("Genus: "+genus+ "is not valid"); 
			}
			
			char category = treeBranch[2].toLowerCase().charAt(0);
			while (category !='d' && category != 'c') {
				category = getInputString("Unknown category, enter D for Deciduous or C for Coniferous : ").toLowerCase().charAt(0);
			}

			short age = Short.parseShort(treeBranch[3]);
			while  (age < 0 || age > 1000) {
			
					age = Short.parseShort(getInputString("Invalid age: enter correct age: "));
				}
			
		    int quantity = Integer.parseInt(treeBranch[4]);
			while (quantity < 0)
				quantity= Integer.parseInt(getInputString("Error, cannot be a negative number, enter positive value: "));
			 if (quantity >0 && quantity < 100)
				quantity = Integer.parseInt(getInputString("Low quanitity, consider expanding"));

			float heightInMtrs = Float.parseFloat(treeBranch[5]);
			while (heightInMtrs < 0 || heightInMtrs > 250)
				heightInMtrs = Float.parseFloat(getInputString("Invalid height, enter correct height: "));

			boolean threatenedSpecies= Boolean.parseBoolean(treeBranch[6]);
			
			String newEntry = this.backEnd.addNextTree(species, genus, category, age, quantity, heightInMtrs, threatenedSpecies);
			if (newEntry.isEmpty())
				System.out.println("Warning, no entry added");
			showTreesOnConsole();


		}

	// Amend is the next function the user will see after
	// the add function. Therefore it is placed after the add methods.
	// amend tree could be 'editTree' or 'modifyTree'
	// this method needs to be public for the maintainability of
	// the code in case more classes are added to widen the scope of the
	// program
	public void modifyTreeOnConsole() {
		//String newSpecies;
		
		String oldSpecies =  getInputString("Enter the species that you want to modify");
		String newSpecies= getInputString("Enter the new species");
		

		String[] allData = this.backEnd.gatherAllData();
		int i = 0;
		String[] Tree = new String[7];
		while (i < allData.length) {
			if(allData[i].contains(oldSpecies)){
				Tree= allData[i].split("\t");
			}
			i++;
		}
		String oldGenus= Tree[1];
		String newGenus= getInputString("Enter the new genus to replace "+oldGenus);
		char oldCategory= Tree[2].charAt(0);
		char newCategory= getInputString("Enter the new category").charAt(0);
		short oldAge = Short.parseShort(Tree[3]);
		short newAge = Short.parseShort(getInputString("Enter age to replace " + oldAge));
		int oldQuantity = Integer.parseInt(Tree[4]);
		int newQuantity = Integer.parseInt(getInputString("Enter quantity to replace " + oldQuantity));
		float oldHeightInMtrs = Float.parseFloat(Tree[5]);
		float newHeightInMtrs = Float
					.parseFloat(getInputString("Enter new height in meters to replace " + oldHeightInMtrs));
		boolean oldThreatenedSpecies = Boolean.parseBoolean(Tree[6]);
		boolean newThreatenedSpecies = Boolean
					.parseBoolean(getInputString("Enter True or False to replace " + oldThreatenedSpecies));

		this.backEnd.amendTree(oldSpecies, newSpecies, oldGenus, newGenus, oldCategory, newCategory, oldAge, newAge,
					oldQuantity, newQuantity, oldHeightInMtrs, newHeightInMtrs, oldThreatenedSpecies,
					newThreatenedSpecies);

		showTreesOnConsole();

	}

	// remove tree is the next method as it is the next function in the
	// program. Alternative name 'deleteTree' 'deleteRow' 'deleteRecord'
	// this method is accessible from any class created
	// removeEntryData is next sequentially and will
	// update the array when the data is deleted
	public void deleteTreeOnConsole() {
		String species = getInputString("Enter species to delete: ");
		if (!species.isBlank()) {
			this.backEnd.removeEntryData(species);
		} else {
			System.out.println ("Error, select entry to delete: ");
		}
		showTreesOnConsole();
	}

	public static void main(String[] args) {
		BackEnd backEnd = new BackEnd();
		FrontEndConsole ob= new FrontEndConsole(backEnd);
		ob.showMenu();

	}

}
