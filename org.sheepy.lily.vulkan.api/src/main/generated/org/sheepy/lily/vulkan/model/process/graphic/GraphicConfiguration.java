package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.ProcessConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicConfigurationBuilder;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface GraphicConfiguration extends ProcessConfiguration {
  static Builder builder() {
    return new GraphicConfigurationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  SwapchainConfiguration swapchainConfiguration();
  FramebufferConfiguration framebufferConfiguration();
  EPipelineStage acquireWaitStage();
  PhysicalSurface surface();
  RenderPass renderPass();
  ImageViews imageViews();
  void swapchainConfiguration(final SwapchainConfiguration swapchainConfiguration);
  void framebufferConfiguration(final FramebufferConfiguration framebufferConfiguration);
  void acquireWaitStage(final EPipelineStage acquireWaitStage);
  void surface(final PhysicalSurface surface);
  void renderPass(final RenderPass renderPass);
  void imageViews(final ImageViews imageViews);

  interface FeatureIDs {
    int SWAPCHAIN_CONFIGURATION = -1922732307;
    int FRAMEBUFFER_CONFIGURATION = 829906222;
    int ACQUIRE_WAIT_STAGE = -640971144;
    int SURFACE = -721329432;
    int RENDER_PASS = 1913780908;
    int IMAGE_VIEWS = -731595336;
  }

  interface Features<T extends Features<T>> extends ProcessConfiguration.Features<T> {
    Relation<SwapchainConfiguration, SwapchainConfiguration, Listener<SwapchainConfiguration>, Features<?>> SWAPCHAIN_CONFIGURATION = new RelationBuilder<SwapchainConfiguration, SwapchainConfiguration, Listener<SwapchainConfiguration>, Features<?>>().name("swapchainConfiguration").mandatory(true).contains(true).id(GraphicConfiguration.FeatureIDs.SWAPCHAIN_CONFIGURATION).concept(() -> GraphicModelDefinition.Groups.SWAPCHAIN_CONFIGURATION).build();
    Relation<FramebufferConfiguration, FramebufferConfiguration, Listener<FramebufferConfiguration>, Features<?>> FRAMEBUFFER_CONFIGURATION = new RelationBuilder<FramebufferConfiguration, FramebufferConfiguration, Listener<FramebufferConfiguration>, Features<?>>().name("framebufferConfiguration").mandatory(true).contains(true).id(GraphicConfiguration.FeatureIDs.FRAMEBUFFER_CONFIGURATION).concept(() -> GraphicModelDefinition.Groups.FRAMEBUFFER_CONFIGURATION).build();
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> ACQUIRE_WAIT_STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("acquireWaitStage").defaultValue("COLOR_ATTACHMENT_OUTPUT_BIT").id(GraphicConfiguration.FeatureIDs.ACQUIRE_WAIT_STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Relation<PhysicalSurface, PhysicalSurface, Listener<PhysicalSurface>, Features<?>> SURFACE = new RelationBuilder<PhysicalSurface, PhysicalSurface, Listener<PhysicalSurface>, Features<?>>().name("surface").mandatory(true).contains(true).id(GraphicConfiguration.FeatureIDs.SURFACE).concept(() -> GraphicModelDefinition.Groups.PHYSICAL_SURFACE).build();
    Relation<RenderPass, RenderPass, Listener<RenderPass>, Features<?>> RENDER_PASS = new RelationBuilder<RenderPass, RenderPass, Listener<RenderPass>, Features<?>>().name("renderPass").mandatory(true).contains(true).id(GraphicConfiguration.FeatureIDs.RENDER_PASS).concept(() -> GraphicModelDefinition.Groups.RENDER_PASS).build();
    Relation<ImageViews, ImageViews, Listener<ImageViews>, Features<?>> IMAGE_VIEWS = new RelationBuilder<ImageViews, ImageViews, Listener<ImageViews>, Features<?>>().name("imageViews").contains(true).id(GraphicConfiguration.FeatureIDs.IMAGE_VIEWS).concept(() -> GraphicModelDefinition.Groups.IMAGE_VIEWS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(SWAPCHAIN_CONFIGURATION, FRAMEBUFFER_CONFIGURATION, ACQUIRE_WAIT_STAGE, SURFACE, RENDER_PASS, IMAGE_VIEWS);
  }

  interface Builder extends IFeaturedObject.Builder<GraphicConfiguration> {
    Builder swapchainConfiguration(Supplier<SwapchainConfiguration> swapchainConfiguration);
    Builder framebufferConfiguration(Supplier<FramebufferConfiguration> framebufferConfiguration);
    Builder acquireWaitStage(EPipelineStage acquireWaitStage);
    Builder surface(Supplier<PhysicalSurface> surface);
    Builder renderPass(Supplier<RenderPass> renderPass);
    Builder imageViews(Supplier<ImageViews> imageViews);
  }
}
