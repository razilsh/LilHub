package dev.razil.lilhub.common

import com.apollographql.apollo.response.CustomTypeAdapter
import com.apollographql.apollo.response.CustomTypeValue
import org.threeten.bp.Instant

object DateAdapter : CustomTypeAdapter<Instant> {
    override fun encode(value: Instant): CustomTypeValue<*> {
        return CustomTypeValue.GraphQLString(value.toString())
    }

    override fun decode(value: CustomTypeValue<*>): Instant {
        return Instant.parse(value.value.toString())
    }
}
