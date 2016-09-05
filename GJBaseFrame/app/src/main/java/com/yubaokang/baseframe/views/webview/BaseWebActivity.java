package com.yubaokang.baseframe.views.webview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.yubaokang.baseframe.R;
import com.yubaokang.baseframe.base.views.BaseActivity;
import com.hank.refresh.load.more.utils.IntentUtils;
import com.hank.refresh.load.more.utils.NetworkStateUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 最简单的webview界面，顶部包括：返回按钮，标题，分享按钮
 * 分享按钮显示逻辑：if (isShareJs() || isShare)
 */
public class BaseWebActivity extends BaseActivity {
    @BindView(R.id.toolBar)
    Toolbar toolBar;
    @BindView(R.id.webView)
    WebView webView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private List<String> titles;//webView获取的标题列表

    public final static String URL = "URL";
    String url;//="http://rshop.goujiawang.com/shopView/index?shopId=81"

    @Override
    public int getLayoutId() {
        return R.layout.activity_base_web;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        setSupportActionBar(toolBar);
        url = getIntent().getStringExtra(URL);
        initWebView();
    }

    @Override
    public void providers() {
    }

    @Override
    public void apiCancel() {
    }

    @Override
    public View getCurrentLayout() {
        return null;
    }

    @SuppressLint("SetJavaScriptEnabled")
    protected void initWebView() {
        titles = new ArrayList<>();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDatabaseEnabled(true);
        //启用地理定位
        webSettings.setGeolocationEnabled(true);
        String dir = "/sdcard/temp";//设置定位的数据库路径
        webSettings.setGeolocationDatabasePath(dir);
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setGeolocationDatabasePath(getFilesDir().getPath());
        if (NetworkStateUtils.getInstance(this).isConnection()) {
            webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        } else {
            webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        }
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                titles.add(title);
                toolBar.setTitle(title);
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith(WebView.SCHEME_MAILTO) || url.startsWith(WebView.SCHEME_GEO) || url.startsWith(WebView.SCHEME_TEL)) {
                    if (url.startsWith(WebView.SCHEME_TEL)) {
                        url = url.replaceAll(WebView.SCHEME_TEL, "");
                        url = url.replaceAll("//", "");
                    }
                    IntentUtils.IntentCall(BaseWebActivity.this, url);
                } else {
                    webView.loadUrl(url);
                }
                return true;
            }
        });
        webView.loadUrl(url);
    }
}

