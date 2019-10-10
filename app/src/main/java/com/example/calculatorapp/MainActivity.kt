package com.example.calculatorapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){


    var operation= "";
    var oldvalue = "";
    var newValue="";
    var isOPerationClicked = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClick(view :View)
    {
        Log.e("isOPerationClicked",""+isOPerationClicked)
        if(isOPerationClicked)
        {
            edValue.setText("")
            isOPerationClicked = false;
        }
        var editTextValue=edValue.text.toString()
        when(view.id)
        {

            btnZero.id-> editTextValue += "0"
            btnOne.id-> editTextValue += "1"
            btnTwo.id->editTextValue +="2"
            btnThree.id->editTextValue+="3"
            btnFour.id->editTextValue+="4"
            btnFive.id->editTextValue+="5"
            btnSix.id->editTextValue+="6"
            btnSeven.id->editTextValue+="7"
            btnEight.id->editTextValue+="8"
            btnNine.id->editTextValue+="9"
            btnPlusMinus.id->{
                if(editTextValue.contains("-"))
                {
                    editTextValue =   editTextValue.replace("-","")
                }
                else
                {
                    editTextValue = "-"+editTextValue
                }
            }
        }

        edValue.setText(editTextValue)
    }

    fun onOperationClick(view :View){

        when(view.id)
        {
            btnModule.id->operation="%"
            btnPlus.id->operation="+"
            btnMultiply.id->operation="*"
            btnSubstract.id->operation="-"
            btnDivide.id->operation="/"
        }
        isOPerationClicked = true;
        Log.e("isOPerationClicked",""+isOPerationClicked)
        Log.e("operation",""+operation)
        oldvalue = edValue.text.toString();


    }

    fun clickEquals(view : View){

        newValue = edValue.text.toString();
        var result="";

        when(operation)
        {
            "+"->result = (oldvalue.toDouble()+newValue.toDouble()).toString()
            "-"->result = (oldvalue.toDouble()-newValue.toDouble()).toString()
            "*"->result = (oldvalue.toDouble()*newValue.toDouble()).toString()
            "/"->result = (oldvalue.toDouble()/newValue.toDouble()).toString()
            "%"->result = ((newValue.toDouble() * 100)/oldvalue.toDouble()).toString()
        }

        edValue.setText(result)

    }

    fun clearEveryThing(view:View)
    {
        edValue.setText("")
        isOPerationClicked = false;
         operation= "";
         oldvalue = "";
         newValue="";
    }
}