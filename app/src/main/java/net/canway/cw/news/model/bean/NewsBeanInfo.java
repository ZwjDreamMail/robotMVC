package net.canway.cw.news.model.bean;

import java.util.List;

/**
 * @author 张文建 king
 * @email 529169501@qq.com
 * @desc ${TODD}
 */
public class NewsBeanInfo {

    /**
     * top_stories : [{"id":9253270,"title":"偏远的奥特莱斯，难用的录像机，都是为了赚钱专门设计的","ga_prefix":"022807","image":"http://pic2.zhimg.com/dec813de80659e17554c9a8d311fb419.jpg","type":0},{"id":9253384,"title":"巨头出手，共享单车领域的决定性战役即将开启？","ga_prefix":"022807","image":"http://pic4.zhimg.com/695a89274adcfaad94758568f5afdd5b.jpg","type":0},{"id":9253411,"title":"奥斯卡 · 这是一份完整的（没出错的）获奖名单分析","ga_prefix":"022716","image":"http://pic3.zhimg.com/6184ccf05c5bd52053f21f150fef32d6.jpg","type":0},{"id":9253164,"title":"奥斯卡 · 讲述黑人、毒品、同性恋《月光男孩》，是编剧自己的故事","ga_prefix":"022714","image":"http://pic1.zhimg.com/b3a2d414ac6e8d9225fbef107ad9550c.jpg","type":0},{"id":9241361,"title":"奥斯卡 · 《月光男孩》，政治正确的胜利还是电影语言的成功？","ga_prefix":"022713","image":"http://pic1.zhimg.com/ef9f4abc09282f8ea634b2a068aee720.jpg","type":0}]
     * stories : [{"id":9251246,"title":"真正的吃货，一口就尝出冷鲜奶和常温奶的区别","ga_prefix":"022810","images":["http://pic2.zhimg.com/d8f36004628c4d1a3b6d1e2be7e81591.jpg"],"type":0},{"id":9254337,"multipic":true,"title":"我在洛杉矶找到了《爱乐之城》里关于爱的 15 个地点","ga_prefix":"022809","images":["http://pic3.zhimg.com/b0df0cc5e98fbac6ff7fd821b4057426.jpg"],"type":0},{"id":9253808,"title":"作为一名眼科医生，我想说「洗眼液」真的没什么用","ga_prefix":"022808","images":["http://pic3.zhimg.com/a66e7586025c20eadda9350a5ced1d2a.jpg"],"type":0},{"id":9253270,"title":"偏远的奥特莱斯，难用的录像机，都是为了赚钱专门设计的","ga_prefix":"022807","images":["http://pic3.zhimg.com/2a9a83a7a5a2c69d887c63cccb2a2a16.jpg"],"type":0},{"id":9254324,"title":"奥斯卡 · 本届影帝有个很红的哥哥，还有更多的爱和更清醒的「任性」","ga_prefix":"022807","images":["http://pic2.zhimg.com/d3642908f3881056cd969eae16d025fd.jpg"],"type":0},{"id":9253384,"title":"巨头出手，共享单车领域的决定性战役即将开启？","ga_prefix":"022807","images":["http://pic2.zhimg.com/2bc3ef8df694da1ba2a29674b7d40d25.jpg"],"type":0},{"id":9244327,"title":"瞎扯 · 如何正确地吐槽","ga_prefix":"022806","images":["http://pic2.zhimg.com/6f924666559fd601d02a219b4eace4d9.jpg"],"type":0}]
     * date : 20170228
     */
    private List<TopStoriesEntity> top_stories;
    private List<StoriesEntity> stories;
    private String date;

    public void setTop_stories(List<TopStoriesEntity> top_stories) {
        this.top_stories = top_stories;
    }

    public void setStories(List<StoriesEntity> stories) {
        this.stories = stories;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TopStoriesEntity> getTop_stories() {
        return top_stories;
    }

    public List<StoriesEntity> getStories() {
        return stories;
    }

    public String getDate() {
        return date;
    }

    public static class TopStoriesEntity {
        /**
         * id : 9253270
         * title : 偏远的奥特莱斯，难用的录像机，都是为了赚钱专门设计的
         * ga_prefix : 022807
         * image : http://pic2.zhimg.com/dec813de80659e17554c9a8d311fb419.jpg
         * type : 0
         */
        private int id;
        private String title;
        private String ga_prefix;
        private String image;
        private int type;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setType(int type) {
            this.type = type;
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

        public String getImage() {
            return image;
        }

        public int getType() {
            return type;
        }
    }

    public static class StoriesEntity {
        /**
         * id : 9251246
         * title : 真正的吃货，一口就尝出冷鲜奶和常温奶的区别
         * ga_prefix : 022810
         * images : ["http://pic2.zhimg.com/d8f36004628c4d1a3b6d1e2be7e81591.jpg"]
         * type : 0
         */
        private int id;
        private String title;
        private String ga_prefix;
        private List<String> images;
        private int type;

        public void setId(int id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        public void setType(int type) {
            this.type = type;
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

        public List<String> getImages() {
            return images;
        }

        public int getType() {
            return type;
        }
    }
}
