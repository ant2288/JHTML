package cn.abble.jhtml.util;

import cn.abble.jhtml.tags.Tag;

import java.util.List;

public class SelectReturnResult {
    public static final String OK = "OK";

    private String message;
    private List<Tag> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Tag> getResult() {
        return result;
    }

    public void setResult(List<Tag> result) {
        this.result = result;
    }
}
