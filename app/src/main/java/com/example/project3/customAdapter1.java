package com.example.project3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class customAdapter1 extends BaseAdapter {
    Context context1;
    LayoutInflater layoutInflater=null;

    String number[];
    String number2[];
    String number3[];
    String gender[];
    public customAdapter1(Context context,

                         String number[],String number2[],String number3[],   String gender[])
    {
        this.context1=context;
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
        View row1=view;
        if(row1==null)
        {
            layoutInflater=(LayoutInflater) context1.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row1=layoutInflater.inflate(R.layout.root1,null);
        }
        //ImageView img=(ImageView) row1.findViewById(R.id.phone);
        //ImageView img2=(ImageView) row.findViewById(R.id.mess);
        TextView tv=(TextView) row1.findViewById(R.id.further);
        TextView tv2=(TextView) row1.findViewById(R.id.cn);
        TextView tv3=(TextView) row1.findViewById(R.id.nnnn);
        TextView tv4=(TextView) row1.findViewById(R.id.ge);
       // img.setImageResource(R.drawable.ic_baseline_local_phone_24);
        // img2.setImageResource(R.drawable.ic_baseline_message_24);
        tv.setText(number[i]);
        tv2.setText(number2[i]);
        tv3.setText(number3[i]);
        tv4.setText(gender[i]);
        return row1;
    }
}

