package com.example.studysample_01.utils

import java.lang.Exception

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "$data"
            is Error -> "$exception"
        }
    }

    val Result<*>.succeeded
        get() = this is Result.Success && data != null
    val <T>Result<T>.data: T?
        get() = (this as? Result.Success)?.data

    fun <T> Result<T>.successOr(fallback: T): T {
        return (this as? Result.Success<T>)?.data ?: fallback
    }

}