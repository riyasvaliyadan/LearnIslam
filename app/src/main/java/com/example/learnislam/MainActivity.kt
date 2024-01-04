package com.example.learnislam

import android.os.Bundle
import android.widget.ScrollView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType.Companion.Scroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnislam.ui.theme.LearnIslamTheme
import com.halilibo.richtext.markdown.Markdown
import com.halilibo.richtext.ui.CodeBlockStyle
import com.halilibo.richtext.ui.RichText
import com.halilibo.richtext.ui.RichTextStyle
import com.halilibo.richtext.ui.TableStyle
import com.halilibo.richtext.ui.string.RichTextStringStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnIslamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        RichText(
            modifier = Modifier.padding(16.dp)
        ) {
            Markdown(
                """
    # Salat Al Janaza
    
    **1 – Say first Takbeer:** Recite Surah Al-Fatihah

    **2 – Say second Takbeer:** Recite Darood on Prophet Muhammad (ﷺ) as one does at the end of the prayer

    ٱللَّٰهُمَّ صَلِّ عَلَىٰ مُحَمَّدٍ وَعَلَىٰ آلِ مُحَمَّدٍ كَمَا صَلَّيْتَ عَلَىٰ إِبْرَاهِيمَ وَعَلَىٰ آلِ إِبْرَاهِيمَ إِنَّكَ حَمِيدٌ مَجِيدٌ ٱللَّٰهُمَّ بَارِكْ عَلَىٰ مُحَمَّدٍ وَعَلَىٰ آلِ مُحَمَّدٍ كَمَا بَارَكْتَ عَلَىٰ إِبْرَاهِيمَ وَعَلَىٰ آلِ إِبْرَاهِيمَ إِنَّكَ حَمِيدٌ مَجِيدٌ

    O Allah, let Your Peace come upon Muhammad and the family of Muhammad, as you have brought peace to Ibrahim and his family. Truly, You are Praiseworthy and Glorious. Allah, bless Muhammad and the family of Muhammad, as you have blessed Ibrahim and his family. Truly, You are Praiseworthy and Glorious.

    **3 – Say third Takbeer:** Make supplication (du’a) for the deceased.

    اللهُـمِّ اغْفِـرْ لَهُ وَارْحَمْـه ، وَعافِهِ وَاعْفُ عَنْـه ، وَأَكْـرِمْ نُزُلَـه ، وَوَسِّـعْ مُدْخَـلَه ، وَاغْسِلْـهُ بِالْمـاءِ وَالثَّـلْجِ وَالْبَـرَدْ ، وَنَقِّـهِ مِنَ الْخطـايا كَما نَـقّيْتَ الـثَّوْبُ الأَبْيَـضُ مِنَ الدَّنَـسْ ، وَأَبْـدِلْهُ داراً خَـيْراً مِنْ دارِه ، وَأَهْلاً خَـيْراً مِنْ أَهْلِـه ، وَزَوْجَـاً خَـيْراً مِنْ زَوْجِه ، وَأَدْخِـلْهُ الْجَـنَّة ، وَأَعِـذْهُ مِنْ عَذابِ القَـبْر وَعَذابِ النّـار

    O Allah, forgive and have mercy upon him, excuse him and pardon him, and make honourable his reception. Expand his entry, and cleanse him with water, snow, and ice, and purify him of sin as a white robe is purified of filth. Exchange his home for a better home, and his family for a better family, and his spouse for a better spouse. Admit him into the Garden, protect him from the punishment of the grave and the torment of the Fire.

    **4 – Say fourth Takbeer**

    and pause for a little while, Then end by saying

    السلام عليكم ورحمة الله
    Peace be upon you as well as the Mercy of Allah
    
    ---
    
    ```java
    var s = "code blocks use monospace font";
    alert(s);
    ```

    ```javascript
    var s = "code blocks use monospace font";
    alert(s);
    ```

    Markdown | Table | Extension
    --- | --- | ---
    *renders* | `beautiful images` | ![random image](https://picsum.photos/seed/picsum/400/400 "Text 1")
    1 | 2 | 3

    > Blockquotes are very handy in email to emulate reply text.
    > This line is part of the same quote.
    """.trimIndent()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnIslamTheme {
        Greeting()
    }
}