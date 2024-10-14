package ProjectXI;

import java.awt.*;
import java.awt.event.*;

/**
 *  Contains all listener methods for different components of ui class.
 */

public class listener extends ui
{
    public static MouseListener searchML()
    {
        return new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                SearchEngine.SearchMatcher(ui.symptomField1.getText().substring(3),ui.symptomField2.getText().substring(3),ui.symptomField3.getText().substring(3),ui.symptomField4.getText().substring(3));
                searchButton.setBackground(Color.decode("#A8A8A8"));
                searchButton.setForeground(Color.white);
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                SearchEngine.SearchMatcher(ui.symptomField1.getText().substring(3),
                        ui.symptomField2.getText().substring(3),
                        ui.symptomField3.getText().substring(3),
                        ui.symptomField4.getText().substring(3));
                searchButton.setForeground(Color.black);
                searchButton.setBackground(Color.decode("#F7F7F7"));
            }

        };
    }

    public static KeyListener searchKL()
    {
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER)
                    SearchEngine.SearchMatcher(ui.symptomField1.getText().substring(3),ui.symptomField2.getText().substring(3),ui.symptomField3.getText().substring(3),ui.symptomField4.getText().substring(3));
                searchButton.setForeground(Color.black);
                searchButton.setBackground(Color.decode("#F7F7F7"));
            }
        };
    }

    public static MouseListener clearML()
    {
        return new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                treatment.setText("");
                treatmentLabel.setText("Expected Disease and Treatment");
                symptomField1.setText("1) ");
                symptomField2.setText("2) ");
                symptomField3.setText("3) ");
                symptomField4.setText("4) ");
                symptomField1.isCursorSet();
                symptomField1.isEnabled();
                clearButton.setBackground(Color.decode("#A8A8A8"));
                clearButton.setForeground(Color.white);
            }

            public void mouseReleased(MouseEvent e)
            {
                treatment.setText("");
                treatmentLabel.setText("Expected Disease and Treatment");
                symptomField1.setText("1) ");
                symptomField2.setText("2) ");
                symptomField3.setText("3) ");
                symptomField4.setText("4) ");

                symptomField1.requestFocus();
                symptomField1.setCaretPosition(3);

                clearButton.setBackground(Color.decode("#F7F7F7"));
                clearButton.setForeground(Color.black);
            }
        };
    }
}
