package com.edw.platzitechnical.ui.screens.characterdetail


import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.edw.platzitechnical.ui.lineBreak
import com.edw.platzitechnical.ui.theme.CommonList
import com.edw.platzitechnical.ui.theme.Purple40
import com.edw.platzitechnical.ui.theme.PurpleDark
import com.edw.platzitechnical.ui.theme.PurpleGrey80
import com.edw.platzitechnical.viewmodel.CharacterDetailViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(navController: NavController, id: Int?) {

    val context = LocalContext.current
    val viewModel = hiltViewModel<CharacterDetailViewModel>()
    viewModel.getDetailCharacter(id ?: 1)

    val character by viewModel.characterDetail.observeAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Detalle")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(PurpleGrey80),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Navigation icon"
                        )
                    }
                }
            )
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 72.dp,
                    end = 16.dp
                ),
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
                        model = character?.imageUrl,
                        contentDescription = character?.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.CenterHorizontally)
                            .weight(3f)
                            .height(170.dp)
                            .padding(16.dp)
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Text(
                            modifier = Modifier.padding(16.dp),
                            text = character?.name ?: "",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 16.sp,
                            color = Purple40
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            textAlign = TextAlign.Right,
                            text = "Código: ${character?.id.toString()}",
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelLarge,
                            fontSize = 16.sp,
                            color = Purple40
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (character?.tvShows?.isNotEmpty() == true) {
                        CommonList(title = "Series de TV", character!!.tvShows)
                    }
                    if (character?.enemies?.isNotEmpty() == true) {
                        CommonList(title = "Enemigos", character!!.enemies)
                    }
                }
            }
        }
    }


}

