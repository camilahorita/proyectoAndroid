package com.camilaoliveira.proyecto00.ui.recetas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecetasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public RecetasViewModel() {

        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}