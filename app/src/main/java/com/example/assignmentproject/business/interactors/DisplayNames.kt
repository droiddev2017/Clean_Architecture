package com.example.assignmentproject.business.interactors

import com.example.assignmentproject.business.data.cache.abstraction.CacheDataSource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Created by Vinit Saxena on 01/08/21.
 */
class DisplayNames @Inject constructor(val dataSource: CacheDataSource) {
    suspend fun getData() = withContext(IO) {
        val data = dataSource.readData()
        val listOfName = data.names.toMutableList().map { name ->
            name.capitalize(Locale.ROOT)
        }

        listOfName
    }
}