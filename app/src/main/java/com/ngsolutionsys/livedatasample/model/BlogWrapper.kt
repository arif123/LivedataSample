package com.ngsolutionsys.livedatasample.model

/**
 * Created by Arif Hossen<arif123@gmail.com> on 6/21/2019.
 */
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BlogWrapper (

    @Json(name="data")
    var blog: MutableList<Blog>? = null,
    @Json(name="error")
    var error: Boolean? = null,
    @Json(name="message")
    var message: String? = null,
    @Json(name="status")
    var status: String? = null

)