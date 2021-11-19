package com.capstonedesign.coring

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.webkit.*
import androidx.navigation.fragment.findNavController
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_qrweb_view.*

class QRWebView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_qrweb_view)

        val QRPage : WebView = findViewById(R.id.webview)       //웹뷰 QRPage 생성
        val NaverQR = "https://nid.naver.com/login/privacyQR"   //NAVER_QR_URL

        QRPage.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true   //자바스크립트 사용
            webViewClient = object: WebViewClient() {
                override fun onPageFinished(view: WebView, url: String) {
                    view.loadUrl("javascript:(function() { " +                                  //자바스크립트
                            "document.getElementById('qr_area').style.display='block';" +           //QR Page
                            "document.getElementById('v3box').style.display='none';" +              //QR화면 간단화
                            "document.getElementById('v3btn').style.display='none';" +
                            "document.getElementById('cancel').style.display='none';" +
                            "document.getElementsByClassName('banner_box')[0].innerHTML = ' ';" +
                            "document.getElementsByClassName('u_cr')[0].innerHTML = ' ';" +
                            "})()")
                }
            }
        }

        QRPage.loadUrl(NaverQR) //웹뷰 호출
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                //toolbar의 back키 눌렀을 때 동작
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}