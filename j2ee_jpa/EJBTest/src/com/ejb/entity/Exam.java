package com.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Tonndiyee on 2016/12/19.
 */
@Entity
@Table(name = "examresult")
public class Exam implements Serializable {
    @Id
    private String examName;

    @Id
    private String username;

    private int examMark;
    private int q1Mark;
    private int q2Mark;
    private int q3Mark;

    public Exam() {

    }

    public Exam(String examName, String username, int examMark, int q1Mark, int q2Mark, int q3Mark) {
        this.examName = examName;
        this.username = username;
        this.examMark = examMark;
        this.q1Mark = q1Mark;
        this.q2Mark = q2Mark;
        this.q3Mark = q3Mark;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getExamMark() {
        return examMark;
    }

    public void setExamMark(int examMark) {
        this.examMark = examMark;
    }

    public int getQ1Mark() {
        return q1Mark;
    }

    public void setQ1Mark(int q1Mark) {
        this.q1Mark = q1Mark;
    }

    public int getQ2Mark() {
        return q2Mark;
    }

    public void setQ2Mark(int q2Mark) {
        this.q2Mark = q2Mark;
    }

    public int getQ3Mark() {
        return q3Mark;
    }

    public void setQ3Mark(int q3Mark) {
        this.q3Mark = q3Mark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
