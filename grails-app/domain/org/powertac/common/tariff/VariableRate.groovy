package org.powertac.common.tariff

import org.joda.time.Duration

class VariableRate extends AbstractRate
{
  double minValue
  double maxValue
  Duration noticeInterval
  double expectedMean
  def rateHistory = [:]
}
