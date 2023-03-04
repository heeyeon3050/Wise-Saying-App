package org.example.wiseSaying.entity;

public class WiseSaying {
    private long id;
    private String content;
    private String author;

    public WiseSaying(long id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthorName() {
        return author;
    }

    @Override
    public String toString() {
        return id + " / " + author + " / " + content;
    }
}
