package com.example.stl.myapplication;

import java.util.List;

// PokerHand is a Class that holds our list of cards
public class PokerHand {
    public List<Card> hand;

    public PokerHand(List<Card> hand) {
        this.hand = hand;
    }

    public List<Card> getHand() {
        return hand;
    }
}