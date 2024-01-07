package com.example.learnislam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnislam.data.Data
import com.example.learnislam.ui.theme.LearnIslamTheme
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.BlockQuote
import com.halilibo.richtext.ui.Heading
import com.halilibo.richtext.ui.HorizontalRule
import com.halilibo.richtext.ui.RichText

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val index = intent.getIntExtra(KEY, -1) // todo have a look use of null safety
        val data = Utility.getRawData(this, Data.duas[index].rawId)
        
        setContent {
            LearnIslamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    DetailView(data)
                }
            }
        }
    }
}

@Composable
fun DetailView(data: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        RichText(
            modifier = Modifier.padding(16.dp)
        ) {
            Markdown(content = data)
        }
    }
}

@Preview
@Composable
fun Halibo() {
    RichText(modifier = Modifier.background(color = Color.White)) {
        Heading(0, "Title")
        Text("Summary paragraph.", color = Color.Blue)
        HorizontalRule()
        BlockQuote {
            Text("A wise person once said…")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnIslamTheme {
//        DetailView()
    }
}