package org.sheepy.vulkan.model.enumeration;

public enum ECullMode {
  NONE(0),
  FRONT_BIT(1),
  BACK_BIT(2),
  FRONT_AND_BACK(3);

  private final int value;

  ECullMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
