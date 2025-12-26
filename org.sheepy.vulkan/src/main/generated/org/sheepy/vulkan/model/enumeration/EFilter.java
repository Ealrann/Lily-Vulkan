package org.sheepy.vulkan.model.enumeration;

public enum EFilter {
  NEAREST(0),
  LINEAR(1);

  private final int value;

  EFilter(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
