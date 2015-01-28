package scu.edu.zoodirectory;


import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<String> {

    Context context;
    String[] names;
    int[] icons;


    public MyAdapter(Context context, int layout, String[] animals, int[] images) {
        super(context, R.layout.row_layout, animals);
        this.context = context;
        this.names = animals;
        this.icons = images;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater theInflater = LayoutInflater.from(context);
        View theView = theInflater.inflate(R.layout.row_layout, parent, false);


        TextView name = (TextView) theView.findViewById(R.id.row_text);
        name.setText(names[position]);

        ImageView icon = (ImageView) theView.findViewById(R.id.row_image);
        icon.setImageResource(icons[position]);
        return theView;

    }
}
