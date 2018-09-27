package com.Kashsoft.h.kitychat.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.Kashsoft.h.kitychat.R;
import com.Kashsoft.h.kitychat.ui.fragments.ChatFragment;
import com.Kashsoft.h.kitychat.utils.Constants;

/**
 * Created by DEVELOPMENT on 4/16/2018.
 */

public class ChatActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    public static void startActivity(Context context
            , String reciever, String recieverUid, String firebaseToken) {
        Intent intent = new Intent(context, ChatActivity.class);
        intent.putExtra(Constants.ARG_RECEIVER, reciever);
        intent.putExtra(Constants.ARG_RECEIVER_UID, recieverUid);
        intent.putExtra(Constants.ARG_FIREBASE_TOKEN, firebaseToken);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        bindViews();
        init();


    }

    private void bindViews() {
        mToolbar = findViewById(R.id.toolbar);
    }


    private void init() {
        //check this one later
        setSupportActionBar(mToolbar);
        mToolbar.setTitle(getIntent().getExtras().
                getString(Constants.ARG_RECEIVER));

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_content_chat,
                ChatFragment.newInstance(getIntent().getExtras().getString(Constants.ARG_RECEIVER),
                        getIntent().getExtras().getString(Constants.ARG_RECEIVER_UID),
                        getIntent().getExtras().getString(Constants.ARG_FIREBASE_TOKEN)),
                ChatFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
