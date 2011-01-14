package org.powertac.common.tariff;

import org.joda.time.DateTimeFieldType;
import org.joda.time.Partial;
import org.joda.time.ReadablePartial;

/**
 * Data structure that represents days of the week during which particular
 * tariff rates are applicable.
 * @author jcollins
 */
public class WeeklyInterval implements Serializable
{
  Partial begin
  Partial end
  
  public WeeklyInterval (Partial begin_, Partial end_)
  {
    begin = new Partial(DateTimeFieldType.dayOfWeek(),
                        begin_.get(DateTimeFieldType.dayOfWeek()))
    end = new Partial(DateTimeFieldType.dayOfWeek(),
                      end_.get(DateTimeFieldType.dayOfWeek()))
  }
}
