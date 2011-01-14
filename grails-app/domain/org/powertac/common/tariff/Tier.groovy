package org.powertac.common.tariff;

/**
 * Tier specifier for a multi-tier Tariff structure. If a rate specifies
 * at Tier, then that rate applies only for usage above the threshold. 
 * @author jcollins
 */
class Tier implements Serializable
{
  double threshold = 0.0
}
