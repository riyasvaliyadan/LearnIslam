package com.example.learnislam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnislam.data.Data
import com.example.learnislam.ui.theme.LearnIslamTheme

const val KEY = "key"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = this

        val items = Data.duas.map { it.title }.toList()

        setContent {
            LearnIslamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainMenu(items, modifier = Modifier, activity)
                }
            }
        }
    }
}

@Composable
fun MainMenu(items: List<String>, modifier: Modifier = Modifier, activity: MainActivity) {
    LazyColumn(modifier = modifier.fillMaxWidth()) {
        itemsIndexed(items) {index, item ->
            MenuItem(
                item = item,
                modifier = modifier.clickable {
                    val i = Intent(activity, DetailActivity::class.java)
                    i.putExtra(KEY, index)
                    activity.startActivity(i)
                }
            )
        }

    }
}

@Composable
fun MenuItem(item: String, modifier: Modifier) {
    Box {
        Text(text = item,
            fontFamily = FontFamily(Font(R.font.roboto_condensed_regular)),
            modifier = modifier
            .padding(14.dp)
            .fillMaxWidth())
        Divider()
    }
}

@Preview(showBackground = true)
@Composable
fun MenuItemPreview(){
    MenuItem(item = "Menu Item", modifier = Modifier)
}