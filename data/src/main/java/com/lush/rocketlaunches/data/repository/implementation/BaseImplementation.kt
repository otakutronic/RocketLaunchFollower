package com.lush.rocketlaunches.data.repository.implementation

import com.lush.rocketlaunches.domain.model.Result
import retrofit2.Response

abstract class BaseImplementation {

    protected suspend fun <T1,T2> getResult(call: suspend () -> Response<T1>, mapper: (T1) -> T2): Result<T2> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val mapped = mapper(body)
                    return Result.success(mapped)
                }
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        return Result.error("Call failed: $message")
    }
}
