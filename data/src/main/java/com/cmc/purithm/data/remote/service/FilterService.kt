package com.cmc.purithm.data.remote.service

import com.cmc.purithm.data.remote.dto.base.BaseResponse
import com.cmc.purithm.data.remote.dto.filter.FilterDetailResponseDto
import com.cmc.purithm.data.remote.dto.filter.FilterListResponseDto
import com.cmc.purithm.data.remote.dto.filter.FilterReviewResponseDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

internal interface FilterService {
    @GET("api/filters")
    suspend fun getFilterList(
        @Query("os") os: String = "AOS",
        @Query("tag") tag: String? = null,
        @Query("sortedBy") sortedBy: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): BaseResponse<FilterListResponseDto>

    @POST("api/filters/{filterId}/likes")
    suspend fun requestFilterLike(
        @Path("filterId") filterId: String
    ): BaseResponse<Boolean>

    @DELETE("api/filters/{filterId}/likes")
    suspend fun deleteFilterLike(
        @Path("filterId") filterId: String
    ): BaseResponse<Boolean>

    @GET("api/filters/{filterId}")
    suspend fun getFilterDetail(
        @Path("filterId") filterId: String
    ): BaseResponse<FilterDetailResponseDto>

    @GET("api/filters/{filterId}/reviews")
    suspend fun getFilterReview(
        @Path("filterId") filterId: String
    ): BaseResponse<FilterReviewResponseDto>
}