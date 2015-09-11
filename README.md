EocboxVolleyBox  
----------

This is a toolbox for integration of [Android Volley library](https://android.googlesource.com/platform/frameworks/volley), [OkHttp](https://github.com/square/okhttp) and [Gson](https://github.com/google/gson)

* **Android-Volley**
    * Is an HTTP library that makes networking for Android apps easier and most importantly, faster. 
    * Automatic scheduling of network requests.
    * Multiple concurrent network connections.
    * Transparent disk and memory response caching with standard HTTP cache coherence.
    * Support for request prioritization.
    * Cancellation request API. You can cancel a single request, or you can set blocks or scopes of requests to cancel.
    * Ease of customization, for example, for retry and backoff.
    * Strong ordering that makes it easy to correctly populate your UI with data fetched asynchronously from the network.
    * Debugging and tracing tools.

* **OkHttp**
    * An HTTP & SPDY client for Android and Java applications. 
    * HTTP/2 and SPDY support allows all requests to the same host to share a socket.
    * Connection pooling reduces request latency (if SPDY isn’t available).
    * Transparent GZIP shrinks download sizes.
    * Response caching avoids the network completely for repeat requests.

* **Gson**
    * Is a Java library that can be used to convert Java Objects into their JSON representation.
    * Provide simple toJson() and fromJson() methods to convert Java objects to JSON and vice-versa
    * Allow pre-existing unmodifiable objects to be converted to and from JSON
    * Extensive support of Java Generics
    * Allow custom representations for objects
    * Support arbitrarily complex objects (with deep inheritance hierarchies and extensive use of generic types)

## Screenshot
* *Demo for get image from internet*
![](https://github.com/CloudedDragon/eocboxVolleyBox/blob/master/demo.png)
* *Demo for get JSON from Tumblr test api and save it with GSON Library*
![](https://github.com/CloudedDragon/eocboxVolleyBox/blob/master/demo2.png)

## Statement
The project is just for research purpose,not as a commercial activity.

## Example

``` java
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
                createGetReqSuccessListener(),
                createReqErrorListener());

        getTumblrReuest.setRetryPolicy(new DefaultRetryPolicy(7000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        getTumblrReuest.setTag("getTumblrReuest");
        VolleySingleton.getInstance(context).getRequestQueue().add(getTumblrReuest);
    }

    private Response.Listener<GsonTumblr> createGetReqSuccessListener(
    ) {

        return new Response.Listener<GsonTumblr>() {
            @Override
            public void onResponse(GsonTumblr response) {
                Log.d(TAG, "Success response :" + response.toString());
                demoEditText.setText(response.toString());
            }
        };
    }

    private Response.ErrorListener createReqErrorListener() {

        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d(TAG, "error response :" + error);
            }
        };
    }
```
## License
Copyright (c) 2014 ~ 2015 - CloudedDragon

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
