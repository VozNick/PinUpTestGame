package com.example.pinuptestgame;

import android.app.Application;

import com.example.pinuptestgame.data.ContactInfoRepository;
import com.example.pinuptestgame.db.AppDatabase;

public class App extends Application {
    private static App instance;
    private AppExecutors executors;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        executors = new AppExecutors();
    }

    public static App getInstance() {
        return instance;
    }

    public ContactInfoRepository getRepository() {
        return ContactInfoRepository.getInstance(getDatabase().personModelDao(), executors);
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }
}