import java.util.List;

public class CalculationResults implements Runnable {
    private List<Integer> allNumbers;
    private int beginPosition;
    private int endPosition;
    private int[] threadSums;
    private int threadId;

    public CalculationResults(List<Integer> allNumbers, int beginPosition,
                              int endPosition, int[] threadSums, int threadId) {
        this.allNumbers = allNumbers;
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
        this.threadSums = threadSums;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        int sum;

        sum = 0;
        for (Integer num : allNumbers) {
            sum += num;
        }
        threadSums[threadId] = sum;
        System.out.println(this);
    }

    @Override
    public String toString() {
        String result;

        result = "Thread " + (threadId + 1) + ": from " + beginPosition + " to " + (endPosition - 1)
                + " sum is " + threadSums[threadId];
        return (result);
    }
}