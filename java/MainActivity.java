import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button login;
    EditText phone,password;
    TextView forgotpass,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login=(Button)findViewById(R.id.login_button);
        phone=(EditText)findViewById(R.id.phone);
        password=(EditText)findViewById(R.id.password);
        forgotpass=(TextView)findViewById(R.id.forgotpass);
        signup=(TextView)findViewById(R.id.signup);


        final Intent forgot=new Intent(this,forgotpass.class);
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(forgot);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,register.class));
            }
        });




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Bundle extras = getIntent().getExtras();
                String ph=extras.getString("username");
                //String ps=extras.getString("pass");
                if(extras!=null){
                    ph="notset";
                    //ps="notset";
                }
                */
                if(phone.getText().toString().equals("9958792078") &&
                        password.getText().toString().equals("yash")){
                    Toast.makeText(getApplicationContext(),"WELCOME ADMIN...",Toast.LENGTH_SHORT).show();
                }
                else if(phone.getText().toString().equals("9958446074") &&
                        password.getText().toString().equals("mak")){
                    Toast.makeText(getApplicationContext(),"WELCOME USER...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,Menu.class));
                }

                /*else if(phone.getText().toString().equals(ph)&& password.getText().toString().equals(0)){
                    Toast.makeText(getApplicationContext(),"WELCOME USER...",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,Menu.class));
                }*/
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
