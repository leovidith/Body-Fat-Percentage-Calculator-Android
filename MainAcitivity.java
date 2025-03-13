package com.example.body;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText ageInput, weightInput, heightInput, neckInput, waistInput, hipInput;
    private RadioGroup genderGroup;
    private Button calculateButton;
    private TextView resultView;
    private ProgressBar progressBar;  // Reference to the progress bar
    private View hipInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        ageInput = findViewById(R.id.ageInput);
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        neckInput = findViewById(R.id.neckInput);
        waistInput = findViewById(R.id.waistInput);
        hipInput = findViewById(R.id.hipInput);
        genderGroup = findViewById(R.id.genderGroup);
        calculateButton = findViewById(R.id.calculateButton);
        resultView = findViewById(R.id.resultView);
        progressBar = findViewById(R.id.progressBar); // Reference to the progress bar
        hipInputLayout = findViewById(R.id.hipInputLayout);

        // Set listener for gender selection
        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.female) {
                    hipInputLayout.setVisibility(View.VISIBLE);
                } else {
                    hipInputLayout.setVisibility(View.GONE);
                }
            }
        });

        // Set click listener for the calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBodyFat();
            }
        });
    }

    private void calculateBodyFat() {
        // Show progress bar and animate
        progressBar.setVisibility(View.VISIBLE);

        // Add a delay of 3 seconds before performing calculations and animate the progress bar
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    double weight = Double.parseDouble(weightInput.getText().toString());
                    double height = Double.parseDouble(heightInput.getText().toString());
                    double neck = Double.parseDouble(neckInput.getText().toString());
                    double waist = Double.parseDouble(waistInput.getText().toString());
                    int selectedGender = genderGroup.getCheckedRadioButtonId();
                    double bodyFat, leanBodyMass, fatBodyMass;

                    if (selectedGender == R.id.male) {
                        bodyFat = 495 / (1.0324 - 0.19077 * Math.log10(waist - neck) + 0.15456 * Math.log10(height)) - 450;
                    } else {
                        double hip = Double.parseDouble(hipInput.getText().toString());
                        bodyFat = 495 / (1.29579 - 0.35004 * Math.log10(waist + hip - neck) + 0.22100 * Math.log10(height)) - 450;
                    }

                    fatBodyMass = (bodyFat / 100) * weight;
                    leanBodyMass = weight - fatBodyMass;

                    resultView.setText(String.format("Body Fat: %.2f%%\nLean Body Mass: %.2f kg\nFat Body Mass: %.2f kg", bodyFat, leanBodyMass, fatBodyMass));

                } catch (Exception e) {
                    resultView.setText("Please enter valid inputs.");
                } finally {
                    // Hide the progress bar after calculation
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 3000); // Delay for 3 seconds
    }
}
