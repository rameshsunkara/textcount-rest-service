package com.rsunkara.exercise.model;

public class WordCount {

    private String sentence;

    private Integer count;

    public WordCount(String sentence, Integer count) {
        this.sentence = sentence;
        this.count = count;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
