package com.amg.libimgur.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "accent")
    val accent: String?,

    @Json(name = "background_is_animated")
    val background_is_animated: Boolean?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "display_name")
    val display_name: String?,
    @Json(name = "followers")
    val followers: Int?,
    @Json(name = "following")
    val following: Boolean?,
    @Json(name = "is_promoted")
    val is_promoted: Boolean?,
    @Json(name = "is_whitelisted")
    val isWhitelisted: Boolean?,
    @Json(name = "items")
    val items: List<Image>?,
    @Json(name = "logo_destination_url")
    val logoDestinationUrl: Any?,
    @Json(name = "logo_hash")
    val logoHash: Any?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "background_hash")
    @SerializedName("background_hash")
    val backgroundHash: String?,     //need to put the same name of variable as of json name
    @Json(name = "thumbnail_hash")
    val thumbnail_hash: Any?,
    @Json(name = "thumbnail_is_animated")
    val thumbnail_is_animated: Boolean?,
    @Json(name = "total_items")
    val total_items: Int?
)