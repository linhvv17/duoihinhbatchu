package com.example.duoichu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.annotation.IntegerRes
import androidx.core.view.get
import androidx.core.view.size
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Modifier
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private val questions = arrayListOf<Question>()
    private var currentIndex: Int = 0
    private val listAn = arrayListOf<Char>()
    private val listAnSelected = arrayListOf<String>()
    private var listQt = arrayListOf<Button>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initQuestion()
        updateQuestionContent()
        updateSuggest()
//        clickSuggest()
        clickNext()
        clickSuggest()


    }

    private fun clickNext() {
        val btn_click_next = findViewById<Button>(R.id.btn_click_next)
        btn_click_next.setOnClickListener{
            ll_1.removeAllViews()
            ll_2.removeAllViews()
            listAn.clear()
            for (i in 0 until llSuggest1.childCount){
                if ((llSuggest1.getChildAt(i) as Button).visibility == View.INVISIBLE){
                    (llSuggest1.getChildAt(i) as Button).visibility=View.VISIBLE
                }
            }

            for (i in 0 until llSuggest2.childCount){
                if ((llSuggest2.getChildAt(i) as Button).visibility == View.INVISIBLE){
                    (llSuggest2.getChildAt(i) as Button).visibility=View.VISIBLE
                }
            }
            updateQuestionContent()
            updateSuggest()
        }

    }

//    private fun clickForm() {
//
//
////        for (i in 0..listQt.size-1){
////            if ((ll_1.getChildAt(i) as Button).text.toString() == ""){
////                clickSuggest()
////                (ll_1.getChildAt(i) as Button).setText(
////                    (llSuggest1.getChildAt(i) as Button).text.toString()
////                )
////                break
////            }
////            if ((ll_2.getChildAt(i) as Button).text.toString() == ""){
////                (ll_2.getChildAt(i) as Button).setText(
////                    (llSuggest2.getChildAt(i) as Button).text.toString()
////                )
////                break
////            }
////        }
////        for (i in 0..ll_2.childCount-1){
////            if ((ll_2.getChildAt(i) as Button).text.toString() == ""){
////                (ll_2.getChildAt(i) as Button).setText(
////                    (llSuggest1.getChildAt(i) as Button).text.toString()
////                )
////                break
////            }
////        }
//    }

    private fun clickSuggest() {
        for (i in 0 until llSuggest1.childCount){
            (llSuggest1.getChildAt(i) as Button).setOnClickListener{
                (llSuggest1.getChildAt(i) as Button).visibility = View.INVISIBLE
                Log.d("SELECT",""+(llSuggest1.getChildAt(i) as Button).text)
//                listAnSelected.add((llSuggest1.getChildAt(i) as Button).text as String)
                val txt = (llSuggest1.getChildAt(i) as Button).text as String
                Log.d("CHOOSE", txt as String)
                for (i in 0 until ll_1.size){
                    val btn  = ll_1.getChildAt(i) as Button
                    if (btn.text == ""){
                        btn.text =  txt
                        break
                    }
                    if ((ll_1.getChildAt(ll_1.size-1) as Button).text !=""){
                        for (i in 0 until ll_2.size){
                            val btn  = ll_2.getChildAt(i) as Button
//                            val oke = (llSuggest1.getChildAt(i) as Button).text as String
                            if (btn.text == ""){
                                btn.text =  txt
                                break
                            }
//                            break
                        }
                    }
                }
//                for (i in 0 until ll_2.size){
//                    val btn  = ll_2.getChildAt(i) as Button
//                    if (btn.text == ""){
//                        btn.text =  txt
//                        break
//                    }
//                }

            }
        }
        for (i in 0 until llSuggest2.childCount){
            (llSuggest2.getChildAt(i) as Button).setOnClickListener{
                (llSuggest2.getChildAt(i) as Button).visibility = View.INVISIBLE
                Log.d("SELECT",""+(llSuggest2.getChildAt(i) as Button).text)
//                listAnSelected.add((llSuggest1.getChildAt(i) as Button).text as String)
//                val btn  = ll_1.getChildAt(i) as Button
                val txt2 = (llSuggest2.getChildAt(i) as Button).text as String
                Log.d("CHOOSE", txt2 as String)
                for (i in 0 until ll_1.size){
                    val btn  = ll_1.getChildAt(i) as Button
                    if (btn.text == ""){
                        btn.text =  txt2
                        break
                    }
                    if ((ll_1.getChildAt(ll_1.size-1) as Button).text !=""){
                        for (i in 0 until ll_2.size){
                            val btn  = ll_2.getChildAt(i) as Button
//                            val okela = (llSuggest2.getChildAt(i) as Button).text as String
                            if (btn.text == ""){
                                btn.text =  txt2
                                break
                            }
//                            break
                        }
                    }


                }
//                for (i in 0 until ll_2.size){
//                    val btn  = ll_2.getChildAt(i) as Button
//                    if (btn.text == ""){
//                        btn.text =  txt2
//                        break
//                    }
//                }
            }
        }
        //clickForm()

    }
//    private fun clickBtnNext(){
//        val btn_click_next = findViewById(R.id.btn_click_next) as Button
//        btn_click_next.setOnClickListener{
//
//        }
//    }
    private fun updateSuggest(){
        val rd = Random()
        //tao ra o dap an bat ky
        for (i in 0..15- questions[currentIndex].name.length){
            listAn.add(
                (rd.nextInt(26) + 65).toChar()
            )
        }
        //tao ra o dap an tu ten
        for (element in questions[currentIndex].name){
            listAn.add(
                element
            )
        }
        //tron lan 2 loai dap an
    listAn.sortWith(Comparator { o1, o2-> o1.compareTo(o2)})

        for (i in 0 until llSuggest1.childCount){
            (llSuggest1.getChildAt(i) as Button).text = listAn[i].toString()
        }
        for (i in 0 until llSuggest2.childCount){
            (llSuggest2.getChildAt(i) as Button).text = listAn[i+8].toString()
        }
    }
    private fun updateQuestionContent() {
        val rd = Random()
        currentIndex = rd.nextInt(questions.size)
        ivImg.setImageResource(
            questions[currentIndex].imageId
        )

        val numberQuestion = questions[currentIndex].name.length
//        listQt = numberQuestion
        for (i in 0..(8 - 1).coerceAtMost(numberQuestion - 1)){
            val btn = LayoutInflater.from(this)
                .inflate(R.layout.button_anwser,
                    ll_1, false) as Button
            ll_1.addView(btn)
            listQt.add(btn)

        }
        for (i in 8 until numberQuestion){
            val btn = LayoutInflater.from(this)
                .inflate(R.layout.button_anwser,
                    ll_1, false) as Button
            ll_2.addView(btn)
            listQt.add(btn)
        }
    }
    private fun initQuestion() {
        questions.add(
            Question("aomua".toUpperCase(),R.drawable.aomua)
        )
        questions.add(
            Question("baocao".toUpperCase(),R.drawable.baocao)
        )
        questions.add(
            Question("canthiep".toUpperCase(),R.drawable.canthiep)
        )
        questions.add(
            Question("cattuong".toUpperCase(),R.drawable.cattuong)
        )
        questions.add(
            Question("chieutre".toUpperCase(),R.drawable.chieutre)
        )
        questions.add(
            Question("danhlua".toUpperCase(),R.drawable.danhlua)
        )
        questions.add(
            Question("vuonbachthu".toUpperCase(),R.drawable.vuonbachthu)
        )
        questions.add(
            Question("vuaphaluoi".toUpperCase(),R.drawable.vuaphaluoi)
        )
    }

}
