package com.example.marco.courseandroidmaterialdesign;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("Main Activity");
        mToolbar.setSubtitle("just a subtitle");
        mToolbar.setLogo(R.mipmap.ic_launcher);
       setSupportActionBar(mToolbar);

      mToolbarBottom = (Toolbar) findViewById(R.id.inc_tb_bottom);
      mToolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
          @Override
          public boolean onMenuItemClick(MenuItem item) {

              Intent it = null;

              switch (item.getItemId())
              {
                  case R.id.action_facebook:
                      it = new Intent(Intent.ACTION_VIEW);
                      it.setData(Uri.parse("http://www.facebook.com"));
                      break;
                  case R.id.action_youtube:
                      it = new Intent(Intent.ACTION_VIEW);
                      it.setData(Uri.parse("http://www.youtube.com"));
                      break;
                  case R.id.action_google_plus:
                      it = new Intent(Intent.ACTION_VIEW);
                      it.setData(Uri.parse("http://www.plus.google.com"));
                      break;
                  case R.id.action_linkedin:
                      it = new Intent(Intent.ACTION_VIEW);
                      it.setData(Uri.parse("http://www.linkedin.com"));
                      break;
                  case R.id.action_whatsapp:
                      it = new Intent(Intent.ACTION_VIEW);
                      it.setData(Uri.parse("http://www.whatsapp.com"));
                      break;

              }
              startActivity(it);
              return true;
          }
      });

        mToolbarBottom.inflateMenu(R.menu.menu_bottom);

        mToolbarBottom.findViewById(R.id.ic_settings).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Settings pressed",Toast.LENGTH_SHORT).show();
                //      startActivity(new Intent(MainActivity.this,SecondPageActivity.class));
            }
        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_action_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.action_second_page){
            startActivity(new Intent(this,SecondPageActivity.class));
        }

         return super.onOptionsItemSelected(item);
    }


}
