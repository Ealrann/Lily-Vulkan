package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapchainConfigurationImpl;
import org.sheepy.vulkan.model.enumeration.EImageUsage;

public final class SwapchainConfigurationBuilder implements Builder {
  private int requiredSwapImageCount = 3;
  private final List<EImageUsage> swapImageUsages = new ArrayList<>();
  private boolean presentWhenVBlank = true;
  private boolean acquireWaitForVBlank = true;
  private boolean allowingAccessFromCompute = false;
  private Supplier<SwapImageAttachment> colorAttachment;

  public SwapchainConfigurationBuilder() {
  }

  @Override
  public SwapchainConfigurationBuilder requiredSwapImageCount(int requiredSwapImageCount) {
    this.requiredSwapImageCount = requiredSwapImageCount;
    return this;
  }

  @Override
  public SwapchainConfigurationBuilder addSwapImageUsage(EImageUsage swapImageUsage) {
    this.swapImageUsages.add(swapImageUsage);
    return this;
  }

  @Override
  public SwapchainConfigurationBuilder addSwapImageUsages(final List<EImageUsage> swapImageUsages) {
    this.swapImageUsages.addAll(swapImageUsages);
    return this;
  }

  @Override
  public SwapchainConfigurationBuilder presentWhenVBlank(boolean presentWhenVBlank) {
    this.presentWhenVBlank = presentWhenVBlank;
    return this;
  }

  @Override
  public SwapchainConfigurationBuilder acquireWaitForVBlank(boolean acquireWaitForVBlank) {
    this.acquireWaitForVBlank = acquireWaitForVBlank;
    return this;
  }

  @Override
  public SwapchainConfigurationBuilder allowingAccessFromCompute(
      boolean allowingAccessFromCompute) {
    this.allowingAccessFromCompute = allowingAccessFromCompute;
    return this;
  }

  @Override
  public SwapchainConfigurationBuilder colorAttachment(
      Supplier<SwapImageAttachment> colorAttachment) {
    this.colorAttachment = colorAttachment;
    return this;
  }

  @Override
  public SwapchainConfiguration build() {
    final var built = new SwapchainConfigurationImpl(presentWhenVBlank, acquireWaitForVBlank, allowingAccessFromCompute, colorAttachment.get());
    built.requiredSwapImageCount(requiredSwapImageCount);
    built.swapImageUsages().addAll(swapImageUsages);
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<SwapchainConfigurationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SwapchainConfigurationBuilder>(5, Inserters::attributeIndex).add(SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT, (builder, value) -> builder.requiredSwapImageCount((int) value)).add(SwapchainConfiguration.FeatureIDs.SWAP_IMAGE_USAGES, (builder, value) -> builder.addSwapImageUsage((EImageUsage) value)).add(SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK, (builder, value) -> builder.presentWhenVBlank((boolean) value)).add(SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK, (builder, value) -> builder.acquireWaitForVBlank((boolean) value)).add(SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE, (builder, value) -> builder.allowingAccessFromCompute((boolean) value)).build();
    private static final RelationLazyInserter<SwapchainConfigurationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SwapchainConfigurationBuilder>(1, Inserters::relationIndex).add(SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT, (builder, value) -> builder.colorAttachment((Supplier<SwapImageAttachment>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SwapchainConfiguration.FeatureIDs.REQUIRED_SWAP_IMAGE_COUNT -> 0;
        case SwapchainConfiguration.FeatureIDs.SWAP_IMAGE_USAGES -> 1;
        case SwapchainConfiguration.FeatureIDs.PRESENT_WHENV_BLANK -> 2;
        case SwapchainConfiguration.FeatureIDs.ACQUIRE_WAIT_FORV_BLANK -> 3;
        case SwapchainConfiguration.FeatureIDs.ALLOWING_ACCESS_FROM_COMPUTE -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SwapchainConfiguration.FeatureIDs.COLOR_ATTACHMENT -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
