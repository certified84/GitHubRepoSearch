package com.certified.githubreposearcch.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import com.certified.githubreposearcch.R
import com.certified.githubreposearcch.data.model.Repo
import com.certified.githubreposearcch.ui.theme.GitHubRepoSearchTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SearchRepositoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            GitHubRepoSearchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                top = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp),
                                start = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp),
                                end = dimensionResource(id = com.intuit.sdp.R.dimen._16sdp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

//                        CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))

                        var text by remember { mutableStateOf(TextFieldValue()) }
                        OutlinedTextField(
                            label = { Text(text = "GitHub Repository") },
                            modifier = Modifier.fillMaxWidth(),
                            value = text,
                            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                            keyboardActions = KeyboardActions(onSearch = {
                                viewModel.accept(UiAction.Search(query = text.text))
                            }),
                            onValueChange = { text = it },
                            textStyle = TextStyle(fontSize = 14.sp)
                        )
                        ListContent(items = viewModel.pagingDataFlow.collectAsLazyPagingItems())
                    }
                }
            }
        }
    }
}

//@Composable
//fun OnClickListener(onClick: (() -> Unit)? = null) {
//
//}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemRepository(repo: Repo, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Column {
            Text(
                text = repo.fullName,
                fontStyle = FontStyle.Normal,
                color = colorResource(id = R.color.colorPrimary),
                fontSize = 20.sp
            )
            repo.description?.let {
                Text(
                    text = it,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Language:",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp)
                )
                repo.language?.let {
                    Text(
                        text = it, fontSize = 14.sp, textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 4.dp, top = 20.dp)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_star), contentDescription = "",
                    modifier = Modifier.padding(start = 4.dp, top = 20.dp)
                )
                Text(
                    text = repo.stars.toString(), fontSize = 14.sp, textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 4.dp, top = 20.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_git_branch),
                    contentDescription = "",
                    modifier = Modifier.padding(start = 4.dp, top = 20.dp)
                )
                Text(
                    text = repo.forks.toString(), fontSize = 14.sp, textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 4.dp, top = 20.dp)
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp), color = colorResource(
                    id = R.color.black
                )
            )
        }
    }
}

@Composable
fun Greeting(name: String, number: Int) {
    Column(modifier = Modifier.fillMaxSize()) {
        for (i in 0..number)
            Surface {
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
        ItemRepository(
            repo = Repo(
                1,
                "Scrcpy",
                "Genymobile/scrcpy",
                "Display and control your Android Device",
                "",
                2000,
                700,
                "C"
            ),
            onClick = { }
        )
    }
}