package practicaltest01var02.eim.systems.cs.pub.ro.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    private EditText editText_1 = null;
    private EditText editText_2= null;
    private Button plusButton = null;
    private Button minusButton = null;
    private Button navigateToSecondaryActivityButton;
    private TextView show_result = null;

    public int sum = 0;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    String var1;
    String var2;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            int editText_1_int = Integer.parseInt(editText_1.getText().toString());
            int editText_2_int = Integer.parseInt(editText_2.getText().toString());

            switch(view.getId()) {
                case R.id.button_plus:
                    show_result.setText(editText_1.getText().toString() + " + " + editText_2.getText().toString() + " = " + String.valueOf(editText_1_int + editText_2_int));
                    break;
                case R.id.button_minus:
                    show_result.setText(editText_1.getText().toString() + " - " + editText_2.getText().toString() + " = " + String.valueOf(editText_1_int - editText_2_int));
                    break;
            }
        }
    }

    private ButtonClickListener2 buttonClickListener2 = new ButtonClickListener2();
    private class ButtonClickListener2 implements Button.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.navigate_to_secondary_activity_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var02SecondaryActivity.class);

                    intent.putExtra("result", show_result.getText().toString());
                    startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                    break;
            }
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        editText_1 = (EditText)findViewById(R.id.edit_text_1);
        editText_2 = (EditText)findViewById(R.id.edit_text_2);
        show_result = (TextView)findViewById(R.id.show_result);

        plusButton = (Button)findViewById(R.id.button_plus);
        minusButton = (Button)findViewById(R.id.button_minus);
        plusButton.setOnClickListener(buttonClickListener);
        minusButton.setOnClickListener(buttonClickListener);

        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener2);

        var1 = editText_1.getText().toString();
        var2 = editText_2.getText().toString();

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("editText_1")) {
                editText_1.setText(savedInstanceState.getString("editText_1"));
            } else {
                editText_1.setText(var1);
            }
            if (savedInstanceState.containsKey("editText_2")) {
                editText_2.setText(savedInstanceState.getString("editText_2"));
            } else {
                editText_2.setText(var2);
            }
        } else {
            editText_1.setText(var1);
            editText_2.setText(var2);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("editText_1", editText_1.getText().toString());
        savedInstanceState.putString("editText_2", editText_2.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("editText_1")) {
            editText_1.setText(savedInstanceState.getString("editText_1"));
        } else {
            editText_1.setText(var1);
        }
        if (savedInstanceState.containsKey("editText_2")) {
            editText_2.setText(savedInstanceState.getString("editText_2"));
        } else {
            editText_2.setText(var2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
