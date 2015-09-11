EocboxVolleyBox  
----------

This is a toolbox for integration of [Android Volley library](https://android.googlesource.com/platform/frameworks/volley) and [OkHttp](https://github.com/square/okhttp)

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



## Screenshot
![](https://github.com/CloudedDragon/eocboxVolleyBox/blob/master/demo.png)


## Statement
The project is just for research purpose,not as a commercial activity.



## Example

``` java
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
}

```
## License
Copyright (c) 2014 ~ 2015 - CloudedDragon

Licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)
