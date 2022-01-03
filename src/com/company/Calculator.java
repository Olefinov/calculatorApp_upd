package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	private String operation;
	private Scanner scanner;

	public Calculator() {
		this.scanner = new Scanner(System.in);
	}

	public void calculate() {
		while (!"q".equals(operation)) {
			try {
				System.out.println(calculationStep());
			} catch (InputMismatchException ex) {
				System.out.println("Wrong input data!");
			}
		}
	}

	private double calculationStep() throws InputMismatchException {
		System.out.println("enter first number:");
		int firstNumber = Integer.parseInt(scanner.nextLine());
		System.out.println("enter second number:");
		int secondNumber = Integer.parseInt(scanner.nextLine());
		System.out.println("enter operation ('+' '-' '*' '/' ) to perform or q if you want to quit:");

		operation = scanner.nextLine();

		return performOperation(firstNumber, secondNumber);
	}

	private double performOperation(int firstNumber, int secondNumber) {
		double result;

		switch (operation) {
			case "+":
				result = plus(firstNumber, secondNumber);
				break;
			case "-":
				result = minus(firstNumber, secondNumber);
				break;
			case "*":
				result = multiply(firstNumber, secondNumber);
				break;
			case "/":
				result = divide(firstNumber, secondNumber);
				break;
			default:
				System.out.println("Incorrect operation. Please try again. ");
				result = calculationStep();
				break;
		}

		return result;
	}

	private int plus(int numberOne, int numberTwo) {
		return numberOne + numberTwo;
	}

	private int minus(int numberOne, int numberTwo) {
		return numberOne - numberTwo;
	}

	private int multiply(int numberOne, int numberTwo) {
		return numberOne * numberTwo;
	}

	private int divide(int numberOne, int numberTwo) {
		return numberOne / numberTwo;
	}
}

