package org.sheepy.vulkan.model.enumeration;

public enum EDynamicState {
  VIEWPORT(0),
  SCISSOR(1),
  LINE_WIDTH(2),
  DEPTH_BIAS(3),
  BLEND_CONSTANTS(4),
  DEPTH_BOUNDS(5),
  STENCIL_COMPARE_MASK(6),
  STENCIL_WRITE_MASK(7),
  STENCIL_REFERENCE(8);

  private final int value;

  EDynamicState(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
