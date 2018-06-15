package com.example.dheeraj.loktratask.models;

/**
 * Created by dheeraj on 15/6/18.
 */

public class Commit {
    public User author,committer;
    public String message;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getCommitter() {
        return committer;
    }

    public void setCommitter(User committer) {
        this.committer = committer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
