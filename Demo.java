import java.awt.EventQueue;
import javax.swing.JFrame;

import javax.swing.JPanel;
/*
  public class Board extends JPanel {

      public Board() {}
  }
*/
public class Demo extends JFrame {
    public Demo() {
        initUI();
    }

    private void initUI() {
        add(new JPanel());
        setSize(500, 500);
        setTitle("Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Demo ex = new Demo();
            ex.setVisible(true);
        });
    }
}

