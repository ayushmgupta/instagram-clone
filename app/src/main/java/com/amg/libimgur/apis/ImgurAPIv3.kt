package com.amg.libimgur.apis

import com.amg.libimgur.models.GalleryRes
import com.amg.libimgur.models.GalleryTagRes
import com.amg.libimgur.models.TagRes
import com.amg.libimgur.params.Section
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ImgurAPIv3 {
    @GET("gallery/{section}")
     suspend fun getGallery(
        @Path("section") section: Section,
        @Query("album_previews") albumPreviews: Boolean? = true
    ) : Response<GalleryRes>

    @GET("tags")
    suspend fun getTags() : Response<TagRes>

    @GET("gallery/t/{tags}")
    suspend fun getGalleryTag(
        @Path("tags") tags: String
    ): Response<GalleryTagRes>
}