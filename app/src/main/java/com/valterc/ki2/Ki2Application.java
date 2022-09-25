package com.valterc.ki2;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import timber.log.Timber;

public class Ki2Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.Tree() {
            @Override
            protected void log(int priority, @Nullable String tag, @NonNull String message, @Nullable Throwable t) {
                Log.println(priority, tag, message + (t == null ? "" : "\n" + t.getMessage() + "\n" + Log.getStackTraceString(t)));
            }
        });
    }
}
