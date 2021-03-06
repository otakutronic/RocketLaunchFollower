package com.test.rocketlaunches.data

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import com.test.rocketlaunches.data.remote.ApiConstants
import com.test.rocketlaunches.domain.util.Constants.SPACE_X_BASE_URL
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun provideHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(ApiConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(ApiConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(ApiConstants.REQUEST_TIMEOUT, TimeUnit.SECONDS)
    .build()

fun provideTypeAdapter(): TypeAdapterFactory {
    return object : TypeAdapterFactory {

        override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T> {
            val delegate = gson!!.getDelegateAdapter(this, type)
            val elementAdapter = gson!!.getAdapter(JsonElement::class.java)

            return object : TypeAdapter<T>() {

                override fun write(out: JsonWriter?, value: T) {
                    delegate.write(out, value)
                }

                override fun read(`in`: JsonReader?): T {
                    val jsonElement = elementAdapter.read(`in`)
                    if (jsonElement.isJsonObject) {
                        val jsonObject = jsonElement.asJsonObject
                        if (jsonObject.has("Error Message"))
                            throw Exception(jsonObject.get("Error Message").asString)

                        if (jsonObject.has("Information"))
                            throw Exception(jsonObject.get("Information").asString)

                        if (jsonObject.has("Note"))
                            throw Exception(jsonObject.get("Note").asString)
                    }

                    return delegate.fromJsonTree(jsonElement)
                }
            }.nullSafe()
        }
    }
}

fun provideGson(typeAdapterFactory: TypeAdapterFactory): Gson {
    return GsonBuilder()
        .registerTypeAdapterFactory(typeAdapterFactory)
        .create()
}

fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
    .baseUrl(SPACE_X_BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()

val networkModule = module {
    factory { provideHttpClient() }
    factory { provideTypeAdapter() }
    factory { provideGson(get()) }
    single { provideRetrofit(get(), get()) }
}
