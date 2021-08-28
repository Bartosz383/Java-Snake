package pl.kru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener {

    
    static final int SCREEN_WIDTH = 600;
    static final  int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;            // the size of the fields
    static  final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];        // snake coordinates
    int bodyParts = 6;
    int dotsEaten;
    int dotX;                                   // dots coordinates
    int dotY;
    char direction = 'R';                       // snake begun to right
    boolean running = false;
    Timer timer;
    Random random;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));  // size of window
        this.setBackground(Color.black);                                    // set color background black
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        starGame();
    }

    public void starGame() {
        newDot();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {                    // Paints each of the components in this container, g - graphics context
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {                                                 // draws the game's graphical interface

        if(running) {

            for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {                         // draws the grid
                g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);     // draws vertical lines
                g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);      // draws horizontal lines
            }

            g.setColor(Color.yellow);                                                    // set dot's color
            g.fillOval(dotX, dotY, UNIT_SIZE, UNIT_SIZE);                              // Fills an oval bounded by the specified rectangle with the current color.

            for (int i = 0; i < bodyParts; i++) {                                       // draws snake's body parts
                if (i == 0) {                                                          // snake's head
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {                                                               // snake's tail
                    g.setColor(new Color(45, 180, 0));
//                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));         // rainbow snake
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }

            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("SCORE: " + dotsEaten, (SCREEN_WIDTH - metrics.stringWidth("SCORE: " + dotsEaten))/2, g.getFont().getSize());

        } else {
            gameOver(g);
        }
    }

    public void newDot() {
        dotX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
        dotY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
    }

    public void move() {

        for(int i = bodyParts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }

        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }

    }

    public void checkDot() {

        if((x[0] == dotX) && (y[0] == dotY)) {          // increase body parts if ate a dot
            bodyParts++;
            dotsEaten++;
            newDot();
        }
    }

    public void checkCollisions() {
        for(int i = bodyParts; i > 0; i--) {            // checks if head collides with body
            if((x[0] == x[i]) && (y[0] == y[i])) {
                running  = false;
            }

        }

        if(x[0] < 0) {                                  //check if head touches left border
            running = false;
        }

        if(x[0] > SCREEN_HEIGHT) {                                  //check if head touches right border
            running = false;
        }

        if(y[0] < 0) {                                  //check if head touches top border
            running = false;
        }

        if(y[0] > SCREEN_HEIGHT) {                                  //check if head touches left border
            running = false;
        }

        if(!running) {
            timer.stop();
        }
    }

    public void gameOver(Graphics g) {
        // Score text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("SCORE: " + dotsEaten, (SCREEN_WIDTH - metrics1.stringWidth("SCORE: " + dotsEaten))/2, g.getFont().getSize());

        // Game over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("GAME OVER", (SCREEN_WIDTH - metrics2.stringWidth("GAME OVER"))/2, SCREEN_HEIGHT/2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(running) {
            move();
            checkDot();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {            // Invoked when a key has been pressed.
            switch (e.getKeyCode()) {                   // Returns the integer keyCode associated with the key in this event
                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;

            }
        }
    }
}
