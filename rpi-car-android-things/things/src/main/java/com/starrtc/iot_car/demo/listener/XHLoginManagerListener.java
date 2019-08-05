package com.starrtc.iot_car.demo.listener;

import com.starrtc.iot_car.utils.AEvent;
import com.starrtc.starrtcsdk.api.XHConstants;
import com.starrtc.starrtcsdk.apiInterface.IXHLoginManagerListener;

public class XHLoginManagerListener implements IXHLoginManagerListener {

    @Override
    public void onConnectionStateChanged(XHConstants.XHSDKConnectionState state) {
        if(state == XHConstants.XHSDKConnectionState.IFSDKConnectionStateDisconnect){
            AEvent.notifyListener(AEvent.AEVENT_USER_OFFLINE,true,"");
        }else if(state == XHConstants.XHSDKConnectionState.IFSDKConnectionStateReconnect){
            AEvent.notifyListener(AEvent.AEVENT_USER_ONLINE,true,"");
        }
    }

    @Override
    public void onKickedByOtherDeviceLogin() {
        AEvent.notifyListener(AEvent.AEVENT_USER_KICKED,true,"");
    }

    @Override
    public void onLogout() {

    }
}
