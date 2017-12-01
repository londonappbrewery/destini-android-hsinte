package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mTopBtn;
    private Button mBotBtn;
    private int mCurrentIndex;
    private Question mCurQues;
    final private Question[] questions=new Question[]{
            new Question(R.string.T1_Story,R.string.T1_Ans1,R.string.T3_Story,R.string.T1_Ans2,R.string.T2_Story),
            new Question(R.string.T2_Story,R.string.T2_Ans1,R.string.T3_Story,R.string.T2_Ans2,R.string.T4_End),
            new Question(R.string.T3_Story,R.string.T3_Ans1,R.string.T6_End,R.string.T3_Ans2,R.string.T5_End),
            new Question(R.string.T4_End),
            new Question(R.string.T5_End),
            new Question(R.string.T6_End)
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt("StoryKey");
        }
        else {
            mCurrentIndex=0;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView= (TextView) findViewById(R.id.storyTextView);
        mTopBtn=(Button) findViewById(R.id.buttonTop);
        mBotBtn=(Button)findViewById(R.id.buttonBottom);

        updateTextNButton();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextStory(true);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToNextStory(false);
            }
        });
    }
    private void moveToNextStory(boolean top){
        int to_story;
        if (top){
            to_story=mCurQues.getAns1_to();
        }
        else{
            to_story=mCurQues.getAns2_to();
        }
        for (int i=0;i<questions.length;i++){
            if(questions[i].getStory()==to_story){
                mCurrentIndex=i;
                break;
            }
        }
        updateTextNButton();
    }
    private void updateTextNButton(){
        mCurQues=questions[mCurrentIndex];
        mStoryTextView.setText(mCurQues.getStory());
        if(mCurQues.getAns1()!=0) {
            mTopBtn.setText(mCurQues.getAns1());
        }else {
            mTopBtn.setVisibility(View.INVISIBLE);
        }
        if(mCurQues.getAns2()!=0) {
            mBotBtn.setText(mCurQues.getAns2());
        }else{
            mBotBtn.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("StoryKey",mCurrentIndex);
    }
}
