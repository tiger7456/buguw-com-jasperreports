package buguw.com.report.exception;

/**
 * 报表异常
 * @author 方宗虎
 * @since 2012-5-15
 * @version 1.1.0
 */
public class ReportException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String resonCode = "-1";

    public ReportException() {

    }

    public ReportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ReportException(String message) {
        super(message);
    }

    public ReportException(String message, String resonCode) {
        super(message);
        this.resonCode = resonCode;
    }

    public ReportException(Throwable cause) {
        super(cause);
    }

    public String getResonCode() {
        return this.resonCode;
    }
}
