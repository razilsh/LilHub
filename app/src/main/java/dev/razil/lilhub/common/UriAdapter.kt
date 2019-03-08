package dev.razil.lilhub.common

import com.apollographql.apollo.response.CustomTypeAdapter
import com.apollographql.apollo.response.CustomTypeValue
import java.net.URI
import java.text.ParseException

object UriAdapter : CustomTypeAdapter<URI> {
    override fun encode(value: URI): CustomTypeValue<String> {
        return CustomTypeValue.GraphQLString(value.toString())
    }

    override fun decode(value: CustomTypeValue<*>): URI {
        try {
            return URI.create(value.value.toString())
        } catch (e: ParseException) {
            throw e
        }
    }
}
