/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.individuallending.api.v1.domain.product;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author Myrle Krantz
 */
public enum ChargeProportionalDesignator {
  NOT_PROPORTIONAL("{notproportional}", 0),
  MAXIMUM_BALANCE_DESIGNATOR("{maximumbalance}", 1),
  RUNNING_BALANCE_DESIGNATOR("{runningbalance}", 2),
  PRINCIPAL_ADJUSTMENT_DESIGNATOR("{principaladjustment}", 3),
  REPAYMENT_DESIGNATOR("{repayment}", 4),
  ;

  private final String value;
  private final int orderOfApplication;

  ChargeProportionalDesignator(final String value, final int orderOfApplication) {
    this.value = value;
    this.orderOfApplication = orderOfApplication;
  }

  public String getValue() {
    return value;
  }

  public int getOrderOfApplication() {
    return orderOfApplication;
  }

  public static Optional<ChargeProportionalDesignator> fromString(final String value) {
    if (value == null)
      return Optional.of(NOT_PROPORTIONAL);
    return Arrays.stream(ChargeProportionalDesignator.values())
        .filter(x -> x.getValue().equals(value))
        .findFirst();
  }
}