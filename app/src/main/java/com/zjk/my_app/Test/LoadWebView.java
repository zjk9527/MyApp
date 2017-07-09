package com.zjk.my_app.Test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.zjk.my_app.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zjk on 2017/5/23.
 */

public class LoadWebView extends WebView {
    /** 进度条进度默认的颜色--深天蓝*/
    private static final int DEF_BAR_COLOR_REACH = 0xFF00BFFF;
    /** 进度条默认的高度*/
    private static final int DEF_BAR_HEIGHT = 1;// dp

    private static final String DEF_ERROR_TEXT = "页面加载错误！点击屏幕重试！";
    /** 错误显示文字颜色*/
    private static final int DEF_ERROR_TEXT_COLOR = 0xFFFC00D1;// 红色
    /** 错误显示文字字体大小*/
    private static final int DEF_ERROR_TEXT_SIZE = 20;// sp

    private String TAG = this.getClass().getSimpleName();
    private Context mContext;

    /**
     * 网页加载进度条
     */
    private ProgressBar mProgressBar;
    /**
     * 进度条进度的颜色
     */
    private int mBarReachColor;
    /**
     * 进度条高度
     */
    private int mBarHeight;

    /**
     * 自定义的Url历史记录--不存储错误页面mUrlErrorStart的地址
     */
    private List<String> mUrlList;

    private String mMimeType = "text/html";
    /** 编码*/
    private String mEncoding = "UTF-8";
    /** 网页加载错误时加载空白页*/
    private String mUrlErrorStart = "about:blank";

    /** 错误显示的TextView*/
    private TextView mTvError;
    /** WebView显示错误页面时候，需要设置一个空字符串，否则不同的手机有可能会出现不同的文字*/
    private String mHintFail = "";
    /** 错误页面提醒文字*/
    private String mErrorText;
    /** 错误提醒文字大小*/
    private int mErrorTextSize;
    /** 错误提醒文字颜色*/
    private int mErrorTextColor;
    public LoadWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setWebViewClient(mWebViewClient);
        mContext = context;
        this.setWebViewClient(mWebViewClient);
        this.setWebChromeClient(mWebChromeClient);

        obtainStyledAttributes(context, attrs, defStyle);

