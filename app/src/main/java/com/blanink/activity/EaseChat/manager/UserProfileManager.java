package com.blanink.activity.EaseChat.manager;

import android.content.Context;
import android.util.Log;

import com.blanink.activity.EaseChat.manager.PreferenceManager;
import com.blanink.activity.EaseChat.modle.DemoHelper;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;

import java.util.ArrayList;
import java.util.List;

public class UserProfileManager {

    /**
     * application context
     */
    protected Context appContext = null;

    /**
     * init flag: test if the sdk has been inited before, we don't need to init
     * again
     */
    private boolean sdkInited = false;

    /**
     * HuanXin sync contact nick and avatar listener
     */
    //private List<DataSyncListener> syncContactInfosListeners;

    private boolean isSyncingContactInfosWithServer = false;

    private EaseUser currentUser;
    private List<DemoHelper.DataSyncListener> syncContactInfosListeners;

    public UserProfileManager() {
    }

    public synchronized boolean init(Context context) {
        if (sdkInited) {
            return true;
        }
        //ParseManager.getInstance().onInit(context);
        syncContactInfosListeners = new ArrayList<DemoHelper.DataSyncListener>();
        sdkInited = true;
        return true;
    }

    public void addSyncContactInfoListener(DemoHelper.DataSyncListener listener) {
        if (listener == null) {
            return;
        }
        if (!syncContactInfosListeners.contains(listener)) {
            syncContactInfosListeners.add(listener);
        }
    }

    public void removeSyncContactInfoListener(DemoHelper.DataSyncListener listener) {
        if (listener == null) {
            return;
        }
        if (syncContactInfosListeners.contains(listener)) {
            syncContactInfosListeners.remove(listener);
        }
    }


    public void notifyContactInfosSyncListener(boolean success) {
        for (DemoHelper.DataSyncListener listener : syncContactInfosListeners) {
            listener.onSyncComplete(success);
        }
    }

    public boolean isSyncingContactInfoWithServer() {
        return isSyncingContactInfosWithServer;
    }

    public synchronized void reset() {
        isSyncingContactInfosWithServer = false;
        currentUser = null;
        PreferenceManager.getInstance().removeCurrentUserInfo();
    }

    public synchronized EaseUser getCurrentUserInfo() {
        if (currentUser == null) {
            String username = EMClient.getInstance().getCurrentUser();
            currentUser = new EaseUser(username);
            String nick = getCurrentUserNick();
            Log.e("UserProfile","nick="+nick);
            currentUser.setNick((nick != null) ? nick : username);
            currentUser.setAvatar(getCurrentUserAvatar());
        }
        return currentUser;
    }

    public void updateCurrentUserNickNameAndAvater(final String nickname, String avatar) {
        Log.e("@@@",nickname+"____"+avatar);
        if (nickname != null && !"".equals(nickname)) {
            setCurrentUserNick(nickname);
        }
        if (avatar != null && !"".equals(avatar))
            setCurrentUserAvatar(avatar);
    }

    public String uploadUserAvatar(String avatarUrl) {
        if (avatarUrl != null) {
            setCurrentUserAvatar(avatarUrl);
        }
        return avatarUrl;
    }


    public void setCurrentUserNick(String nickname) {
        getCurrentUserInfo().setNick(nickname);
        PreferenceManager.getInstance().setCurrentUserNick(nickname);
    }

    public void setCurrentUserAvatar(String avatar) {
        getCurrentUserInfo().setAvatar(avatar);
        PreferenceManager.getInstance().setCurrentUserAvatar(avatar);
    }

    public String getCurrentUserNick() {
        return PreferenceManager.getInstance().getCurrentUserNick();
    }

    public String getCurrentUserAvatar() {
        return PreferenceManager.getInstance().getCurrentUserAvatar();
    }

}
