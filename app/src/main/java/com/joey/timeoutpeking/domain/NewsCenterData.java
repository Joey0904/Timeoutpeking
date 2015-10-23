package com.joey.timeoutpeking.domain;

import java.util.List;

/**
 * Created by Di on 10/16/15.
 */
public class NewsCenterData {
    public int retCode;
    public List<Data> mData;
    public List<String> mExtends;

    public class Data {

        public List<Children> mChildren;
        public String id;//	10000
        public String title;//	新闻
        public String type;//	1
        public String url;//	/10006/list_1.json
        public String url1;//	/10007/list1_1.json
        public String dayurl;//
        public String excurl;//
        public String weekurl;

        public class Children {

            public String id;//	10007
            public String title;//	北京
            public String type;//	1
            public String url;//	/10007/list_1.json
        }
    }
}
