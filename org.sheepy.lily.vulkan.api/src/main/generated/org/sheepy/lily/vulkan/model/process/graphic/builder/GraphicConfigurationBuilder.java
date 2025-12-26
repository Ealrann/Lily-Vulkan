package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicConfigurationImpl;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class GraphicConfigurationBuilder implements Builder {
  private Supplier<SwapchainConfiguration> swapchainConfiguration;
  private Supplier<FramebufferConfiguration> framebufferConfiguration;
  private EPipelineStage acquireWaitStage = EPipelineStage.COLOR_ATTACHMENT_OUTPUT_BIT;
  private Supplier<PhysicalSurface> surface;
  private Supplier<RenderPass> renderPass;
  private Supplier<ImageViews> imageViews = () -> null;

  public GraphicConfigurationBuilder() {
  }

  @Override
  public GraphicConfigurationBuilder swapchainConfiguration(
      Supplier<SwapchainConfiguration> swapchainConfiguration) {
    this.swapchainConfiguration = swapchainConfiguration;
    return this;
  }

  @Override
  public GraphicConfigurationBuilder framebufferConfiguration(
      Supplier<FramebufferConfiguration> framebufferConfiguration) {
    this.framebufferConfiguration = framebufferConfiguration;
    return this;
  }

  @Override
  public GraphicConfigurationBuilder acquireWaitStage(EPipelineStage acquireWaitStage) {
    this.acquireWaitStage = acquireWaitStage;
    return this;
  }

  @Override
  public GraphicConfigurationBuilder surface(Supplier<PhysicalSurface> surface) {
    this.surface = surface;
    return this;
  }

  @Override
  public GraphicConfigurationBuilder renderPass(Supplier<RenderPass> renderPass) {
    this.renderPass = renderPass;
    return this;
  }

  @Override
  public GraphicConfigurationBuilder imageViews(Supplier<ImageViews> imageViews) {
    this.imageViews = imageViews;
    return this;
  }

  @Override
  public GraphicConfiguration build() {
    final var built = new GraphicConfigurationImpl(swapchainConfiguration.get(), framebufferConfiguration.get(), surface.get(), renderPass.get());
    built.acquireWaitStage(acquireWaitStage);
    built.imageViews(imageViews.get());
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
    private static final FeatureInserter<GraphicConfigurationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GraphicConfigurationBuilder>(1, Inserters::attributeIndex).add(GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE, (builder, value) -> builder.acquireWaitStage((EPipelineStage) value)).build();
    private static final RelationLazyInserter<GraphicConfigurationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GraphicConfigurationBuilder>(5, Inserters::relationIndex).add(GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION, (builder, value) -> builder.swapchainConfiguration((Supplier<SwapchainConfiguration>) value)).add(GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION, (builder, value) -> builder.framebufferConfiguration((Supplier<FramebufferConfiguration>) value)).add(GraphicConfiguration.FeatureIDs.SURFACE, (builder, value) -> builder.surface((Supplier<PhysicalSurface>) value)).add(GraphicConfiguration.FeatureIDs.RENDER_PASS, (builder, value) -> builder.renderPass((Supplier<RenderPass>) value)).add(GraphicConfiguration.FeatureIDs.IMAGE_VIEWS, (builder, value) -> builder.imageViews((Supplier<ImageViews>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION -> 0;
        case GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION -> 1;
        case GraphicConfiguration.FeatureIDs.SURFACE -> 2;
        case GraphicConfiguration.FeatureIDs.RENDER_PASS -> 3;
        case GraphicConfiguration.FeatureIDs.IMAGE_VIEWS -> 4;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
