package com.github.satoshun.example.retain;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.satoshun.example.retain.databinding.MainActBinding;

public class MainActivity extends AppCompatActivity {

    private MainActBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_act);
    }
}
