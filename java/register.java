import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class register extends AppCompatActivity {

    Button register;
    EditText newphone;
    EditText newpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        newphone=(EditText)findViewById(R.id.phone);
        newpass=(EditText)findViewById(R.id.pswd);
        register=(Button)findViewById(R.id.reg);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                //i.putExtra("username",newphone.getText().toString());
                //i.putExtra("pass",newpass.getText().toString());
                startActivity(i);
            }
        });

    }
}