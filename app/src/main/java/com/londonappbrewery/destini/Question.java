package com.londonappbrewery.destini;

/**
 * Created by Tom on 2017/12/1.
 */

public class Question {
    private int story;
    private int ans1;
    private int ans1_to;
    private int ans2;
    private int ans2_to;

    public Question(int story) {
        this.story = story;
    }

    public Question(int story, int ans1, int ans1_to, int ans2, int ans2_to) {
        this.story = story;
        this.ans1 = ans1;
        this.ans1_to = ans1_to;
        this.ans2 = ans2;
        this.ans2_to = ans2_to;
    }

    public int getStory() {
        return story;
    }

    public int getAns1() {
        return ans1;
    }

    public int getAns2() {
        return ans2;
    }

    public int getAns1_to() {
        return ans1_to;
    }

    public int getAns2_to() {
        return ans2_to;
    }
}
