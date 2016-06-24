package com.example.hp.couple;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 1/13/2016.
 */
public class ChatActivity extends Activity {
    private static final String TAG = ChatActivity.class.getName();
    public static final String USER_ID_KEY = "userId";
    private static String sUserId;
    private EditText etMessage;
    private Button btSend;

    private android.os.Handler handler = new android.os.Handler();

    private ListView lvChat;
    private ArrayList<Message> mMessages;
    private ChatListAdapter mAdapter;
    private boolean mFirstLoad;
    private static final int MAX_CHAT_MESSAGES_TO_SHOW = 50;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        if (ParseUser.getCurrentUser() != null) {
            startWithCurrentUser();

        } else {

            login();

        }
        handler.postDelayed(runnable, 1000);

    }

    private Runnable runnable = new Runnable() {

        @Override
        public void run() {
            refreshMessages();
            Log.d("Handlers", "Called on main thread");
            handler.postDelayed(this, 1000);
        }

    };

    private void refreshMessages() {

        receiveMessage();

    }

    private void startWithCurrentUser() {

        sUserId = ParseUser.getCurrentUser().getObjectId();
        setupMessagePosting();

    }

    private void setupMessagePosting() {
        etMessage = (EditText) findViewById(R.id.etMessage);
        btSend = (Button) findViewById(R.id.btSend);
        lvChat = (ListView) findViewById(R.id.lvChat);
        mMessages = new ArrayList<Message>();
        lvChat.setTranscriptMode(1);
        mFirstLoad = true;
        mAdapter = new ChatListAdapter(ChatActivity.this, sUserId, mMessages);
        lvChat.setAdapter(mAdapter);
        btSend.setOnClickListener(new View.OnClickListener() {


            @Override

            public void onClick(View v) {

                String body = etMessage.getText().toString();
                Message message = new Message();
                message.setUserId(sUserId);
                message.setBody(body);

                message.saveInBackground(new SaveCallback() {

                    @Override
                    public void done(com.parse.ParseException e) {
                        receiveMessage();
                    }
                });


                etMessage.setText("");
            }


        });
    }

    private void receiveMessage() {
        ParseQuery<Message> query = ParseQuery.getQuery(Message.class);
        query.setLimit(MAX_CHAT_MESSAGES_TO_SHOW);
        query.orderByAscending("createdAt");
        query.findInBackground(new FindCallback<Message>() {


            @Override
            public void done(List<Message> messages, com.parse.ParseException e) {
                if (e == null) {
                    mMessages.clear();
                    mMessages.addAll(messages);
                    mAdapter.notifyDataSetChanged();
                    if (mFirstLoad) {
                        lvChat.setSelection(mAdapter.getCount() - 1);
                        mFirstLoad = false;
                    }
                } else {
                    Log.d("message", "Error: " + e.getMessage());
                }
            }
        });

    }

    private void login() {

        ParseAnonymousUtils.logIn(new LogInCallback() {
            @Override
            public void done(ParseUser parseUser, com.parse.ParseException e) {
                if (e != null) {

                    Log.d(TAG, "Anonymous login failed: " + e.toString());
                } else {

                    startWithCurrentUser();

                }
            }
        });

    }
}