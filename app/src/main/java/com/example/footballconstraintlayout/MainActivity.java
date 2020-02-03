package com.example.footballconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //implements CompoundButton.OnCheckedChangeListener {
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
/*This is super freakin annoying. /the possessionSwitcherA method works,
but when I copy it make it onClick for switchB then it says it can't
find it in the right class.

Scratch that, it did work, but there was a curly brace in the wrong place
That kept some code outside of the mainactivity and freaked the xml out, and
wouldn't link the switch to the method.
 */
//    public void highlightA(View view) {
//        touchdownTeamA.setBackgroundColor(Color.GREEN);
//    }
//    public void colorButtonsA(View view) {
//        touchdownTeamA.setBackgroundColor(Color.GREEN);
//        fieldGoalTeamA.setBackgroundColor(Color.GREEN);
//        safetyTeamA.setBackgroundColor(Color.GREEN);
//    }
    public void possessionSwitcherA(View view) {
        boolean isTeamA = mySwitchA.isChecked();
        Button touchdownTeamA = findViewById(R.id.touchdownTeamA);
        Button fieldGoalTeamA = findViewById(R.id.fieldgoalTeamA);
        Button safetyTeamA = findViewById(R.id.safetyTeamA);
        Button safetyTeamB = findViewById(R.id.safetyTeamB);
        Button touchdownTeamB = findViewById(R.id.touchdownTeamB);
        Button fieldgoalTeamB = findViewById(R.id.fieldgoalTeamB);
        if (isTeamA) {
            mySwitchB.setChecked(false);
            touchdownTeamA.setBackgroundColor(R.color.colorAccent);
            fieldGoalTeamA.setBackgroundColor(Color.parseColor("#ffffbb33"));
            safetyTeamA.setBackgroundColor(Color.parseColor("#ffffbb33"));
            touchdownTeamB.setBackgroundColor(Color.LTGRAY);
            fieldgoalTeamB.setBackgroundColor(Color.LTGRAY);
            safetyTeamB.setBackgroundColor(Color.LTGRAY);
        } else {
            mySwitchB.setChecked(true);
            touchdownTeamB.setBackgroundColor(Color.parseColor("#ffffbb33"));
            fieldgoalTeamB.setBackgroundColor(Color.parseColor("#ffffbb33"));
            safetyTeamB.setBackgroundColor(Color.parseColor("#ffffbb33"));
            touchdownTeamA.setBackgroundColor(R.color.colorPrimaryDark);
            fieldGoalTeamA.setBackgroundColor(R.color.colorPrimaryDark);
            safetyTeamA.setBackgroundColor(R.color.colorPrimaryDark);
        }
    }
    //below are examples of how to setBackgroundColor for buttons.
//    fieldgoalTeamB.setBackgroundColor(getResources().getColor(R.color.blue));
//
//    or
//
//    fieldgoalTeamB.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
//
//    or
//
//    fieldgoalTeamB.setBackgroundColor(Color.rgb(226, 11, 11));
//
//
//    or
//    fieldgoalTeamB.setBackgroundColor(Color.RED)

    public void possessionSwitcherB(View view) {
        boolean isTeamB = mySwitchB.isChecked();
        Button touchdownTeamA = findViewById(R.id.touchdownTeamA);
        Button fieldGoalTeamA = findViewById(R.id.fieldgoalTeamA);
        Button safetyTeamA = findViewById(R.id.safetyTeamA);
        Button safetyTeamB = findViewById(R.id.safetyTeamB);
        Button touchdownTeamB = findViewById(R.id.touchdownTeamB);
        Button fieldgoalTeamB = findViewById(R.id.fieldgoalTeamB);
        if (isTeamB) {
            mySwitchA.setChecked(false);
            touchdownTeamB.setBackgroundColor(Color.GREEN);
            fieldgoalTeamB.setBackgroundColor(Color.GREEN);
            safetyTeamB.setBackgroundColor(Color.GREEN);
            touchdownTeamA.setBackgroundColor(Color.LTGRAY);
            fieldGoalTeamA.setBackgroundColor(Color.LTGRAY);
            safetyTeamA.setBackgroundColor(Color.LTGRAY);
        } else {
            mySwitchA.setChecked(true);
            touchdownTeamA.setBackgroundColor(Color.GREEN);
            fieldGoalTeamA.setBackgroundColor(Color.GREEN);
            safetyTeamA.setBackgroundColor(Color.GREEN);
            touchdownTeamB.setBackgroundColor(Color.LTGRAY);
            fieldgoalTeamB.setBackgroundColor(Color.LTGRAY);
            safetyTeamB.setBackgroundColor(Color.LTGRAY);
        }
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

//    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if (mySwitchA.isChecked()) {
//            mySwitchB.setChecked(false);
//        }
//            else {
//            mySwitchB.setChecked(true);
//            mySwitchA.setChecked(false);
//        }
    //}
}
/**
 * the above was my 15th attempt at getting the buttons to work. I couldn't get
 * the onclick listener to work for only one button, so I set onClick methods for
 * both, and changed the logic a little bit by adding in boolean value for the
 * checked states, and checking those in the if else control flow.
 */

//    strangely the checks are inversely linked when you hit teamPossessionA switch
//    both on and off.
//    but when you try to switch on or off teamPossessionB then the other
//    is not inversely linked. I tried writing another listener for switchB.
//    I tried writing several different if's and a then. I couldn't figure it out.

    //I tried to find a way to have teamPossessionA switch automatically turn teamPossessionB
    //off when teamPossessionA is on, and conversely I wanted teamPossessionA switch turned
    //off when teamPossessionB is on. I couldn't find a way to make it work
    //with onClickListener or setChecked either. Hopefully I'll learn more about this later
