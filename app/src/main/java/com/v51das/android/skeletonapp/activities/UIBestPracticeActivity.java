package com.v51das.android.skeletonapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.v51das.android.skeletonapp.R;
import com.v51das.android.skeletonapp.adapter.MsgAdapter;
import com.v51das.android.skeletonapp.model.Msg;

import java.util.ArrayList;
import java.util.List;

public class UIBestPracticeActivity extends BaseActivity {

    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecyclerView;
    private MsgAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uibestpractice);
        initMsg();
        inputText = findViewById(R.id.input_text);
        send = findViewById(R.id.send);
        msgRecyclerView = findViewById(R.id.msg_rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(llm);
        adapter = new MsgAdapter(msgList);
        msgRecyclerView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);
                    msgRecyclerView.scrollToPosition(msgList.size() - 1);
                    inputText.setText("");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello .Who is that?", Msg.TYPE_SENT);
        msgList.add(msg1);
        Msg msg3 = new Msg("This is Tom.Nice talking to you.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }
}