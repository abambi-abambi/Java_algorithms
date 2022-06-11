class Program extends Object {
    public static void errExit() {
        System.out.println("Wrong arguments, please, write: \njava Program --count=1 (or another number instead of 1)");
        System.exit(-1);
    }

    public static void main(String[] args) throws InterruptedException {
        int     count = 0;
        String  name = "Human";

        if (args.length != 1 || args[0].startsWith("--count=") == false) {
            errExit();
        }

        String[] arr = args[0].split("=");
        if (arr.length != 2) {
            errExit();
        }

        try {
            count = Integer.parseInt(arr[1]);
        } catch (Exception e) {
            errExit();
        }

        if (count < 1) {
            errExit();
        }

        MyThread1 thread1 = new MyThread1(count, "Egg");
        Thread thread2 = new Thread(new MyThread2(count, "Hen"), "Runnable Thread");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        for (int i = 0; i < count; i++) {
            System.out.println(name);
        }
    }
}