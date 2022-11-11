package wsb.rest.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException () {
        super("Phone not found.");
    }
}
