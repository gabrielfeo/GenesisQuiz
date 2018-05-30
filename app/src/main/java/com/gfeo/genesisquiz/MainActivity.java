package com.gfeo.genesisquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

	/* Questions result booleans. */
	private boolean[] answerIsCorrect = new boolean[7];

	/* Question 1-specific booleans (checkbox question). */
	private boolean q1_gabrielIsChecked;
	private boolean q1_banksIsChecked;
	private boolean q1_phillipsIsChecked;
	private boolean q1_rutherfordIsChecked;
	private boolean q1_stewartIsChecked;
	private boolean q1_hackettIsChecked;
	private boolean q1_collinsIsChecked;
	private boolean q1_silverIsChecked;
	private boolean q1_mayhewIsChecked;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_start);
		android.support.v7.widget.Toolbar toolbarStart = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_start);
		setSupportActionBar(toolbarStart);
		getSupportActionBar().hide();
	}

	/**
	 * This method changes the layout displayed.
	 * @param view the button that called the method.
	 */
	public void changeLayout(View view) {
		switch (view.getId()) {
			case R.id.button_start_quiz:
				setContentView(R.layout.activity_main_questions);
				break;
			case R.id.button_reset:
				setContentView(R.layout.activity_main_start);
				break;
		}
	}

	/**
	 * This method is called by the Question 1 checkboxes.
	 * @param view the checkbox that called the method
	 */
	public void setAnswerQ1(View view) {
		switch (view.getId()) {
			//Correct answers
			case R.id.q1_checkbox_gabriel:
				q1_gabrielIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_banks:
				q1_banksIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_phillips:
				q1_phillipsIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_rutherford:
				q1_rutherfordIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_stewart:
				q1_stewartIsChecked = ((CheckBox) view).isChecked();
				break;
			//Incorrect answers
			case R.id.q1_checkbox_mayhew:
				q1_mayhewIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_silver:
				q1_silverIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_collins:
				q1_collinsIsChecked = ((CheckBox) view).isChecked();
				break;
			case R.id.q1_checkbox_hackett:
				q1_hackettIsChecked = ((CheckBox) view).isChecked();
				break;

		}
		answerIsCorrect[0] = ((q1_gabrielIsChecked) && (q1_banksIsChecked) && (q1_phillipsIsChecked) && (q1_rutherfordIsChecked) && (q1_stewartIsChecked) && (!q1_hackettIsChecked) && (!q1_collinsIsChecked) && (!q1_silverIsChecked) && (!q1_mayhewIsChecked));

	}

	/**
	 * This method is called by the Question 2 radios.
	 * Only the correct answer fulfills the condition.
	 * @param view the Radio button that called the method
	 */
	public void setAnswerQ2(View view) {
		answerIsCorrect[1] = (view.getId() == R.id.q2_radio_spot);
	}

	/**
	 * This method is called by the Question 3 radios.
	 * Only the correct answer fulfills the condition.
	 * @param view the Radio button that called the method
	 */
	public void setAnswerQ3(View view) {
		answerIsCorrect[2] = (view.getId() == R.id.q3_radio_lamb);
	}

	/**
	 * This method  is called by the Question 4 radios.
	 * Only the correct answer fulfills the condition.
	 * @param view the Radio button that called the method
	 */
	public void setAnswerQ4(View view) {
		answerIsCorrect[3] = (view.getId() == R.id.q4_radio_absent);
	}

	/** This method is called by the "Show result" button to get the value put in the Question 5 text field */
	public void setAnswerQ5() {
		answerIsCorrect[4] = (((EditText) findViewById(R.id.q5_edittext)).getText().toString().toLowerCase().contains(getString(R.string.q_answer_5)));
	}

	/**
	 * This method is called by the Question 6 radios.
	 * Only the correct answer fulfills the condition.
	 * @param view the Radio button that called the method
	 */
	public void setAnswerQ6(View view) {
		answerIsCorrect[5] = (view.getId() == R.id.q6_radio_from);
	}

	/**
	 * This method  is called by the Question 7 radios.
	 * Only the correct answer fulfills the condition.
	 * @param view the Radio button that called the method
	 */
	public void setAnswerQ7(View view) {
		answerIsCorrect[6] = (view.getId() == R.id.q7_radio_land);
	}

	/**
	 * This method  is called by the Question 8 radios.
	 * Only the correct answer fulfills the condition.
	 * @param view the Radio button that called the method
	 */
	public void setAnswerQ8(View view) {
		answerIsCorrect[7] = (view.getId() == R.id.q8_radio_hackett);
	}

	/**
	 * This method is called by the "Show result" button to check the aforementioned "Question result boolean".
	 * @param view the button that called the method i.e. the "Show result" button
	 */
	public void showResult(View view) {
		String result;
		setAnswerQ5();
		if (!Arrays.toString(answerIsCorrect).contains("false")) {
			result = getString(R.string.messagePassed);
		} else {
			result = getString(R.string.messageFailed);
		}
		Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
	}


}
