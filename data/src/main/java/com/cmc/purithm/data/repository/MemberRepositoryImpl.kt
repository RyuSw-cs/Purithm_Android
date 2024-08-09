package com.cmc.purithm.data.repository

import com.cmc.purithm.data.local.datasource.MemberDataStore
import com.cmc.purithm.data.remote.HandleApi
import com.cmc.purithm.data.remote.service.MemberService
import com.cmc.purithm.domain.repository.MemberRepository
import javax.inject.Inject

internal class MemberRepositoryImpl @Inject constructor(
    private val memberService: MemberService,
    private val memberDataStore: MemberDataStore
) : MemberRepository {
    override suspend fun getFirstRun(): Boolean {
        return memberDataStore.getFirstRun()
    }

    override suspend fun setFirstRun(flag: Boolean) {
        return memberDataStore.setFirstRun(flag)
    }

    override suspend fun agreeToTermsOfService() {
        HandleApi.callApi { memberService.requestAgreeTermsOfService() }
    }

    override suspend fun getFirstFilter(): Boolean {
        return memberDataStore.getFirstFilterRun()
    }

    override suspend fun setFirstFilter(flag: Boolean) {
        memberDataStore.setFirstFilterRun(flag)
    }

}