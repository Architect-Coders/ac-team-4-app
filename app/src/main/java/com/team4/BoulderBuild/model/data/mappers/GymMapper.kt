package com.team4.BoulderBuild.model.data.mappers

import com.team4.BoulderBuild.model.data.database.Gym as DBGym
import com.team4.BoulderBuild.model.domain.Gym as DomainGym

fun DomainGym.toDBGym(): DBGym =
    DBGym(
        id ?: -1,
        name ?: "",
        description ?: "",
        lat ?: 0.0,
        lon ?: 0.0,
        imgSrc ?: ""
    )

fun DBGym.toDomainGym(): DomainGym =
    DomainGym(
        id,
        name,
        description,
        lat,
        lon,
        imgSrc
    )