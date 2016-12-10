package com.hemant.parkinglot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.shell.Bootstrap;
import org.springframework.shell.core.CommandResult;
import org.springframework.shell.core.JLineShellComponent;

public class FileCommandExecutor {

	private JLineShellComponent shell;
	List<String> commands;

	public FileCommandExecutor() {
		Bootstrap bootstrap = new Bootstrap();
		shell = bootstrap.getJLineShellComponent();
		commands = new ArrayList<>();
	}

	private void readFileLineByLine(String fileName) throws IOException {
		BufferedReader br = null;
		try {
			 br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				commands.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				br.close();
			}
		}
	}

	public void executeFileLineByLine(String fileName) throws IOException {
		readFileLineByLine(fileName);
		for (String command : commands) {
			try {
				CommandResult result = shell.executeCommand(command);
				System.out.println(result.getResult().toString());
			} catch (Exception e) {
				// Don't stop execution if one command fail. Log and continue with next
				System.out.println("***Command failed :" + command + " Error: "+ e.getMessage());
			}
			
		}

	}
}
