package binar.academy.myfirstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import binar.academy.myfirstcompose.ui.theme.MyFirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSecondary
                ) {
                    GreetingWithText("Nur Yusuf Oktavianda", 22)

                }
            }
        }
    }
}

@Composable
fun GreetingWithText(name: String, age: Int) {
Box(
    modifier = Modifier
//        .background(Color.DarkGray)
        .fillMaxSize()

) {
    Column(
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .wrapContentSize()
            .padding(top = 150.dp)
    ) {
        val image = painterResource(id = R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .background(color = Color.DarkGray)
                .align(alignment = CenterHorizontally)
                .wrapContentWidth()
                .wrapContentHeight()
        )

        Text(
            text = name,
            fontSize = 36.sp,
            textAlign= TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .wrapContentHeight()
        )
        Text(
            text = age.toString(),
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth()
                .wrapContentHeight()
        )
    }
}



}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

//@Composable
//fun contactFrame(){
//    Row() {
//
//    }
//}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyFirstComposeTheme {
        GreetingWithText("Yusuf Oktavianda", 22)
    }
}