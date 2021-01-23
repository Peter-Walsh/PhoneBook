package utilities;

public class Counter {
    private double start;
    private double end;

    public void start() {
        this.start = System.currentTimeMillis();
    }

    public void stop() {
        this.end = System.currentTimeMillis();
    }

    public double getStart() {
        return this.start;
    }

    public double getEnd() {
        return this.end;
    }

    public double timeTaken() {
        return this.end - this.start;
    }

    public String getTimeTaken() {
        String res;
        int mili = (int) (end - start);
        int minutes = mili / (60 * 1000);
        mili %= 60 * 1000;
        int seconds = mili / 1000;
        mili %= 1000;
        res = "Time taken: " + minutes + " min. " + seconds + " sec. " + mili + " ms. ";
        return res;
    }
}
