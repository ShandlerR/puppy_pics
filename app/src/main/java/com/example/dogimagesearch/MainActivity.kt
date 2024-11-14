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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
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
                DogImageSearch(
                    mapOf(
                        "khaleesi" to listOf(
                            R.drawable.kahlsee0,
                            R.drawable.kahlsee1,
                            R.drawable.kahlsee2,
                            R.drawable.kahlsee3
                        ),
                        "qubert" to listOf(
                            R.drawable.qbert0,
                            R.drawable.qbert1
                        )
                    )
                )
            }
        }
    }
}

@Composable
fun DogImageSearch(imageDirectory: Map<String, List<Int>>,modifier: Modifier = Modifier) {
    var index by remember { mutableIntStateOf(0) }
    var searchTerm by remember {
        mutableStateOf("")
    }
    val searchResult = findCloseInDirectory(searchTerm, imageDirectory)
    val nameAndImage = findNameAndImageByIndex(index, searchResult)

    var backEnabled by remember { mutableStateOf(false) }
    var frontEnabled by remember { mutableStateOf(true) }
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
                    painter = painterResource(id = nameAndImage.second),
                    contentDescription = null,
                    modifier = Modifier.padding(32.dp)
                )
            }
        }
        Surface(
            border = BorderStroke(1.dp, Color.Black),
            color = Color(225, 226, 236),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = nameAndImage.first.lowercase().replaceFirstChar { it.uppercase() },
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
            
            BigButton(
                iconResource = R.drawable.arrow_back,
                enabled = backEnabled,
                modifier = modifier.testTag("back")
            ) {
                index--
            }

            BigButton(
                iconResource = R.drawable.arrow_front,
                enabled = frontEnabled,
                modifier = modifier.testTag("front")
            ) {
                backEnabled = true
                index++
            }
        }

    }
}

@Composable
fun BigButton(
    @DrawableRes iconResource: Int,
    enabled: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(enabled = enabled ,onClick = onClick, modifier = modifier) {
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
internal fun findCloseInDirectory(searchTerm: String, directory: Map<String, List<Int>>): Map<String, List<Int>> {
    val cleanedSearchTerm = searchTerm.replace(" ", "").lowercase()
    if (cleanedSearchTerm == "") {
        return directory
    }

    return directory.filterKeys {
        val cleanedKey = it.replace(" ", "").lowercase()
        cleanedKey.contains(cleanedSearchTerm)
    }
}

@VisibleForTesting
internal fun findNameAndImageByIndex(
    index: Int,
    directory: Map<String, List<Int>>,
    unknownParas: Pair<String, Int> = Pair("Unknown Dog", R.drawable.failed_search)
): Pair<String, Int> {
    var totalIndexesPassed = 0
    var lastSafeName = unknownParas.first
    var lastSafeImage = unknownParas.second

    // negative index or index within range
    for((name, imageList) in directory) {
        if(imageList.size + totalIndexesPassed > index && imageList.isNotEmpty()) {
            val tempName = name.ifBlank { unknownParas.first } // If the name is empty, use default value
            return Pair(tempName, imageList[(index - totalIndexesPassed).coerceAtLeast(0)])

        } else {
            totalIndexesPassed += imageList.size
            if (imageList.isNotEmpty()) {
                lastSafeName = name
                lastSafeImage = imageList.last()
            }
        }
    }

    // index out of range - overflow
    return Pair(lastSafeName, lastSafeImage)
}

@Preview(showBackground = true)
@Composable
fun DogPreview() {
    DogImageSearchTheme {
        DogImageSearch(
            mapOf(
                "khaleesi" to listOf(
                    R.drawable.kahlsee0,
                    R.drawable.kahlsee1,
                    R.drawable.kahlsee2,
                    R.drawable.kahlsee3
                ),
                "qubert" to listOf(
                    R.drawable.qbert0,
                    R.drawable.qbert1
                )
            )
        )
    }
}