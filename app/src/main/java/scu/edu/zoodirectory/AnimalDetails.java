package scu.edu.zoodirectory;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class AnimalDetails extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_details);

        Intent intent = new Intent();

        TextView title = (TextView) findViewById(R.id.detail_title);
        ImageView image = (ImageView) findViewById(R.id.detail_image);
        TextView desc = (TextView) findViewById(R.id.detail_desc);


        title.setText(getIntent().getExtras().getString("name"));
        image.setImageResource(getIntent().getExtras().getInt("image"));
        desc.setText(getIntent().getExtras().getInt("desc"));


    }
}
