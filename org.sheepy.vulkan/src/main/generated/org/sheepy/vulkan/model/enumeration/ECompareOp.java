package org.sheepy.vulkan.model.enumeration;

public enum ECompareOp {
  NEVER(0),
  LESS(1),
  EQUAL(2),
  LESS_OR_EQUAL(3),
  GREATER(4),
  NOT_EQUAL(5),
  GREATER_OR_EQUAL(6),
  ALWAYS(7);

  private final int value;

  ECompareOp(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
