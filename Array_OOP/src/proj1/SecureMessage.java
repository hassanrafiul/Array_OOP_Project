
package proj1;

public class SecureMessage {

    private String message;
    private String sourceName;
    private String destName;
    private String key;

    public SecureMessage(String msg, String srcnm, String dstnm, String ky) {
        this.message = msg;
        this.sourceName = srcnm;
        this.destName = dstnm;
        this.key = ky;
    }

    public String getMessage(String ky) {
        if (ky.equals(key)) {
            return "Correct Key " + message;
        } else {
            return "Incorrect Key. Key does not match stored key. Message cannot be displayed.";
        }
    }

    public String getSourceName() {
        return sourceName;
    }

    public String getDestName() {
        return destName;
    }

}
