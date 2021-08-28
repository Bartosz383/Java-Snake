/* package pl.kru;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JMenuBar menuBar;
    JMenu menuPlik, menuNarzędzia, menuPomoc;       // Poszczególen menu
    JMenuItem mOtwórz, mZapisz;                              // pdzbiory menu (przyciski)

    public JMenuTest() {
        setTitle("JMenuBar");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        menuBar = new JMenuBar();
        menuPlik = new JMenu(("Plik"));
        menuNarzędzia = new JMenu("Narzędzia");
        menuPomoc = new JMenu("Pomoc");

        setJMenuBar((menuBar));
        menuBar.add(menuPlik);
        menuBar.add(menuNarzędzia);
        menuBar.add(menuPomoc);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
*/