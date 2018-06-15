package com.example.dheeraj.loktratask.models;

/**
 * Created by dheeraj on 15/6/18.
 */

public class CommitData {
    public Commit commit;
    public UserFullInfo committer;
    public UserFullInfo author;


    public UserFullInfo getAuthor() {
        return author;
    }

    public void setAuthor(UserFullInfo author) {
        this.author = author;
    }

    public UserFullInfo getCommitter() {
        return committer;
    }

    public void setCommitter(UserFullInfo committer) {
        this.committer = committer;
    }

    public Commit getCommit() {
        return commit;
    }

    public void setCommit(Commit commit) {
        this.commit = commit;
    }
}

