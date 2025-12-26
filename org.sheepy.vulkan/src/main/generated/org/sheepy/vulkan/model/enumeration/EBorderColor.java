package org.sheepy.vulkan.model.enumeration;

public enum EBorderColor {
  FLOAT_TRANSPARENT_BLACK(0),
  INT_TRANSPARENT_BLACK(1),
  FLOAT_OPAQUE_BLACK(2),
  INT_OPAQUE_BLACK(3),
  FLOAT_OPAQUE_WHITE(4),
  INT_OPAQUE_WHITE(5);

  private final int value;

  EBorderColor(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
