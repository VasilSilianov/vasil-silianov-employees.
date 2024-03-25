import records.WorkedTogether;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class MainFrame extends Component {
    private JFrame frame;
    private JPanel panel;

    public JButton btnBrowse;
    private JFileChooser chooser;
    private JScrollPane scrollPane;
    private JTextArea textArea;


    public MainFrame() {
        init();
    }

    private void init() {

        frame = new JFrame();
        frame.setTitle("Pair of employees");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        btnBrowse = createButton();
        textArea = createTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(btnBrowse);
        panel.add(scrollPane);
        frame.add(panel, BorderLayout.CENTER);
    }

    public void show() {
        this.frame.setVisible(true);
    }

    private JButton createButton() {
        JButton button = new JButton("Browse...");
        button.setFocusable(false);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == btnBrowse) {
                    chooser = new JFileChooser();
                    int res = chooser.showOpenDialog(null);

                    if (res == JFileChooser.APPROVE_OPTION) {
                        File filePath = new File(chooser.getSelectedFile().getPath());
                        try {
                            List<WorkedTogether> workedTogetherList = EmployeeOperations.findEmployeePairWorkedTogether(filePath.getAbsolutePath());
                            textArea.setText(Utils.printWorkedTogether(workedTogetherList));
                        } catch (IOException | ParseException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });

        return button;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea(10, 20);
        textArea.setEditable(false);

        return textArea;
    }
}

