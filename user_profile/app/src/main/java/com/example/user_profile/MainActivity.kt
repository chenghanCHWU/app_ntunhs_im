package com.example.user_profile

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spnCity = findViewById<Spinner>(R.id.spnCity)
        val city = arrayListOf("請選擇","臺北市","新北市","桃園市","新竹縣","新竹市")
        var gender=""
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,city)
        spnCity.adapter = adapter

        val radGrp_Gender = findViewById<RadioGroup>(R.id.radGrpGender)
        val radBtn_Male = findViewById<RadioButton>(R.id.radBtn_Male)
        val radBtn_Female = findViewById<RadioButton>(R.id.radBtn_Female)

        val numPicker = findViewById<NumberPicker>(R.id.numPicker_Age)


        numPicker.setMinValue(0)
        numPicker.setMaxValue(100)
        numPicker.setValue(50)

        val chkbox1 = findViewById<CheckBox>(R.id.ckb1)
        val chkbox2 = findViewById<CheckBox>(R.id.ckb2)
        val chkbox3 = findViewById<CheckBox>(R.id.ckb3)
        val chkbox4 = findViewById<CheckBox>(R.id.ckb4)

        val btn_send = findViewById<Button>(R.id.btn_send)


        val applyDate = findViewById<EditText>(R.id.applydate)
        val applyTime = findViewById<EditText>(R.id.applytime)


        applyTime.setOnClickListener{
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            TimePickerDialog(this, {
                    _, hour, minute->  applyTime.setText("$hour:$minute")
            }, hour, minute, true).show()
        }

        applyDate.setOnClickListener{
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this, { _, year, month, day ->
                run {
                    var format = "${setDateFormat(year, month, day)}"
                    applyDate.setText(format)
                }
            }, year, month, day).show()
        }



        btn_send.setOnClickListener {
            var msg=""
            if (chkbox1.isChecked()) {         //判斷複選框1是否被選定
                msg = msg + chkbox1.getText().toString()   //若選定，則將字串加該項目
            }
            if (chkbox2.isChecked()) {
                msg = msg + "、" + chkbox2.getText().toString()
            }
            if (chkbox3.isChecked()) {
                msg = msg + "、" + chkbox3.getText().toString()
            }
            if (chkbox4.isChecked()) {
                msg = msg + "、" + chkbox4.getText().toString()
            }
            Toast.makeText(this@MainActivity, "你選的是" + msg,
                Toast.LENGTH_LONG).show()

        }

        spnCity.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                if (pos>0)
                    Toast.makeText(this@MainActivity, "你選的是" + city[pos],
                                                                    Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        radGrp_Gender.setOnCheckedChangeListener { _, checkedId ->
            gender= radGrp_Gender.findViewById<RadioButton>(checkedId).text.toString()
            Toast.makeText(this,gender+numPicker.getValue(),Toast.LENGTH_LONG).show()
        }


    }
    private fun setDateFormat(year: Int, month: Int, day: Int): String {
        return "$year-${month + 1}-$day"
    }
}

