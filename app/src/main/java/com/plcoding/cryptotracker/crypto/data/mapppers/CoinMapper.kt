package com.plcoding.cryptotracker.crypto.data.mapppers

import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinDto
import com.plcoding.cryptotracker.crypto.data.networking.dto.CoinPriceDto
import com.plcoding.cryptotracker.crypto.domain.Coin
import com.plcoding.cryptotracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

// used to map a data layer Dto object into a domain layer object
fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}