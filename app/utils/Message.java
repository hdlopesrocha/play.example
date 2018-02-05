package utils;

import java.io.Serializable;

public class Message implements Serializable {
    private String type;
    private String content;

    public Message() {
    }

    public Message(final String type, final String content) {
        this.type = type;
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }
}
