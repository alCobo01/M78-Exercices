package cat.itb.m78.exercices.projecteMapsCamera.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import cat.itb.m78.exercices.projecteMapsCamera.DTOs.InsertMarker
import cat.itb.m78.exercices.projecteMapsCamera.PHOTO_URI_KEY
import cat.itb.m78.exercices.sqldelight.database

class AddMarkerViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel(){
    //Database
    private val dbQueries = database.monumentsQueries

    fun addMarker(marker : InsertMarker){
        dbQueries.insert(
            marker.latitude,
            marker.longitude,
            marker.title,
            marker.description,
            marker.imageUri
        )
    }

    //Photo URI
    var showDialog by mutableStateOf(false)
    var showTitleErrorDialog by mutableStateOf(false)
    val photoUri = savedStateHandle.getStateFlow<String?>(PHOTO_URI_KEY, null)

    //State between screens
    private var tempMarker = InsertMarker(0.0, 0.0, "", "", "")

    fun saveMarkerState(marker: InsertMarker) {
        tempMarker = marker
    }

    fun getMarkerState(): InsertMarker {
        return tempMarker
    }


}