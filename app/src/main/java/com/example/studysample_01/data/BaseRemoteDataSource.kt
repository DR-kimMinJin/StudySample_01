package com.example.studysample_01.data

import android.util.Log
import com.example.studysample_01.domain.Entity
import com.example.studysample_01.domain.entity.EntityMapper
import com.example.studysample_01.utils.ResponseMapper
import com.example.studysample_01.utils.Result
import retrofit2.HttpException
import java.io.IOException
import java.lang.Exception
import java.util.*

abstract class BaseRemoteDataSource {

    protected suspend fun <E : Entity, M : Model> getResult(
        mapper: EntityMapper<E, M>,
        call: suspend () -> ResponseMapper<M>
    ): Result<E> {
        return try {
            convertGetResult(mapper, call())
        } catch (e: Exception) {
            convertException(e)
        }
    }

    private fun <E : Entity, M : Model> convertGetResult(
        entityMapper: EntityMapper<E, M>,
        responseMapper: ResponseMapper<M>
    ): Result<E> {

        Log.d("로그","convertGetResult call - ${responseMapper.body}")

        return Result.Success(entityMapper.fromModelEntity(responseMapper.body!!))
//        val code = responseMapper.code
//        val message = responseMapper.message
//
//        return when (code) {
//            202 -> Result.Error(DuplicateFormatFlagsException(message))
//            else -> Result.Success(entityMapper.fromModelEntity(responseMapper.body!!))
//        }
    }

    private fun convertException(exception: Exception): Result.Error {
        return when (exception) {

            is IOException -> Result.Error(exception)
            is HttpException -> Result.Error(exception)
            else -> Result.Error(exception)
        }
    }

}