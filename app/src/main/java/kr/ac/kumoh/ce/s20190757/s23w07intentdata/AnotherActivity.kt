package kr.ac.kumoh.ce.s20190757.s23w07intentdata

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kr.ac.kumoh.ce.s20190757.s23w07intentdata.ui.theme.S23W07IntentDataTheme

class AnotherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            S23W07IntentDataTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SingerImage()
                }
            }
        }
    }
}

@Composable
fun SingerImage(modifier: Modifier = Modifier) {
    val activity = LocalContext.current as Activity
    val intent = activity.intent
    val res = when(intent.getStringExtra(MainActivity.KEY_NAME)) {
        MainActivity.IMAGE_NEWJEANS1 -> R.drawable.newjeans1
        MainActivity.IMAGE_NEWJEANS2 -> R.drawable.newjeans2
        else -> R.drawable.ic_launcher_foreground
    }

    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(id = res),
        contentScale = ContentScale.Crop,
        contentDescription = "Singer Image"
    )
    Row(
        modifier = modifier.fillMaxWidth().wrapContentHeight(Alignment.Bottom),
            horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = {}) {
            Text("좋아요")
        }
        Button(onClick = {}) {
            Text("싫어요")
        }
    }
}
