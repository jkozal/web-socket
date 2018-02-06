package com.example.jacek.ekosocket;

import android.util.Log;

import java.net.URI;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import okhttp3.WebSocket;
//import okhttp3.WebSocketListener;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/**
 * Created by jacek on 25/1/2018 AD.
 */

//3.9.1 version
public class EkoSocket {

    protected OkHttpClient client;
//    private WebSocket ws;
    private Request request;

    public EkoSocket(OkHttpClient client) { //wss://eko-s1.dev.ekoapp.com:443 ws://s1.eko03.local:80
        this.client = client;
        this.request = new Request.Builder().url("wss://echo.websocket.org").build();
    }

//    public void connect() {
//        disconnect();
//        this.ws = client.newWebSocket(request, new EkoSocketListener());
//    }
//
//    public void disconnect() {
//        if(ws != null) {
//            ws.close(1000, "Socket will be closed");
//        }
//    }
//
//    private class EkoSocketListener extends WebSocketListener {
//
//        @Override
//        public void onOpen(WebSocket webSocket, Response response) {
//            Log.e("Socket", "onOpen " + request.url().toString());
//            ws.send("Test Message");
//            ws.send(ByteString.encodeUtf8("Byte test"));
//        }
//
//        @Override
//        public void onMessage(WebSocket webSocket, String payload) {
//            Log.e("Socket", "onMessage " + payload);
//        }
//
//        @Override
//        public void onMessage(WebSocket webSocket, ByteString bytes) {
//            Log.e("Socket", "onMessageBytes " + bytes.toString());
//            ws.close(1000, "Bye!");
//        }
//
//        @Override
//        public void onClosing(WebSocket webSocket, int code, String reason) {
//            Log.e("Socket", "onClosing " + code + " / " + reason);
//        }
//
//        @Override
//        public void onClosed(WebSocket webSocket, int code, String reason) {
//            Log.e("Socket", "onClosed " + code + " / " + reason);
//        }
//
//        @Override
//        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
//            Log.e("Socket", "onFailure " + t.getMessage());
//        }
//    }
}
