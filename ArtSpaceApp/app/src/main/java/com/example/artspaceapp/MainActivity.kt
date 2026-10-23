package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout() {
    var currentArtwork by remember { mutableIntStateOf(1) }

    val imageResource: Int
    val titleResource: Int
    val artistResource: Int
    when (currentArtwork) {
        1 -> {
            imageResource = R.drawable.starry_night
            titleResource = R.string.starry_night_title
            artistResource = R.string.starry_night_artist
        }
        2 -> {
            imageResource = R.drawable.impression_sunrise
            titleResource = R.string.impression_sunrise_title
            artistResource = R.string.impression_sunrise_artist
        }
        else -> {
            imageResource = R.drawable.great_wave
            titleResource = R.string.great_wave_title
            artistResource = R.string.great_wave_artist
        }
    }

    val onPreviousClick = {
        currentArtwork = when (currentArtwork) {
            1 -> 3
            else -> currentArtwork - 1
        }
    }
    val onNextClick = {
        currentArtwork = when (currentArtwork) {
            3 -> 1
            else -> currentArtwork + 1
        }
    }

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.screenWidthDp > configuration.screenHeightDp

    if (isLandscape) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ArtworkWall(
                imageResource = imageResource,
                titleResource = titleResource,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ArtworkDescriptor(
                    titleResource = titleResource,
                    artistResource = artistResource
                )
                Spacer(modifier = Modifier.height(24.dp))
                DisplayController(
                    onPreviousClick = onPreviousClick,
                    onNextClick = onNextClick
                )
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            ArtworkWall(
                imageResource = imageResource,
                titleResource = titleResource,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            ArtworkDescriptor(
                titleResource = titleResource,
                artistResource = artistResource
            )
            Spacer(modifier = Modifier.height(32.dp))
            DisplayController(
                onPreviousClick = onPreviousClick,
                onNextClick = onNextClick
            )
        }
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes imageResource: Int,
    @StringRes titleResource: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shadowElevation = 8.dp
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = stringResource(titleResource),
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes titleResource: Int,
    @StringRes artistResource: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = stringResource(titleResource),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Light
            )
            Text(
                text = stringResource(artistResource),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = stringResource(R.string.previous))
        }
        Button(
            onClick = onNextClick,
            modifier = Modifier.width(130.dp)
        ) {
            Text(text = stringResource(R.string.next))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 360)
@Composable
fun ArtSpaceLayoutLandscapePreview() {
    ArtSpaceAppTheme {
        ArtSpaceLayout()
    }
}
