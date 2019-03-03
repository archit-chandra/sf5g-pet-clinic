package com.example.jokeapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    // ChuckNorrisQuotes bean will be initialized from config class "ChuckConfiguration" and not from the constructor
    // It is a better way when using some externalized dependency
    public JokeServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
        this.chuckNorrisQuotes = chuckNorrisQuotes;
    }

    @Override
    public String getJoke() {
        // Very inefficient - instance will be created for each request
        //ChuckNorrisQuotes chuckNorrisQuotes=new ChuckNorrisQuotes();
        return chuckNorrisQuotes.getRandomQuote();
    }
}