        initProgressBar();
        addErrorTextView();
        mUrlList = new LinkedList<String>();
    }

    private void obtainStyledAttributes(Context context, AttributeSet attrs, int defStyle) {
        TypedArray ta = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.loadWebView, defStyle, 0);
        mBarReachColor = ta.getColor(R.styleable.loadWebView_progress_color, DEF_BAR_COLOR_REACH);
        mBarHeight = ta.getDimensionPixelSize(R.styleable.loadWebView_progress_height, dp2px(DEF_BAR_HEIGHT));
        mErrorText = ta.getString(R.styleable.loadWebView_error_text);
        if (TextUtils.isEmpty(mErrorText))
            mErrorText = DEF_ERROR_TEXT;
        mErrorTextColor = ta.getColor(R.styleable.loadWebView_error_text_color, DEF_ERROR_TEXT_COLOR);
        mErrorTextSize = ta.getDimensionPixelSize(R.styleable.loadWebView_error_text_size, sp2px(DEF_ERROR_TEXT_SIZE));
    }

    public LoadWebView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadWebView(Context context) {
        this(context, null);
    }

    private void addErrorTextView() {
        if (mTvError != null)
            return;
        mTvError = new TextView(mContext);
        android.widget.RelativeLayout.LayoutParams lp = new android.widget.RelativeLayout.LayoutParams(android.widget.RelativeLayout.LayoutParams.MATCH_PARENT,
                android.view.ViewGroup.LayoutParams.MATCH_PARENT);

        lp.addRule(RelativeLayout.CENTER_IN_PARENT);

        mTvError.setVisibility(INVISIBLE);
        mTvError.setText(mErrorText);
        mTvError.setTextSize(mErrorTextSize);
        mTvError.setTextColor(mErrorTextColor);
        mTvError.setGravity(Gravity.CENTER);

        mTvError.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // mWebView
                String url = getLastUrl();
                LoadWebView.this.loadUrl(url);
            }
        });
        this.addView(mTvError, lp);
    }

    /** WebView的client*/
    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            hideErrorTextView();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            if (url.startsWith(mUrlErrorStart))
                mTvError.setVisibility(VISIBLE);
            else {
                checkBack(url);
                addUrlList(url);
            }
        }

        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String url) {
            // 加载错误时，进行错误页面的加载
            loadDataWithBaseURL(null, mHintFail, mMimeType, mEncoding, null);
        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int progress) {
            mProgressBar.setProgress(progress);
            if (progress == 100) {
                if (mProgressBar.getVisibility() == VISIBLE) {
                    // 延迟隐藏进度条
                    handler.postDelayed(new Runnable() {

                        @Override
                        public void run() {

                            mProgressBar.setVisibility(INVISIBLE);
                        }
                    }, 200);
                }
            } else {
                mProgressBar.setVisibility(VISIBLE);
            }
        }
    };

    private Handler handler = new Handler();

    /**
     * <p>checkBack</p>
     * @Description:   检查是否可以回退
     * @param url
     */
    private void checkBack(String url) {
        String backUrl = getBackUrl();
        if (TextUtils.equals(url, backUrl))
            removeUrlTop();
    }

    /**
     * <p>initProgressBar</p>
     * @Description:   初始化进度条
     */
    private void initProgressBar() {
        mProgressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
        // mProgressBar.setLayoutParams(new
        // LayoutParams(LayoutParams.MATCH_PARENT, 10, 0, 0));
        mProgressBar.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(android.widget.RelativeLayout.LayoutParams.MATCH_PARENT, mBarHeight));

        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(mBarReachColor), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        mProgressBar.setProgressDrawable(clipDrawable);

        this.addView(mProgressBar);
    }

    private void hideErrorTextView() {
        if (mTvError != null && mTvError.getVisibility() == VISIBLE)
            mTvError.setVisibility(GONE);
    }

    /**
     * (非 Javadoc) <p>Title: goBack</p> <p>Description:
     * url页面回退(重写webView的goBack方法)，并删除上一级url</p>
     */
    @Override
    public void goBack() {
        String url = getBackUrl();
        this.loadUrl(url);
        removeUrlTop();
    }

    /**
     * <p>removeUrlTop</p>
     * @Description:   移除url列表顶部的url
     * @return url列表
     */
    private List<String> removeUrlTop() {
        if (mUrlList != null && mUrlList.size() > 1) {
            int size = mUrlList.size();
            mUrlList.remove(size - 1);
        }
        return mUrlList;
    }

    /**
     * <p>addUrlList</p>
     * @Description:   在url列表中添加url
     * <p> 添加规则：   1.错误页面(about:blank)不添加
     *             2.顶部页面相同不添加(不重复添加url--这个添加url列表的操作是在onPageFinished()中进行，有些手机在页面访问不成功会执行两次这个回调函数)
     * </p>
     * @param url      当前url
     * @return         url列表
     */
    private List<String> addUrlList(String url) {
        if (TextUtils.isEmpty(url))
            return mUrlList;
        if (url.startsWith(mUrlErrorStart))// 如果是错误页面显示的地址，则不添加到url列表中
            return mUrlList;
        if (null == mUrlList)
            mUrlList = new ArrayList<String>();
        int size = mUrlList.size();
        if (size == 0)
            mUrlList.add(url);
        else if (!TextUtils.equals(getLastUrl(), url))
            mUrlList.add(url);
        return mUrlList;
    }

    /**
     * <p>getLastUrl</p>
     * @Description:   获取url列表顶部的url(最后访问的地址)
     * @return     最顶部的url
     */
    private String getLastUrl() {
        if (null == mUrlList || mUrlList.size() == 0)
            return null;
        int size = mUrlList.size();
        return mUrlList.get(size - 1);
    }

    /**
     * <p>getBackUrl</p>
     * @Description:   获取上一页的url
     * @return 上一页的url，如果只有一个页面，则返回当前页面的url
     */
    private String getBackUrl() {
        if (mUrlList == null)
            return null;
        int size = mUrlList.size();
        if (size == 0)
            return null;
        else if (size == 1)
            return mUrlList.get(0);
        else
            return mUrlList.get(size - 2);
    }

    /** (非 Javadoc)
     * <p>Title: canGoBack</p>
     * <p>Description: 判断是否可以回退
     *                 1.如果自定义url列表只有一个对象的时候，则表示不能回退了
     *                 2.其他情况，调用WebView的super方法进行判定
     * </p>
     * @return
     * @see android.webkit.WebView#canGoBack()
     */
    @Override
    public boolean canGoBack() {
        if (mUrlList != null && mUrlList.size() == 1)
            return false;
        return super.canGoBack();
    }

    /**
     * <p>isErrorPage</p>
     * @Description:   判断当前展示的是否是错误页面
     * @return
     */
    public boolean isErrorPage() {
        if (mTvError != null && mTvError.getVisibility() == VISIBLE)
            return true;
        else
            return false;
    }

    /**
     * 将dp转换为px
     *
     * @param dpVal 单位为dp的值
     * @return      dp对应的px值
     */
    private int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, getResources().getDisplayMetrics());
    }

    /**
     * 将sp转换为px
     *
     * @param spVal sp的值
     * @return 像素
     */
    private int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, getResources().getDisplayMetrics());
    }

    /**
     * <p>setBarReachColor</p>
     * @Description:   设置进度条进度的颜色
     * @param color    色值
     */
    public void setBarReachColor(int color) {
        mBarReachColor = color;
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(mBarReachColor), Gravity.LEFT, ClipDrawable.HORIZONTAL);
        mProgressBar.setProgressDrawable(clipDrawable);
    }

    /**
     * <p>setErrorText</p>
     * @Description:   设置错误页面提醒文字
     * @param text     文字
     */
    public void setErrorText(String text){
        mTvError.setText(text);
    }
    /**
     * <p>setErrorTextColor</p>
     * @Description:   设置错误文字的颜色
     * @param color    颜色色值
     */
    public void setErrorTextColor(int color){
        mTvError.setTextColor(color);
    }
    /**
     * <p>setErrorTextSize</p>
     * @Description:   设置错误文字的字体
     * @param size     错误提醒文字的字体大小(sp)
     */
    public void setErrorTextSize(int size){
        mTvError.setTextSize(sp2px(size));
    }
}

