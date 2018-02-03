package example

import java.time.{ZoneId, ZonedDateTime}
import java.util

import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.indicators.{EMAIndicator, MACDIndicator}
import org.ta4j.core.{Bar, BaseBar, BaseTimeSeries}

object MacdDemo extends App {

  val series = new BaseTimeSeries(util.Arrays.asList[Bar](
    new BaseBar(ZonedDateTime.of(2012, 10, 1, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 800.050000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 2, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 800.050000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 3, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 807.470000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 4, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 807.470000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 5, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 807.470000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 6, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 807.470000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 7, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 800.750000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 8, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 800.750000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 9, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 807.470000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 10, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 807.000000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 11, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.990000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 12, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.000000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 13, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.500000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 14, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.500000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 15, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.500000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 16, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.940000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 17, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.950000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 18, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.010000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 19, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.010000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 20, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.010000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 21, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.010000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 22, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.900000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 23, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.900000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 24, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.900000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 25, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.900000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 26, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.000000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 27, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.900000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 28, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.000000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 29, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 801.000000000000, 0),
    new BaseBar(ZonedDateTime.of(2012, 10, 30, 12, 0, 0, 0, ZoneId.systemDefault()), 0, 0, 0, 806.890000000000, 0),
  ))
  val closePrice = new ClosePriceIndicator(series)

  // same as binance.com
  val macd = new MACDIndicator(closePrice, 9, 26)
  val emaMacd = new EMAIndicator(macd, 12)

  (0 until series.getBarCount).foreach(index => {
    println(macd.getValue(index))
    println(emaMacd.getValue(index))
  })

}
