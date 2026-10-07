/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.polaris.core.policy.content;

import org.apache.polaris.core.policy.validator.InvalidPolicyException;
import tools.jackson.core.JsonParser;
import tools.jackson.core.JsonToken;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Accepts only JSON boolean literals {@code true} / {@code false}. Rejects string and numeric
 * coercions such as {@code "true"}, {@code "TRUE"}, {@code 1}, and {@code 0}.
 */
public class StrictBooleanDeserializer extends ValueDeserializer<Boolean> {
  @Override
  public Boolean deserialize(JsonParser p, DeserializationContext ctxt) {
    JsonToken token = p.currentToken();
    if (token == JsonToken.VALUE_TRUE) {
      return Boolean.TRUE;
    }
    if (token == JsonToken.VALUE_FALSE) {
      return Boolean.FALSE;
    }
    throw new InvalidPolicyException("Invalid boolean value: " + p.getValueAsString());
  }
}
