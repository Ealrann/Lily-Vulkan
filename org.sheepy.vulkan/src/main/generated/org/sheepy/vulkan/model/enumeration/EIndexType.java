package org.sheepy.vulkan.model.enumeration;

public enum EIndexType {
  UINT16(0),
  UINT32(1);

  private final int value;

  EIndexType(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
