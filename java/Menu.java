
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class Menu extends Activity {
    TextView totaltxt;
    int total;
    Button order;
    ListView list;

    String[] web = {
            "Butter Chicken","Kadai Chicken",
            "Kadai Paneer","Shahi Paneer","Butter Naan","Coke"
    };

    String[] price = {
            "200","210","170","165","30","35"
    };

    Integer[] imageId = {
            R.drawable.download,R.drawable.kadai,
            R.drawable.kadaipaneer,
            R.drawable.shahi,
            R.drawable.naan,
            R.drawable.coke
    };

    String[] quantity= {
            "0","0","0","0","0","0"
    };

    Integer[] additem={
            R.id.additem
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu2);
        totaltxt=(TextView)findViewById(R.id.total);
        order=(Button)findViewById(R.id.order);
        CustomList adapter = new CustomList(Menu.this, web, price, imageId,quantity,additem);
        list=(ListView)findViewById(R.id.list_menu);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                Toast.makeText(Menu.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        totaltxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=0;
                for(int i=0;i<quantity.length;i++){
                    total=total + Integer.valueOf(quantity[i])*Integer.valueOf(price[i]);
                    totaltxt.setText("TOTAL =      "+total);
                }
            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),order.class);
                i.putExtra("total",total);
                startActivity(i);
            }
        });




    }

}