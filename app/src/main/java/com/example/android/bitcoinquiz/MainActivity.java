package com.example.android.bitcoinquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int TOTAL_QUESTIONS = 4;


    //save states vars
    int answer_1_selectedRbId = -1;
    boolean answer_2_chk_1 = false;
    boolean answer_2_chk_2 = false;
    boolean answer_2_chk_3 = false;
    boolean answer_2_chk_4 = false;
    String answer_3_input = "";
    int answer_4_selectedRbId = -1;


    //views
    RadioGroup question_1_rg;
    //RadioButton question_1_rb_1;
    RadioButton question_1_rb_2;
    //RadioButton question_1_rb_3;
    //RadioButton question_1_rb_4;

    CheckBox question_2_chk_1;
    CheckBox question_2_chk_2;
    CheckBox question_2_chk_3;
    CheckBox question_2_chk_4;

    EditText question_3_input;

    RadioGroup question_4_rg;
    //RadioButton question_4_rb_1;
    //RadioButton question_4_rb_2;
    //RadioButton question_4_rb_3;
    RadioButton question_4_rb_4;

    //for longer toast duration
    private Toast toastedScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //disable keyboard popup on rotate
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        question_1_rg = findViewById(R.id.question_1_rg);
        //question_1_rb_1 = findViewById(R.id.question_1_rb_1);
        question_1_rb_2 = findViewById(R.id.question_1_rb_2);
        //question_1_rb_3 = findViewById(R.id.question_1_rb_3);
        //question_1_rb_4 = findViewById(R.id.question_1_rb_4);

        question_2_chk_1 = findViewById(R.id.question_2_chk_1);
        question_2_chk_2 = findViewById(R.id.question_2_chk_2);
        question_2_chk_3 = findViewById(R.id.question_2_chk_3);
        question_2_chk_4 = findViewById(R.id.question_2_chk_4);

        question_3_input = findViewById(R.id.question_3_input);

        question_4_rg = findViewById(R.id.question_4_rg);
        //question_4_rb_1 = findViewById(R.id.question_4_rb_1);
        //question_4_rb_2 = findViewById(R.id.question_4_rb_2);
        //question_4_rb_3 = findViewById(R.id.question_4_rb_3);
        question_4_rb_4 = findViewById(R.id.question_4_rb_4);


        //setup listeners

        question_2_chk_1.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk1) + " " + getText(R.string.checked), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk1) + " " + getText(R.string.unchecked), Toast.LENGTH_SHORT).show();
                }

            }
        });

        question_2_chk_2.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk2) + " " + getText(R.string.checked), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk2) + " " + getText(R.string.unchecked), Toast.LENGTH_SHORT).show();
                }

            }
        });

        question_2_chk_3.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk3) + " " + getText(R.string.checked), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk3) + " " + getText(R.string.unchecked), Toast.LENGTH_SHORT).show();
                }

            }
        });

        question_2_chk_4.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk4) + " " + getText(R.string.checked), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, getText(R.string.question2Chk4) + " " + getText(R.string.unchecked), Toast.LENGTH_SHORT).show();
                }

            }
        });

        //Question 1 RadioGroup
        question_1_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.question_1_rb_1:
                        Toast.makeText(MainActivity.this, getText(R.string.donald_trump) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.question_1_rb_2:
                        Toast.makeText(MainActivity.this, getText(R.string.satoshi_nakamoto) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.question_1_rb_3:
                        Toast.makeText(MainActivity.this, getText(R.string.mickey_mouse) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.question_1_rb_4:
                        Toast.makeText(MainActivity.this, getText(R.string.kim_dotcom) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        //Question 4 RadioGroup
        question_4_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.question_4_rb_1:
                        Toast.makeText(MainActivity.this, getText(R.string.cpu) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.question_4_rb_2:
                        Toast.makeText(MainActivity.this, getText(R.string.gpu) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.question_4_rb_3:
                        Toast.makeText(MainActivity.this, getText(R.string.fpga) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.question_4_rb_4:
                        Toast.makeText(MainActivity.this, getText(R.string.asic) + " " + getText(R.string.selected), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        //setup vars to be saved
        setupAnswerVars();

        //Question 1
        savedInstanceState.putInt("sv_question_1_selectedRbId", answer_1_selectedRbId);

        //Question 2
        savedInstanceState.putBoolean("sv_question_2_chk_1", answer_2_chk_1);
        savedInstanceState.putBoolean("sv_question_2_chk_2", answer_2_chk_2);
        savedInstanceState.putBoolean("sv_question_2_chk_3", answer_2_chk_3);
        savedInstanceState.putBoolean("sv_question_2_chk_4", answer_2_chk_4);

        //Question 3
        savedInstanceState.putString("sv_question_3_input", answer_3_input);

        //Question 4
        savedInstanceState.putInt("sv_question_4_selectedRbId", answer_4_selectedRbId);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //Question 1 - load
        answer_1_selectedRbId = savedInstanceState.getInt("sv_question_1_selectedRbId");
        //Question 1 - set
        question_1_rg.check(answer_1_selectedRbId);


        //Question 2 - load
        answer_2_chk_1 = savedInstanceState.getBoolean("sv_question_2_chk_1");
        answer_2_chk_2 = savedInstanceState.getBoolean("sv_question_2_chk_2");
        answer_2_chk_3 = savedInstanceState.getBoolean("sv_question_2_chk_3");
        answer_2_chk_4 = savedInstanceState.getBoolean("sv_question_2_chk_4");
        //Question 2 - set
        question_2_chk_1.setChecked(answer_2_chk_1);
        question_2_chk_2.setChecked(answer_2_chk_2);
        question_2_chk_3.setChecked(answer_2_chk_3);
        question_2_chk_4.setChecked(answer_2_chk_4);


        //Question 3 - load
        answer_3_input = savedInstanceState.getString("sv_question_3_input");
        //Question 3 - set
        question_3_input.setText(String.valueOf(answer_3_input));


        //Question 4 - load
        answer_4_selectedRbId = savedInstanceState.getInt("sv_question_4_selectedRbId");
        //Question 4 - set
        question_4_rg.check(answer_4_selectedRbId);


        //clear focus from any EditText that might have it after rotation
        View view = getCurrentFocus();
        if (view != null) {
            view.clearFocus();
        }
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitScore(View view) {
        EditText nameInput = findViewById(R.id.name_input_view);
        String username = nameInput.getText().toString();

        //load vars
        setupAnswerVars();

        //calculate answers score
        double score = calculateScore();
        //Log.v("MainActivity","The score is " + score);

        //Show toast with score
        showToast(score);

        String message = createScoreSummary(score, username);
        sendEmailOrder(username, message);

        //resetQuiz();
    }

    /**
     * Show Score Toast Mode
     */
    public void showToast(double score) {
        // Set the toast and duration
        int toastDurationInMilliSeconds = 10000;

        // Inflate the Layout
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toasted,
                (ViewGroup) findViewById(R.id.toasted_layout_id));

        // set Score Value
        TextView scoreTxt = layout.findViewById(R.id.toastscore_textview);
        //String scorepercent = String.format(getResources().getString(R.string.scorepercentage), score);
        //String scorepercent = String.format(getResources().getString(R.string.scorepercentage),score,"%");
        scoreTxt.setText(String.valueOf(score) + "%");

        // Create Custom Toast
        toastedScore = new Toast(getApplicationContext());
        toastedScore.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toastedScore.setDuration(Toast.LENGTH_LONG);
        toastedScore.setView(layout);

        // Set the countdown to display the toast
        CountDownTimer toastCountDown;
        toastCountDown = new CountDownTimer(toastDurationInMilliSeconds, 1000 /*Tick duration*/) {
            public void onTick(long millisUntilFinished) {
                toastedScore.show();
            }

            public void onFinish() {
                toastedScore.cancel();
            }
        };

        // Show the toast and starts the countdown
        toastedScore.show();
        toastCountDown.start();
    }

    /**
     * setup answer vars
     */
    private void setupAnswerVars() {
        //Question 1
        answer_1_selectedRbId = question_1_rg.getCheckedRadioButtonId();

        //Question 2
        answer_2_chk_1 = question_2_chk_1.isChecked();
        answer_2_chk_2 = question_2_chk_2.isChecked();
        answer_2_chk_3 = question_2_chk_3.isChecked();
        answer_2_chk_4 = question_2_chk_4.isChecked();

        //Question 3
        answer_3_input = question_3_input.getText().toString();

        //Question 4
        answer_4_selectedRbId = question_4_rg.getCheckedRadioButtonId();
    }

    private int indexOfRadio(RadioGroup radioButtonGroup) {
        int radioButtonID = radioButtonGroup.getCheckedRadioButtonId();
        View radioButton = radioButtonGroup.findViewById(radioButtonID);
        return radioButtonGroup.indexOfChild(radioButton);
    }

    /**
     * Calculates the score in percentage
     */
    private double calculateScore() {

        double score = 0;

        if (answer_1_selectedRbId == question_1_rb_2.getId()) {
            score += 1;
            //Log.v("MainActivity", "Question 1 is correct ");
        }

        double scoreQuestion2 = 0;
        if (answer_2_chk_1) {
            scoreQuestion2 -= 1;
        } else {
            scoreQuestion2 += 1;
        }
        if (answer_2_chk_2) {
            scoreQuestion2 -= 1;
        } else {
            scoreQuestion2 += 1;
        }
        if (answer_2_chk_3) {
            scoreQuestion2 += 1;
        } else {
            scoreQuestion2 -= 1;
        }
        if (answer_2_chk_4) {
            scoreQuestion2 += 1;
        } else {
            scoreQuestion2 -= 1;
        }
        if (scoreQuestion2 > 0) {
            scoreQuestion2 = scoreQuestion2 / 4;
            //Log.v("MainActivity", "Question 2 score is: " + scoreQuestion2);
        }

        if (answer_3_input.equals("8")) {
            score += 1;
            //Log.v("MainActivity", "Question 3 is correct ");
        }

        if (answer_4_selectedRbId == question_4_rb_4.getId()) {
            score += 1;
            //Log.v("MainActivity", "Question 4 is correct ");
        }

        score = (score + scoreQuestion2) * 100.0 / TOTAL_QUESTIONS;
        //Log.v("MainActivity", "Total Score is: " + score);
        return score;

    }

    /**
     * Creates message for mail.
     */
    private String createScoreSummary(double score, String username) {
        String priceMessage = "Hello! :) ";
        priceMessage += "\nName: " + username;
        priceMessage += "\nScore: " + score + "%";
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * Send Email.
     */
    public void sendEmailOrder(String username, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "Bitcoin Quiz Score for " + username);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * Reset Quiz - vars and views
     */
    private void resetQuiz() {

        answer_1_selectedRbId = -1;
        answer_2_chk_1 = false;
        answer_2_chk_2 = false;
        answer_2_chk_3 = false;
        answer_2_chk_4 = false;
        answer_3_input = "";
        answer_4_selectedRbId = -1;

        question_1_rg.check(answer_1_selectedRbId);
        question_2_chk_1.setChecked(answer_2_chk_1);
        question_2_chk_2.setChecked(answer_2_chk_2);
        question_2_chk_3.setChecked(answer_2_chk_3);
        question_2_chk_4.setChecked(answer_2_chk_4);
        question_3_input.setText(String.valueOf(answer_3_input));
        question_4_rg.check(answer_4_selectedRbId);

    }

}
