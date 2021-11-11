package com.company;

import java.util.Date;

public class Book {
    private  String bookName,writerName;
    private int pageNum,releaseDate;


public  Book(String bookName, String writerName, int pageNum, int releaseDate){

    this.bookName=bookName;
    this.writerName=writerName;
    this.pageNum=pageNum;
    this.releaseDate=releaseDate;
}


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }
}
