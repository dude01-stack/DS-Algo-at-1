
//The class is enabling the creation of objects needed for the program. This class has
//the name Arboretum, it could alternatively be called 'TreeLibrary' or
//TreeCatalogue' or 'TreeDatabase' as all describe the collection of data on trees.
//Without the class the program would not create the objects needed and would not run.
//This class can be expanded by adding other classes with different flora categories
//to create a multi-dimensional database of plants and trees, including locations, maps
//illustrations, breeding etc.
public class BackEnd {
	private Tree[] trees;
	
	// Name alternatives: 'maxRecords' 'maximumInputs' 'totalRecords' 'maxRecords'
	// Data type alternative: this data type needs to be a whole number as
	// portions or decimals of a record are unable to be created.
	// Int is the most maintainable data type for an expandable
	// program. Short is the alternate data type but would have a maximum
	// of 32,767 inputs which would limit the program.
	private int maxNumTrees;
	// Name alternatives: 'activeNumRecords' 'currentNumber' 'activeAmount'
	// Data type alternative: int offers a flexible numerical storage option for
	// maintainability, short is the alternative though the program would run
	// into errors if expanded
	private int currentTrees;
	// Alternatives for Gterm are many, for a gui interface jpanel or
	// java swing or JavaFX are some options. A graphical user
	// interface makes the program more palatable for
	// non-technical users so is important.

	public BackEnd() {
		this.maxNumTrees = 3;
		this.currentTrees = 0;
		trees= new Tree[this.maxNumTrees];
	}

	public int findIndexOfTreeSpecies(String type) {
		int index = 0;

		while (index < this.currentTrees && !this.trees[index].getSpecies().equalsIgnoreCase(type))
			index += 1;
		if (index >= this.currentTrees) {
			index -= 1;
		}
		return index;
	}

	// This method addNextTree is the next method in the code
	// as it gets all the data needed for the rest of the code.
	// It could alternatively be named as 'addTree' 'nextTreeToAdd' or
	// 'nextInput' 'nextRecord' 'newTree'
	// The conditions used ensure the user has made the
	// correct inputs for the data and no inputs are missed
	// Alternative to splitting the input text by ','
	// tab, white space or another character like a - could
	// be used. Or the user could have individual text from entry
	// fields for each array, this would change the structure of
	// the code but may get confusing when entering each separate
	// field to make sure the data didn't get messed up and go into
	// the wrong record.

	public String addNextTree(String species, String genus, char category, short age, int quantity, float heightInMtrs,
			boolean threatenedSpecies) {
		
			String addTreeData = "";
			boolean working = false;
			int nextRecord = 0;

			// this while loop is needed to check the conditions for
			// the data entry by the user. A for loop could have been
			// used or an if statement for each condition with
			// a boolean value to check the validity of the input
			// before it is accepted
			// this could be written in reverse with a > symbol
			if (this.currentTrees < this.maxNumTrees) {
				this.trees[this.currentTrees]= new Tree(species, genus, category, age,  heightInMtrs, threatenedSpecies);
				
				this.trees[this.currentTrees].setQuantity(quantity);
				addTreeData = this.trees[this.currentTrees].getSpecies()+"\t";
				addTreeData += this.trees[this.currentTrees].getGenus()+"\t";
				addTreeData += this.trees[this.currentTrees].getCategory()+"\t";
				addTreeData += this.trees[this.currentTrees].getAge()+"\t";
				addTreeData += this.trees[this.currentTrees].getQuantity()+"\t";
				addTreeData += this.trees[this.currentTrees].getHeightInMtrs()+"\t";
				addTreeData += this.trees[this.currentTrees].getThreatenedSpecies()+"\t";
				
				working = true;

				nextRecord++;

				this.currentTrees++;

				expandArrays();
			}
			//expandArrays();
			return addTreeData;

		

		// the expand array method is called here to ensure
		// all the arrays continually multiply when needed
		// creating a dynamic database. Alternatively, no expand array method
		// could be called leaving a fixed input at the declaration of
		// maxNumTrees

	}

