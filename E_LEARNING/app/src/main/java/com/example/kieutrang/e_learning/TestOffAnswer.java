package com.example.kieutrang.e_learning;

/**
 * Created by KieuTrang on 11/1/2015.
 */
public class TestOffAnswer {

    private String answer, myanswer;
    private int id;

    public TestOffAnswer() {
        super();
    }

    public TestOffAnswer(String answer, String myanswer, int id) {
        super();
        this.answer = answer;
        this.myanswer = myanswer;
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMyanswer() {
        return myanswer;
    }

    public void setMyanswer(String myanswer) {
        this.myanswer = myanswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

