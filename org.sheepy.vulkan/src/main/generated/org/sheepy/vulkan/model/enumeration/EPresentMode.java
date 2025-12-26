package org.sheepy.vulkan.model.enumeration;

public enum EPresentMode {
  IMMEDIATE(0),
  MAIL_BOX(1),
  FIFO(2),
  FIFO_RELAXED(3);

  private final int value;

  EPresentMode(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
