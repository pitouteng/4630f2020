package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class ResumeActivity extends AppCompatActivity {
    PDFView mPDFView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        mPDFView = (PDFView) findViewById(R.id.pdfView);
        mPDFView.fromAsset("resume.pdf").load();

//        String doc="<iframe src='http://docs.google.com/viewer?url=http://www.iasted.org/conferences/formatting/presentations-tips.ppt&embedded=true' width='100%' height='100%' style='border: none;'></iframe>";
//        WebView wv = (WebView)findViewById(R.id.webView);
//        wv.getSettings().setJavaScriptEnabled(true);
//        wv.getSettings().setPluginsEnabled(true);
//        wv.getSettings().setAllowFileAccess(true);
//        wv.loadUrl(doc);
        //wv.loadData( doc, "text/html",  "UTF-8");
    }
}