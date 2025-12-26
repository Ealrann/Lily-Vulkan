package org.sheepy.vulkan.model.enumeration;

public enum EPolygonMode {
  FILL(0),
  LINE(1),
  POINT(2);

  private final int value;

  EPolygonMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
