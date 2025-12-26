package org.sheepy.vulkan.model.enumeration;

public enum EMemoryProperty {
  DEVICE_LOCAL_BIT(1),
  HOST_VISIBLE_BIT(2),
  HOST_COHERENT_BIT(4),
  HOST_CACHED_BIT(8),
  LAZILY_ALLOCATED_BIT(16);

  private final int value;

  EMemoryProperty(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
