package marcelo.foresto.korthapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bSum;
    private Button bSub;
    private TextView textView;
    private String ACTION;
    private Double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = getIntent().getDoubleExtra("key", 0.0);
            textView.setText(String.valueOf(value));

        }

        bSum = (Button) findViewById(R.id.buttonSum);
        bSub = (Button) findViewById(R.id.buttonSubtraction);

        bSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "addtion";
                openActivity2();
            }
        });

        bSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "subtraction";
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("key", ACTION);
        startActivity(intent);
    }
}
