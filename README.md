## REST service which provides following api's

1. /word_count_per_sentence - Return individual sentences along with a word count for the sentence

1. /total_letter_count - For each case-insensitive letter, return the number of times that letter appears in the entire text of the request body


### Assumptions

1. Both are HTTP POST requests with JSON payload.
1. The payload should be a simple key/value pair, where the value is a string with two or more sentences.



### How to Run

1. Install `gradle`
1. Clone the repo: `git clone https://github.com/rameshsunkara/textcount-rest-service.git`
1. `cd textcount-rest-service`
1. This service defaults to 9000 port which can be configured here: `/textcount-rest-service/src/main/resources/application.yaml`
1. Start the service `./gradlew bootRun`


### How to test

- Open a new Terminal
- `cd /textcount-rest-service/src/test/`
- Test1: WordCount Api - Success

```text
curl -d '@testSuccess.json' -H "Content-Type: application/json" -X POST http://localhost:9000/word_count_per_sentence
```

- Test2: WordCount Api - Empty Request Body

```text
curl -d '@testEmptyBody.json' -H "Content-Type: application/json" -X POST http://localhost:9000/word_count_per_sentence
```

- Test3: WordCount Api - Duplicate keys in Body
```text
curl -d '@testDuplicateKeys.json' -H "Content-Type: application/json" -X POST http://localhost:9000/word_count_per_sentence
```

- Test4: WordCount Api - Invalid Request Body
```text
curl -d '@testInvalidReqBody.json' -H "Content-Type: application/json" -X POST http://localhost:9000/word_count_per_sentence
```

- Test5: WordCount Api - Null Value
```text
curl -d '@testNullValue.json' -H "Content-Type: application/json" -X POST http://localhost:9000/word_count_per_sentence
```

- Test6: WordCount Api - Empty Value
```text
curl -d '@testNullValue.json' -H "Content-Type: application/json" -X POST http://localhost:9000/word_count_per_sentence
```

- Test7: WordCount Api - No Request Headers
```text
curl -d '@testNullValue.json' -X POST http://localhost:9000/word_count_per_sentence
```

- Test8: WordCount Api - No Request Body
```text
curl -X POST http://localhost:9000/word_count_per_sentence
```

- Test9: Letter Count Api - Success

```text
curl -d '@testSuccess.json' -H "Content-Type: application/json" -X POST http://localhost:9000/total_letter_count
```