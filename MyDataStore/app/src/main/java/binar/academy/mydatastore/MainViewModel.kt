package binar.academy.mydatastore

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel(private val pref: CounterDataStoreManager) : ViewModel() {
    private val _vCount: MutableLiveData<Int> = MutableLiveData(0)
    val vCount: LiveData<Int> = _vCount

    fun saveDataStore(value: Int) {
        viewModelScope.launch {
            pref.setCounter(value)
        }
    }

    fun getDataStore(): LiveData<Int> {
//        val getValue = pref.getCounter().toString().toInt()
//        _vCount.value = getValue
//       _vCount.value=pref.getCounter().asLiveData().value
        return pref.getCounter().asLiveData()
    }

    fun incrementCount() {
        _vCount.value = _vCount.value?.plus(1)
    }

    fun getValue(value: Int){
        _vCount.value = value
    }
    fun decrementCount() {
        _vCount.value?.let {
            if (it > 0) {
                _vCount.value = _vCount.value?.minus(1)
            }
        }
    }


}