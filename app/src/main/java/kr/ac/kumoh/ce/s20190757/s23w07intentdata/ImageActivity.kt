package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    companion object {
        const val IMAGE_RESULT = "image result"
        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }

    private lateinit var main: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        Log.i("Image!!", intent.getStringExtra(MainActivity.KEY_NAME) ?: "없음")
        val res = when (intent.getStringExtra(MainActivity.KEY_NAME)) {
            MainActivity.IMAGE_NEWJEANS1 -> R.drawable.newjeans1
            MainActivity.IMAGE_NEWJEANS2 -> R.drawable.newjeans2
            else -> R.drawable.ic_launcher_foreground
        }
        main.image.setImageResource(res)
    }
}