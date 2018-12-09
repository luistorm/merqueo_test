package com.merqueotest.luistorm.merqueotest.ui.models

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Movie : RealmObject() {

    @PrimaryKey
    @SerializedName("id")
    var id: Int = -1

    @SerializedName("vote_average")
    var vote_average: Double = -1.0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("poster_path")
    var poster_path: String = ""

    @SerializedName("backdrop_path")
    var backdrop_path: String = ""

    @SerializedName("overview")
    var overview: String = ""

}