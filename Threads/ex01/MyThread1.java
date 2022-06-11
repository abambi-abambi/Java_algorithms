public class MyThread1 extends Thread {
private static int count;
    private String name;
    private static Printer printer;

    public MyThread1(int count, String name, Printer printer) {
        this.count = count;
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                printer.printMessage1(name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}