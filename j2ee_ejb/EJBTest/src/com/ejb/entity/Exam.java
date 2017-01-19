package com.ejb.entity;

import java.io.Serializable;

/**
 * Created by Tonndiyee on 2016/12/19.
 */
public class Exam implements Serializable {
    private String examName;
    private int examMark;
    private int q1Mark;
    private int q2Mark;
    private int q3Mark;

    public Exam(){

    }
    public Exam(String examName, int examMark, int q1Mark, int q2Mark, int q3Mark) {
        this.examName = examName;
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
}
