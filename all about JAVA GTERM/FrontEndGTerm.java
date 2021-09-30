public class FrontEndGTerm {
// Alternatives for Gterm are many, for a gui interface jpanel or
	// java swing or JavaFX are some options. A graphical user
	// interface makes the program more palatable for
	// non-technical users so is important.
	private GTerm gt;
	private BackEnd backEnd;

	public FrontEndGTerm(BackEnd backEnd) {
		this.gt = new GTerm(1300, 700);
		this.backEnd = backEnd;
		this.gt.setBackgroundColor(134, 211, 149);
		// the table could be moved anywhere within the window
		// it does look nicer when not completely flush with the edge.
		// buttons give the user control over how the data is placed in the
		// table.
		this.gt.setXY(10, 10);
		// Alternative names for the add button 'New Tree' 'Add Tree'
		// 'Add Record' 'Add New' 'New Entry'
		this.gt.addButton("Add New Tree ", this, "addNextTree");
		// Alternative name for Remove an entry 'Remove' 'Delete'
		// 'Delete Entry' 'Delete row'
		this.gt.addButton("Remove an entry ", this, "removeEntryData");
		// Alternative name for Amend an entry 'Amend' 'Modify'
		// 'Modify Entry' 'Modify Record' 'Amend Entry' 'Amend Record'
		// 'Amend Row' 'Amend Data'
		this.gt.addButton("Amend an entry ", this, "amendTree");
		// There is a way to take each entry separately which would
		// look nicer and create a greater level of accuracy, though
		// this method has not been taught yet.
		this.gt.addButton("Refresh", this, "refreshTable");

		this.gt.println("\n Type entry in box. Separate fields with a comma");
		// Alternative input would be a prompt box for the user
		// such as gt.getInputString. Another method would be
		// making the entire table an editable field but this would
		// limit the amount of records able to be entered.

		this.gt.addTextField("", 600);
		// The text field could have been left next to the button
		// thoug is more visually appealing below.
		this.gt.println("");
		// Use of scanner method to keep the data in the console
		// is an alternative here to a table.
		this.gt.addTable(950, 450,
				"Species \tGenus \tCategory D/C\tAge \tQuantity \tHeight In Mtrs\tThreatened Species");
		// The image is set the side of the table otherwise the table would
		// cover it and it would not be seen.
		this.gt.addRowToTable(0, null);
		this.gt.setXY(880, 0);
		// The image chosen is of a tree as the database is
		// a library of trees.
		//this.gt.addImageIcon("tree.png");
	}

	public void refreshTable() {
		this.gt.clearRowsOfTable(0);
		String[] allData = this.backEnd.gatherAllData();
		int i = 0;
		while (i < allData.length) {
			gt.addRowToTable(0, allData[i]);
			i++;
		}
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

	public void addNextTree() {
		// string needed here as 'index' holds a string
		// and int.
		String treeDetails = this.gt.getTextFromEntry(0);
		//this.gt.println(treeDetails);
		addButton(treeDetails);
		refreshTable();

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
	public void amendTree() {
		// findEntry could be 'locateEntry' or 'locateCell'
		// alternate code could be indexOf using another library
		String findEntry = this.gt.getSelectedRowFromTable(0);
		if (findEntry != null) {
			String[] treeBranch = findEntry.split("\t");
			String oldSpecies = treeBranch[0];
			String newSpecies = gt.getInputString("Enter species to replace " + oldSpecies);
			String oldGenus = treeBranch[1];
			String newGenus = gt.getInputString("Enter genus to replace " + oldGenus);
			char oldCategory = treeBranch[2].toLowerCase().charAt(0);
			char newCategory = gt.getInputString("Enter new category D or C to replace " + oldCategory).charAt(0);
			short oldAge = Short.parseShort(treeBranch[3]);
			short newAge = Short.parseShort(gt.getInputString("Enter age to replace " + oldAge));
			int oldQuantity = Integer.parseInt(treeBranch[4]);
			int newQuantity = Integer.parseInt(gt.getInputString("Enter quantity to replace " + oldQuantity));
			float oldHeightInMtrs = Float.parseFloat(treeBranch[5]);
			float newHeightInMtrs = Float
					.parseFloat(gt.getInputString("Enter new height in meters to replace " + oldHeightInMtrs));
			boolean oldThreatenedSpecies = Boolean.parseBoolean(treeBranch[6]);
			boolean newThreatenedSpecies = Boolean
					.parseBoolean(gt.getInputString("Enter True or False to replace " + oldThreatenedSpecies));
			this.backEnd.amendTree(oldSpecies, newSpecies,oldGenus,newGenus,oldCategory,newCategory, oldAge,newAge,oldQuantity,newQuantity, oldHeightInMtrs,newHeightInMtrs,oldThreatenedSpecies,newThreatenedSpecies);

		} else {
			this.gt.showErrorDialog("none selected");
		}

		refreshTable();
	}

	// removeEntryData is next sequentially and will
	// update the array when the data is deleted
	public void removeEntryData() {
		String type = this.gt.getSelectedRowFromTable(0);
		if (type!=null) {
			String[] tree = type.split("\t");
			String species = tree[0];
			this.backEnd.removeEntryData(species);
		}
		else {
			this.gt.showErrorDialog("Error, select an entry to delete");
		}
		refreshTable();
	}

	// the main method must be static and contains the creation of the new
	// object

	public void addButton(String treeDetails) {
		String  addTreeData;
		// treeDetails = this.gt.getInputString(
		// 		"Enter Tree Details: \\nSpecies, Genus, Category, Age, Quantity, Height in Mtrs, Threatened Species");
		String[] tree = treeDetails.split(",");
		String species = tree[0];
		while (species.isBlank())
			species = this.gt.getInputString("Error, do enter a tree species");
		

		String genus = tree[1];
		while (genus.isBlank())
			genus = this.gt.getInputString("Error, do enter a tree genus");

		char category = tree[2].toLowerCase().charAt(0);
		while (category != 'd' && category != 'c')
			category = this.gt.getInputString("Error! Type C for Coniferous or D for Deciduous").toLowerCase()
					.charAt(0);

		short age = Short.parseShort(tree[3]);
		while (age < 0 || age > 800)
			age = Short.parseShort(this.gt.getInputString("Error, enter a valid age please"));

		int quantity = Integer.parseInt(tree[4]);
		while (quantity < 0)
			quantity = Integer.parseInt(this.gt.getInputString("Error, enter a positive quantity please"));
		if(quantity > 0 &&  quantity < 100)
			this.gt.showWarningDialog("Low quantity warning, concider new purchase");
		

		float heightInMtrs = Float.parseFloat(tree[5]);
		while (heightInMtrs <0 || heightInMtrs >130)
		heightInMtrs = Float.parseFloat(gt.getInputString("Error, enter a valid height"));
		
		boolean threatenedSpecies = Boolean.parseBoolean(tree[6]);
		addTreeData = this.backEnd.addNextTree(species, genus, category, age, quantity, heightInMtrs, threatenedSpecies);
		if (addTreeData.isBlank())
			this.gt.showErrorDialog("Warning: tree not added");
		else
			gt.addRowToTable(0,addTreeData);
			this.gt.setTextInEntry(0, "");
		refreshTable();

	}
	// public static void main(String[] args) {
	// 	BackEnd backEnd = new BackEnd();
	// 	FrontEndGTerm app = new FrontEndGTerm(backEnd);
	// }
}
