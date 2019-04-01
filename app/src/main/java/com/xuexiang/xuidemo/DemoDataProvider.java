package com.xuexiang.xuidemo;

import android.support.v4.view.ViewPager;

import com.xuexiang.xui.adapter.simple.AdapterItem;
import com.xuexiang.xui.widget.banner.transform.DepthTransformer;
import com.xuexiang.xui.widget.banner.transform.FadeSlideTransformer;
import com.xuexiang.xui.widget.banner.transform.FlowTransformer;
import com.xuexiang.xui.widget.banner.transform.RotateDownTransformer;
import com.xuexiang.xui.widget.banner.transform.RotateUpTransformer;
import com.xuexiang.xui.widget.banner.transform.ZoomOutSlideTransformer;
import com.xuexiang.xui.widget.banner.widget.banner.BannerItem;
import com.xuexiang.xui.widget.imageview.nine.NineGridImageView;
import com.xuexiang.xuidemo.fragment.components.imageview.preview.ImageViewInfo;
import com.xuexiang.xuidemo.fragment.components.imageview.preview.NineGridInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 演示数据
 *
 * @author xuexiang
 * @since 2018/11/23 下午5:52
 */
public class DemoDataProvider {

    public static String[] titles = new String[]{
            "伪装者:胡歌演绎'痞子特工'",
            "无心法师:生死离别!月牙遭虐杀",
            "花千骨:尊上沦为花千骨",
            "综艺饭:胖轩偷看夏天洗澡掀波澜",
            "碟中谍4:阿汤哥高塔命悬一线,超越不可能",
    };

    public static String[] urls = new String[]{//640*360 360/640=0.5625
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144160323071011277.jpg",//伪装者:胡歌演绎"痞子特工"
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144158380433341332.jpg",//无心法师:生死离别!月牙遭虐杀
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144160286644953923.jpg",//花千骨:尊上沦为花千骨
            "http://photocdn.sohu.com/tvmobilemvms/20150902/144115156939164801.jpg",//综艺饭:胖轩偷看夏天洗澡掀波澜
            "http://photocdn.sohu.com/tvmobilemvms/20150907/144159406950245847.jpg",//碟中谍4:阿汤哥高塔命悬一线,超越不可能
    };

    public static List<BannerItem> getBannerList() {
        ArrayList<BannerItem> list = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            BannerItem item = new BannerItem();
            item.imgUrl = urls[i];
            item.title = titles[i];

            list.add(item);
        }

