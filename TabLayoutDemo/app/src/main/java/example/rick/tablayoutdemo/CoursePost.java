package example.rick.tablayoutdemo;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class CoursePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursepost);

        // ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.CPTB);
        setSupportActionBar(toolbar);
        toolbar.setTitle("發起課程");
        toolbar.setTitleTextColor(0xFFFFFFFF);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // TimePickerDialog
        final EditText timeEditStart = (EditText) findViewById(R.id.timeEditStart);
        final EditText timeEditEnd = (EditText) findViewById(R.id.timeEditEnd);
        final Calendar calendar = Calendar.getInstance();

        final TimePickerDialog timeStart = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker arg0, int hour, int minute) {
                timeEditStart.setText((hour>12?hour-12:hour)+":"+(minute<10?"0":"")+minute+(hour>12?" AM":" PM"));

            }},calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);

        timeEditStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeStart.show();
            }
        });

        final TimePickerDialog timeEnd = new TimePickerDialog(this,new TimePickerDialog.OnTimeSetListener(){
            @Override
            public void onTimeSet(TimePicker arg0, int hour, int minute) {
                timeEditEnd.setText((hour>12?hour-12:hour)+":"+(minute<10?"0":"")+minute+(hour>12?" AM":" PM"));
            }},calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false);

        timeEditEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeEnd.show();
            }
        });



        //
    }

}

