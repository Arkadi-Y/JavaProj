package ongoing;

import windows.*;

public class main {
    public static void main(String[] args) {
        try {
            new MainWindow();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
