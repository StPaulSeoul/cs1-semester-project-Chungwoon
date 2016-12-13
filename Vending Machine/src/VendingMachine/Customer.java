package VendingMachine;

import java.util.Scanner;

public class Customer {
	Scanner input = new Scanner(System.in);

	String name;
	String beverage;
	double paid = 0;
	double balance = 0;

	public Customer(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public void observe(Customer customer, Machine machine) {
		System.out.println(this.name + ": Guess I should get a drink.");
		machine.display(this, machine);
	}

	public void select(Customer customer, Machine machine) {
		for (;;) {
			System.out.println("What would you like to drink?");
			beverage = input.nextLine();
			System.out.printf("Please insert money. You have $%2.f\n", this.balance);
			paid = input.nextDouble();
			if (paid > balance) {
				System.out.println("Please check your balance again.");
			} else {
				balance = balance - paid;
				break;
			}
		}
		machine.check(this, machine, beverage, paid);
	}
}