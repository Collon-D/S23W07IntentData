package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_NAME = "Singer"
    }
    private lateinit var main: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)

        main.btnMusic1.setOnClickListener{
            Toast.makeText(this, "NewJeans1", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME, "newjeans1")
            startActivity(intent)
        }

        main.btnMusic2.setOnClickListener{
            Toast.makeText(this, "NewJeans2", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra(KEY_NAME, "newjeans2")
            startActivity(intent)
        }
    }
}