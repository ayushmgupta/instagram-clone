package com.amg.instagram_clone.data

import com.amg.libimgur.Client
import com.amg.libimgur.models.Image
import com.amg.libimgur.models.Tag
import com.amg.libimgur.params.Section

class Repository {
    val api = Client.api

    suspend fun getHotFeed(): List<Image>? {
        val response = api.getGallery(Section.HOT)
        return response.body()?.data
    }

    suspend fun getTopFeed(): List<Image>?{
        val response = api.getGallery(Section.TOP)
        return response.body()?.data
    }

    suspend fun getTags(): List<Tag>?{
        val response = api.getTags()
        return response.body()?.data?.tags
    }

    suspend fun getTagGallery(tagName: String):List<Image>?{
        val response = api.getGalleryTag(tagName)
        return response.body()?.data?.items
    }

}