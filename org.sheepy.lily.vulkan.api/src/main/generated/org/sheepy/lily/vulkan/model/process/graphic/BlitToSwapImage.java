package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector3ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BlitToSwapImageBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.vulkan.model.enumeration.EFilter;

public interface BlitToSwapImage extends AbstractBlitTask {
  static Builder builder() {
    return new BlitToSwapImageBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int FILTER = AbstractBlitTask.FeatureIDs.FILTER;
    int CLEAR_COLOR = AbstractBlitTask.FeatureIDs.CLEAR_COLOR;
    int SRC_IMAGE = AbstractBlitTask.FeatureIDs.SRC_IMAGE;
  }

  interface Features<T extends Features<T>> extends AbstractBlitTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<EFilter, EFilter, Listener<EFilter>, AbstractBlitTask.Features<?>> FILTER = AbstractBlitTask.Features.FILTER;
    Attribute<Vector3ic, Vector3ic, Listener<Vector3ic>, AbstractBlitTask.Features<?>> CLEAR_COLOR = AbstractBlitTask.Features.CLEAR_COLOR;
    Relation<IVulkanImage, IVulkanImage, Listener<IVulkanImage>, AbstractBlitTask.Features<?>> SRC_IMAGE = AbstractBlitTask.Features.SRC_IMAGE;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, FILTER, CLEAR_COLOR, SRC_IMAGE);
  }

  interface Builder extends IFeaturedObject.Builder<BlitToSwapImage> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder filter(EFilter filter);
    Builder clearColor(Vector3ic clearColor);
    Builder srcImage(Supplier<IVulkanImage> srcImage);
  }
}
