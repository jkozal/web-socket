package com.example.jacek.ekosocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        client =
            new OkHttpClient.Builder()
//                .pingInterval(3000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
//                .addInterceptor(logging)
                .build();

//        EkoSocket socket = new EkoSocket(client);
//        socket.connect();

        OldWebSocket socket = new OldWebSocket(client);
        socket.connect();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("eko-s1.dev.ekoapp.com", 443);
//                    socket.startHandshake();
//                    SSLSession session = socket.getSession();
//                    Log.e("Socket", session.getProtocol());
//                    Log.e("Socket", session.getCipherSuite());
//                } catch(IOException e) {
//                    Log.e("Socket", e.getMessage());
//                }
//            }
//        }).start();
    }


}
