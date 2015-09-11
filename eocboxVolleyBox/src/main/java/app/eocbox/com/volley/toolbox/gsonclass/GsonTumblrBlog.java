package app.eocbox.com.volley.toolbox.gsonclass;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Field;

/**
 * Created by Bruce_Lan on 15/9/11.
 */
public class GsonTumblrBlog {

    @SerializedName("title")
    private String title;

    @SerializedName("name")
    private String name;

    @SerializedName("posts")
    private Integer posts;

    @SerializedName("url")
    private String url;

    @SerializedName("updated")
    private Long updated;

    @SerializedName("description")
    private String description;

    @SerializedName("is_nsfw")
    private Boolean isNsfw;

    @SerializedName("ask")
    private Boolean isAsk;

    @SerializedName("ask_page_title")
    private String askPageTitle;

    @SerializedName("ask_anon")
    private Boolean isAskAnon;

    @SerializedName("can_message")
    private Boolean isCanMessage;

    @SerializedName("share_likes")
    private Boolean isShareLikes;

    public String getAskPageTitle() {
        return askPageTitle;
    }

    public void setAskPageTitle(String askPageTitle) {
        this.askPageTitle = askPageTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsAsk() {
        return isAsk;
    }

    public void setIsAsk(Boolean isAsk) {
        this.isAsk = isAsk;
    }

    public Boolean getIsAskAnon() {
        return isAskAnon;
    }

    public void setIsAskAnon(Boolean isAskAnon) {
        this.isAskAnon = isAskAnon;
    }

    public Boolean getIsCanMessage() {
        return isCanMessage;
    }

    public void setIsCanMessage(Boolean isCanMessage) {
        this.isCanMessage = isCanMessage;
    }

    public Boolean getIsNsfw() {
        return isNsfw;
    }

    public void setIsNsfw(Boolean isNsfw) {
        this.isNsfw = isNsfw;
    }

    public Boolean getIsShareLikes() {
        return isShareLikes;
    }

    public void setIsShareLikes(Boolean isShareLikes) {
        this.isShareLikes = isShareLikes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosts() {
        return posts;
    }

    public void setPosts(Integer posts) {
        this.posts = posts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}


