package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp("Android")
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(name: String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier.fillMaxSize()
    ){
        var id by remember {mutableStateOf(1)}
        var art by remember { mutableStateOf(R.drawable.draw_a_peacock_colored_by_diana_huang_d4cdozz) }
        var description by remember { mutableStateOf(R.string.first_content_description) }
        var title by remember { mutableStateOf(R.string.first_title) }
        var artist by remember { mutableStateOf(R.string.first_artist) }

        art = when(id) {
            1 -> R.drawable.draw_a_peacock_colored_by_diana_huang_d4cdozz
            2 -> R.drawable.flute
            3 -> R.drawable.nature
            else -> R.drawable.draw_a_peacock_colored_by_diana_huang_d4cdozz
        }

        description = when(id) {
            1 -> R.string.first_content_description
            2 -> R.string.second_content_description
            3 -> R.string.third_content_description
            else -> R.string.first_content_description
        }

        title = when(id) {
            1 -> R.string.first_title
            2 -> R.string.second_title
            3 -> R.string.third_title
            else -> R.string.first_title
        }

        artist = when(id) {
            1 -> R.string.first_artist
            2 -> R.string.second_artist
            3 -> R.string.third_artist
            else -> R.string.first_artist
        }

        ArtImage(art = art, description = description, modifier = Modifier.weight(1f))
        ArtDescriptor(title = title, artist = artist, modifier = Modifier.weight(0.25f))
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(32.dp)
                .weight(0.25f)
        ) {
            Button(onClick = { id = if (id==1) 3 else id-1},
                modifier = Modifier.size(width = 136.dp, height = 36.dp),
                colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                Text(text = "Previous")
            }
            Button(onClick = { id = if (id==3) 1 else id+1},
                modifier = Modifier.size(width = 136.dp, height = 36.dp),
                colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                Text("Next")
            }
        }
    }
}

@Composable
fun ArtImage(
    @DrawableRes art : Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {
    Image(painter = painterResource(id = art), contentDescription = stringResource(id = description),
        modifier = modifier
            .border(width = 24.dp, color = Color.White, shape = RectangleShape)
            .padding(32.dp).fillMaxWidth()
            .size(width = 160.dp, height = 320.dp))
}
@Composable
fun ArtDescriptor(@StringRes title: Int, @StringRes artist: Int,modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
     ){
        Text(text = stringResource(id = title), fontWeight = FontWeight.Bold)
        Text(text = stringResource(id = artist), fontSize = 12.sp, fontStyle = FontStyle.Italic, fontFamily = FontFamily.Cursive)
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp("Android")
    }
}