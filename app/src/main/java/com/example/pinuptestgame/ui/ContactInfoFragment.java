package com.example.pinuptestgame.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pinuptestgame.R;
import com.example.pinuptestgame.databinding.FragmentContactInfoBinding;
import com.example.pinuptestgame.db.entity.PersonEntity;
import com.example.pinuptestgame.model.ContactInfoViewModel;

public class ContactInfoFragment extends Fragment {
    private static ContactInfoFragment instance;
    private FragmentContactInfoBinding binding;
    private ContactInfoViewModel viewModel;

    private EditText nameEt;
    private EditText phoneEt;
    private EditText emailEt;
    private Button startBtn;

    public static ContactInfoFragment getInstance() {
        if (instance == null) {
            synchronized (ContactInfoFragment.class) {
                if (instance == null) {
                    instance = new ContactInfoFragment();
                }
            }
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return (binding = FragmentContactInfoBinding.inflate(inflater, container, false))
                .getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initWidgets(view);
        initViewModel();
    }

    private void initWidgets(View view) {
        nameEt = binding.nameEt;
        phoneEt = binding.phoneEt;
        emailEt = binding.emailEt;
        startBtn = binding.startBtn;
        startBtn.setOnClickListener(v -> {
            viewModel.savePersonToDb(getPerson());
            Navigation.findNavController(view)
                    .navigate(R.id.action_contactInfoFragment_to_webViewFragment);
        });
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(ContactInfoViewModel.class);
//        viewModel.getPerson().observe(getViewLifecycleOwner(), entity -> {
//            nameEt.setText(entity.getName());
//            phoneEt.setText(entity.getNumber());
//            emailEt.setText(entity.getEmail());
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        viewModel.setPerson(getPerson());
    }

    private PersonEntity getPerson() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(nameEt.getText().toString());
        personEntity.setNumber(phoneEt.getText().toString());
        personEntity.setEmail(emailEt.getText().toString());
        return personEntity;
    }
}
