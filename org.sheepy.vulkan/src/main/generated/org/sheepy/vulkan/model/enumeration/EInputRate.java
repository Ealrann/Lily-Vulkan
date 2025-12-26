package org.sheepy.vulkan.model.enumeration;

public enum EInputRate {
  VERTEX(0),
  INSTANCE(1);

  private final int value;

  EInputRate(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
