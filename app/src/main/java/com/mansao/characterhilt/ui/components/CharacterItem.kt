package com.mansao.characterhilt.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mansao.characterhilt.data.remote.response.GetAllCharactersResponseItem

@Composable
fun CharacterItem(
    character: GetAllCharactersResponseItem,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Column(modifier = modifier.fillMaxWidth()) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(character.image)
                .crossfade(true)
                .build(),
            contentDescription = "character Image",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = character.name)
        Text(text = character.actor)

    }

}
