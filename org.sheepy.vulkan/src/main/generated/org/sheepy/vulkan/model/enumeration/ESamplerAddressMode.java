package org.sheepy.vulkan.model.enumeration;

public enum ESamplerAddressMode {
  REPEAT(0),
  MIRRORED_REPEAT(1),
  CLAMP_TO_EDGE(2),
  CLAMP_TO_BORDER(3);

  private final int value;

  ESamplerAddressMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
