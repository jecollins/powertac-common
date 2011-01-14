package org.powertac.common.tariff

import java.io.Serializable;
import org.joda.time.DateTime

class HourlyCharge implements Serializable
{
  static belongsTo = Rate
  BigDecimal value
  DateTime when
}
