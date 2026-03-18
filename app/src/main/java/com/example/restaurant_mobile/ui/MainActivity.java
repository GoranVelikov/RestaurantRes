package com.example.restaurant_mobile.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurant_mobile.R;
import com.example.restaurant_mobile.logic.TimeController;
import com.example.restaurant_mobile.model.ReservationRequest;
import com.example.restaurant_mobile.repository.ReservationRepository;
import com.example.restaurant_mobile.ui.dialogs.ReservationDialogFragment;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ReservationDialogFragment.ReservationListener{

    private Button time_back,time_forward;
    private TextView time_lable,date_lable;
    private EditText datePicker;
    private ScrollView scrollView;
    private final Calendar calendar = Calendar.getInstance();
    TimeController timeController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        time_back =findViewById(R.id.button);
        time_forward=findViewById(R.id.button3);
        time_lable=findViewById(R.id.tImeLable);
        date_lable=findViewById(R.id.dateLable);
        datePicker=findViewById(R.id.editTextDate);
        scrollView=findViewById(R.id.scrollView4);

        updateDateLabel();
        datePicker.setOnClickListener(view -> showDatePicker());


        timeController = new TimeController(
                getString(R.string.StartTime),
                getString(R.string.EndTime)
        );

        time_back.setOnClickListener(v -> onTimeChange(-90));
        time_forward.setOnClickListener(v -> onTimeChange(90));

        findViewById(R.id.viewT1).setOnClickListener(this::onTableClick);
        findViewById(R.id.viewT2).setOnClickListener(this::onTableClick);
        findViewById(R.id.viewT3).setOnClickListener(this::onTableClick);
        findViewById(R.id.viewT4).setOnClickListener(this::onTableClick);
        findViewById(R.id.viewT5).setOnClickListener(this::onTableClick);
        findViewById(R.id.viewT6).setOnClickListener(this::onTableClick);

    }

    private void onTimeChange(int i) {

        String currentTimeText = time_lable.getText().toString();
        String startTimeStr=getString(R.string.StartTime);
        String endTimeStr=getString(R.string.EndTime);

        try{
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime currentTime = LocalTime.parse(currentTimeText, formatter);
        LocalTime startTime = LocalTime.parse(startTimeStr, formatter);
        LocalTime endTime = LocalTime.parse(endTimeStr, formatter);
        LocalTime newTime = currentTime.plusMinutes(i);

        if (!newTime.isBefore(startTime) && !newTime.isAfter(endTime)){
            time_lable.setText(newTime.format(formatter));
        }else {
            Toast.makeText(this, "Time must be between " + startTimeStr + " and " + endTimeStr, Toast.LENGTH_SHORT).show();
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDateLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        datePicker.setText(sdf.format(calendar.getTime()));
    }

    private void showDatePicker() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    calendar.set(Calendar.YEAR, selectedYear);
                    calendar.set(Calendar.MONTH, selectedMonth);
                    calendar.set(Calendar.DAY_OF_MONTH, selectedDay);
                    updateDateLabel();
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    public void onTableClick(View view) {
        int tableId     = view.getId();

        String tableName = (String) view.getTag();

        ReservationDialogFragment dialog= ReservationDialogFragment.newInstance(String.valueOf(tableId));
        dialog.show(getSupportFragmentManager(),"reservationDialog");
    }

    private void showReservationDialog(String tableName) {
    }

    @Override
    public void onReservationConfirmed(ReservationRequest request) {
        ReservationRepository repository=new ReservationRepository();
        repository.makeReservation(request);
    }
}