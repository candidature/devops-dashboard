package com.broadcom.devopsd.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.broadcom.devopsd.dao.ToolInstanceDao;
import com.broadcom.devopsd.dao.ToolInstanceDaoImpl;

public class ExternalCommand {

	private int instanceId;
	private String command;
	
	
	ProcessBuilder processBuilder = new ProcessBuilder();
	ToolInstanceDao toolInstance = new ToolInstanceDaoImpl();
	
	public int RunShellCommand(String command) {
		processBuilder.command("bash", "-c", command);
		try {

			Process process = processBuilder.start();
			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}
			
			int exitVal = process.waitFor();
			if (exitVal == 0) {
				System.out.println("Success!");
				System.out.println(output);
				
				System.exit(0);
			} else {
				//abnormal...
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return instanceId;
	}
}
