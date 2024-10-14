package ProjectXI;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

public class core extends ui
{
    public static void main(String[]args)
    {
        ui.frame();
        SearchEngine.putter();
        searchButton.addMouseListener(listener.searchML());
        searchButton.addKeyListener(listener.searchKL());
        clearButton.addMouseListener(listener.clearML());


    }

}
