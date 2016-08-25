package com.yubaokang.baseframe.model.response;

import java.util.List;

/**
 * Created by yubaokang on 2016/8/25.
 */

public class NewsDataRes {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"title":"巫山云雨枉断肠：女摄影师ErikaLust记录的性爱","date":"2016-06-13 10:31","author_name":"POCO摄影","thumbnail_pic_s":"http://09.imgmini.eas03.jpeg","thumbnail_pic_s02":"http://09.imgmini01.jpeg","thumbnail_pic_s03":"http://09.imgmini..jpeg","url":"http://mini.eastday.com/mobile/160613103108379.html?qid=juheshuju","uniquekey":"160613103108379","type":"头条","realtype":"娱乐"}]}
     */

    private String reason;
    /**
     * stat : 1
     * data : [{"title":"巫山云雨枉断肠：女摄影师ErikaLust记录的性爱","date":"2016-06-13 10:31","author_name":"POCO摄影","thumbnail_pic_s":"http://09.imgmini.eas03.jpeg","thumbnail_pic_s02":"http://09.imgmini01.jpeg","thumbnail_pic_s03":"http://09.imgmini..jpeg","url":"http://mini.eastday.com/mobile/160613103108379.html?qid=juheshuju","uniquekey":"160613103108379","type":"头条","realtype":"娱乐"}]
     */

    private ResultBean result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        private String stat;
        /**
         * title : 巫山云雨枉断肠：女摄影师ErikaLust记录的性爱
         * date : 2016-06-13 10:31
         * author_name : POCO摄影
         * thumbnail_pic_s : http://09.imgmini.eas03.jpeg
         * thumbnail_pic_s02 : http://09.imgmini01.jpeg
         * thumbnail_pic_s03 : http://09.imgmini..jpeg
         * url : http://mini.eastday.com/mobile/160613103108379.html?qid=juheshuju
         * uniquekey : 160613103108379
         * type : 头条
         * realtype : 娱乐
         */

        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            private String title;
            private String date;
            private String author_name;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;
            private String url;
            private String uniquekey;
            private String type;
            private String realtype;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getRealtype() {
                return realtype;
            }

            public void setRealtype(String realtype) {
                this.realtype = realtype;
            }
        }
    }
}
