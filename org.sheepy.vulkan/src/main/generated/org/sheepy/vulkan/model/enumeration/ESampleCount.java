package org.sheepy.vulkan.model.enumeration;

public enum ESampleCount {
  SAMPLE_COUNT_1_BIT(1),
  SAMPLE_COUNT_2_BIT(2),
  SAMPLE_COUNT_4_BIT(4),
  SAMPLE_COUNT_8_BIT(8),
  SAMPLE_COUNT_16_BIT(16),
  SAMPLE_COUNT_32_BIT(32),
  SAMPLE_COUNT_64_BIT(64);

  private final int value;

  ESampleCount(final int value) {
    this.value = value;
  }

  public int value() {
    return value;
  }
}
