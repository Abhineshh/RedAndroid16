package com.example.basicactivity

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity: AppCompatActivity(){
      override fun onCreate(savedInstanceState: Bundle?){
          super.onCreate(savedInstanceState)
          setContentView(R.layout.activity_main)

          val btnOrder = findViewById<Button>(R.id.btnOrder)
          btnOrder.setOnClickListener{
              val checkedRadioButton = findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId
              val s1 = findViewById<CheckBox>(R.id.cboval).isChecked
              val s2 = findViewById<CheckBox>(R.id.cblong).isChecked
              val shapeString: String = if(s1){"oval shape"} else {"elongated shape"}
              val orderString = "You ordered the bun with a amazingly tasty\n ${findViewById<RadioButton>(checkedRadioButton).text} in easy on eye but good ${shapeString}"
              findViewById<TextView>(R.id.orderdetails).text = orderString
          }

          val btnShowtoast = findViewById<Button>(R.id.showToast)
          btnShowtoast.setOnClickListener{
              Toast.makeText(this, "Kaido the beast is coming",Toast.LENGTH_LONG).show()
          }

          val btnshowcustumToast = findViewById<Button>(R.id.showCustomToast)
          btnshowcustumToast.setOnClickListener{
              Toast(this).apply {
                  duration = Toast.LENGTH_LONG
                  view = layoutInflater.inflate(R.layout.custom_toast,findViewById(R.id.cltoast))
                  show()
              }
          }

      }


  }