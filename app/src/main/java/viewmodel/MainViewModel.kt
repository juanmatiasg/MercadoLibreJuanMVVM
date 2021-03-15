package viewmodel

import androidx.lifecycle.*

import com.example.mvvmmercadolibrejuan.model.repository.Repo
import kotlinx.coroutines.Dispatchers
import utils.Resource
import java.lang.Exception

class MainViewModel (private val repo:Repo):ViewModel(){

    fun getListProduct() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))

       try {
           emit(Resource.success(data = repo.getListProduct()))
       }
       catch (e:Exception){
           emit(Resource.error(data = null,message = e.message ?: "Error Ocurred"))
       }

    }

}