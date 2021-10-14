package com.example.studysample_01.view

import androidx.lifecycle.*
import com.example.studysample_01.domain.BookKeywordSendRepository
import com.example.studysample_01.domain.BookKeywordSendUseCase
import com.example.studysample_01.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val bookKeywordSendUseCase: BookKeywordSendUseCase
) : ViewModel() {

    private val _openEvent = MutableLiveData<Event<String>>()
    val openEvent: LiveData<Event<String>> get() = _openEvent

    fun bookSearch(keyword: String) {
        _openEvent.value = Event(
            bookKeywordSendUseCase.bookKeywordSend(keyword)
        )
    }
}

inline fun <T> LiveData<Event<T>>.eventObserve(
    owner: LifecycleOwner,
    crossinline onChanged: (T) -> Unit
): Observer<Event<T>> {

    val wrappedObserver = Observer<Event<T>> { t ->
        t.getContentIfNotHandled()?.let {
            onChanged.invoke(it)
        }
    }
    observe(owner, wrappedObserver)

    return wrappedObserver
}
