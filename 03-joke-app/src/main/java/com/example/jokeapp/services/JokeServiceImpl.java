package com.example.jokeapp.services;

import org.springframework.stereotype.Service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@Service
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl() {
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override

    public String getJoke() {
        // Very inefficient - instance will be created for each request
        //ChuckNorrisQuotes chuckNorrisQuotes=new ChuckNorrisQuotes();
        return chuckNorrisQuotes.getRandomQuote();
    }
}
