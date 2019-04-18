import javax.swing.*;
import java.awt.*;

/**
 * @Author: 王帆
 * @CreateTime: 2019-03-08 17:04
 * @Description:
 */
public class frame {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    static class SimpleFrame extends JFrame {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;

        public SimpleFrame() {
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
