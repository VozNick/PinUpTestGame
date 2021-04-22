package com.example.pinuptestgame.data;

import com.example.pinuptestgame.AppExecutors;
import com.example.pinuptestgame.db.dao.PersonModelDao;
import com.example.pinuptestgame.db.entity.PersonEntity;

public class ContactInfoRepository {
    private static ContactInfoRepository instance;
    private final PersonModelDao personModelDao;
    private final AppExecutors executors;

    public static ContactInfoRepository getInstance(PersonModelDao personModelDao, AppExecutors executors) {
        if (instance == null) {
            synchronized (ContactInfoRepository.class) {
                if (instance == null) {
                    instance = new ContactInfoRepository(personModelDao, executors);
                }
            }
        }
        return instance;
    }

    private ContactInfoRepository(final PersonModelDao personModelDao, AppExecutors executors) {
        this.personModelDao = personModelDao;
        this.executors = executors;
    }

    public void insertPerson(PersonEntity entity) {
        executors.diskIO().execute(() -> personModelDao.insert(entity));
    }
}

