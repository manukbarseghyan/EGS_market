package exception;

import java.sql.SQLException;

public class NotFoundException extends SQLException{

    public NotFoundException(String message) {
        super(message);
    }
}
