# Android


<scale
android:fromXScale="1.0"
android:toXScale="1.5"
android:fromYScale="1.0"
android:toYScale="1.5"
android:pivotX="50%"
android:pivotY="50%"
android:duration="500" />

<alpha
android:fromAlpha="0.0"
android:toAlpha="1.0"
android:duration="300"
android:repeatCount="3"
android:repeatMode="reverse"/>


   


val btn1 = findViewById<Button>(R.id.myButton)
val txt1 = findViewById<TextView>(R.id.textView)
val txt2 = findViewById<TextView>(R.id.textView2)
val txt3 = findViewById<TextView>(R.id.textView3)
val txt4 = findViewById<TextView>(R.id.textView4)

        btn1.setOnClickListener {
            val scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation)
            btn1.startAnimation(scaleAnimation)
            val fadeInBottom = AnimationUtils.loadAnimation(this, R.anim.fade_in_bottom)
            txt1.startAnimation(fadeInBottom)
            val fadeInBottom1 = AnimationUtils.loadAnimation(this, R.anim.bounce_up_down)
            txt2.startAnimation(fadeInBottom1)

           

        }

       