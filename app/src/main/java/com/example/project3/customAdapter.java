package com.example.project3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class customAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater=null;

    String number[];
    String number2[];
    String number3[];
    String gender[];
    public customAdapter(Context context,

            String number[],String number2[],String number3[],   String gender[])
    {
        this.context=context;
        this.number=number;

        this.number2=number2;
        this.number3=number3;
        this.gender=gender;

    }
    @Override
    public int getCount()
    {
        return number.length;
    }

    @Override
    public Object getItem(int i)
    {
        return getItemId(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row=view;
        if(row==null)
        {
           layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           row=layoutInflater.inflate(R.layout.root,null);
        }
        ImageView img=(ImageView) row.findViewById(R.id.phone);
        //ImageView img2=(ImageView) row.findViewById(R.id.mess);
        TextView tv=(TextView) row.findViewById(R.id.further);
        TextView tv2=(TextView) row.findViewById(R.id.cn);
        TextView tv3=(TextView) row.findViewById(R.id.nnnn);
        TextView tv4=(TextView) row.findViewById(R.id.ge);
        img.setImageResource(R.drawable.ic_baseline_local_phone_24);
       // img2.setImageResource(R.drawable.ic_baseline_message_24);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv.setText(number[i]);
        tv2.setText(number2[i]);
        tv3.setText(number3[i]);
        tv4.setText(gender[i]);
        return row;
    }
}
