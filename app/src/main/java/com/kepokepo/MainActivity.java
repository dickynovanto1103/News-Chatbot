package com.kepokepo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.kepokepo.adapter.ChatAdapter;
import com.kepokepo.bot.ChatBot;
import com.kepokepo.model.ChatData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View
        .OnClickListener {
    private static final String TAG = "MainActivityTAG";
    List<Integer> listViewType;
    List<ChatData> listChatData;
    ChatAdapter chatAdapter;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", new
            Locale("en", "US"));
    private RecyclerView mainRecyclerView;
    private EditText chatMessageEditText;
    private FloatingActionButton sendMessageFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_main);
        chatMessageEditText = (EditText) findViewById(R.id
                .edit_text_chat_message);
        sendMessageFab = (FloatingActionButton) findViewById(R.id
                .fab_send_message);

        setupChat();

        sendMessageFab.setOnClickListener(this);
    }

    private void setupChat() {
        listViewType = new ArrayList<>();
        listViewType.add(ChatAdapter.LEFT_VIEW_TYPE);

        listChatData = new ArrayList<>();
        ChatData chatData = new ChatData();

        chatData.setMessage("Hi, aku <b>KepoKepo</b>! Mau <font " +
                "size='6'>baca</font> berita apa nih?<br><br>Butuh " +
                "bantuan? Ketik aja <b>'tolong'</b> atau <b>'help'</b>");
        chatData.setTime(simpleDateFormat.format(new Date()));
        listChatData.add(chatData);

        chatAdapter = new ChatAdapter(listViewType, listChatData);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager
                (this);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerView.setAdapter(chatAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == sendMessageFab) {
            String message = chatMessageEditText.getText().toString();
            if (!TextUtils.isEmpty(message)) {
                // user chat
                chatMessageEditText.setText("");
                listViewType.add(ChatAdapter.RIGHT_VIEW_TYPE);
                ChatData chatData = new ChatData();
                chatData.setMessage(message);
                chatData.setTime(simpleDateFormat.format(new Date()));
                listChatData.add(chatData);

                //  bot response
                String response = ChatBot.getResponse(message);
                listViewType.add(ChatAdapter.LEFT_VIEW_TYPE);
                ChatData chatDataBot = new ChatData();
                chatDataBot.setMessage(response);
                chatDataBot.setTime(simpleDateFormat.format(new Date()));
                listChatData.add(chatDataBot);
                chatAdapter.notifyDataSetChanged();

                // scroll chat to bottom
                mainRecyclerView.scrollBy(0, Integer.MAX_VALUE);
            }
        }
    }
}
