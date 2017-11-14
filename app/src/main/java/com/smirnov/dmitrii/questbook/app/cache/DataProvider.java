package com.smirnov.dmitrii.questbook.app.cache;

import android.support.annotation.NonNull;

import com.smirnov.dmitrii.questbook.app.cache.repository.DataRepository;
import com.smirnov.dmitrii.questbook.app.cache.repository.DataRepositoryImpl;

/**
 * Created by Дмитрий on 13.11.2017.
 */

public class DataProvider {

    private static DataRepository sDataRepository;

    @NonNull
    public static DataRepository provide() {
        DataRepository repository = sDataRepository;
        if (repository == null) {
            synchronized (DataProvider.class) {
                repository = sDataRepository;
                if (repository == null) {
                    repository = sDataRepository = new DataRepositoryImpl();
                }
            }
        }
        return repository;
    }
}
