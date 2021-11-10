package exception;

import java.io.IOException;

public class TextFileException extends RuntimeException{

    public TextFileException(IOException e) {
        super(e);
    }
}
