/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an
 * "AS IS" BASIS,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.powertac.common

import org.joda.time.LocalDateTime
import org.powertac.common.enumerations.TariffState


/**
 * Denormalized tariff definition, superseded by the richer normalized definition
 * org.powertac.common.tariff.Tariff.
 */
@Deprecated
class TariffDN implements Serializable {

  String id = IdGenerator.createId()
  String transactionId
  Competition competition
  Broker broker
  Customer customer
  String tariffId //this id remains identical over all db instances of the tariff (where one instance is generated for each change in the tariff, e.g. a price update)
  String customTariffId //this id is only populated if a broker and a customer enter a private tariff negotiation. In this case customTariffId remains the same across all negotiation offers and also for tariff updates during tariff runtime
  TariffState tariffState
  Boolean isDynamic
  Boolean isNegotiable
  LocalDateTime dateCreated = new LocalDateTime()
  Boolean latest

  BigDecimal signupFee //one-time fee (>0) / reward (<0) charged / paid for contract signup
  BigDecimal earlyExitFee //payed by the customer if he leaves the contract before its regular end
  BigDecimal baseFee //daily base Fee (>0) / reward (<0) charged at the end of each day

  Integer changeLeadTime //time in timeslots a tariff change has to be announced in advance

  /*
    * These attributes allow a broker to specify minimum and maximum
    * contract runtimes, e.g. min one month
    */
  LocalDateTime contractStartDate //defines a specific contract start Date, may be specified by customer or broker
  LocalDateTime contractEndDate //defines a specific contract end Date, may be specified by customer or broker
  Integer minimumContractRuntime //null or min days; has to be consistent with contractEndTime - contractStartTime
  Integer maximumContractRuntime //null or max days; has to be consistent with contractEndTime - contractStartTime

  /*
   * These attributes allow modeling a two-part tariff
   */
  BigDecimal powerConsumptionThreshold   // >0: threshold consumption level; consumption exceeding this threshold leads to a surcharge (see below) being added to the time dependent powerConsumptionPrice
  BigDecimal powerConsumptionSurcharge   // % fee added to hourly powerConsumptionPrice if consumption exceeds threshold (see above)

  BigDecimal powerProductionThreshold    // >0: threshold production level; production exceeding this threshold leads to a surcharge (see below) being added to the time dependent powerProductionPrice
  BigDecimal powerProductionSurcharge    // % fee added to hourly powerProductionPrice if production exceeds threshold (see above)

  BigDecimal powerConsumptionPrice0
  BigDecimal powerConsumptionPrice1
  BigDecimal powerConsumptionPrice2
  BigDecimal powerConsumptionPrice3
  BigDecimal powerConsumptionPrice4
  BigDecimal powerConsumptionPrice5
  BigDecimal powerConsumptionPrice6
  BigDecimal powerConsumptionPrice7
  BigDecimal powerConsumptionPrice8
  BigDecimal powerConsumptionPrice9
  BigDecimal powerConsumptionPrice10
  BigDecimal powerConsumptionPrice11
  BigDecimal powerConsumptionPrice12
  BigDecimal powerConsumptionPrice13
  BigDecimal powerConsumptionPrice14
  BigDecimal powerConsumptionPrice15
  BigDecimal powerConsumptionPrice16
  BigDecimal powerConsumptionPrice17
  BigDecimal powerConsumptionPrice18
  BigDecimal powerConsumptionPrice19
  BigDecimal powerConsumptionPrice20
  BigDecimal powerConsumptionPrice21
  BigDecimal powerConsumptionPrice22
  BigDecimal powerConsumptionPrice23

  BigDecimal powerProductionPrice0
  BigDecimal powerProductionPrice1
  BigDecimal powerProductionPrice2
  BigDecimal powerProductionPrice3
  BigDecimal powerProductionPrice4
  BigDecimal powerProductionPrice5
  BigDecimal powerProductionPrice6
  BigDecimal powerProductionPrice7
  BigDecimal powerProductionPrice8
  BigDecimal powerProductionPrice9
  BigDecimal powerProductionPrice10
  BigDecimal powerProductionPrice11
  BigDecimal powerProductionPrice12
  BigDecimal powerProductionPrice13
  BigDecimal powerProductionPrice14
  BigDecimal powerProductionPrice15
  BigDecimal powerProductionPrice16
  BigDecimal powerProductionPrice17
  BigDecimal powerProductionPrice18
  BigDecimal powerProductionPrice19
  BigDecimal powerProductionPrice20
  BigDecimal powerProductionPrice21
  BigDecimal powerProductionPrice22
  BigDecimal powerProductionPrice23

  static belongsTo = [competition: Competition, broker: Broker, customer: Customer]

