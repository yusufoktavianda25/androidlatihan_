package binar.academy.dicerollcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import binar.academy.dicerollcompose.ui.theme.DiceRollComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Roll("Android")
                }
            }
        }
    }
}

@Composable
fun Roll(name: String) {
    Box(modifier = Modifier
        .background(Color.DarkGray)
        .fillMaxHeight()
        .fillMaxWidth())
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize()

    ) {
        Image(painter = painterResource(R.drawable.dice_1), contentDescription = null
//        modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
       )

        Button(
            onClick = {
               
            },
//            modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
        ) {
            Text(text = "Roll")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceRollComposeTheme {
        Roll("Android")
    }
}