package com.Lesson3.Test;

public class Speaker {
    private SpeechWriter writer;

    public Speaker(SpeechWriter writer){
        this.writer = writer;
    }

    public void speak(){
        System.out.println(writer.getSpeech());
    }
}
