package org.powertac.common.tariff;

import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDateTime;
import org.joda.time.Partial;
import org.joda.time.ReadablePartial;

/**
 * Data structure that represents a daily interval of time during which
 * a particular tariff rate is applicable. The interval is treated as
 * half-open - closed at the beginning, open at the end.
 * @author jcollins
 */
class DailyInterval implements Serializable
{
  int begin
  int end
  
  /**
   * Constructor extracts just the hourOfDay from the input parameters.
   */
  DailyInterval (Partial begin_, Partial end_)
  {
    begin = begin_.getHourOfDay()
    end = end_.getHourOfDay()
  }

  /**
   * True just in case this DailyInterval contains the given time. 
   */
  boolean contains (LocalDateTime time)
  {
    hour = time.getHourOfDay()
    if (end > begin)
      // Interval does not span midnight
      return (hour >= begin && hour < end)
    else
      // Interval spans midnight
      return (hour >= begin || hour < end)
  }
}
