package com.amg.libimgur.apis

import com.amg.libimgur.Client
import com.amg.libimgur.params.Section
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ImgurAPIv3Tests {
    val api = Client.api

    @Test
    fun `get tags working`() = runBlocking {
        val response = api.getTags()
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - hot working`() = runBlocking{
        val response = api.getGallery(Section.HOT)
        assertNotNull(response.body())
    }

    @Test
    fun `get galleries - top working`() = runBlocking {
        val response = api.getGallery(Section.TOP)
        assertNotNull(response.body())
    }
}