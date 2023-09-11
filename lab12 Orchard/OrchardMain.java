//Name: Michael Pollock
//Time: 4.5 hours
//References: N/A

public class OrchardMain{
	public static void main(String[] args){

		//Create orchard and grow trees
		Orchard myOrchard = new Orchard();
		myOrchard.nameOrchard();

		//Set up orchard
		myOrchard.construction();
		myOrchard.addTrees();
		ConsoleIO.printLine("");
		myOrchard.allocateAppleTrees();
		ConsoleIO.printLine("");
		myOrchard.allocateCiderTrees();
		ConsoleIO.printLine("");
		myOrchard.remainTrees();
		ConsoleIO.printLine("");
		myOrchard.calcAppleSales();
		myOrchard.calcCiderSales();
		myOrchard.orchardSetUp();
		ConsoleIO.printLine("");

		//Manage Orchard
		int choice = 0;
		while (choice != 7){
			ConsoleIO.printLine("Welcome to "+myOrchard.orchardName()+" Manager.");
			ConsoleIO.printLine("");
			ConsoleIO.printLine("1) Add Trees");
			ConsoleIO.printLine("2) Cut down Trees");
			ConsoleIO.printLine("3) Allocate Trees for Apple/Cider Harvest");
			ConsoleIO.printLine("4) Change Apple/Pound Price");
			ConsoleIO.printLine("5) Change Cider/Gallon Price");
			ConsoleIO.printLine("6) View Orchard Specs");
			ConsoleIO.printLine("7) EXIT");
			ConsoleIO.printLine("");
			ConsoleIO.print("Enter Choice: ");
			choice = myOrchard.valid(1, 7);
			ConsoleIO.printLine("");

			//Choice actions
			if (choice == 1){
				myOrchard.addTrees();
			} else if (choice == 2){
				myOrchard.chopTrees();
			} else if (choice == 3){
				myOrchard.remainTrees();
			} else if (choice == 4){
				ConsoleIO.printLine("Current Apple Price/Pound: $"+myOrchard.appleC());
				myOrchard.calcAppleSales();
			} else if (choice == 5){
				ConsoleIO.printLine("Current Cider Price/Gallon: $"+myOrchard.ciderC());
				myOrchard.calcCiderSales();
			} else if (choice == 6){
				myOrchard.specs();
			} else {
			}
		}
	}
}