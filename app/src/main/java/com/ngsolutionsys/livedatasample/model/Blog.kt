package com.ngsolutionsys.livedatasample.model

/**
 * Created by Arif Hossen<arif123@gmail.com> on 6/21/2019.
 */

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Blog (

    @Json(name="author")
    var author: String? = null,
    @Json(name="description")
    var description: String? = null,
    @Json(name="link")
    var link: String? = null,
    @Json(name="pubDate")
    var pubDate: String? = null,
    @Json(name="thumbnail")
    var thumbnail: String? = null,
    @Json(name="title")
    var title: String? = null

)