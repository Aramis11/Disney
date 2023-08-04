package com.edw.platzitechnical.ui.character

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edw.data.domain.CharacterInfo
import com.edw.platzitechnical.ui.theme.CharacterTheme
import com.edw.platzitechnical.ui.theme.Purple40
import com.edw.platzitechnical.ui.theme.PurpleGrey80

@Composable
fun CharacterItem(
    character: CharacterInfo,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth().height(200.dp)
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(PurpleGrey80)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
                .padding(4.dp)
                .background(PurpleGrey80)
        ) {
            Column(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    contentScale = ContentScale.FillBounds,
                    model = character.imageUrl,
                    contentDescription = character.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                        .weight(3f)
                        .height(170.dp)
                        .padding(16.dp)
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = character.name,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 16.sp,
                    color = Purple40
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview
@Composable
fun BeerItemPreview() {
    CharacterTheme {
        CharacterItem(
            character = CharacterInfo(
                id = 1,
                name = "Olu Mel",
                created = "2021-04-12T01:25:09.759Z",
                updated = "2021-12-20T20:39:18.031Z",
                sourceUrl = "https://disney.fandom.com/wiki/%27Olu_Mel",
                imageUrl = null,
                url = "https://api.disneyapi.dev/characters/6"
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
