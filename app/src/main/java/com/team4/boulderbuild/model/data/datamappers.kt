package com.team4.boulderbuild.model.data

import com.team4.domain.Gym as DomainGym
import com.team4.boulderbuild.model.data.database.Gym as DBGym

fun DomainGym.toDBGym(): DBGym =
    DBGym(
        id ?: -1,
        name ?: "",
        description ?: "",
        lat ?: 0.0,
        lon ?: 0.0,
        imgSrc ?: ""
    )

fun DBGym.toDomainGym() : DomainGym =
    DomainGym(
        id,
        name,
        description,
        lat,
        lon,
        imgSrc
    )