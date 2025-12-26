package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.VertexBindingBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface VertexBinding extends LMObject {
  static Builder builder() {
    return new VertexBindingBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IBuffer buffer();
  void buffer(final IBuffer buffer);

  interface FeatureIDs {
    int BUFFER = 609654624;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IBuffer, IBuffer, Listener<IBuffer>, Features<?>> BUFFER = new RelationBuilder<IBuffer, IBuffer, Listener<IBuffer>, Features<?>>().name("buffer").id(VertexBinding.FeatureIDs.BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<VertexBinding> {
    Builder buffer(Supplier<IBuffer> buffer);
  }
}
