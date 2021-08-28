
package pl.kru;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Test implements ActionListener {

    JFrame frame;
    JMenuBar menuBar;
    JMenu menu /*, menu2 */;
//    JMenu subMenu;
    JMenuItem menuItem1 /* , menuItem2, menuItem3 */;
//    JCheckBoxMenuItem checkItem1, checkItem2;

    public Test() {

        menuBar = new JMenuBar();

        menu = new JMenu("New Game");
//        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        /*
        menu2 = new JMenu("Edit");
        menu2.setMnemonic(KeyEvent.VK_E);
        menuBar.add(menu2);
        */

        menuItem1 = new JMenuItem("Start Game" /*, new ImageIcon("file.png") */ );
//        menuItem1.setMnemonic(KeyEvent.VK_L);
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

//        menuItem2 = new JMenuItem("Save", new ImageIcon("save.png"));
//        menuItem2.setMnemonic(KeyEvent.VK_S);
//        menuItem2.addActionListener(this);
//        menu.add(menuItem2);

//        menuItem3 = new JMenuItem("Options", new ImageIcon("options.png"));
//        menuItem3.setMnemonic(KeyEvent.VK_O);
//        menuItem3.addActionListener(this);
//        menu.add(menuItem3);
//
//        subMenu = new JMenu("submenu");
//        menu.add(subMenu);
//
//        checkItem1 = new JCheckBoxMenuItem("item #1");
//        checkItem1.addActionListener(this);
//        subMenu.add(checkItem1);
//
//        checkItem2 = new JCheckBoxMenuItem("item #2");
//        checkItem2.addActionListener(this);
//        subMenu.add(checkItem2);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setJMenuBar(menuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == menuItem1) {
            GameFrame frame = new GameFrame();
//            System.out.println("*beep boop* you have loaded the file");
        }
//        if(e.getSource() == menuItem2) {
//            System.out.println("*beep boop* you have saved the file");
//        }
//        if(e.getSource() == menuItem3) {
//            System.out.println("*beep boop* you have opened the options menu");
//        }
//        if(e.getSource() == checkItem1 && checkItem1.isSelected()) {
//            System.out.println("*beep boop* you have selected Item #1");
//        }
//        if(e.getSource() == checkItem1 && !checkItem1.isSelected()) {
//            System.out.println("*beep boop* you have unselected Item #1");
//        }
//        if(e.getSource() == checkItem2 && checkItem2.isSelected()) {
//            System.out.println("*beep boop* you have selected Item #2");
//        }
//        if(e.getSource() == checkItem2 && !checkItem2.isSelected()) {
//            System.out.println("*beep boop* you have unselected Item #2");
//        }
    }
}
