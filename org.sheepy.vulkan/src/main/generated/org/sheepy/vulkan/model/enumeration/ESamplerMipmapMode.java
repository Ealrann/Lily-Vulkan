package org.sheepy.vulkan.model.enumeration;

public enum ESamplerMipmapMode {
  NEAREST(0),
  LINEAR(1);

  private final int value;

  ESamplerMipmapMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