  static constraints = {
    id(nullable: false, blank: false, unique: true)
    transactionId(nullable: false, blank: false)
    competition(nullable: false)
    broker(nullable: false)
    customer(nullable: true)
    tariffId(nullable: false)
    customTariffId(nullable: true)
    tariffState(nullable: false)
    isDynamic(nullable: false)
    isNegotiable(nullablee: false)
    dateCreated(nullable: false)
    latest(nullable: false)
    signupFee(nullable: true, scale: Constants.DECIMALS)
    earlyExitFee(nullable: true, scale: Constants.DECIMALS)
    baseFee(nullable: true, scale: Constants.DECIMALS)
    changeLeadTime(nullable: true)
    contractStartDate(nullable: true)
    contractEndDate(nullable: true)
    minimumContractRuntime(nullable: true)
    maximumContractRuntime(nullable: true)
    powerConsumptionThreshold(nullable: true, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionSurcharge(nullable: true, scale: Constants.DECIMALS, min: 0.0)
    powerProductionThreshold(nullable: true, scale: Constants.DECIMALS, min: 0.0)
    powerProductionSurcharge(nullable: true, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice0(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice1(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice2(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice3(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice4(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice5(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice6(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice7(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice8(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice9(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice10(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice11(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice12(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice13(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice14(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice15(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice16(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice17(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice18(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice19(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice20(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice21(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice22(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerConsumptionPrice23(nullable: false, scale: Constants.DECIMALS, min: 0.0)

    powerProductionPrice0(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice1(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice2(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice3(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice4(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice5(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice6(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice7(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice8(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice9(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice10(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice11(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice12(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice13(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice14(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice15(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice16(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice17(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice18(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice19(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice20(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice21(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice22(nullable: false, scale: Constants.DECIMALS, min: 0.0)
    powerProductionPrice23(nullable: false, scale: Constants.DECIMALS, min: 0.0)

  }

  static mapping = {
    id(generator: 'assigned')
  }

  static transients = ['powerConsumptionPrices', 'powerProductionPrices', 'powerProductionPriceForRange', 'powerConsumptionPriceForRange', 'powerProductionPriceFor', 'powerConsumptionPriceFor', 'flatPowerConsumptionPrice', 'flatPowerProductionPrice']


  public String toString() {
    return tariffId
  }

  public BigDecimal[] getPowerConsumptionPrices() {
    BigDecimal[] array = new BigDecimal[24]
    for (i in 0..23) {
      array[i] = this."powerConsumptionPrice$i"
    }
    return array
  }

  public BigDecimal[] getPowerProductionPrices() {
    BigDecimal[] array = new BigDecimal[24]
    for (i in 0..23) {
      array[i] = this."powerProductionPrice$i"
    }
    return array
  }

  public void setPowerConsumptionPrices(BigDecimal[] powerConsumptionPrices) {
    if (!powerConsumptionPrices) return
    int length = Math.min(powerConsumptionPrices.length,24)
    for (i in 0..(length - 1)) {
      this."powerConsumptionPrice$i" = powerConsumptionPrices[i]
    }
  }

  public void setPowerProductionPrices(BigDecimal[] powerProductionPrices) {
    if (!powerProductionPrices) return
    int length = Math.min(powerProductionPrices.length, 24)
    for (i in 0..(length - 1)) {
      this."powerProductionPrice$i" = powerProductionPrices[i]
    }
  }

  public void setFlatPowerProductionPrice(BigDecimal price) {
    for (i in 0..23) {
      this."powerProductionPrice$i" = price
    }
  }

  public void setFlatPowerConsumptionPrice(BigDecimal price) {
    for (i in 0..23) {
      this."powerConsumptionPrice$i" = price
    }
  }

  public void setPowerProductionPriceForRange(int start, int end, BigDecimal price) {
    int i = start < 0 ? 0 : start
    if (i > 23) i = 23
    int j = end < i ? i : end
    if (j > 23) j = 23
    for (k in i..j) {
      this."powerProductionPrice$k" = price
    }
  }

  public void setPowerConsumptionPriceForRange(int start, int end, BigDecimal price) {
    int i = start < 0 ? 0 : start
    if (i > 23) i = 23
    int j = end < i ? i : end
    if (j > 23) j = 23
    for (k in i..j) {
      this."powerConsumptionPrice$k" = price
    }
  }

  public void setPowerProductionPriceFor(int slot, BigDecimal price) {
    if (slot < 0 || slot > 23) return
    this."powerProductionPrice$slot" = price
  }

  public BigDecimal getPowerProductionPriceFor(int slot) {
    if (slot < 0 || slot > 23) return null
    return this."powerProductionPrice$slot"
  }

  public void setPowerConsumptionPriceFor(int slot, BigDecimal price) {
    if (slot < 0 || slot > 23) return
    this."powerConsumptionPrice$slot" = price
  }

  public BigDecimal getPowerConsumptionPriceFor(int slot) {
    if (slot < 0 || slot > 23) return null
    return this."powerConsumptionPrice$slot"
  }
}
