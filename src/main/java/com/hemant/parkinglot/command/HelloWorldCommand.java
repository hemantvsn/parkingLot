package com.hemant.parkinglot.command;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldCommand implements CommandMarker {

	@CliCommand(value = "hello", help = "Print a simple hello world message")
	public String helloWorld() {
		return "Hello World";
	}
}
