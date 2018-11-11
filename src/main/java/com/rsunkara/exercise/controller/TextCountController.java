package com.rsunkara.exercise.controller;

import com.rsunkara.exercise.model.WordCount;
import com.rsunkara.exercise.service.TextCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class TextCountController {

    @Autowired
    private TextCountService textCountService;

    @PostMapping("/word_count_per_sentence")
    public Collection<WordCount> getWordCountPerSentence(@RequestBody Map<Integer, String> sentenceMap) {
        return textCountService.getWordCountBySentence(sentenceMap);
    }

    @PostMapping("/total_letter_count")
    public Map<Character, Integer> getLetterCount(@RequestBody Map<Integer, String> sentenceMap) {
        return textCountService.getLetterCount(sentenceMap);
    }
}