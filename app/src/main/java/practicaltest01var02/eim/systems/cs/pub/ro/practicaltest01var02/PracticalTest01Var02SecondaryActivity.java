package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private TextView result = null;
    private Button yes_button = null;
    private Button no_button = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.button_yes:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.button_no:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        result = (TextView)findViewById(R.id.textView_secondary);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("result")) {
//            int resultAnother = intent.getIntExtra("result", -1);
//            intent.get
            result.setText(String.valueOf(intent.getExtras().get("result")));
        }

        yes_button = (Button)findViewById(R.id.button_yes);
        yes_button.setOnClickListener(buttonClickListener);
        no_button = (Button)findViewById(R.id.button_no);
        no_button.setOnClickListener(buttonClickListener);
    }
}
