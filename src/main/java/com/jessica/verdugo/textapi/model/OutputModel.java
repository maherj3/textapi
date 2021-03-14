package com.jessica.verdugo.textapi.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

@Entity
@Data
public class OutputModel {
    private @Id @GeneratedValue Long id;
    private TreeMap<Integer, Integer> wordsLength;
    private Integer wordCount;
    private double averageLength;
    private HashMap<Integer, List<Integer>> frequency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TreeMap<Integer, Integer> getWordsLength() {
        return wordsLength;
    }

    public void setWordsLength(TreeMap<Integer, Integer> wordsLength) {
        this.wordsLength = wordsLength;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public double getAverageLength(double averageLength) {
        return this.averageLength;
    }

    public void setAverageLength(double averageLength) {
        this.averageLength = averageLength;
    }

    public double getAverageLength() {
        return averageLength;
    }


    public HashMap<Integer, List<Integer>> getFrequency() {
        return frequency;
    }

    public void setFrequency(HashMap<Integer, List<Integer>> frequency) {
        this.frequency = frequency;
    }

}
