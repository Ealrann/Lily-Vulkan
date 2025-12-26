package org.sheepy.lily.vulkan.extra.model.rendering;

public enum EPhysicalEntityFeature {
  Location(0);

  private final int value;

  EPhysicalEntityFeature(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