	// Amend is the next function the user will see after
	// the add function. Therefore it is placed after the add methods.
	// amend tree could be 'editTree' or 'modifyTree'
	// this method needs to be public for the maintainability of
	// the code in case more classes are added to widen the scope of the
	// program
	public void amendTree(String oldSpecies, String newSpecies, String oldGenus, String newGenus, char oldCategory, char newCategory, short oldAge, short newAge, int oldQuantity, int newQuantity, float oldHeightInMtrs, float newHeightInMtrs, boolean oldThreatenedSpecies, boolean newThreatenedSpecies) {
		// findEntry could be 'locateEntry' or 'locateCell'
		// alternate code could be indexOf using another library
		int i = findIndexOfTreeSpecies(oldSpecies);
		if (i >= 0) {
			this.trees[i].setSpecies(newSpecies);
		this.trees[i].setGenus(newGenus);
		this.trees[i].setCatgeory(newCategory);
		this.trees[i].setAge(newAge);
		this.trees[i].setQuantity(newCategory);
		this.trees[i].setHeightInMtrs(newHeightInMtrs);
		this.trees[i].setThreatenedSpecies(newThreatenedSpecies);
		}
	}

	// amendEntryData fits next sequentially, it is conveniently
	// located next to the amendTree method as these need
	// updating together. Alternate names for this method
	// 'amendTreeData' 'modifyTreeData' 'modifyTreeEntry'

	// removeEntryData is next sequentially and will
	// update the array when the data is deleted
	public void removeEntryData(String species) {
		int i = findIndexOfTreeSpecies(species);
		if (i >= 0) {
			this.currentTrees -= 1;
			while (i < this.currentTrees) {
				this.trees[i] = this.trees[i+1];
				i++;
			}
		}
	}

	// As justified in the AddNextTree method, the expand Arrays
	// method can be called to expand the arrays when needed.
	// If another class was created to expand the usability of
	// the program, the expand Arrays method could be extended
	// to add new array types to the method before being called.
	// Alternatively a larger number could be added to the variable
	// maxNumTrees to create a larger, but fixed program.
	public void expandArrays() {
		
		this.maxNumTrees += 1;
		//System.out.println(maxNumTrees);

		String[] longerArraySpecies = new String[this.maxNumTrees];
		String[] longerArrayGenus = new String[this.maxNumTrees];
		char[] longerArrayCategory = new char[this.maxNumTrees];
		short[] longerArrayAge = new short[this.maxNumTrees];
		int[] longerArrayQuantity = new int[this.maxNumTrees];
		float[] longerArrayHeight = new float[this.maxNumTrees];
		boolean[] longerArrayThreatenedSpecies = new boolean[this.maxNumTrees];

		int counter = 0;

		while (counter < this.maxNumTrees - 3) {
			longerArraySpecies[counter] = this.trees[counter].getSpecies();
			longerArrayGenus[counter] = this.trees[counter].getGenus();
			longerArrayCategory[counter] = this.trees[counter].getCategory();
			longerArrayAge[counter] = this.trees[counter].getAge();
			longerArrayQuantity[counter] = this.trees[counter].getQuantity();
			longerArrayHeight[counter] = this.trees[counter].getHeightInMtrs();
			longerArrayThreatenedSpecies[counter] = this.trees[counter].getThreatenedSpecies();
			counter++;
		}
		this.trees= new Tree[this.maxNumTrees];
		counter=0;
		//System.out.println(longerArraySpecies[0]);
		while (counter < this.maxNumTrees - 3) {
			 this.trees[counter]= new Tree(longerArraySpecies[counter],longerArrayGenus[counter],longerArrayCategory[counter],
			 								longerArrayAge[counter],longerArrayHeight[counter],longerArrayThreatenedSpecies[counter]);
			 this.trees[counter].setQuantity(longerArrayQuantity[counter]);
			
			counter++;
		}
	


		// the naming convention on these clearly indicates that
		// the variable is for expanding the array. Alternative
		// names could have been 'expandedArraySpecies' etc
		// or 'biggerArraySpecies' or 'largerArraySpecies' etc
		// this.species = longerArraySpecies;
		// this.genus = longerArrayGenus;
		// this.category = longerArrayCategory;
		// this.age = longerArrayAge;
		// this.quantity = longerArrayQuantity;
		// this.heightInMtrs = longerArrayHeight;
		// this.threatenedSpecies = longerArrayThreatenedSpecies;
	}
	

	public String[] gatherAllData() {
		String[] compiledData = new String[this.currentTrees];
		int i = 0;
		while (i < this.currentTrees) {
			String newTree = "";
			newTree += this.trees[i].getSpecies() + "\t";
			newTree += this.trees[i].getGenus() + "\t";
			newTree += this.trees[i].getCategory() + "\t";
			newTree += this.trees[i].getAge() + "\t";
			newTree += this.trees[i].getQuantity() + "\t";
			newTree += this.trees[i].getHeightInMtrs() + "\t";
			newTree += this.trees[i].getThreatenedSpecies() + "\t";
			compiledData[i] = newTree;
			i++;
		}
		return compiledData;
	}
}

