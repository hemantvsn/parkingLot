package com.hemant.parkinglot;

import java.io.IOException;

import org.springframework.shell.Bootstrap;

public class App {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			// simply launch the console
			Bootstrap.main(args);
		} else if (args.length == 1) {
			// 1 arguement is fileName, don't open console
			String fileName = args[0];
			new FileCommandExecutor().executeFileLineByLine(fileName);
		} else {
			// not supported
			System.out.println("Arguements mismatch, we need 1 or no arguements");
		}
	}
}
