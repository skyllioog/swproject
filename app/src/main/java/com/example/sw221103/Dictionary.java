package com.example.sw221103;

public class Dictionary {

    private String id;
    private String Title;
    private String Content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Dictionary(String id, String title, String content) {
        this.id = id;
        Title = title;
        Content = content;
    }
}
