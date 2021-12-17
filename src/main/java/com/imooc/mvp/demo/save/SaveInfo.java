package com.imooc.mvp.demo.save;

public class SaveInfo {

    private String title;
    private String author;

    public SaveInfo(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "ArticleInfo{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
