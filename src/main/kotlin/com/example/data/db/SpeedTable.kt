package com.example.data.db

import org.jetbrains.exposed.sql.Table

object SpeedTable : Table("speed_trac") {
    val id = integer("id").autoIncrement()
    val lat = varchar(name = "lat", length = 56)
    val lon = varchar(name = "lon", length = 56)
    val speed = float("speed")
}