package marcelo.foresto.korthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    private Button bCalculate;
    private EditText num1;
    private EditText num2;
    private Double result = 3.0;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        bCalculate = (Button) findViewById(R.id.buttonResult);
        num1 = (EditText) findViewById(R.id.num1);
        num2 = (EditText) findViewById(R.id.num2);

        value = getIntent().getStringExtra("key");

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value.equals("addtion")) {
                    result = Double.parseDouble(num1.getText().toString()) + Double.parseDouble(num2.getText().toString()) ;

                }
                if (value.equals("subtraction")) {
                    result = Double.parseDouble(num1.getText().toString()) - Double.parseDouble(num2.getText().toString()) ;
                }

                openActivity1();
            }
        });

    }

    public void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("key", result);
        startActivity(intent);
    }
}
