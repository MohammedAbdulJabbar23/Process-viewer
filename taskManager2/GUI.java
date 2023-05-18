import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GUI extends JFrame{

    private JButton refresh;
    // private JButton kill;
    private DefaultListModel<String> processListModel;
    private JList<String> processList;
    
    public GUI(){
        setTitle("Process Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        processListModel = new DefaultListModel<>();
        processList = new JList<>(processListModel);
        JScrollPane scrollPane = new JScrollPane(processList);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());  
        scrollPane.setBounds(0, 0, 300, 400);
        
        refresh = new JButton("Refresh");
        // kill = new JButton("Kill Process");

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                HandleProcesses.refreshProcesses(processListModel,GUI.this);
            }
        });

        buttonPanel.add(refresh);
        // buttonPanel.add(kill);
        pack();
        add(scrollPane);
        add(buttonPanel, BorderLayout.SOUTH); 
        setSize(300, 400);
        setVisible(true);
    }
    
}
