package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var main: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = ActivityMainBinding.inflate(layoutInflater)
        setContentView(main.root)
    }
}