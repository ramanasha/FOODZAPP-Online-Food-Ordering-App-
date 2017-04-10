import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomList extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final String[] price;
    private final Integer[] imageId;
    private final String[] quantity;
    private final Integer[] additem;


    public CustomList(Activity context,
                      String[] web, String[] price, Integer[] imageId,String[] quantity,Integer[] additem) {
        super(context, R.layout.row, web);
        this.context = context;
        this.web = web;
        this.price = price;
        this.imageId = imageId;
        this.quantity=quantity;
        this.additem=additem;

    }




    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View rowView= inflater.inflate(R.layout.row, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        TextView pri=(TextView) rowView.findViewById(R.id.price);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        Button additem=(Button) rowView.findViewById(R.id.additem);
        final TextView quan=(TextView) rowView.findViewById(R.id.quantity);
        Button delete=(Button) rowView.findViewById(R.id.delete);
        quan.setText(quantity[position]);
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.valueOf(quantity[position]);
                a++;
                quantity[position]=String.valueOf(a);
                quan.setText(quantity[position]);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a=Integer.valueOf(quantity[position]);
                a--;
                if(a==-1){
                    a=0;
                }
                quantity[position]=String.valueOf(a);
                quan.setText(quantity[position]);
            }
        });
        txtTitle.setText(web[position]);
        pri.setText(price[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}
