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

        ArtImage(art = R.drawable.draw_a_peacock_colored_by_diana_huang_d4cdozz, description = R.string.first_content_description)
        ArtDescriptor(title = R.string.first_title, artist = R.string.first_artist)
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {
            Button(onClick = { goToPrevious(id, art, description, title, artist) },
                modifier = Modifier.size(width = 136.dp, height = 36.dp),
                colors = ButtonDefaults.buttonColors(Color.DarkGray)) {
                Text(text = "Previous")
            }
            Button(onClick = { /*TODO*/ },
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
        modifier = Modifier
            .border(width = 24.dp, color = Color.White, shape = RectangleShape)
            .padding(32.dp))
}
@Composable
fun ArtDescriptor(@StringRes title: Int, @StringRes artist: Int,modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ){
        Text(text = stringResource(id = title), fontWeight = FontWeight.Bold)
        Text(text = stringResource(id = artist), fontSize = 12.sp, fontStyle = FontStyle.Italic, fontFamily = FontFamily.Cursive)
    }
}

fun goToPrevious(id: Int, art: Int, description: Int, title: Int, artist: Int) {

}

fun goToNext(id: Int) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp("Android")
    }
}