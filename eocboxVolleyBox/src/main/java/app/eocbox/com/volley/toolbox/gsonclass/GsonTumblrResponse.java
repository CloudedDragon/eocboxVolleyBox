package app.eocbox.com.volley.toolbox.gsonclass;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;

/**
 * Created by Bruce_Lan on 15/9/11.
 */
public class GsonTumblrResponse {

    @SerializedName("blog")
    private GsonTumblrBlog gsonTumblrBlog;

    public GsonTumblrBlog getGsonTumblrBlog() {
        return gsonTumblrBlog;
    }

    public void setGsonTumblrBlog(GsonTumblrBlog gsonTumblrBlog) {
        this.gsonTumblrBlog = gsonTumblrBlog;
    }

    public String toString() {

        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(this.getClass().getName());
        result.append(" Object {");
        result.append(newLine);

        // determine fields declared in this class only (no fields of
        // superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        // print field names paired with their values
        for (Field field : fields) {
            result.append("  ");
            try {
                result.append(field.getName());
                result.append(": ");
                // requires access to private field:
                result.append(field.get(this));
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }
//        {
//                meta:{
//                        status:200,
//                        msg:"OK"
//                },
//                response:{
//                        blog:{
//                                       title:"Scipsy",
//                                        name:"scipsy",
//                                        posts:8524,
//                                        url:"http://scipsy.tumblr.com/",
//                                        updated:1365196814,
//                                        description:""Science is interesting and if you don't agree, fuck off"",
//                                        is_nsfw:false,
//                                        ask:true,
//                                        ask_page_title:"Ask me anything",
//                                        ask_anon:true,
//                                        can_message:false,
//                                        share_likes:false
//                        }
//                }
//        }
}
