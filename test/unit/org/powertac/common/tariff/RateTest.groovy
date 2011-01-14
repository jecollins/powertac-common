package org.powertac.common.tariff

import grails.test.GrailsUnitTestCase;
import groovy.lang.MetaClass;

class RateTest extends GrailsUnitTestCase
{
  protected void setUp() {
    super.setUp()
    mockForConstraintsTests(Rate)
  }

  protected void tearDown() {
    super.tearDown()
  }

  void testFixedRate ()
  {
    Rate r = new Rate (value:0.121)
    assertNotNull("Rate not null", r)
    assertTrue("Rate is fixed", r.isFixed)
    assertEquals("Correct fixed rate", r.value, 0.121)
  }
  
  public MetaClass getMetaClass ()
  {
    // TODO Auto-generated method stub
    return null;
  }

  public Object getProperty (String arg0)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public Object invokeMethod (String arg0, Object arg1)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public void setMetaClass (MetaClass arg0)
  {
    // TODO Auto-generated method stub

  }

  public void setProperty (String arg0, Object arg1)
  {
    // TODO Auto-generated method stub

  }

}
