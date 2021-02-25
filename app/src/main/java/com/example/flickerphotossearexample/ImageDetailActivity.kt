package com.example.flickerphotossearexample
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.flickerphotossearexample.R

class ImageDetailActivity : AppCompatActivity(), ScaleGestureDetector.OnScaleGestureListener {

    private var scale = 1f
    private lateinit var image: ImageView
    private lateinit var scaleGestureDetector: ScaleGestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        image = findViewById(R.id.imageView)

        Glide.with(this).load(intent.getStringExtra("image")).into(image)
        scaleGestureDetector = ScaleGestureDetector(this, this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return true
    }

    override fun onScaleBegin(detector: ScaleGestureDetector?): Boolean {
        return true
    }

    override fun onScaleEnd(detector: ScaleGestureDetector?) {
    }

    override fun onScale(detector: ScaleGestureDetector): Boolean {
        // Multiply scale factor

        scale*= detector.scaleFactor

        // Scale or zoom the imageview

        image.scaleX = scale;

        image.scaleY = scale;


        return true;
    }
}