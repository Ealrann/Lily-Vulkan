package org.sheepy.vulkan.model.enumeration;

public enum EFrontFace {
  COUNTER_CLOCKWISE(0),
  CLOCKWISE(1);

  private final int value;

  EFrontFace(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
