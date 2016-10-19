public class CoreResult {
    private final String message;
    private final boolean isError;

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return isError;
    }

    public CoreResult(String message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }
}
