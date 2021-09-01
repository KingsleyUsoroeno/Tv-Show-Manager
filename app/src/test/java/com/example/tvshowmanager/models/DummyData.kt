package com.example.tvshowmanager.models

import com.benasher44.uuid.Uuid
import com.example.tvshowmanager.data.local.models.CachedMovieEntity
import java.util.*

internal object DummyData {

    val movieEntity = CachedMovieEntity(
        id = Uuid.randomUUID().toString(),
        title = "Merlin",
        releaseDate = Date(),
        seasons = 5
    )
}
