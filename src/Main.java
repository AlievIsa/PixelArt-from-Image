import javax.imageio.ImageIO;
import java.io.File;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        System.out.println(k);
        try {
            // Открываем изображение
            File file = new File("minion.jpg");
            BufferedImage source = ImageIO.read(file);

            // Создаем новое пустое изображение, такого же размера
            BufferedImage result = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());

            // Делаем двойной цикл, чтобы обработать каждый пиксель
            for (int x = 0; x < source.getWidth() - k; x+=k) {
                for (int y = 0; y < source.getHeight(); y+=k) {

                    // Получаем цвет текущего пикселя
                    Color color = new Color(source.getRGB(x, y));

                    // И устанавливаем этот цвет в область пикселей в зависимости от коэффициента
                    for (int j = x; j < x + k; j++) {
                        for (int i = y; i < y + k; i++) {
                            result.setRGB(j, i, color.getRGB());
                        }
                    }
                }
            }

            // Созраняем результат в новый файл
            File output = new File("pixeledMinion.jpg");
            ImageIO.write(result, "jpg", output);

        } catch (IOException e) {

            // При открытии и сохранении файлов, может произойти неожиданный случай.
            // И на этот случай у нас try catch
            System.out.println("Файл не найден или не удалось сохранить");
        }
    }
}



/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JComponent implements KeyListener, ActionListener {

    Image minion = new ImageIcon("C:/Users/user/Desktop/Study/minion.jpg").getImage();

    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D)g;
        g2D.drawImage(minion, 0, 0, null);
    }

    public static void main(String[] args) {
        Main main = new Main();
        JFrame frame = new JFrame("Graphic test");
        frame.setSize(627, 720);
        frame.setLocation(450, 50);
        frame.addKeyListener(main);
        frame.add(new Main());
        frame.add(main);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}*/

