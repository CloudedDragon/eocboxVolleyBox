package application.eocbox.com.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import app.eocbox.com.volley.toolbox.CircleNetworkImageView;
import app.eocbox.com.volley.toolbox.NetworkImageView;
import app.eocbox.com.volley.toolbox.VolleySingleton;

public class MainActivity extends Activity {

    Context context;

    String errorUrl = null;
    String testUrl = "http://i.imgur.com/ZzcDHhn.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        NetworkImageView errorNIV = (NetworkImageView) findViewById(R.id.error_niv);
        NetworkImageView demoNIV = (NetworkImageView) findViewById(R.id.demo_niv);
        CircleNetworkImageView demoCNIV = (CircleNetworkImageView) findViewById(R.id.demo_cniv);

        // when the url is not valid or the internet is not available
        errorNIV.setErrorImageResId(R.drawable.dummy);
        errorNIV.setDefaultImageResId(R.drawable.dummy);
        errorNIV.setImageUrl(errorUrl, VolleySingleton.getInstance(context).getImageLoader());

        // get the image from testUrl and show it with NetworkImageView
        demoNIV.setErrorImageResId(R.drawable.dummy);
        demoNIV.setDefaultImageResId(R.drawable.dummy);
        demoNIV.setImageUrl(testUrl, VolleySingleton.getInstance(context).getImageLoader());

        // get the image from testUrl and show it with CircleNetworkImageView
        demoCNIV.setErrorImageResId(R.drawable.dummy);
        demoCNIV.setDefaultImageResId(R.drawable.dummy);
        demoCNIV.setImageUrl(testUrl, VolleySingleton.getInstance(context).getImageLoader());

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
