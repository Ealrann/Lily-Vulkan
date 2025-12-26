package org.sheepy.vulkan.model.enumeration;

public enum EBindPoint {
  GRAPHICS(0),
  COMPUTE(1);

  private final int value;

  EBindPoint(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
