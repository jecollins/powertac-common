package org.powertac.common.tariff;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.powertac.common.Broker
import org.powertac.common.Competition;

/**
 * Represents a Tariff offered by a Broker to customers. A Tariff specifies
 * prices for energy in various circumstances, along with upfront and periodic
 * payments and basic constraints. This class is simply a serializable,
 * immutable data structure. You need a TariffBuilder to create one, and a
 * TariffExaminer to make serious use of one.
 */
class Tariff implements Serializable
{
  
  // ----------- Power-type enumeration --------------
  enum PowerType
  {
    CONSUMPTION, INTERRUPTIBLE_CONSUMPTION,
    PRODUCTION, SOLAR_PRODUCTION, WIND_PRODUCTION,
    BATTERY_STORAGE, THERMAL_STORAGE
  }
  
  enum State
  {
    OFFERED, ACTIVE, LEGACY 
  }
  
  /** Unique ID for this Tariff, composed from Broker ID and unique ID */
  String id
  
  /** Last date new subscriptions will be accepted */
  DateTime expiration
  
  /** Current state of this Tariff */
  State state = OFFERED
  
  /** Minimum contract duration */
  Duration minDuration
  
  /** Type of power covered by this tariff */
  PowerType powerType = CONSUMPTION
  
  /**
   * One-time payment for subscribing to tariff, positive for payment
   * from customer, negative for payment to customer.
   */
  BigDecimal signupPayment = 0
  
  /**
   * Payment from customer to broker for canceling subscription before
   * minDuration has elapsed.
   */
  BigDecimal earlyWithdrawPayment = 0
  
  /** Flat payment per period for two-part tariffs */
  BigDecimal periodicPayment = 0
  
  /** Returns the rate table */
  Rate[] rates
  
  /** IDs of tariffs superseded by this Tariff */
  String[] supersedes

  static hasMany = [rates:Rate, supersedes:String]
  static constraints = {
    id(nullable: false, blank: false, unique: true)
    expiration(nullable: false)
    state(nullable: false)
    minDuration()
    powerType(nullable: false)
    signupPayment()
    earlyWithdrawPayment()
    rates(nullable: false)
    supersedes()
  }  
}
