package VendingMachine;

public class Machine {
	public Machine() {
	}

	public void display(Customer customer, Machine machine) {
		System.out.printf("Coke $1.20\nSprite $1.20\nPepsi $1.00\nLet's be $0.50\n");
		customer.select(customer, this);
	}

	public void check(Customer customer, Machine machine, String beverage, double paid) {
		if (beverage.equals("Coke")) {
			if (paid >= 1.20) {
				System.out.println("Here is your coke.");
			} else {
				System.out.println("Please check if you put enough amount of money.");
			}
		} else if (beverage.equals("Sprite")) {
			
		}
	}

}