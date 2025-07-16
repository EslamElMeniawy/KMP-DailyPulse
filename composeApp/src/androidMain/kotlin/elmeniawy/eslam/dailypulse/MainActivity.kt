package elmeniawy.eslam.dailypulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.tooling.preview.Preview
import elmeniawy.eslam.dailypulse.articles.ArticlesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val articlesViewModel: ArticlesViewModel by viewModels()

        setContent {
            App(articlesViewModel)
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App()
//}