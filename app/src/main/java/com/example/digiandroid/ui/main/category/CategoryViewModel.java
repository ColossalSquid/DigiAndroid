package com.example.digiandroid.ui.main.category;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.digiandroid.api.ApiConfig;
import com.example.digiandroid.api.IService;
import com.example.digiandroid.models.BaseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryViewModel extends AndroidViewModel {


    MutableLiveData<BaseModel> baseModelData;
    Throwable error;
    public CategoryViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<BaseModel> getCategories() {
        if(baseModelData == null){
            baseModelData = new MutableLiveData<>();
            //call webservice
            getBaseModel();
        }
        return baseModelData;
    }


    //webservice call
    public void getBaseModel() {
        IService iService = ApiConfig.INSTANCE.getRetrofit().create(IService.class);
        iService.getCategories().enqueue(new Callback<BaseModel>() {
            @Override
            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
                baseModelData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<BaseModel> call, Throwable t) {
                Log.e("error", t.getLocalizedMessage());
                Log.e("error", t.getMessage());
                t.printStackTrace();
                baseModelData.setValue(null);
            }
        });
    }
}
