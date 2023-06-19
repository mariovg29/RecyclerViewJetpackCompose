package com.mariovg.recycler.model

import androidx.annotation.DrawableRes

data class SuperHeroe(
    var superHeroeName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)
