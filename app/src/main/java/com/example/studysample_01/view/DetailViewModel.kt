package com.example.studysample_01.view

import android.util.Log
import androidx.lifecycle.*
import com.example.studysample_01.domain.BookSearchUseCase
import com.example.studysample_01.view.model.BookInfo
import com.example.studysample_01.utils.Result
import com.example.studysample_01.view.model.mapToItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val bookSearchUseCase: BookSearchUseCase
) : ViewModel() {

    private val _documentData = MutableLiveData<List<BookInfo>>()
    val documentData: LiveData<List<BookInfo>> get() = _documentData

    init {
        bookSearch()
    }

    private fun bookSearch() {

        viewModelScope.launch {
            bookSearchUseCase(
                params = BookSearchUseCase.Params(getKeyword())
            ).let {

                when (it) {

                    is Result.Success -> {

                        it.data.mapToItem().items.let { bookInfo ->
                            _documentData.value = bookInfo
                        }

//                        it.data.items.map { bookEntity -> bookEntity.mapToItem() }
//                            .let { bookInfo ->
//                                _documentData.value = bookInfo
//                            }
                    }

                    is Result.Error -> {
                        Log.d("로그", "error ${it.exception}")
                    }
                }
            }
        }

        // TODO : MainThread 에 접근을 해야 하는 상황이 생기면 어떻게 할것인지?
//        withContext(Dispatchers.IO) {
//            try {
//                val entity = bookSearchUseCase.getSearchBookInfo(getKeyword())
//                val model = BookSearchMapper.fromEntityModel(entity)
//                _documentData.postValue(model.items)
//
//            } catch (e: Exception) {
//                Log.d("로그", "error $e")
//            }
//        }
    }

    private fun getKeyword(): String {
        return savedStateHandle.get<String>(DetailActivity.BOOK_SEARCH_KEYWORD) ?: ""
    }
}