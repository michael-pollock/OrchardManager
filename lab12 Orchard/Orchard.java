//Import decimal formatter
import java.text.DecimalFormat; // Reference [1], formatting a variable
import java.math.RoundingMode;

public class Orchard {
	private String name;
	private int trees;
	private int appleTrees;
	private double appleCost;
	private double appleRev;
	private int ciderTrees;
	private double ciderCost;
	private double ciderRev;
	private int unallocatedTrees;
	private int decorativeTrees;
	private double startUpCost;
	private double yearlyRevenue;
	private double yearsInTheRed;
	private boolean setUpComplete;

	//Land purchase, licensing and construction cost
	public void construction(){
		//Decimal formatter Cont.
		DecimalFormat myFormatter;
		myFormatter = new DecimalFormat("0,000.00");
		myFormatter.setRoundingMode(RoundingMode.UP);

		double constructionCost = Math.random()*100000;
		startUpCost += constructionCost;
		String c = myFormatter.format(constructionCost);
		ConsoleIO.printLine("Congratulations! You bought an empty orchard for $"+c+"!");
	}

	//Print Orchard Specs
	public void specs(){
		DecimalFormat myFormatter;
		myFormatter = new DecimalFormat("0.00");
		myFormatter.setRoundingMode(RoundingMode.UP);

		ConsoleIO.printLine("Name: "+name);
		ConsoleIO.printLine("Total Number of Trees: "+trees);
		ConsoleIO.printLine("Total Number of Trees for Apples: "+appleTrees);
		ConsoleIO.printLine("Total Number of Trees for Cider: "+ciderTrees);
		ConsoleIO.printLine("Total Number of Decorative Trees: "+decorativeTrees);
		String c = myFormatter.format(appleCost);
		ConsoleIO.printLine("Apple/Pound cost: $"+c);
		c = myFormatter.format(ciderCost);
		ConsoleIO.printLine("Cider/Gallon cost: $"+c);
		myFormatter = new DecimalFormat("0,000.00");
		c = myFormatter.format(startUpCost);
		ConsoleIO.printLine("Set up cost: $"+c);
		c = myFormatter.format(yearlyRevenue);
		ConsoleIO.printLine("Yearly revenue: $"+c);
		yearsToProfit();
		ConsoleIO.printLine("");
	}

	//Print Name
	public String orchardName(){
		String s = name;
		return s;
	}

	//Print Apple cost
	public double appleC(){
		double i = appleCost;
		return i;
	}

	//Print Cider cost
	public double ciderC(){
		double i = ciderCost;
		return i;
	}

	//public void orchardSetUp(){
	//}

	//public void orchardManager(){
	//}

	//Name orchard
	public void nameOrchard(){
		ConsoleIO.print("What would you like to name your orchard? ");
		name = ConsoleIO.readLine();
	}

	//Add j trees
	public void addTrees(){
		int j = 0;
		if (setUpComplete){
			int choice = 0;
			ConsoleIO.printLine("What kind of trees would you like to add?");
			ConsoleIO.printLine("1) Trees for Apple Harvest");
			ConsoleIO.printLine("2) Trees for Cider Harvest");
			ConsoleIO.printLine("3) Decorative Trees");
			ConsoleIO.printLine("4) Custom");
			choice = valid(1, 4);
			if (choice == 1){
				ConsoleIO.print("How many Apple trees would you like to add? ");
				j = posNumI();
				trees += j;
				appleTrees += j;
				startUpCost += j*75; //$75 to grow and maintain a tree
			} else if (choice == 2){
				ConsoleIO.print("How many Cider trees would you like to add? ");
				j = posNumI();
				trees += j;
				ciderTrees += j;
				startUpCost += j*75; //$75 to grow and maintain a tree
			} else if (choice == 3){
				ConsoleIO.print("How many Decorative trees would you like to add? ");
				j = posNumI();
				trees += j;
				decorativeTrees += j;
				startUpCost += j*75; //$75 to grow and maintain a tree
			} else {
				ConsoleIO.print("How many Apple trees would you like to add? ");
				j = posNumI();
				trees += j;
				appleTrees += j;
				startUpCost += j*75; //$75 to grow and maintain a tree
				ConsoleIO.print("How many Cider trees would you like to add? ");
				j = posNumI();
				trees += j;
				appleTrees += j;
				startUpCost += j*75; //$75 to grow and maintain a tree
				ConsoleIO.print("How many Decorative trees would you like to add? ");
				j = posNumI();
				trees += j;
				decorativeTrees += j;
				startUpCost += j*75; //$75 to grow and maintain a tree
			}
		} else {
			ConsoleIO.print("How many trees would you like to grow? ");
			j = posNumI();
			trees += j;
			unallocatedTrees = j;
			startUpCost += j*75; //$75 to grow and maintain a tree
		}
	}

