package org.sheepy.lily.vulkan.model.vulkanresource;

public enum EFlushMode {
  PUSH(0),
  FETCH(1);

  private final int value;

  EFlushMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
