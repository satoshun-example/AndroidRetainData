package com.github.satoshun.example.retain;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.github.satoshun.example.retain.databinding.MainActBinding;
import com.github.satoshun.example.retain.databinding.MainItemBinding;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements RetainFragment.DataCallback {

    private MainActBinding binding;
    private RepoAdapter repoAdapter;
    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_act);

        Fragment dataFrag = getSupportFragmentManager().findFragmentByTag("data");
        if (dataFrag == null) {
            dataFrag = RetainFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(dataFrag, "data")
                    .commit();
        }
        repoAdapter = new RepoAdapter(LayoutInflater.from(this), new ArrayList<>());
        binding.content.setAdapter(repoAdapter);
        binding.content.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onDataSource(Observable<List<Repo>> source) {
        disposables.add(source.subscribe(
                data -> repoAdapter.addRepos(data),
                e -> Log.e("onDataSource", e.getMessage())));
    }

    @Override
    protected void onDestroy() {
        disposables.dispose();
        super.onDestroy();
    }

    private static class RepoAdapter extends RecyclerView.Adapter {

        private static class ViewHolder extends RecyclerView.ViewHolder {

            private final MainItemBinding binding;

            public ViewHolder(MainItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

        private final LayoutInflater inflater;
        private final List<Repo> repos;

        public RepoAdapter(LayoutInflater inflater, List<Repo> repos) {
            this.inflater = inflater;
            this.repos = repos;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MainItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.main_item, parent, false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Repo repo = repos.get(position);
            ((ViewHolder) holder).binding.setRepo(repo);
        }

        @Override
        public int getItemCount() {
            return repos.size();
        }

        void addRepos(List<Repo> repos) {
            this.repos.addAll(repos);
            notifyDataSetChanged();
        }
    }
}