        return list;
    }

    public static ArrayList<Integer> getUsertGuides() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.drawable.guide_img_1);
        list.add(R.drawable.guide_img_2);
        list.add(R.drawable.guide_img_3);
        list.add(R.drawable.guide_img_4);
        return list;
    }

    public static Class<? extends ViewPager.PageTransformer> transformers[] = new Class[]{
            DepthTransformer.class,
            FadeSlideTransformer.class,
            FlowTransformer.class,
            RotateDownTransformer.class,
            RotateUpTransformer.class,
            ZoomOutSlideTransformer.class,
    };


    public static String[] dpiItems = new String[]{
            "480 × 800",
            "1080 × 1920",
            "720 × 1280",
    };

    public static Collection<String> getDemoData() {
        return Arrays.asList("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public static AdapterItem[] menuItems = new AdapterItem[]{
            new AdapterItem("登陆", R.drawable.icon_password_login),
            new AdapterItem("筛选", R.drawable.icon_filter),
            new AdapterItem("设置", R.drawable.icon_setting),
    };

    public static List<List<ImageViewInfo>> sPics;
    public static List<List<ImageViewInfo>> sVideos;

    public static List<ImageViewInfo> imgs;
    public static List<ImageViewInfo> videos;

    public static List<List<NineGridInfo>> sNineGridPics;
    public static List<List<NineGridInfo>> sNineGridVideos;


    static {
        imgs = new ArrayList<>();
        List<String> list = getUrls();
        for (int i = 0; i < list.size(); i++) {
            imgs.add(new ImageViewInfo(list.get(i)));
        }

        videos = getVideos();

        sPics = split(imgs, 10);
        sVideos = split(videos, 10);

        sNineGridPics = split(getMediaDemos(40, 0), 10);
        sNineGridVideos = split(getMediaDemos(20, 1), 10);

    }

    private static List<NineGridInfo> getMediaDemos(int length, int type) {
        List<NineGridInfo> list = new ArrayList<>();
        NineGridInfo info;
        for (int i = 0; i < length; i++) {
            info = new NineGridInfo("我是一只喵，快乐的星猫～～～", getRandomMedias((int) (Math.random() * 10 + 0.5), type))
                .setShowType(NineGridImageView.STYLE_FILL);
            list.add(info);
        }
        return list;
    }

    private static List<ImageViewInfo> getRandomMedias(int length, int type) {
        List<ImageViewInfo> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (type == 0) {
                list.add(imgs.get(i));
            } else {
                list.add(videos.get(i));
            }
        }
        return list;
    }


    private static List<ImageViewInfo> getVideos() {
        List<ImageViewInfo> videos = new ArrayList<>();
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a.mp4",
                "http://pic.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a.mp4",
                "http://pic.vjshi.com/2017-05-25/b146e104069c2bd0590bb919269193c4/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-05-07/d0bbfc4ac4dd173cc93873ed4eb0be53.mp4",
                "http://pic.vjshi.com/2017-05-07/d0bbfc4ac4dd173cc93873ed4eb0be53/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));

        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-07-18/80d08ce1a84adfbaed5c7067b73d19ed.mp4",
                "http://pic.vjshi.com/2017-07-18/80d08ce1a84adfbaed5c7067b73d19ed/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://img0.imgtn.bdimg.com/it/u=556618733,1205300389&fm=21&gp=0.jpg"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a.mp4",
                "http://pic.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://img0.imgtn.bdimg.com/it/u=556618733,1205300389&fm=21&gp=0.jpg"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2018-06-07/cf673556cce54ab9cf4633fd7d9d0d46.mp4",
                "http://pic.vjshi.com/2018-06-06/caa296729c8e6e41e6aff2aadf4feff3/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://img44.photophoto.cn/20170730/0018090594006661_s.jpg"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a.mp4",
                "http://pic.vjshi.com/2017-09-13/f55a900d89679ac1c9837d5b5aaf632a/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2018-01-27/5169bb7bdd7386ce7bd4ce1739229424.mp4",
                "http://pic.vjshi.com/2018-01-27/5169bb7bdd7386ce7bd4ce1739229424/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://photocdn.sohu.com/20160307/mp62252655_1457334772519_2.png"));
        videos.add(new ImageViewInfo("http://lmp4.vjshi.com/2017-09-27/9a6e69f7c257ff7b7832e8bac6fddf82.mp4",
                "http://pic.vjshi.com/2017-09-27/9a6e69f7c257ff7b7832e8bac6fddf82/online/puzzle.jpg?x-oss-process=style/resize_w_285_crop_h_428"));
        videos.add(new ImageViewInfo("http://photocdn.sohu.com/20160307/mp62252655_1457334772519_2.png"));
        return videos;
    }

    private static List<String> getUrls() {
        List<String> urls = new ArrayList<>();
        urls.add("http://img4.duitang.com/uploads/item/201307/02/20130702113059_UEGL2.jpeg");
        urls.add("http://img0.imgtn.bdimg.com/it/u=985035006,79865976&fm=21&gp=0.jpg");
        urls.add("http://img5.imgtn.bdimg.com/it/u=1774291582,2563335167&fm=21&gp=0.jpg");
        urls.add("http://img5.imgtn.bdimg.com/it/u=1511364704,3337189105&fm=21&gp=0.jpg");
        urls.add("http://pic.qiantucdn.com/58pic/11/90/83/96a58PICrRx.jpg");
        urls.add("http://pic.qiantucdn.com/58pic/13/09/97/26W58PICKNk_1024.jpg");
        urls.add("http://img1.imgtn.bdimg.com/it/u=3272030875,860665188&fm=21&gp=0.jpg");
        urls.add("http://img1.imgtn.bdimg.com/it/u=2237658959,3726297486&fm=21&gp=0.jpg");
        urls.add("http://img1.imgtn.bdimg.com/it/u=3016675040,1510439865&fm=21&gp=0.jpg");
        urls.add("http://photocdn.sohu.com/20160307/mp62252655_1457334772519_2.png");

        urls.add("http://img0.imgtn.bdimg.com/it/u=556618733,1205300389&fm=21&gp=0.jpg");
        urls.add("http://img1.imgtn.bdimg.com/it/u=3272030875,860665188&fm=21&gp=0.jpg");
        urls.add("http://img1.imgtn.bdimg.com/it/u=2237658959,3726297486&fm=21&gp=0.jpg");
        urls.add("http://img1.imgtn.bdimg.com/it/u=3016675040,1510439865&fm=21&gp=0.jpg");
        urls.add("http://photocdn.sohu.com/20160307/mp62252655_1457334772519_2.png");
        urls.add("http://d040779c2cd49.scdn.itc.cn/s_big/pic/20161213/184474627873966848.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/36f0523ee1888a57.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/07915a0154ac4a64.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/9ec4bc44bfaf07ed.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/fa85037f97e8191f.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/de13315600ba1cff.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/9ec4bc44bfaf07ed.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/fa85037f97e8191f.jpg");
        urls.add("ttp://ac-QYgvX1CC.clouddn.com/de13315600ba1cff.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/ad99de83e1e3f7d4.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/15c5c50e941ba6b0.jpg");
        urls.add("http://ac-QYgvX1CC.clouddn.com/eaf1c9d55c5f9afd.jpg");
        urls.add("http://pic44.photophoto.cn/20170802/0017030376585114_b.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0847085702814554_s.jpg");
        urls.add("http://img44.photophoto.cn/20170802/0017030319134956_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0838084023987260_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0838084009134421_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0838084002855326_s.jpg");

        urls.add("http://img44.photophoto.cn/20170731/0847085207211178_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0017030319740534_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0838084002855326_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085969586424_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0014105802293676_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0847085242661101_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0886088744582079_s.jpg");
        urls.add("http://img44.photophoto.cn/20170801/0017029514287804_s.jpg");
        urls.add("http://img44.photophoto.cn/20170730/0018090594006661_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085848134910_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085581124963_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085226124343_s.jpg");

        urls.add("http://img44.photophoto.cn/20170729/0847085226124343_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085200668628_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085246003750_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085012707934_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0005018303330857_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085231427344_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085236829578_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085729490157_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0847085751995287_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085729043617_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085786392651_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085761440022_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0847085275244570_s.jpg");


        urls.add("http://img44.photophoto.cn/20170722/0847085858434984_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085781987193_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085707961800_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085229451104_s.jpg");
        urls.add("http://img44.photophoto.cn/20170720/0847085716198074_s.jpg");
        urls.add("http://img44.photophoto.cn/20170720/0847085769259426_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085717385169_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085757949071_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085789079771_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085229451104_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085757949071_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085265005650_s.jpg");
        urls.add("http://img44.photophoto.cn/20170730/0008118269110532_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0008118203762697_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0008118269666722_s.jpg");

        urls.add("http://img44.photophoto.cn/20170722/0847085858434984_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085781987193_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085707961800_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085229451104_s.jpg");
        urls.add("http://img44.photophoto.cn/20170720/0847085716198074_s.jpg");
        urls.add("http://img44.photophoto.cn/20170720/0847085769259426_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085717385169_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085757949071_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085789079771_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085229451104_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085757949071_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085265005650_s.jpg");
        urls.add("http://img44.photophoto.cn/20170730/0008118269110532_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0008118203762697_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0008118269666722_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085858434984_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085781987193_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085707961800_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085229451104_s.jpg");
        urls.add("http://img44.photophoto.cn/20170720/0847085716198074_s.jpg");
        urls.add("http://img44.photophoto.cn/20170720/0847085769259426_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085717385169_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085757949071_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085789079771_s.jpg");
        urls.add("http://img44.photophoto.cn/20170722/0847085229451104_s.jpg");
        urls.add("http://img44.photophoto.cn/20170721/0847085757949071_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085265005650_s.jpg");
        urls.add("http://img44.photophoto.cn/20170730/0008118269110532_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0008118203762697_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0008118269666722_s.jpg");

        urls.add("http://img44.photophoto.cn/20170731/0847085207211178_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0017030319740534_s.jpg");
        urls.add("http://img44.photophoto.cn/20170731/0838084002855326_s.jpg");
        urls.add("http://img44.photophoto.cn/20170728/0847085969586424_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0014105802293676_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0847085242661101_s.jpg");
        urls.add("http://img44.photophoto.cn/20170727/0886088744582079_s.jpg");
        urls.add("http://img44.photophoto.cn/20170801/0017029514287804_s.jpg");
        urls.add("http://img44.photophoto.cn/20170730/0018090594006661_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085848134910_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085581124963_s.jpg");
        urls.add("http://img44.photophoto.cn/20170729/0847085226124343_s.jpg");

        return urls;
    }


    public static List<ImageViewInfo> getGifUrls() {
        List<ImageViewInfo> userViewInfos = new ArrayList<>();
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/8Q8Vy8jh6wEYCT4bYiEAOZdmzIf7GrLQ.gif_s400x0"));
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/yCPIVl3icfbIhZ1rjKKU6Kl6lCKkC8Wq.gif_s400x0"));
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/mQK3vlOYVOIpnhNYKg6XuWqpc3yAg9hR.gif_s400x0"));
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/mESQBeZn5V8Xzke0XPsnEEXUF9MaU3sA.gif_s400x0"));
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/HFuVvydFj7dgIEcbEBMA9ccGcGOFdEsx.gif_s400x0"));
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/SH0FB6FnTNgoCsVtxcAMtSNfV7XxXmo8.gif"));
        userViewInfos.add(new ImageViewInfo("http://img.soogif.com/KkB9WARG3PFrz9EEX4DJdiy6Vyg95fGl.gif"));
        return userViewInfos;
    }

    /**
     * 拆分集合
     *
     * @param <T>
     * @param resList 要拆分的集合
     * @param count   每个集合的元素个数
     * @return 返回拆分后的各个集合
     */
    public static <T> List<List<T>> split(List<T> resList, int count) {
        if (resList == null || count < 1)
            return null;
        List<List<T>> ret = new ArrayList<>();
        int size = resList.size();
        if (size <= count) { //数据量不足count指定的大小
            ret.add(resList);
        } else {
            int pre = size / count;
            int last = size % count;
            //前面pre个集合，每个大小都是count个元素
            for (int i = 0; i < pre; i++) {
                List<T> itemList = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    itemList.add(resList.get(i * count + j));
                }
                ret.add(itemList);
            }
            //last的进行处理
            if (last > 0) {
                List<T> itemList = new ArrayList<>();
                for (int i = 0; i < last; i++) {
                    itemList.add(resList.get(pre * count + i));
                }
                ret.add(itemList);
            }
        }
        return ret;
    }

}
