package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val IMAGE_NAME = "image name"
        const val IMAGE_RESULT = "image result"
        const val LIKE = 100
        const val DISLIKE = 101
        const val NONE = 0
    }

    private lateinit var main: ActivityImageBinding

    private lateinit var imageName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityImageBinding.inflate(layoutInflater)
        setContentView(main.root)

        Log.i("Image!!", intent.getStringExtra(MainActivity.KEY_NAME) ?: "없음")
        imageName = intent.getStringExtra(MainActivity.KEY_NAME) ?: "none"
        val res = when (imageName) {
            MainActivity.IMAGE_NEWJEANS1 -> R.drawable.newjeans1
            MainActivity.IMAGE_NEWJEANS2 -> R.drawable.newjeans2
            else -> R.drawable.ic_launcher_foreground
        }
        main.image.setImageResource(res)

        main.btnLike.setOnClickListener(this)
        main.btnDislike.setOnClickListener(this)
    }

//  fuctional interface : 함수를 하나만 가지고 있는 인터페이스
    override fun onClick(v: View?) {
        val intent = Intent()
        val value = when(v?.id) {
            main.btnLike.id -> LIKE
            main.btnDislike.id -> DISLIKE
            else -> NONE
        }
        intent.putExtra(IMAGE_NAME, imageName)
        intent.putExtra(IMAGE_RESULT, value)
        setResult(RESULT_OK, intent)
        finish()
    }
}