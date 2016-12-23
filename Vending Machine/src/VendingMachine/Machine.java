package VendingMachine;

import java.util.Scanner;

public class Machine {
	public Machine() {
	}

	public void display(Customer customer, Machine machine) {
		System.out.printf("Coke $1.20\nSprite $1.20\nPepsi $1.00\nLet's be $0.50\n");
		customer.select(customer, this);
	}

	public void check(Customer customer, Machine machine, String beverage, double paid, double balance, double change) {
		Scanner input = new Scanner(System.in);

		for (;;) {
			for (;;) {
				beverage = input.nextLine();
				if (beverage.equals("Coke") && customer.balance >= 1.2) {
					break;
				} else if (beverage.equals("Sprite") && customer.balance >= 1.2) {
					break;
				} else if (beverage.equals("Pepsi") && customer.balance >= 1) {
					break;
				} else if (beverage.equals("Let's be") && customer.balance >= 0.5) {
					break;
				} else {
					System.out.println("Error. Invalid input. Please try again.");
				}
			}
			if (beverage.equals("Coke")) {
				for (;;) {
					System.out.printf("Please insert money.\n$");
					customer.paid = input.nextDouble();
					if (customer.paid >= 1.2 && customer.paid <= customer.balance) {
						break;
					} else if (customer.paid < 1.2 && customer.paid <= customer.balance) {
						System.out.println("Please check if you put enough amount of money.");
					} else {
						System.out.println("Please check out your balance again.");
					}
				}
				customer.change = customer.paid - 1.20;
				customer.balance = customer.balance - customer.paid + customer.change;
				break;
			} else if (beverage.equals("Sprite")) {
				for (;;) {
					System.out.printf("Please insert money.\n$");
					customer.paid = input.nextDouble();
					if (customer.paid >= 1.2 && customer.paid <= customer.balance) {
						break;
					} else if (customer.paid < 1.2 && customer.paid <= customer.balance) {
						System.out.println("Please check if you put enough amount of money.");
					} else {
						System.out.println("Please check out your balance again.");
					}
				}
				customer.change = customer.paid - 1.20;
				customer.balance = customer.balance - customer.paid + customer.change;
				break;
			} else if (beverage.equals("Pepsi")) {
				for (;;) {
					System.out.printf("Please insert money.\n$");
					customer.paid = input.nextDouble();
					if (customer.paid >= 1 && customer.paid <= customer.balance) {
						break;
					} else if (customer.paid < 1 && customer.paid <= customer.balance) {
						System.out.println("Please check if you put enough amount of money.");
					} else {
						System.out.println("Please check out your balance again.");
					}
				}
				customer.change = customer.paid - 1;
				customer.balance = customer.balance - customer.paid + customer.change;
				break;
			} else if (beverage.equals("Let's be")) {
				for (;;) {
					System.out.printf("Please insert money.\n$");
					customer.paid = input.nextDouble();
					if (customer.paid >= 0.5 && customer.paid <= customer.balance) {
						break;
					} else if (customer.paid < 0.5 && customer.paid <= customer.balance) {
						System.out.println("Please check if you put enough amount of money.");
					} else {
						System.out.println("Please check out your balance again.");
					}
				}
				customer.change = customer.paid - 0.5;
				customer.balance = customer.balance - customer.paid + customer.change;
				break;
			} else {
				System.out.println("Error. Invalid input. Please try again.");
			}
		}
		customer.get(customer, this, beverage, paid, balance, change);
	}

	public double checkIf(Customer customer, Machine machine, double balance) {
		return customer.balance;
	}
}