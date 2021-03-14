package com.jessica.verdugo.textapi.service;

import com.jessica.verdugo.textapi.model.OutputModel;
import org.springframework.stereotype.Service;
import java.io.*;
import java.net.URL;
import java.util.*;


@Service
public class TextServiceImpl implements TextService {

    @Override
    public OutputModel outputModelCreate(URL url) throws IOException {
        OutputModel output = new OutputModel(); //Create the new model object
        TreeMap<Integer, Integer> wordLengthMap = new TreeMap<>(); //I have used a tree map in order to give a sorted output
        Scanner s = new Scanner(new InputStreamReader(url.openStream())); //the Scanner is used to read the stream of the input txt file

        Integer length;
        while(s.hasNext()) { //read if only there is another line to read
            length = s.next().length();//what is the length of the next word
            if(wordLengthMap.containsKey(length)) { //do we already have that length is so
                Integer oldValue = wordLengthMap.get(length); //get the old length
                Integer newValue = oldValue + 1; //add one cause we have another
                wordLengthMap.replace( length, oldValue, newValue); //replace within the map
            }else{
                wordLengthMap.put(length, 1); //the first occurrence of that word length
            }
        }
        output.setWordsLength(wordLengthMap); //set the final output for the word length map
        wordCount(output); //call the next functions with the output model
        averageLength(output);
        fequentlyUsed(output);
        return output;
    }

    private static void wordCount(OutputModel outputModel) {
        Integer wordsSum = 0;
        for (Integer f: outputModel.getWordsLength().values()){ //Use the map values and add them all together in order to get the totle word count
            wordsSum += f;
        }
        outputModel.setWordCount(wordsSum); // set the word count figure
    }

    private static void averageLength(OutputModel outputModel) {
        double averageLength = 0d;
        for (Map.Entry<Integer, Integer> f : outputModel.getWordsLength().entrySet()) { //Use the Map entries in order to do the average length math
            averageLength += (f.getValue() * f.getKey()); //for each entry we need the multiple the length by the amount of that length
        }
        averageLength /= outputModel.getWordCount(); //then divide all the figures by the total word count
        outputModel.setAverageLength(averageLength); // set the output average word length value
    }

    private static void fequentlyUsed(OutputModel outputModel) {
        TreeMap<Integer, Integer> outputModelWordsLength = outputModel.getWordsLength();
        List<Integer> check = new ArrayList<>();
        List<Integer> dupCheck = new ArrayList<>();
        List<Integer> dupLengths = new ArrayList<>(); //
        HashMap<Integer, List<Integer>> freq = new HashMap<>();

        outputModelWordsLength.forEach((key, value) -> {
            if (!check.contains(value)) {//check if we had that frequency before, if not add it to the list
                check.add(value);
            } else {
                dupCheck.add(value);//not we have seen it before we add it to the duplicate list
            }
        });
        int dupHi = Collections.max(dupCheck); //get the max number ie the most frequent
        outputModelWordsLength.forEach((key, value) ->{ // now we are gonna check how many values are equal to the most frequent
            if (value.equals(dupHi)){
                dupLengths.add(key); // and add it to a list
            }
        });
        freq.put(dupHi, dupLengths); // now setting the most frequent number as a key and the list as the values
        outputModel.setFrequency(freq);
    }

}
