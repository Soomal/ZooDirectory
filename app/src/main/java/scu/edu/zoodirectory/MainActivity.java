package scu.edu.zoodirectory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    int i;

    String[] animals = {"Panda", "Koala", "Bear", "Giraffe", "Tiger"};
    int[] desc = {R.string.panda_desc, R.string.koala_desc, R.string.bear_desc, R.string.giraffe_desc, R.string.tiger_desc};
    //Images are taken from San Diego zoo website
    int[] icons = {R.drawable.panda_thumb, R.drawable.koala_thumb, R.drawable.bear_thumb, R.drawable.giraffe_thumb, R.drawable.tiger_thumb};
    int[] images = {R.drawable.panda, R.drawable.koala, R.drawable.bear, R.drawable.giraffe, R.drawable.tiger};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(new MyAdapter(this, R.layout.row_layout, animals, icons));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == (animals.length - 1)) {
                    i = position;

                    showAlertDialog(MainActivity.this);

                } else {
                    Intent intent = new Intent(MainActivity.this, AnimalDetails.class);
                    intent.putExtra("name", animals[position]);
                    intent.putExtra("desc", desc[position]);
                    intent.putExtra("image", images[position]);
                    startActivity(intent);
                }
            }
        });
    }


    public void showAlertDialog(MainActivity mainactivity) {
        AlertDialog.Builder theDialog = new AlertDialog.Builder(mainactivity);
        theDialog.setTitle("Scary Animal");
        theDialog.setMessage("This animal is very scary. Do you still want to proceed?");
        theDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, AnimalDetails.class);
                intent.putExtra("name", animals[i]);
                intent.putExtra("desc", desc[i]);
                intent.putExtra("image", images[i]);
                startActivity(intent);
            }
        });
        theDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        theDialog.create().show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Intent intent = new Intent(MainActivity.this, ZooInformation.class);
            startActivity(intent);
        } else {
            if (id == R.id.action_uninstall) {
                Uri packageURI = Uri.parse("package:scu.edu.zoodirectory");
                Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
