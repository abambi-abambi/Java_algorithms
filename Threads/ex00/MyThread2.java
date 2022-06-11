public class MyThread2 extends Object implements Runnable {
    private static int  count;
    private String      name;

    public MyThread2(int count, String name) {
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