package application.eocbox.com.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import app.eocbox.com.volley.toolbox.CircleNetworkImageView;
import app.eocbox.com.volley.toolbox.GsonRequest;
import app.eocbox.com.volley.toolbox.NetworkImageView;
import app.eocbox.com.volley.toolbox.VolleySingleton;
import app.eocbox.com.volley.toolbox.gsonclass.GsonTumblr;

public class MainActivity extends Activity {
    private final static String TAG = "MainActivity";
    Context context;

    String errorUrl = "http://";
    String testImageUrl = "http://i.imgur.com/ZzcDHhn.png";
    String testGsonUrl = "https://api.tumblr.com/v2/blog/scipsy.tumblr.com/info?api_key=fuiKNFp9vQFvjLNvx4sUwti4Yb5yGutBN4Xh10LXZhhRKjWlV4";


    //views
    NetworkImageView errorNIV;
    NetworkImageView demoNIV;
    CircleNetworkImageView demoCNIV;
    EditText demoEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        errorNIV = (NetworkImageView) findViewById(R.id.error_niv);
        demoNIV = (NetworkImageView) findViewById(R.id.demo_niv);
        demoCNIV = (CircleNetworkImageView) findViewById(R.id.demo_cniv);
        demoEditText = (EditText) findViewById(R.id.gson_demo_et);

        // when the url is not valid or the internet is not available
        errorNIV.setErrorImageResId(R.drawable.dummy);
        errorNIV.setDefaultImageResId(R.drawable.dummy);
        errorNIV.setImageUrl(errorUrl, VolleySingleton.getInstance(context).getImageLoader());

        // get the image from testImageUrl and show it with NetworkImageView
        demoNIV.setErrorImageResId(R.drawable.dummy);
        demoNIV.setDefaultImageResId(R.drawable.dummy);
        demoNIV.setImageUrl(testImageUrl, VolleySingleton.getInstance(context).getImageLoader());

        // get the image from testImageUrl and show it with CircleNetworkImageView
        demoCNIV.setErrorImageResId(R.drawable.dummy);
        demoCNIV.setDefaultImageResId(R.drawable.dummy);
        demoCNIV.setImageUrl(testImageUrl, VolleySingleton.getInstance(context).getImageLoader());

        // get the json oject from internet and use GSON to save it
        GsonRequest<GsonTumblr> getTumblrReuest = new GsonRequest<GsonTumblr>(
                Request.Method.GET, testGsonUrl, GsonTumblr.class,
                createGetNotificationReqSuccessListener(),
                createNotificationReqErrorListener());

        getTumblrReuest.setRetryPolicy(new DefaultRetryPolicy(7000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getTumblrReuest.setTag("getNotification");
        VolleySingleton.getInstance(context).getRequestQueue().add(getTumblrReuest);
    }

    private Response.Listener<GsonTumblr> createGetNotificationReqSuccessListener(
    ) {

        return new Response.Listener<GsonTumblr>() {
            @Override
            public void onResponse(GsonTumblr response) {
                Log.d(TAG, "Success response :" + response.toString());
                demoEditText.setText(response.toString());
            }
        };
    }

    private Response.ErrorListener createNotificationReqErrorListener() {

        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d(TAG, "error response :" + error);
            }
        };
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
