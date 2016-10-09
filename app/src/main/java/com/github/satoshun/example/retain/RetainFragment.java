package com.github.satoshun.example.retain;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetainFragment extends Fragment {

    public static RetainFragment newInstance() {
        return new RetainFragment();
    }

    private CompositeDisposable disposables = new CompositeDisposable();
    private Subject<List<Repo>> subject = BehaviorSubject.create();

    public RetainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        refresh();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        disposables.dispose();
        super.onDestroy();
    }

    Observable<List<Repo>> observable() {
        return subject;
    }

    void refresh() {
        disposables.clear();
        disposables.add(provideGithubAPI()
                .getRepositories("satoshun")
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        data -> subject.onNext(data),
                        e -> subject.onError(e)));
    }

    // TODO: Use DI like a Dagger2.
    private static GithubAPI provideGithubAPI() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(AutoValueGsonTypeAdapterFactory.create())
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(GithubAPI.class);
    }
}
