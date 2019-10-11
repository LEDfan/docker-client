/*-
 * -\-\-
 * docker-client
 * --
 * Copyright (C) 2016 Spotify AB
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

package com.spotify.docker.client.messages.swarm;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

import java.util.List;
import javax.annotation.Nullable;

@AutoValue
@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, setterVisibility = NONE)
public abstract class TaskSpec {

  @Nullable
  @JsonProperty("ContainerSpec")
  public abstract ContainerSpec containerSpec();

  @Nullable
  @JsonProperty("Resources")
  public abstract ResourceRequirements resources();

  @Nullable
  @JsonProperty("RestartPolicy")
  public abstract RestartPolicy restartPolicy();

  @Nullable
  @JsonProperty("Placement")
  public abstract Placement placement();

  @Nullable
  @JsonProperty("Networks")
  public abstract ImmutableList<NetworkAttachmentConfig> networks();

  @Nullable
  @JsonProperty("LogDriver")
  public abstract Driver logDriver();

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder containerSpec(ContainerSpec containerSpec);

    public abstract Builder resources(ResourceRequirements resources);

    public abstract Builder restartPolicy(RestartPolicy restartPolicy);

    public abstract Builder placement(Placement placement);

    public abstract Builder networks(NetworkAttachmentConfig... networks);

    public abstract Builder networks(List<NetworkAttachmentConfig> networks);

    public abstract Builder logDriver(Driver logDriver);

    public abstract TaskSpec build();
  }

  public static TaskSpec.Builder builder() {
    return new AutoValue_TaskSpec.Builder();
  }

  @JsonCreator
  static TaskSpec create(
      @JsonProperty("ContainerSpec") final ContainerSpec containerSpec,
      @JsonProperty("Resources") final ResourceRequirements resources,
      @JsonProperty("RestartPolicy") final RestartPolicy restartPolicy,
      @JsonProperty("Placement") final Placement placement,
      @JsonProperty("Networks") final List<NetworkAttachmentConfig> networks,
      @JsonProperty("LogDriver") final Driver logDriver) {
    return builder()
        .containerSpec(containerSpec)
        .resources(resources)
        .restartPolicy(restartPolicy)
        .placement(placement)
        .logDriver(logDriver)
        .networks(networks)
        .build();
  }
}
