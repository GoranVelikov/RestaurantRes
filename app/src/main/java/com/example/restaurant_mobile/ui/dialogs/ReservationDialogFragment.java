package com.example.restaurant_mobile.ui.dialogs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.restaurant_mobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReservationDialogFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ReservationDialogFragment extends Fragment {
    private final static String ARG_TABLE="table_Id";


    public ReservationDialogFragment() {
        // Required empty public constructor
    }

    public static ReservationDialogFragment newInstance(String tableId) {
        ReservationDialogFragment fragment = new ReservationDialogFragment();

        Bundle args = new Bundle();
        args.putString(ARG_TABLE, tableId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String tableId = getArguments().getString(ARG_TABLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the table for this fragment
        return inflater.inflate(R.layout.fragment_reservation_dialog, container, false);
    }

    public void show(FragmentManager supportFragmentManager, String reservationDialog) {

    }
}