package com.starrtc.iot_car.demo.listener;

import com.starrtc.iot_car.demo.MLOC;
import com.starrtc.iot_car.utils.AEvent;
import com.starrtc.starrtcsdk.apiInterface.IXHChatManagerListener;
import com.starrtc.starrtcsdk.core.im.message.XHIMMessage;

public class XHChatManagerListener implements IXHChatManagerListener {
    @Override
    public void onReceivedMessage(XHIMMessage message) {
        AEvent.notifyListener(AEvent.AEVENT_C2C_REV_MSG,true,message);
        MLOC.saveC2CUserId(MLOC.appContext,message.fromId);
    }
}
