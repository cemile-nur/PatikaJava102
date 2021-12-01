package com.company;

public class Book {
    private String name, writer;
    private int page;

    public Book(String name, String writer, int page) {
        this.name = name;
        this.writer = writer;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Kitap Adı: "+name +" - Sayfa Sayısı: "+page+" - Yazar: "+writer);
        return sb.toString();
    }
}
