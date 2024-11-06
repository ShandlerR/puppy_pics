package com.example.dogimagesearch

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dogimagesearch.ui.theme.DogImageSearchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DogImageSearchTheme {
                DogImageSearch()
            }
        }
    }
}

@Composable
fun DogImageSearch(modifier: Modifier = Modifier) {
    val imageDirectory: Map<String, List<Int>> = mapOf(
        "kahlsee" to listOf(
            R.drawable.kahlsee0,
            R.drawable.kahlsee1,
            R.drawable.kahlsee2,
            R.drawable.kahlsee3
        ),
        "qbert" to listOf(
            R.drawable.qbert0,
            R.drawable.qbert1
        )
    )
    var searchTerm by remember {
        mutableStateOf("")
    }

    val searchResult = findCloseInDirectory(searchTerm, imageDirectory)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
            Surface(
                color = Color.White,
                border = BorderStroke(1.dp, Color.LightGray),
                shadowElevation = 10.dp
            ) {
                Image(
                    painter = painterResource(id = R.drawable.kahlsee1),
                    contentDescription = null,
                    modifier = Modifier.padding(32.dp)
                )
            }
        }
// Continue Refactor From here
        Surface(
            border = BorderStroke(1.dp, Color.Black),
            color = Color(225, 226, 236),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Khaleesi",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 7.dp)
            )
        }

        TextField(
            value = searchTerm,
            onValueChange = { searchTerm = it },
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.search), contentDescription = null) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            singleLine = true,
            label = { Text(text = stringResource(R.string.search_for_image)) },
            modifier = modifier.fillMaxWidth()
        )

        Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            
            BigButton(R.drawable.arrow_back) {
                Log.i(null, "Click Me Backward!")
            }

            BigButton(R.drawable.arrow_front) {
                Log.i(null, "Click Me Forward!")
            }
        }

    }
}

@Composable
fun BigButton(@DrawableRes iconResource: Int, onClick: () -> Unit) {
    Button(
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
            modifier = Modifier.padding(horizontal = 30.dp, vertical = 10.dp)
        )
    }
}

/*
    Returns a list of any close matching IDs from the directory.
 */
@VisibleForTesting
internal fun findCloseInDirectory(term: String, directory: Map<String, List<Int>>): List<Int> {

    if(term == "") {
        val allImageIds: List<Int> = directory.values.flatten()
        return allImageIds
    }

    return listOf()
}

@Preview(showBackground = true)
@Composable
fun DogPreview() {
    DogImageSearchTheme {
        DogImageSearch()
    }
}