package com.mechtrong.apponlinechattingproject_63135901.FireBase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        //Test Token
        Log.d("FCM", "Token: " + token );
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        //Test Remote message
        Log.d("FCM", "Remote Message" + remoteMessage.getNotification().getBody());
    }
}
