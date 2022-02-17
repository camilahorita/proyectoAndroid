package com.camilaoliveira.proyecto00.ui.dieta;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.camilaoliveira.proyecto00.databinding.FragmentDietaBinding;

public class DietaFragment extends Fragment {

    private DietaViewModel dietaViewModel;
    private FragmentDietaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dietaViewModel =
                new ViewModelProvider(this).get(DietaViewModel.class);

        binding = FragmentDietaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}