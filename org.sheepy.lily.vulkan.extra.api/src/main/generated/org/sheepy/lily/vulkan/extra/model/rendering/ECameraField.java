package org.sheepy.lily.vulkan.extra.model.rendering;

public enum ECameraField {
  ZNear(0),
  ZFar(1),
  FieldOfViewX(2),
  FieldOfViewY(3);

  private final int value;

  ECameraField(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
