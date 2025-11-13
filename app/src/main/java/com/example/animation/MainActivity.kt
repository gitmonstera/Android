package com.example.animation

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.rotationMatrix
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        val txt1 = findViewById<TextView>(R.id.textView3)
        val txt2 = findViewById<TextView>(R.id.textView4)
        val txt3 = findViewById<TextView>(R.id.textView5)
        val txt4 = findViewById<TextView>(R.id.textView6)

        btn.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)
            btn.startAnimation(animation)
            val animationText = AnimationUtils.loadAnimation(this, R.anim.bounce_up_down)
            txt1.startAnimation(animationText)
            val animationText2 = AnimationUtils.loadAnimation(this, R.anim.fade_in_bottom)
            txt2.startAnimation(animationText2)


            val alphaAnimator = ObjectAnimator.ofFloat(txt3, "alpha", 1f, 0f, 1f)
            alphaAnimator.duration = 1000
            alphaAnimator.repeatCount = 10
            alphaAnimator.start()

            ObjectAnimator.ofFloat(txt4, "translationX",
                0f, 20f, -20f, 15f, -15f, 10f, -10f, 5f, -5f, 0f).apply {
                duration = 600
                start()
            }

        }
    }
}