package java2.Logger;

import javafx.scene.control.TextArea;

public class UILogger implements Logger {

    private String text = "";
    private TextArea textArea;

    public UILogger(TextArea textArea) {
        this.textArea = textArea;
    }

    @Override
    public void critical(String message) {
        log("CRITICAL", message);
    }

    @Override
    public void warning(String message) {
        log("WARNING", message);
    }

    @Override
    public void info(String message) {
        log("INFO", message);
    }

    @Override
    public void debug(String message) {
        log("DEBUG", message);
    }

    private void log(String type, String message) {
        text += type + ": " + message + "\n";
        textArea.setText(text);
    }
}
