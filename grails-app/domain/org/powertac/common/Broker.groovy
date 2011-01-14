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

class Broker implements Serializable {

  String id = IdGenerator.createId()
  Competition competition
  String userName
  String apiKey = IdGenerator.createId()

  static belongsTo = [competition: Competition]

  static hasMany = [cashUpdates: CashUpdate, positionUpdates: PositionUpdate, shouts: Shout, tariffs: TariffDN]

  static constraints = {
    id(nullable: false, blank: false, unique: true)
    userName(nullable: false, blank: false, unique: 'competition', minSize: 5, matches: /([a-zA-Z0-9])*/)
    apiKey(nullable: false, blank: false, unique: true, minSize: 32)
  }

  static mapping = {
    cache(true)
    id(generator: 'assigned')
    competition(index: 'competition_username_apikey_idx')
    userName(index: 'competition_username_apikey_idx')
    apiKey(index: 'competition_username_apikey_idx')
  }

  public String toString() {
    return userName
  }
}
