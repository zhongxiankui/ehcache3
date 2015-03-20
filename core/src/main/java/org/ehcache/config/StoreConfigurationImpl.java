/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehcache.config;

import org.ehcache.expiry.Expiry;
import org.ehcache.spi.cache.Store;

/**
 *
 * @author Chris Dennis
 */
public class StoreConfigurationImpl<K, V> implements Store.Configuration<K, V> {
  
  private final Class<K> keyType;
  private final Class<V> valueType;
  private final Comparable<Long> capacityConstraint;
  private final EvictionVeto<? super K, ? super V> evictionVeto;
  private final EvictionPrioritizer<? super K, ? super V> evictionPrioritizer;
  private final ClassLoader classLoader;
  private final Expiry<? super K, ? super V> expiry;
  private final ResourcePools resourcePools;

  public StoreConfigurationImpl(CacheConfiguration<K, V> cacheConfig) {
    this(cacheConfig.getKeyType(), cacheConfig.getValueType(), cacheConfig.getCapacityConstraint(),
            cacheConfig.getEvictionVeto(), cacheConfig.getEvictionPrioritizer(), cacheConfig.getClassLoader(),
        cacheConfig.getExpiry(), cacheConfig.getResourcePools());
  }

  public StoreConfigurationImpl(Class<K> keyType, Class<V> valueType, Comparable<Long> capacityConstraint,
          EvictionVeto<? super K, ? super V> evictionVeto, EvictionPrioritizer<? super K, ? super V> evictionPrioritizer,
          ClassLoader classLoader, Expiry<? super K, ? super V> expiry, ResourcePools resourcePools) {
    this.keyType = keyType;
    this.valueType = valueType;
    this.capacityConstraint = capacityConstraint;
    this.evictionVeto = evictionVeto;
    this.evictionPrioritizer = evictionPrioritizer;
    this.classLoader = classLoader;
    this.expiry = expiry;
    this.resourcePools = resourcePools;
  }

  @Override
  public Class<K> getKeyType() {
    return keyType;
  }

  @Override
  public Class<V> getValueType() {
    return valueType;
  }

  @Override
  public Comparable<Long> getCapacityConstraint() {
    return capacityConstraint;
  }

  @Override
  public EvictionVeto<? super K, ? super V> getEvictionVeto() {
    return evictionVeto;
  }

  @Override
  public EvictionPrioritizer<? super K, ? super V> getEvictionPrioritizer() {
    return evictionPrioritizer;
  }

  @Override
  public ClassLoader getClassLoader() {
    return this.classLoader;
  }
  
  @Override
  public Expiry<? super K, ? super V> getExpiry() {
    return expiry;
  }

  @Override
  public ResourcePools getResourcePools() {
    return resourcePools;
  }
}
