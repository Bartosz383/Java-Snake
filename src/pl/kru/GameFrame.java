package pl.kru;

import javax.swing.*;
// import javax.swing.JFrame;

public class GameFrame extends JFrame {



    GameFrame() {

//        GamePanel panel = new GamePanel();
//
//        this.add(panel);
// this is the same as this

        this.add(new GamePanel());
        this.setTitle("Snake");                                     // set name of the game
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // sets the operation that will happen by default when the user initiates a "close" on this frame.
        this.setResizable(true);                                   // user cannot re-seize the frame
        this.pack();                                                // Causes this Window to be sized to fit the preferred size and layouts of its subcomponents.
        this.setVisible(true);                                      //  if true, makes the Window visible
        this.setLocationRelativeTo(null);                           // the window is placed in the center of the screen


    }
}
