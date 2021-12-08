package com.amg.instagram_clone.ui.story

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amg.instagram_clone.data.Repository
import com.amg.libimgur.models.Image
import com.amg.libimgur.models.Tag
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoryViewModel: ViewModel() {
    private val repo = Repository()
    private val _image = MutableLiveData<List<Image>>()

    val image: LiveData<List<Image>> = _image

    fun fetchTagGallery(tagName: String) = viewModelScope.launch(Dispatchers.IO){
        _image.postValue(repo.getTagGallery(tagName))
    }
}