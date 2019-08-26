package com.raul.androidapps.testapplication.domain.deserializer

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.raul.androidapps.testapplication.domain.model.Flights
import java.lang.reflect.Type


class FlightsDeserializer : JsonDeserializer<Flights> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Flights? =

        try {
            val listOfFlights: MutableList<Flights> = mutableListOf()
            val base: String
            if (json.isJsonObject) {
                val jsonObject = json.asJsonObject
                if (jsonObject.get("base").isJsonPrimitive) {
                    base = jsonObject.get("base")?.asString
                        ?: throw JsonParseException("Error parsing response: no base value included")
                } else {
                    throw JsonParseException("Error parsing response: base value not an String")
                }
                listOfFlights.add(
                    SingleRate(
                        code = base,
                        rate = 1.toBigDecimal(),
                        isBasePrice = true
                    )
                )
                if (jsonObject.get("rates").isJsonObject) {
                    jsonObject.get("rates").asJsonObject?.let { rates ->
                        listOfFlights.addAll(
                            rates.entrySet().map {
                                SingleRate(
                                    code = it.key,
                                    rate = it.value.asBigDecimal,
                                    isBasePrice = false
                                )
                            }
                        )
                    }
                } else {
                    throw JsonParseException("Error parsing response: no rates value included")
                }
                Rates(listOfFlights)
            } else {
                throw JsonParseException("Error parsing response: no value included")
            }

        } catch (e: JsonParseException) {
            null
        }

}
