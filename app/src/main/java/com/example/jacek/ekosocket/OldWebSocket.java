package com.example.jacek.ekosocket;

import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;
import okio.ByteString;

/**
 * Created by jacek on 6/2/2018 AD.
 */

public class OldWebSocket {

    protected OkHttpClient client;
    private EkoSocketListener listener;
    private WebSocket webSocket;
    private Request request;

    public OldWebSocket(OkHttpClient client) { //wss://eko-s1.dev.ekoapp.com:443 ws://s1.eko03.local:80
        this.client = client;
        this.request = new Request.Builder().url("wss://echo.websocket.org").build();
        this.listener = new EkoSocketListener();
    }

    public void connect() {
        disconnect();
        WebSocketCall.create(client, request).enqueue(listener);
    }

    public void disconnect() {
        try {
            if (webSocket != null) {
                webSocket.close(1000, "Socket will be closed");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private class EkoSocketListener implements WebSocketListener {

        @Override
        public void onOpen(WebSocket webSocket, Response response) {
            OldWebSocket.this.webSocket = webSocket;
            Log.e("Socket", "onOpen " + request.url().toString());
            try {
                webSocket.sendPing(new Buffer().write(ByteString.encodeUtf8("Ping1")));
                webSocket.sendMessage(RequestBody.create(WebSocket.TEXT, "Test Message 1"));
                webSocket.sendPing(new Buffer().write(ByteString.encodeUtf8("Ping2")));
                webSocket.sendMessage(RequestBody.create(WebSocket.TEXT, "Test Message 2"));
                webSocket.sendPing(new Buffer().write(ByteString.encodeUtf8("Ping3")));
                webSocket.sendMessage(RequestBody.create(WebSocket.TEXT, "Test Message 3"));
                webSocket.sendPing(new Buffer().write(ByteString.encodeUtf8("Ping4")));
                webSocket.sendMessage(RequestBody.create(WebSocket.TEXT, "Test Message 4"));
                webSocket.sendPing(new Buffer().write(ByteString.encodeUtf8("Ping5")));
                webSocket.sendMessage(RequestBody.create(WebSocket.TEXT, "Test Message 5"));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(IOException e, Response response) {
            Log.e("Socket", "onFailure " + e.getMessage());
            try {
                webSocket.sendPing(new Buffer().write(ByteString.encodeUtf8("Ping6")));
                webSocket.sendMessage(RequestBody.create(WebSocket.TEXT, "Test Message 6"));
            } catch(IOException io) {
                io.printStackTrace();
            }
        }

        @Override
        public void onMessage(ResponseBody message) throws IOException {
            Log.e("Socket", "onMessage " + message.string());
        }

        @Override
        public void onPong(Buffer payload) {
            Log.e("Socket", "onPong " + payload.readUtf8());
        }

        @Override
        public void onClose(int code, String reason) {
            Log.e("Socket", "onClose: " + code + " / " + reason);
        }
    }
}
