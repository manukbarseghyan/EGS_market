package exception;

import java.sql.SQLException;
public class BadRequestException extends SQLException {
    public BadRequestException(String message) {
        super(message);
    }
}
