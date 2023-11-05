import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoveAnimation extends JPanel {
    private int scale = 1;
    private Timer timer;

    public LoveAnimation() {
        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scale = (scale == 1) ? 2 : 1;
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int fontSize = Math.min(width, height) / 4;
        Font font = new Font("Arial", Font.BOLD, fontSize);

        g.setFont(font);
        g.setColor(Color.RED);

        String heart = "♥";
        int x = width / 2 - fontSize / 2;
        int y = height / 2 + fontSize / 4;

        for (int i = 0; i < scale; i++) {
            g.drawString(heart, x - i * fontSize / 6, y - i * fontSize / 6);
            g.drawString(heart, x + i * fontSize / 6, y - i * fontSize / 6);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Love Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new LoveAnimation());
        frame.setVisible(true);
    }
}
