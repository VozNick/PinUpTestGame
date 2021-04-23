package com.example.pinuptestgame.ui;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.pinuptestgame.databinding.FragmentWebViewBinding;

public class WebViewFragment extends Fragment {
    private static WebViewFragment instance;
    private FragmentWebViewBinding binding;
    private WebView webView;

    public static WebViewFragment getInstance() {
        if (instance == null) {
            synchronized (WebViewFragment.class) {
                if (instance == null) {
                    instance = new WebViewFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return (binding = FragmentWebViewBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initWebView();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void initWebView() {
        webView = binding.webView;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.youtube.com/watch?v=CxwJrzEdw1U&ab_channel=ScenicRelaxation");
        webView.setWebViewClient(initWebViewClient());
    }

    private WebViewClient initWebViewClient() {
        return new WebViewClient() {
            @SuppressWarnings("deprications")
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        };
    }
}
