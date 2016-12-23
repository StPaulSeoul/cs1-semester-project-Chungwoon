package VendingMachine;

import java.util.Scanner;

public class Customer {
	Scanner input = new Scanner(System.in);

	String name;
	String beverage;
	double paid;
	double balance;
	double change;

	public Customer(String name) {
		this.name = name;
	}

	public void balance() {
		for (;;) {
			System.out.printf("How much money do I have?\n$");
			this.balance = input.nextDouble();
			if (this.balance >= 0.5) {
				break;
			} else {
				System.out.println("I'm afraid I don't have enough money to buy anything.");
			}
		}
	}

	public void observe(Customer customer, Machine machine) {
		System.out.println(this.name + ": Guess I should get a drink.");
		machine.display(this, machine);
	}

	public void select(Customer customer, Machine machine) {
		System.out.println("What would you like to drink?");
		System.out.printf("I have $%.2f.\n", this.balance);
		machine.check(this, machine, beverage, paid, balance, change);
	}

	public void get(Customer customer, Machine machine, String beverage, double paid, double balance, double change) {
		if (this.change > 0) {
			System.out.printf("Here is your %s and your change $%.2f.\n", beverage, this.change);
		} else {
			System.out.printf("Here is your %s.\n", beverage);
		}
		System.out.printf("I have $%.2f left.\n", this.balance);
		machine.checkIf(this, machine, this.balance);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String again;

		System.out.println("What is my name?");
		Customer myCustomer = new Customer(sc.nextLine());
		Machine myMachine = new Machine();

		myCustomer.balance();
		for (;;) {
			myCustomer.observe(myCustomer, myMachine);
			if (myCustomer.balance < 0.5) {
				System.out.println("I don't have enough money to get anything.");
				break;
			}
			for (;;) {
				System.out.println("Would you like to get another one?\nYes? or No?");
				again = sc.nextLine();
				if (again.equals("Yes") || again.equals("No")) {
					break;
				} else {
					System.out.println("Error. Invalid input.");
				}
			}
			if (again.equals("No")) {
				System.out.println(myCustomer.name + ": I guess I'm good.");
				break;
			}
		}

	}
}