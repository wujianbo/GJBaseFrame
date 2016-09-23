package com.yubaokang.baseframe.views.home;

import com.gj.base.lib.utils.GsonUtils;
import com.yubaokang.baseframe.base.dagger.scopes.ActivityScope;
import com.yubaokang.baseframe.model.response.WeiXinDataListRes;

import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;


/**
 * Created by yubao on 2016/8/27.
 */
@ActivityScope
public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private HomeFragmentContract.View view;
    private Subscription subscription;

    public HomeFragmentPresenter(HomeFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        loadDatas();
    }

    @Override
    public void apiCancel() {
        if (subscription != null) {
            subscription.cancel();
        }
    }

    private String wx="{\n" +
            "    \"reason\": \"success\",\n" +
            "    \"result\": {\n" +
            "        \"list\": [\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401071581\",\n" +
            "                \"title\": \"号外：集宁到乌兰花的班车出事了！！！！！\",\n" +
            "                \"source\": \"内蒙那点事儿\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214279.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071581\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402028462\",\n" +
            "                \"title\": \"【夜读】梁晓声：你追求的，就是你人生的意义\",\n" +
            "                \"source\": \"人民日报\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214521.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402028462\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401071583\",\n" +
            "                \"title\": \"孩子们喜欢怎样的房间 你不能装作不知道\",\n" +
            "                \"source\": \"尚品宅配\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214277.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071583\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401070488\",\n" +
            "                \"title\": \"国家电网员工竟然这样办婚礼……\",\n" +
            "                \"source\": \"国网江苏省电力公司\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214267.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401070488\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401070491\",\n" +
            "                \"title\": \"【独家】2015年室内色彩搭配指南\",\n" +
            "                \"source\": \"尚品宅配\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214270.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401070491\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401070489\",\n" +
            "                \"title\": \"德国人的严谨出了名 那家具设计呢？\",\n" +
            "                \"source\": \"尚品宅配\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214269.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401070489\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402003213\",\n" +
            "                \"title\": \"关于家具，80%的人想这样\",\n" +
            "                \"source\": \"尚品宅配\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214343.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402003213\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402004584\",\n" +
            "                \"title\": \"是夫妻就要戒了这些！\",\n" +
            "                \"source\": \"我是个妈妈\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214375.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402004584\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402007350\",\n" +
            "                \"title\": \"今天吃点后悔药 开始巅峰人生吧\",\n" +
            "                \"source\": \"冷笑话精选\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214476.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402007350\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402007351\",\n" +
            "                \"title\": \"男生在恋爱中要明白的道理 vs 女生要明白的道理\",\n" +
            "                \"source\": \"冷笑话精选\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214479.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402007351\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402003473\",\n" +
            "                \"title\": \"两张照片,震撼了全世界\",\n" +
            "                \"source\": \"视觉志\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214358.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402003473\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402007349\",\n" +
            "                \"title\": \"其实交对了损友，愚人节每天都过~尼玛笑哭了！\",\n" +
            "                \"source\": \"冷笑话\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214475.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402007349\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402004585\",\n" +
            "                \"title\": \"探班颜值最高剧组——《栀子花开》！\",\n" +
            "                \"source\": \"快乐大本营\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214373.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402004585\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401066945\",\n" +
            "                \"title\": \"这个放到你的朋友圈上，大家都会感激你的！\",\n" +
            "                \"source\": \"金立关怀\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214253.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401066945\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401066341\",\n" +
            "                \"title\": \"愚人节：你被这些谣言愚弄过吗？\",\n" +
            "                \"source\": \"国网江苏省电力公司\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214250.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401066341\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402004583\",\n" +
            "                \"title\": \"你见过最美好的女生是什么样的\",\n" +
            "                \"source\": \"清华南都\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214374.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402004583\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150401071587\",\n" +
            "                \"title\": \" 轻松二刻 | 真的要被这些小屁孩蠢哭了！哈哈哈哈\",\n" +
            "                \"source\": \"卡娃微卡\",\n" +
            "                \"firstImg\": \"\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150401071587\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402001258\",\n" +
            "                \"title\": \" 生活百科 | 你的便便能告诉你。。。\",\n" +
            "                \"source\": \"卡娃微卡\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214308.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402001258\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402003470\",\n" +
            "                \"title\": \"笨蛋汪才是人类的贴心小棉袄！！！\",\n" +
            "                \"source\": \"冷兔\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214360.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402003470\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"wechat_20150402003471\",\n" +
            "                \"title\": \"首例男性生子成功，女人们开心吗？\",\n" +
            "                \"source\": \"上街吧\",\n" +
            "                \"firstImg\": \"http://zxpic.gtimg.com/infonew/0/wechat_pics_-214359.jpg/168\",\n" +
            "                \"mark\": \"\",\n" +
            "                \"url\": \"http://v.juhe.cn/weixin/redirect?wid=wechat_20150402003471\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"totalPage\": 16,\n" +
            "        \"ps\": 20,\n" +
            "        \"pno\": 1\n" +
            "    },\n" +
            "    \"error_code\": 0\n" +
            "}";
    @Override
    public void loadDatas() {
//        App.getComponent().request().getWeiXin(String.valueOf(view.loadPageNum()))
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io())
//                .flatMap(new Function<WeiXinDataListRes, Publisher<WeiXinDataListRes>>() {
//                    @Override
//                    public Publisher<WeiXinDataListRes> apply(WeiXinDataListRes weiXinDataListRes) throws Exception {
//                        if (weiXinDataListRes == null) {
//                            return Flowable.error(new NullPointerException("解析错误"));
//                        }
//                        return Flowable.just(weiXinDataListRes);
//                    }
//                })
//                .timeout(1000, TimeUnit.SECONDS, new Flowable<WeiXinDataListRes>() {
//                    @Override
//                    protected void subscribeActual(Subscriber<? super WeiXinDataListRes> s) {
//                        s.onError(new Throwable());
//                    }
//                })
//                .switchMap(new Function<WeiXinDataListRes, Publisher<WeiXinDataListRes>>() {
//                    @Override
//                    public Publisher<WeiXinDataListRes> apply(WeiXinDataListRes weiXinDataListRes) throws Exception {
//                        return Flowable.just(weiXinDataListRes);
//                    }
//                })
//                .subscribe(new Subscriber<WeiXinDataListRes>() {
//                    @Override
//                    public void onComplete() {
//                        L.i("哈哈哈");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        view.showEmpty();
//                    }
//
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        subscription = s;
//                    }
//
//                    @Override
//                    public void onNext(WeiXinDataListRes weiXinDataListRes) {
//                        view.showDatas(weiXinDataListRes);
//                    }
//                });
        Flowable.timer(3,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ResourceSubscriber<Long>() {
                    @Override
                    public void onNext(Long aLong) {
//                        WeiXinDataListRes weiXinDataListRes= GsonUtils.getInstance().getObject(((Fragment)view).getString(R.string.weixin),WeiXinDataListRes.class);
                        WeiXinDataListRes weiXinDataListRes= GsonUtils.getInstance().getObject(wx,WeiXinDataListRes.class);
                        view.showDatas(weiXinDataListRes);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}