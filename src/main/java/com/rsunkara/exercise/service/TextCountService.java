package com.rsunkara.exercise.service;

import com.rsunkara.exercise.model.WordCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TextCountService {

    private static final Logger logger = LoggerFactory.getLogger(TextCountService.class);

    private static final String SENTENCE_DELIMITER_REGEX = "[!.?]";
    private static final String WORD_DELIMITER_REGEX = "\\s";

    public Collection<WordCount> getWordCountBySentence(Map<Integer, String> sentencesMap) {
        List<WordCount> list = sentencesMap
                .keySet()
                .stream()
                .map(key -> getWordCount(Optional.ofNullable(sentencesMap.get(key))))
                .flatMap(wordCounts -> wordCounts.orElse(new ArrayList<>()).stream())
                .collect(Collectors.toList());
        logger.debug("Returning:" + list.size());
        return list;
    }


    private Optional<List<WordCount>> getWordCount(Optional<String> sentenceGroup) {
        if (sentenceGroup.isPresent()) {
            List<WordCount> list = Arrays.stream(sentenceGroup.get().split(SENTENCE_DELIMITER_REGEX))
                    .map(sentence -> sentence.trim())
                    .map(sentence -> new WordCount(sentence, sentence.split(WORD_DELIMITER_REGEX).length))
                    .collect(Collectors.toList());
            return Optional.of(list);
        }
       return Optional.empty();
    }

    public Map<Character, Integer> getLetterCount(Map<Integer, String> sentencesMap) {
        Map<Character, Integer> letterCount = new HashMap<>();
        sentencesMap
                .forEach((key, value) -> {
                    String sentences = value.replaceAll("[^A-Za-z]","").toLowerCase();
                    char[] lettersInSentenceGroup = sentences.toCharArray();
                    for (char c: lettersInSentenceGroup) {
                       letterCount.merge(c, 1, (oldValue, newValue) -> oldValue + newValue);
                    }
                });
        logger.debug("Returning:" + letterCount);
        return letterCount;
    }
}
