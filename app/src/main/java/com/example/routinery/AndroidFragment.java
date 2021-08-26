package com.example.routinery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AndroidFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AndroidFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Object Context;

    public AndroidFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AndroidFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AndroidFragment newInstance(String param1, String param2) {
        AndroidFragment fragment = new AndroidFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_android, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      //  TextView tv = (TextView) view.findViewById(R.id.tvCatchName);
      //  TextView tv1 = (TextView) view.findViewById(R.id.tvCatchName);
     //   Intent intent = getActivity().getIntent();
     //   String message = intent.getStringExtra("name");
        /***** Intent intent = getIntent();
         String name1 = intent.getStringExtra("edit1");
         String name2 = intent.getStringExtra("edit2");
         String name3 = intent.getStringExtra("edit3");
         editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName3);
         editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName2);
         editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName4);
         editTextTextPersonName5.setText(name1);
         editTextTextPersonName6.setText(name2);
         editTextTextPersonName7.setText(name3);
         *********/
     //   tv.setText(message);
    }
}