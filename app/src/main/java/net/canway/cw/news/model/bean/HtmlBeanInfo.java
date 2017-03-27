package net.canway.cw.news.model.bean;


import java.util.List;

/**
 * @author 张文建
 * @time 2017/2/7  16:07
 * @desc ${TODD}
 */
public class HtmlBeanInfo {



    /**
     * id : 9201288
     * title : 动物界有谁是在修炼《葵花宝典》的？
     * ga_prefix : 020710
     * share_url : http://daily.zhihu.com/story/9201288
     * js : []
     * images : ["http://pic2.zhimg.com/1498abb541ba0ff04411c05b78068415.jpg"]
     * image : http://pic1.zhimg.com/18f9a111785b2c485c2690276d91ab20.jpg
     * type : 0
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     * image_source : Ruth Hartnup / CC BY
     */
    private String body;
    private int id;
    private String title;
    private String ga_prefix;
    private String share_url;
    private List<?> js;
    private List<String> images;
    private String image;
    private int type;
    private List<String> css;
    private String image_source;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public void setJs(List<?> js) {
        this.js = js;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public String getShare_url() {
        return share_url;
    }

    public List<?> getJs() {
        return js;
    }

    public List<String> getImages() {
        return images;
    }

    public String getImage() {
        return image;
    }

    public int getType() {
        return type;
    }

    public List<String> getCss() {
        return css;
    }

    public String getImage_source() {
        return image_source;
    }
}
