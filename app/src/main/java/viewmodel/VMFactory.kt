package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmmercadolibrejuan.model.api.ApiHelper
import com.example.mvvmmercadolibrejuan.model.repository.Repo

class VMFactory (private val apiHelper: ApiHelper): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(Repo(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}