package scu.edu.zoodirectory;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ZooInformation extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoo_info_layout);

        final String phone = "888-8888";

        TextView name = (TextView) findViewById(R.id.info_title);
        TextView info_detail = (TextView) findViewById(R.id.info_detail);
        Button call_button = (Button) findViewById(R.id.call_button);

        name.setText("Santa Clara Zoo");
        info_detail.setText(getString(R.string.zoo_info_detail));
        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });


    }
}
