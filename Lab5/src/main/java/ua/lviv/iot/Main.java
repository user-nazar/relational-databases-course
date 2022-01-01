package ua.lviv.iot;

import ua.lviv.iot.view.MyView;

public class Main {

    public static void main(final String[] args) throws Exception {
        try {
            new MyView().show();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            System.exit(0);
        }
    }
}
