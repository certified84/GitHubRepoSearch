package com.certified.githubreposearcch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.certified.githubreposearcch.ui.theme.GitHubRepoSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitHubRepoSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android", 10)
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp)),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextField(value = "Type here", onValueChange = {

                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, number: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        for (i in 0..number)
            Surface(color = colorResource(id = R.color.teal_700)) {
                Text(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Monospace,
                    text = "Hello $name!",
                    modifier = Modifier.padding(dimensionResource(id = com.intuit.sdp.R.dimen._16sdp))
                )
            }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GitHubRepoSearchTheme {
        Greeting("Android", 5)
    }
}