	//Chop down j trees
	public void chopTrees(){
		int choice = 0;
		int j = 0;
		ConsoleIO.printLine("What kind of trees would you like to chop down?");
		ConsoleIO.printLine("1) Trees for Apple Harvest");
		ConsoleIO.printLine("2) Trees for Cider Harvest");
		ConsoleIO.printLine("3) Trees for Decoration");
		ConsoleIO.printLine("4) Custom");
		choice = valid(1, 3);
		if (choice == 1){
			ConsoleIO.print("How many Apple trees would you like to chop down? ");
			j = posNumI();
			j = removeCheck(j, appleTrees);
			trees -= j;
			appleTrees -= j;
		} else if (choice == 2){
			ConsoleIO.print("How many Cider trees would you like to chop down? ");
			j = posNumI();
			j = removeCheck(j, ciderTrees);
			trees -= j;
			ciderTrees -= j;
		} else if (choice == 2){
			ConsoleIO.print("How many Decorative trees would you like to chop down? ");
			j = posNumI();
			j = removeCheck(j, decorativeTrees);
			trees -= j;
			decorativeTrees -= j;
		} else {
			ConsoleIO.print("How many Apple trees would you like to chop down? ");
			j = posNumI();
			j = removeCheck(j, appleTrees);
			trees -= j;
			appleTrees -= j;
			ConsoleIO.print("How many Cider trees would you like to chop down? ");
			j = posNumI();
			j = removeCheck(j, appleTrees);
			trees -= j;
			appleTrees -= j;
			ConsoleIO.print("How many Decorative trees would you like to chop down? ");
			j = posNumI();
			j = removeCheck(j, decorativeTrees);
			trees -= j;
			decorativeTrees -= j;
		}
	}

	//Set specified number of trees to be Apple Trees
	public void allocateAppleTrees(){
		ConsoleIO.printLine("You have "+unallocatedTrees+" trees available.");
		ConsoleIO.print("How many would you like to use for Apples? ");
		int j = posNumI();
		j = removeCheck(j, unallocatedTrees);
		appleTrees += j;
		unallocatedTrees -= appleTrees;
	}

	//Set specified number of trees to be Cider Trees
	public void allocateCiderTrees(){
		ConsoleIO.printLine("You have "+unallocatedTrees+" trees available.");
		ConsoleIO.print("How many would you like to use for Cider? ");
		int j = posNumI();
		j = removeCheck(j, unallocatedTrees);
		ciderTrees += j;
		unallocatedTrees -= ciderTrees;
	}

	//Catch any trees that were unallocated, or reallocate after setup finished
	public void remainTrees(){
		if (unallocatedTrees == 0 && setUpComplete){
			unallocatedTrees += trees;
		} else if (unallocatedTrees != 0){
			int choice = 0;
			ConsoleIO.printLine("You still have "+unallocatedTrees+" trees available.");
			ConsoleIO.printLine("1) Allocate remaining trees for Apple Harvest");
			ConsoleIO.printLine("2) Allocate remaining trees for Cider Harvest");
			ConsoleIO.printLine("3) Allocate remaining trees for Decoration");
			ConsoleIO.printLine("4) Custom allocation");
			choice = valid(1, 4);
			if (choice == 1){
				appleTrees += unallocatedTrees;
				unallocatedTrees -= 0;
			} else if (choice == 2){
				ciderTrees += unallocatedTrees;
				unallocatedTrees = 0;
			} else if (choice == 3){
				decorativeTrees += unallocatedTrees;
			} else {
				allocateAppleTrees();
				allocateCiderTrees();
			}
		}
	}

	//Calculate apple sales, dollars per pound, 200 pounds per tree
	public void calcAppleSales(){
		ConsoleIO.print("Apple Price/Pound: (format 0.00) $");
		appleCost = posNumD();
		appleRev = appleCost*200*appleTrees;
		yearlyRevenue += appleRev;
	}

	//Calculate apple cider sales, dollars per gallon, 15 gallons per tree
	public void calcCiderSales(){
	ConsoleIO.print("Cider Price/Gallon: (format 0.00) $");
		ciderCost = posNumD();
		ciderRev = ciderCost*15*ciderTrees;
		yearlyRevenue += ciderRev;
	}

	//Set up is complete
	public void orchardSetUp(){
		if (trees != 0 && appleCost != 0 && ciderCost != 0){
			setUpComplete = true;
		}
		else {
			ConsoleIO.printLine("Set up is not compelte.");
		}
	}

	//Years until profit
	public void yearsToProfit(){
		double red = yearlyRevenue - startUpCost;
		double i = 0;
		while (red < yearlyRevenue){
			i++;
			red += yearlyRevenue;
		}
		yearsInTheRed = i;
		ConsoleIO.printLine(name+" will be in the red for the first "+yearsInTheRed+" years of their business.");
		ConsoleIO.printLine(name+" can expect to profit on year "+(i+1)+".");
	}

	//Tree Removal Validate, check removed vs num of tree type available
	public int removeCheck(int j, int treeType){
		while (j > treeType){
			ConsoleIO.print("There are not "+j+" trees of that type available. Please choose "+treeType+" or less: ");
			j = posNumI();
		}
		return j;
	}

	//Positive double validator
	public double posNumD(){
		double j = ConsoleIO.readDouble();
		while (j < 0){
			ConsoleIO.print("Please enter a positive value: ");
			j = ConsoleIO.readDouble();
		}
		return j;
	}

	//Positive Integer validator
	public int posNumI(){
		int i = (int)posNumD();
		return i;
	}

	//Choice validator
	public int valid(int low, int high){
		int choice = ConsoleIO.readInt();
		while (choice < low || choice > high){
			ConsoleIO.printLine("Please select a choice from "+low+" to "+high+":");
			choice = ConsoleIO.readInt();
		}
		return choice;
	}
}