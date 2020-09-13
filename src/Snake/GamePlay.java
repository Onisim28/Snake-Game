package Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private int headX = 200;
    private int headY = 200;
    private int head_dirX = 200;
    private int head_dirY = 200;
    private boolean up = false;
    private boolean right = false;
    private boolean left = false;
    private boolean down = false;
    private boolean isGameOver = false;
    private boolean gameStarted = false;
    private boolean first_fruit_wasEaten = false;
    private int number_ofEatenFruits = 0;

    Timer timer;
    private int speed_ofSnake = 15;
    private int[] ntailX;
    private int[] ntailY;
    private Fruit fruit;

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(speed_ofSnake, this);
        timer.start();
        fruit = new Fruit();
        ntailX = new int[10000];
        ntailY = new int[10000];
    }

    public void paint(Graphics graphics) {

        graphics.setColor(Color.black);
        graphics.fillRect(1, 1, 692, 592);//Background

        graphics.setColor(Color.GREEN);//Snake Head
        graphics.fillRect(headX, headY, 30, 30);

        graphics.setColor(Color.RED);//Fruit
        graphics.fillOval(fruit.getFruitX(), fruit.getFruitY(), 25, 25);

        if (first_fruit_wasEaten) {
            for (int i = 0; i < number_ofEatenFruits; i++) {
                graphics.setColor(Color.CYAN);//Tale
                graphics.fillRect(ntailX[i], ntailY[i], 30, 30);
            }
            graphics.dispose();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if (up) {
            move(true, false, false, false);
            if (headY <= 1)
                headY = 592;
        }
        if (right) {
            move(false, true, false, false);
            if (headX >= 692)
                headX = 1;
        }
        if (left) {
            move(false, false, true, false);
            if (headX <= 1)
                headX = 692;
        }
        if (down) {
            move(false, false, false, true);
            if (headY >= 592)
                headY = 1;
        }

        fruit_wasAte_Action();

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
            right = false;
            left = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            up = false;
            right = true;
            left = false;
            down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            up = false;
            right = false;
            left = true;
            down = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            up = false;
            right = false;
            left = false;
            down = true;
        }
    }

    public void move(boolean up,boolean right,boolean left,boolean down) {
        int tailX,tailY,prev_tailX,prev_tailY;

        prev_tailX=headX;
        prev_tailY=headY;

        if(up) {
            headY -= 5;
        }
        else if(right)

    {
        headX += 5;
    }
    else if(left)

    {
        headX -= 5;
    }
    else if(down)

    {
        headY += 5;
    }
        for(int i = 0; i<number_ofEatenFruits;i++)

        {
            tailX = ntailX[i];
            tailY = ntailY[i];

            ntailX[i] = prev_tailX;
            ntailY[i] = prev_tailY;

            prev_tailX = tailX;
            prev_tailY = tailY;
        }
    }




    public boolean fruit_wasAte() {
        if (new Rectangle(headX, headY, 30, 30).intersects(
                new Rectangle(fruit.getFruitX(), fruit.getFruitY(), 25, 25))) {
            first_fruit_wasEaten=true;
            number_ofEatenFruits++;
            return true;
        }
        return false;
    }


        public void fruit_wasAte_Action(){
            if(fruit_wasAte()) {
               fruit.display_aFruitX();
               fruit.display_aFruitY();
            }
        }

    }

