package cli.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class Running {
	private static final String osName = System.getProperty("os.name").toLowerCase();
	
	private static final boolean isWindows () {
		return osName.contains("window");
	}
	
	private static final boolean isUnix () {
		return Boolean.logicalOr(Boolean.logicalOr(osName.contains("nix"), osName.contains("nux")), osName.contains("nix"));
	}
	
	private static final boolean isMac () {
		return osName.contains("mac");
	}
	
	private static final boolean isSolaris () {
		return osName.contains("sunos");
	}
	
	private static final String runCommand (List<String> commandList) {
		try {
			if (isWindows()) {
				commandList.add(0, "cmd.exe");
				commandList.add(1, "/c");
				return commandLineExecutor(commandList);
			} else if (isUnix()) {
				return commandLineExecutor(commandList);
			} else if (isMac()) {
				return commandLineExecutor(commandList);
			} else if (isSolaris()) {
				return commandLineExecutor(commandList);
			} else {
				throw new IOException("OS Not supported!");
			}
		} catch (InterruptedException | IOException e) {
			return e.getMessage();
		}
	}
	
	private static String commandLineExecutor (List<String> commandList) throws IOException, InterruptedException {
		StringBuilder stringBuilder = new StringBuilder();
		try {
			ProcessBuilder pb = new ProcessBuilder(commandList);
			Process p = pb.start();
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line).append("\n");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
	
	
	public static void main (String[] args) {
		try {
			List<String> cmdList = new ArrayList<>();
			// adding command and args to the list
            cmdList.add("notepad");
			System.out.println(runCommand(cmdList));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}