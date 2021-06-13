package com.hotmart.baseapi.application.converter

import com.hotmart.baseapi.domain.entity.ResourceAction
import com.hotmart.baseapi.usecase.base.BaseEntityResponse
import org.springframework.http.HttpMethod
import java.lang.IllegalArgumentException
import java.util.*

class ActionResourceConverter {
    companion object {
        fun convertEntityActions(entity: BaseEntityResponse, resourcePath: String) {
            entity.actions = entity.actions
                .map { toApplicationResourceLink(it as ResourceAction, resourcePath, entity.id) }
        }

        private fun toApplicationResourceLink(action: ResourceAction, resourcePath: String, id: UUID) = when (action) {
            ResourceAction.LIST_BY_ID -> ApplicationResourceLink("SELF", HttpMethod.GET, "$resourcePath/$id")
            ResourceAction.CREATE -> ApplicationResourceLink(action.name, HttpMethod.POST, resourcePath)
            ResourceAction.UPDATE -> ApplicationResourceLink(action.name, HttpMethod.PUT, "$resourcePath/$id")
            ResourceAction.DELETE -> ApplicationResourceLink(action.name, HttpMethod.DELETE, "$resourcePath/$id")
            else -> throw IllegalArgumentException("ResourceAction ($action) not mapped to ApplicationResourceLink")
        }
    }
}

data class ApplicationResourceLink(
    val rel: String,
    val method: HttpMethod,
    val href: String
)