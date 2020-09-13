package Snake;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        GamePlay gamePlay=new GamePlay();
        JFrame frame = new JFrame();
        frame.setBounds(10,10,700,600);
        frame.setTitle("Classic Snake");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(gamePlay);

    }
}
