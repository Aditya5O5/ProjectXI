package ProjectXI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

/**
 *  Creating an expert system for medical diagnosis on the basis of symptoms and prescribe a suitable treatments
 */

public class ui
{

    public static JPanel labelSymptoms,symptomPanel,treatmentPanel, labelTreatment,searchPanel,clearPanel;
    static JFrame frame = new JFrame();
    static int centerX,centerY;
    static JButton clearButton,searchButton;
    static JTextField symptomField1 = new JTextField("1) ");
    static JTextField symptomField2 = new JTextField("2) ");
    static JTextField symptomField3 = new JTextField("3) ");
    static JTextField symptomField4 = new JTextField("4) ");
    static JTextArea treatment = new JTextArea();
    static JLabel treatmentLabel = new JLabel("Expected Disease and Treatment :");

    public static void frame() {
        frame.setIconImage(new ImageIcon("src/ProjectXI/icon.jpg").getImage());
        frame.setContentPane(new BackgroundPanel());
        frame.setSize(500, 500);
        frame.setLayout(null);
        centerX = frame.getWidth() / 2;
        centerY = frame.getHeight() / 2;

        labelSymptoms = getLabelSymptoms();
        symptomPanel = getSymptoms();
        treatmentPanel = getTreatments();
        labelTreatment = getLabelTreatment();

        searchPanel = getSearch();
        clearPanel = getClear();

        // Caret Position Setter
        {
            symptomField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (symptomField1.getText().equals("1) ")) {
                    symptomField1.setCaretPosition(3);
                }

            }
            @Override
            public void focusLost(FocusEvent e) {}
        });

            symptomField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (symptomField2.getText().equals("1) ")) {
                    symptomField2.setCaretPosition(3);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {}
        });

        symptomField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (symptomField3.getText().equals("1) ")) {
                    symptomField3.setCaretPosition(3);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {}
        });

        symptomField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (symptomField4.getText().equals("1) ")) {
                    symptomField4.setCaretPosition(3);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

    }


        symptomField1.addKeyListener(listener.searchKL());
        symptomField2.addKeyListener(listener.searchKL());
        symptomField3.addKeyListener(listener.searchKL());
        symptomField4.addKeyListener(listener.searchKL());

        frame.add(symptomPanel);
        frame.add(labelSymptoms);
        frame.add(treatmentPanel);
        frame.add(labelTreatment);
        frame.add(searchPanel);
        frame.add(clearPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Project XI");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private static JPanel getLabelSymptoms() {
        JLabel symptomsLabel = new JLabel("Enter Symptoms");
        symptomsLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 20));
        symptomsLabel.setBounds(5, 10, 150, 30);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(centerX-132, 25, 160, 40);
        panel.setBackground(Color.decode("#E3E3E3"));
        panel.add(symptomsLabel);
        return panel;
    }

    private static JPanel getSearch(){
        searchButton = new JButton("Search");
        searchButton.setContentAreaFilled(false);
        searchButton.setOpaque(true);
        searchButton.setBackground(Color.decode("#F7F7F7"));
        searchButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
        searchButton.setBounds(2, 2, 100, 35);
        searchButton.setSelected(false);
        searchButton.setBorderPainted(false);
        searchButton.setFocusPainted(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(centerX+120, 60, 104, 40);
        panel.add(searchButton);
        panel.setBackground(Color.decode("#F7F7F7"));
        panel.setBorder(new LineBorder(Color.decode("#BDBDBD"),3));
        return panel;
    }

    private static JPanel getClear(){

        clearButton = new JButton("Clear");
        clearButton.setContentAreaFilled(false);
        clearButton.setOpaque(true);
        clearButton.setBackground(Color.decode("#F7F7F7"));
        clearButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 22));
        clearButton.setBounds(2, 2, 100, 35);
        clearButton.setSelected(false);
        clearButton.setBorderPainted(false);
        clearButton.setFocusPainted(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(centerX+120, 115, 104, 40);
        panel.add(clearButton);
        panel.setBackground(Color.decode("#F7F7F7"));
        panel.setBorder(new LineBorder(Color.decode("#BDBDBD"),3));
        return panel;
    }

    private static JPanel getSymptoms() {
        Font font = new Font("Serif", Font.PLAIN, 25);

        // Fixed prefix code
        {
            symptomField1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        String currentText = symptomField1.getText();
                        if (!currentText.startsWith("1) ")) {
                            symptomField1.setText("1) ");

                        }
                    });
                }
            });

            symptomField2.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        String currentText = symptomField2.getText();
                        if (!currentText.startsWith("2) ")) {
                            symptomField2.setText("2) ");

                        }
                    });
                }
            });

            symptomField3.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    SwingUtilities.invokeLater(() -> {
                        String currentText = symptomField3.getText();
                        if (!currentText.startsWith("3) ")) {
                            symptomField3.setText("3) ");

                        }
                    });
                }
            });

            symptomField4.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                SwingUtilities.invokeLater(() -> {
                    String currentText = symptomField4.getText();
                    if (!currentText.startsWith("4) ")) {
                        symptomField4.setText("4) ");
                    }
                });
            }
            });

    }

        symptomField1.setFont(font);
        symptomField1.setBorder(null);
        symptomField2.setFont(font);
        symptomField2.setBorder(null);
        symptomField3.setFont(font);
        symptomField3.setBorder(null);
        symptomField4.setFont(font);
        symptomField4.setBorder(null);


        int width = frame.getWidth()-150, height = 40;
        symptomField1.setBounds(7, 5, width-22, height);
        symptomField2.setBounds(7, height + 10, width-22, height);
        symptomField3.setBounds(7, 2 * height + 15, width-22, height);
        symptomField4.setBounds(7, 3 * height + 20, width-22, height);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(25, 60, width - 8, height * 4 + 27);
        panel.setForeground(Color.black);
        panel.setBackground(Color.black);

        panel.add(symptomField1);
        panel.add(symptomField2);
        panel.add(symptomField3);
        panel.add(symptomField4);

        return panel;
    }

    private static JPanel getLabelTreatment() {
        treatmentLabel.setOpaque(true);
        treatmentLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        treatmentLabel.setBounds(5, 0, frame.getWidth()-50, 35);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.setBounds(20, 272, frame.getWidth()-60, 35);
        panel.add(treatmentLabel);
        return panel;
    }

    private static JPanel getTreatments() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.yellow);
        panel.setBounds(20, 295+15, 440, 130);


        treatment.setLineWrap(true);  // Enable line wrap
        treatment.setFont(new Font("Serif",Font.PLAIN,20));
        treatment.setWrapStyleWord(true);
        treatment.setEditable(false);
        treatment.setOpaque(true);
        treatment.setSelectedTextColor(Color.BLACK);
        treatment.setBounds(5, 5, 430, 120);
        treatment.setBorder(new LineBorder(Color.blue,1));

        panel.add(treatment);
        return panel;
    }
}

class BackgroundPanel extends JPanel {
        private final Image backgroundImage;

        public BackgroundPanel() {
            backgroundImage = new ImageIcon("src/ProjectXI/icon.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));

            AffineTransform transform = AffineTransform.getScaleInstance((double) getWidth() /backgroundImage.getWidth(null), (double) getWidth() /backgroundImage.getHeight(null));
            g2d.drawImage(backgroundImage, transform, this);

            g2d.dispose();
        }
    }


