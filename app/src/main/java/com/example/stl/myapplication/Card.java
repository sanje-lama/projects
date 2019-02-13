package com.example.stl.myapplication;

public class Card {

    private final String rank;
    private final Suit suit;

    public Card(String rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }
}

