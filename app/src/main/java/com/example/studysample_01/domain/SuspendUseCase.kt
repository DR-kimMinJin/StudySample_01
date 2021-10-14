package com.example.studysample_01.domain

import com.example.studysample_01.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.lang.RuntimeException
import kotlin.jvm.Throws

abstract class SuspendUseCase<in Params, out Type>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: Params): Result<Type> {
        return withContext(coroutineDispatcher) {
            execute(params)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: Params): Result<Type>

}