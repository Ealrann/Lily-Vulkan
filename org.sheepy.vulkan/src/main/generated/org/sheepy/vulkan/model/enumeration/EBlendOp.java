package org.sheepy.vulkan.model.enumeration;

public enum EBlendOp {
  ADD(0),
  SUBTRACT(1),
  REVERSE_SUBTRACT(2),
  MIN(3),
  MAX(4);

  private final int value;

  EBlendOp(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
