package com.sobey.anative;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tenma.ventures.event.TMCallBackMessageEvent;
import com.tenma.ventures.event.TMSendMessageEvent;
import com.tenma.ventures.push.IPushReceiverObserver;
import com.tenma.ventures.push.TMPushReceiver;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;

/**
 * Native
 * Created by bin on 2017/12/15.
 */

public class NativeFragment extends Fragment implements IPushReceiverObserver {

    private static String TAG = "NativeFragment";

    private EditText titleEt;
    private EditText contentEt;
    private Button saveBtn;

    private String action;

    public static Fragment newInstance(Bundle bundle) {
        Fragment fragment = new NativeFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
        TMPushReceiver.registerPushObserver(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_native, container);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();

        titleEt = view.findViewById(R.id.title_et);
        contentEt = view.findViewById(R.id.content_et);
        saveBtn = view.findViewById(R.id.save_btn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEt.getText().toString();
                String content = contentEt.getText().toString();
                TMCallBackMessageEvent tmCallBackMessageEvent = new TMCallBackMessageEvent();
                tmCallBackMessageEvent.action = action;
                tmCallBackMessageEvent.message = "{\"title\":\"" + title + "\",\"content\":\"" + content + "\"}";
                EventBus.getDefault().post(tmCallBackMessageEvent);
            }
        });


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void createDocument(TMSendMessageEvent tmSendMessageEvent) {
        if ("com.tm.native.createDocument".equals(tmSendMessageEvent.action)) {
            this.action = tmSendMessageEvent.action;
            String message = tmSendMessageEvent.message;
            try {
                JSONObject jsonObject = new JSONObject(message);
                titleEt.setText(jsonObject.getString("title"));
                contentEt.setText(jsonObject.getString("content"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        TMPushReceiver.unRegisterPushObserver(this);
    }

    @Override
    public void receivePushMessage(Bundle pushBundle) {
        Toast.makeText(getActivity(), "用户点击了推送消息：" + pushBundle.get(JPushInterface.EXTRA_ALERT), Toast.LENGTH_LONG).show();
    }
}
