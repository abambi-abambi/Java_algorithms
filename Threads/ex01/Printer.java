public class Printer {
	private Category category = Category.EGG;
	private enum Category {
		EGG,
		HEN
	}
	public synchronized void printMessage1(String name) throws InterruptedException {
		if (category != Category.EGG) {
			wait();
		}
		System.out.println(name);
		category = Category.HEN;
		notify();
	}

	public synchronized void printMessage2(String name) throws InterruptedException {
		if (category != Category.HEN) {
			wait();
		}
		System.out.println(name);
		category = Category.EGG;
		notify();
	}
}