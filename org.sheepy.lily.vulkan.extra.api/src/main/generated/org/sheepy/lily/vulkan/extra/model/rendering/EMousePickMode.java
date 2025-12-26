package org.sheepy.lily.vulkan.extra.model.rendering;

public enum EMousePickMode {
  Enabled(0),
  Lock(1),
  Disabled(2);

  private final int value;

  EMousePickMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
