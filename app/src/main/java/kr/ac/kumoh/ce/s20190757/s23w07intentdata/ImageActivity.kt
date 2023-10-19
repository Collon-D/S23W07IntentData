package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var main: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        Log.i("Image!!", intent.getStringExtra(MainActivity.KEY_NAME) ?: "없음")
        val res = when (intent.getStringExtra(MainActivity.KEY_NAME)) {
            "newjeans1" -> R.drawable.newjeans1
            "newjeans2" -> R.drawable.newjeans2
            else -> R.drawable.ic_launcher_foreground
        }
        main.image.setImageResource(res)
    }
}