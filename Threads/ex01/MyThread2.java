public class MyThread2 extends Object implements Runnable {
    private static int  count;
    private String      name;
    private static Printer printer;

    public MyThread2(int count, String name, Printer printer) {
        this.count = count;
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                printer.printMessage2(name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}