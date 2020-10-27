package com.example.aplikasicolormyview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var box_one_text : TextView
    lateinit var box_two_text : TextView
    lateinit var box_three_text : TextView
    lateinit var box_four_text : TextView
    lateinit var box_five_text : TextView
    lateinit var checkBoxOne : CheckBox
    lateinit var checkBoxTwo: CheckBox
    lateinit var checkBoxThree: CheckBox
    lateinit var checkBoxFour: CheckBox
    lateinit var checkBoxFive: CheckBox
    lateinit var selectedBox : ArrayList<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }


    private fun setListeners() {
        box_one_text = findViewById(R.id.box_one_text)
        box_two_text = findViewById(R.id.box_two_text)
        box_three_text = findViewById(R.id.box_three_text)
        box_four_text = findViewById(R.id.box_four_text)
        box_five_text = findViewById(R.id.box_five_text)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)
        val redButton = findViewById<TextView>(R.id.red_button)
        val greenButton = findViewById<TextView>(R.id.green_button)
        val yellowButton = findViewById<TextView>(R.id.yellow_button)

        checkBoxOne = findViewById(R.id.check_box_one)
        checkBoxTwo = findViewById(R.id.check_box_two)
        checkBoxThree = findViewById(R.id.check_box_three)
        checkBoxFour = findViewById(R.id.check_box_four)
        checkBoxFive = findViewById(R.id.check_box_five)

        val clickableViews : List<View> =
            listOf(
                    box_one_text,
                    box_two_text,
                    box_three_text,
                    box_four_text,
                    box_five_text,
                    rootConstraintLayout,
                    redButton,
                    greenButton,
                    yellowButton
            )
        selectedBox = ArrayList()

        for (item in clickableViews) {
            item.setOnClickListener { makeDrawable(it) }
        }

    }

    private fun makeDrawable(view: View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundResource(R.drawable.satu)
            R.id.box_two_text -> view.setBackgroundResource(R.drawable.dua)
            R.id.box_three_text -> view.setBackgroundResource(R.drawable.tiga)
            R.id.box_four_text -> view.setBackgroundResource(R.drawable.empat)
            R.id.box_five_text -> view.setBackgroundResource(R.drawable.lima)


            R.id.red_button -> makeCheckBoxColored(Color.RED)
            R.id.green_button -> makeCheckBoxColored(Color.GREEN)
            R.id.yellow_button -> makeCheckBoxColored(Color.YELLOW)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun makeColored(view : View) {
        when (view.id) {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)


            R.id.red_button -> makeCheckBoxColored(Color.RED)
            R.id.green_button -> makeCheckBoxColored(Color.GREEN)
            R.id.yellow_button -> makeCheckBoxColored(Color.YELLOW)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    fun onCheckBoxClicked(view: View) {
        if (view is CheckBox) {
            when(view) {
                checkBoxOne -> checkAndAddToArrayList(checkBoxOne, box_one_text)
                checkBoxTwo -> checkAndAddToArrayList(checkBoxTwo, box_two_text)
                checkBoxThree -> checkAndAddToArrayList(checkBoxThree, box_three_text)
                checkBoxFour -> checkAndAddToArrayList(checkBoxFour, box_four_text)
                checkBoxFive -> checkAndAddToArrayList(checkBoxFive, box_five_text)
            }
        }
    }

    fun checkAndAddToArrayList(checkBox: CheckBox, view: View) {
        val isChecked : Boolean = checkBox.isChecked
        if(isChecked){
            selectedBox.add(view)
        } else {
            selectedBox.remove(view)
        }
    }

    fun makeCheckBoxColored(color: Int){
        for (item in selectedBox){
            item.setBackgroundColor(color)
        }
    }

}