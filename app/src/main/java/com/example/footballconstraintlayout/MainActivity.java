package com.example.footballconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    int scoreTeamA = 0; //global variables go directly below the MainActivity class declaration/
    int scoreTeamB = 0; //set variable for team scores
    int prevScoreTeamA; //set variable for previous score team A
    int prevScoreTeamB; //set variable for previous score team B

    Switch mySwitchA; //initialize my variables (my switches)
    Switch mySwitchB; //initialize my variables (my switches)

    /*
    to add to a variable, call the variable and set it equal to itself plus
    something. this looks like
    scoreTeamA = scoreTeamA + 3;
    also written thusly-->
    scoreTeam += +3;
    the above calls the variable, sets it equal to something with the equal sign, and sets
    it equal to itself, or the last value of itself, but adds something to it this time.
    Now, next time it is called, it will be in essence (scoreTeamA +3).
    So if you were adding another three to it, it would in essence, but not technically, be
    scoreTeamA = (scoreTeamA + 3) + 3
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySwitchA = findViewById(R.id.teamPossessionA);
        mySwitchB = findViewById(R.id.teamPossessionB);
        mySwitchA.setOnCheckedChangeListener(this);
    }


    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.TeamAScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.TeamBScore);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * resets all the scores, both real and previous.
     */
    public void resetScore(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        prevScoreTeamA = 0;
        prevScoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        //      checkBox8.setChecked(false);

        //I would also like the reset button to uncheck the timeout boxes, in order to reset them.
    }


    /**
     * displays team A previous score, then sets the real score back to that previous number
     */
    public void prevScoreA(View v) {
        displayForTeamA(prevScoreTeamA);
        scoreTeamA = prevScoreTeamA;
    }

    /**
     * displays team B previous score, then sets the real score back to that previous number
     */
    public void prevScoreB(View v) {
        displayForTeamB(prevScoreTeamB);
        scoreTeamB = prevScoreTeamB;
    }

    /**
     * This method increases Team A's score by 6
     */
    public void addSixForTeamA(View v) {
        scoreTeamA = scoreTeamA + 6;
        displayForTeamA(scoreTeamA);
        prevScoreTeamA = scoreTeamA - 6;
    }

    /**
     * This method increases Team A's score by 3
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
        prevScoreTeamA = scoreTeamA - 3;

    }

    /**
     * This method increases Team A's score by 2
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
        prevScoreTeamA = scoreTeamA - 2;
    }

    /**
     * This method increases Team A's score by 1
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
        prevScoreTeamA = scoreTeamA - 1;
    }

    /**
     * This method increases Team B's score by 6
     */
    public void addSixForTeamB(View v) {
        scoreTeamB = scoreTeamB + 6;
        displayForTeamB(scoreTeamB);
        prevScoreTeamB = scoreTeamB - 6;
    }

    /**
     * This method increases Team B's score by 3
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
        prevScoreTeamB = scoreTeamB - 3;
    }

    /**
     * This method increases Team B's score by 2
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
        prevScoreTeamB = scoreTeamB - 2;
    }

    /**
     * This method increases Team B's score by 1
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
        prevScoreTeamB = scoreTeamB - 1;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (mySwitchA.isChecked()) {
            mySwitchB.setChecked(false);
        } else {
            mySwitchB.setChecked(true);
            mySwitchA.setChecked(false);
        }
    }
}
//    strangely the checks are inversely linked when you hit teamPossessionA switch
//    both on and off.
//    but when you try to switch on or off teamPossessionB then the other
//    is not inversely linked. I tried writing another listener for switchB.
//    I tried writing several different if's and a then. I couldn't figure it out.

    //I tried to find a way to have teamPossessionA switch automatically turn teamPossessionB
    //off when teamPossessionA is on, and conversely I wanted teamPossessionA switch turned
    //off when teamPossessionB is on. I couldn't find a way to make it work
    //with onClickListener or setChecked either. Hopefully I'll learn more about this later
