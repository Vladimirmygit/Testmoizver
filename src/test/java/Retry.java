import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
    private int actualRetry = 0;
    private static final int Max_retry = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (actualRetry < Max_retry) {
            actualRetry++;
            return true;
        } else {
            return false;
        }
    }
}
