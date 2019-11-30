/*-
 * -\-\-
 * docker-client
 * --
 * Copyright (C) 2016 Spotify AB
 * Copyright (C) 9/2019 - 2020 Dimitris Mandalidis
 * --
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * -/-/-
 */

package org.mandas.docker.client.messages.mount;

import java.util.Map;

import org.immutables.value.Value.Immutable;
import org.mandas.docker.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = ImmutableVolumeOptions.Builder.class)
@Immutable
public interface VolumeOptions {

  @Nullable
  @JsonProperty("NoCopy")
  Boolean noCopy();

  @Nullable
  @JsonProperty("Labels")
  Map<String, String> labels();

  @Nullable
  @JsonProperty("DriverConfig")
  Driver driverConfig();

  interface Builder {

    Builder noCopy(Boolean noCopy);

    Builder labels(Map<String, ? extends String> labels);

    Builder addLabel(final String label, final String value);

    Builder driverConfig(Driver driverConfig);

    VolumeOptions build();
  }

  public static Builder builder() {
    return ImmutableVolumeOptions.builder();
  }
}
