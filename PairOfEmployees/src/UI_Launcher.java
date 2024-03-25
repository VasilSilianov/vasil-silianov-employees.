import java.awt.*;

public class UI_Launcher {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.show();
            }
        });
    }
}
