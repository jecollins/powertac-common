package org.powertac.common.tariff

import java.io.Serializable;
import org.joda.time.DateTime

/**
 * Tariffs are composed of Rates, all of which are subtypes of this class.
 * Rates may be applicable on particular days of the week, particular times
 * of day, or above some usage threshold.
 * @author jcollins
 */
abstract class AbstractRate implements Serializable
{
  int id
  Tariff tariff
  DailyInterval appliesDaily
  WeeklyInterval appliesWeekly
  Tier tier
  
  /**
   * True just in case this Rate applies at this moment, ignoring the
   * tier.
   * @return
   */
  boolean applies ()
  {
    current = new DateTime()
    return ((appliesWeekly == null || appliesWeekly.contains(current)) &&
            (appliesDaily == null || appliesDaily.contains(current))
  }
  
  // GORM info
  static belongsTo = [Tariff]
  
  static constraints = {
    id(nullable:false)
    tariff(nullable:false)
    appliesDaily(nullable:true)
    appliesWeekly(nullable:true)
    tier(nullable:true)
  }
}
