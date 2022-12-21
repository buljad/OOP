package ru.nsu.izhuravskii;

import java.util.Date;

public class Note {
    private String title;
    private String content;
    private Date date;

    public void makeNote(String title, String content) {
        this.content = content;
        this.title = title;
        setNoteTime();
    }

    public void setNoteTime() {
        date = new Date();
    }
}
