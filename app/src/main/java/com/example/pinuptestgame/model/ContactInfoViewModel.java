package com.example.pinuptestgame.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateHandle;

import com.example.pinuptestgame.App;
import com.example.pinuptestgame.data.ContactInfoRepository;
import com.example.pinuptestgame.db.entity.PersonEntity;

public class ContactInfoViewModel extends AndroidViewModel {
//    private static final String PERSON_KEY = "person_key";
//    private final SavedStateHandle stateHandle;
    private final ContactInfoRepository repository;

    public ContactInfoViewModel(@NonNull Application application,
                                @NonNull SavedStateHandle stateHandle) {
        super(application);
//        this.stateHandle = stateHandle;
        repository = ((App) application).getRepository();
    }

//    public void setPerson(PersonEntity entity) {
//        stateHandle.set(PERSON_KEY, entity);
//    }
//
//    public LiveData<PersonEntity> getPerson() {
//        return stateHandle.getLiveData(PERSON_KEY);
//    }

    public void savePersonToDb(PersonEntity entity) {
        repository.insertPerson(entity);
    }
}
