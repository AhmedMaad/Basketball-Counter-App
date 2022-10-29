package com.example.android.abasketballgame;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int countA = 0;
    int countB = 0;

    TextView scoreViewA,scoreViewB, teamA, teamB;
    Button endGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);
        teamA = (TextView) findViewById(R.id.team_a);
        teamB = (TextView) findViewById(R.id.team_b);
        endGame = (Button) findViewById(R.id.end_game);

        if (savedInstanceState != null) {
            countA = savedInstanceState.getInt("teamA");
            countB = savedInstanceState.getInt("teamB");

            scoreViewA.setText(String.valueOf(countA));
            scoreViewB.setText(String.valueOf(countB));

        }

    }


    public void three_points_A(View view) {
        countA += 3;
        DisplayForTeamA(countA);

    }

    public void two_points_A(View view) {
        countA += 2;
        DisplayForTeamA(countA);
    }

    public void one_point_A(View view) {
        countA += 1;
        DisplayForTeamA(countA);
    }

    public void DisplayForTeamA(int score) {
        scoreViewA.setText(String.valueOf(score));
    }


    /*******TEAM B**********/
    public void three_points_B(View view) {
        countB += 3;
        DisplayForTeamB(countB);
    }

    public void two_points_B(View view) {
        countB += 2;
        DisplayForTeamB(countB);
    }

    public void one_point_B(View view) {
        countB += 1;
        DisplayForTeamB(countB);
    }

    public void DisplayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }

    public void EndGame(View view) {
        if (countA > countB) {
            teamA.setTextColor(getResources().getColor(R.color.green));
            teamB.setTextColor(Color.RED);
            endGame.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Team 'A' wins", Toast.LENGTH_LONG).show();

        } else if (countB > countA) {
            teamB.setTextColor(getResources().getColor(R.color.green));
            teamA.setTextColor(Color.RED);
            endGame.setVisibility(View.INVISIBLE);
            Toast.makeText(this, "Team 'B' wins", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Extra time \"5 minutes\"", Toast.LENGTH_LONG).show();
    }


    public void ResetScore(View view) {
        countA = 0;
        countB = 0;
        teamA.setTextColor(getResources().getColor(R.color.lightBrown));
        teamB.setTextColor(getResources().getColor(R.color.lightBrown));
        endGame.setVisibility(View.VISIBLE);
        DisplayForTeamA(countA);
        DisplayForTeamB(countB);

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("teamA", countA);
        outState.putInt("teamB", countB);
    }
}
