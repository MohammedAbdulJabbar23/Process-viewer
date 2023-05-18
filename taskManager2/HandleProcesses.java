import java.util.Scanner;

import javax.swing.DefaultListModel;

public class HandleProcesses {
    
    public static void refreshProcesses(DefaultListModel<String> processListModel,GUI gui) {
        processListModel.clear();
        try {
            Process process = Runtime.getRuntime().exec("ps -e -o pid,comm");
            process.waitFor();
            int processCount = 0;
            Scanner scanner = new Scanner(process.getInputStream());
            while (scanner.hasNextLine()) {
                String processLine = scanner.nextLine();
                String[] columns = processLine.trim().split("\\s+");
                if (columns.length >= 2) {
                    String processId = columns[0];
                    String processName = columns[1];
                    processListModel.addElement(processId + " - " + processName);
                    processCount++;
                }
            }
            gui.setTitle("Process Manager (" + processCount + " processes)");    
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
