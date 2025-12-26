package org.sheepy.vulkan.model.enumeration;

public enum EPrimitiveTopology {
  POINT_LIST(0),
  LINE_LIST(1),
  LINE_STRIP(2),
  TRIANGLE_LIST(3),
  TRIANGLE_STRIP(4),
  TRIANGLE_FAN(5),
  LINE_LIST_WITH_ADJACENCY(6),
  LINE_STRIP_WITH_ADJACENCY(7),
  TRIANGLE_LIST_WITH_ADJACENCY(8),
  TRIANGLE_STRIP_WITH_ADJACENCY(9),
  PATCH_LIST(10);

  private final int value;

  EPrimitiveTopology(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
