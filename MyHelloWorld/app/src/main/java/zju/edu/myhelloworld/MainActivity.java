package zju.edu.myhelloworld;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private ImageView imageView;
    private RadioButton blue;
    private RadioButton brown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.TextView);
        editText1 = (EditText) findViewById(R.id.EditText1);
        editText2 = (EditText) findViewById(R.id.EditText2);
        imageView = (ImageView) findViewById(R.id.ImageView);
        blue = (RadioButton)findViewById(R.id.blue);
        brown = (RadioButton)findViewById(R.id.brown);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String inputText1 = editText1.getText().toString();
                String inputText2 = editText2.getText().toString();

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Input Wrong!");
                dialog.setMessage("Please input 123456 in password");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ((TextView) editText2).setText("");
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                String testStr = new String("123456");
                if(inputText2.equals(testStr))textView.setText("Hello "+inputText1 + "!");
                else dialog.show();

                if(blue.isChecked())imageView.setImageResource(R.drawable.icon);
                if(brown.isChecked())imageView.setImageResource(R.drawable.pic);
            }
        });
    }
}
