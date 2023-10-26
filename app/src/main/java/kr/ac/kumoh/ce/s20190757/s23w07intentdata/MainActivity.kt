package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.ImageActivity.Companion.IMAGE_RESULT
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.ImageActivity.Companion.NONE
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    companion object {
        const val KEY_NAME = "Singer"
        const val IMAGE_NEWJEANS1 = "newjeans1"
        const val IMAGE_NEWJEANS2 = "newjeans2"
    }
    private lateinit var main: ActivityMainBinding
    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode != Activity.RESULT_OK)
            return@registerForActivityResult

        val result = it.data?.getIntExtra(IMAGE_RESULT, NONE)

        val str = when (result) {
            ImageActivity.LIKE -> "좋아요"
            ImageActivity.DISLIKE -> "싫어요"
            else -> "error"
        }
        when (it.data?.getStringExtra(ImageActivity.IMAGE_NAME)) {
            IMAGE_NEWJEANS1 -> main.btnMusic1.text = "NewJeans1 ($str)"
            IMAGE_NEWJEANS2 -> main.btnMusic2.text = "NewJeans2 ($str)"
        }

//        Log.i("result", str)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnMusic1.setOnClickListener(this)
        main.btnMusic2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val value = when (v?.id) {
            main.btnMusic1.id -> {
                Toast.makeText(this, "NewJeans1", Toast.LENGTH_SHORT).show()
                IMAGE_NEWJEANS1
            }
            main.btnMusic2.id -> {
                Toast.makeText(this, "NewJeans2", Toast.LENGTH_SHORT).show()
                IMAGE_NEWJEANS2
            }
            else -> return
        }

        val intent = Intent(this, AnotherActivity::class.java)
        intent.putExtra(KEY_NAME, value)
        //startActivity(intent)
        startForResult.launch(intent)
    }
}