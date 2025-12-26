package org.sheepy.lily.vulkan.model.vulkanresource;

public enum EContextIndex {
  ContextInstance(0),
  ContextInstance_PlusOne(1),
  ContextInstance_MinusOne(2);

  private final int value;

  EContextIndex(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
