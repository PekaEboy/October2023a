package bauman.indie.pekaeboy;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    public boolean running = false;

    public void run() {
        init();

        while(running) {
            render();
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.dispose();
        bs.show();
    }

    public void init() {
    }

    public void start() {
        running = true;
        new Thread(this).start();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(400, 300));
        JFrame frame = new JFrame("October2023a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        game.start();
    }
}
