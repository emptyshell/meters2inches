package com.example.meterstoinches.meter2inches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTxt;
    private Button convert;
    private TextView txtView;
    private RadioButton m2i, i2m;
    private RadioGroup toValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = (EditText) findViewById(R.id.editText);
        editTxt.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        convert = (Button) findViewById(R.id.ConvertButton);
        txtView = (TextView) findViewById(R.id.textViewResults);
        editTxt.setHint(R.string.txtViewMeters);
        m2i = (RadioButton) findViewById(R.id.radButM2I);
        i2m = (RadioButton) findViewById(R.id.radButI2M);
        toValue = (RadioGroup) findViewById(R.id.radGrp2Value);
        convert.setText(R.string.convertBut);
        m2i.setText(R.string.radButM2I);
        i2m.setText(R.string.radButI2M);
        txtView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        toValue.clearCheck();
        toValue.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group,  int checkedId) {
                if (checkedId == R.id.radButM2I) {
                    editTxt.setHint(R.string.txtViewMeters);
                    convert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            double multiplier = 39.37;
                            double result;
                            if (editTxt.getText().toString().equals("") || editTxt.getText().toString().equals(".")) {
                                txtView.setTextSize(24);
                                txtView.setText(R.string.error_message);
                                txtView.setTextColor(Color.RED);
                            }
                            else {
                                double meterValue = Double.parseDouble(editTxt.getText().toString());
                                result = meterValue * multiplier;
                                txtView.setTextColor(Color.GRAY);
                                txtView.setText(String.format("%.2f", result) + " in");
                            }
                        }
                    });
                }
                else if (checkedId == R.id.radButI2M) {
                    editTxt.setHint(R.string.txtViewInches);
                    convert.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            double multiplier = 0.0254;
                            double result;
                            if (editTxt.getText().toString().equals("") || editTxt.getText().toString().equals(".")) {
                                txtView.setTextSize(24);
                                txtView.setText(R.string.error_message);
                                txtView.setTextColor(Color.RED);
                            }
                            else {
                                double inchValue = Double.parseDouble(editTxt.getText().toString());
                                result = inchValue * multiplier;
                                txtView.setTextColor(Color.GRAY);
                                txtView.setText(String.format("%.2f", result) + " m");
                            }
                        }
                    });
                }
            }
        });
        m2i.setChecked(true);

    }
}
