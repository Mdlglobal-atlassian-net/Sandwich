/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.sandwich

import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response

/**
 * DataSourceCallAdapter is an call adapter for creating [DataSource] from service method.
 *
 * request API network call asynchronously and returns [DataSource].
 */
class DataSourceCallAdapter<R> constructor(
  private val responseType: Type
) : CallAdapter<R, DataSource<R>> {

  override fun responseType(): Type {
    return responseType
  }

  override fun adapt(call: Call<R>): DataSource<R> {
    val responseDataSource: ResponseDataSource<R> = ResponseDataSource()
    return responseDataSource.combine(call, object : Callback<R> {
      override fun onResponse(call: Call<R>, response: Response<R>) = Unit
      override fun onFailure(call: Call<R>, t: Throwable) = Unit
    })
  }
}
