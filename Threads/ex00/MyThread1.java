public class MyThread1 extends Thread {
    private static int  count;
    private String      name;

    public MyThread1(int count, String name) {
        this.count = count;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
    }
}