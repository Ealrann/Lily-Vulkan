package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferReferenceBuilder;

public interface BufferReference extends LMObject {
  static Builder builder() {
    return new BufferReferenceBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IBuffer> buffers();
  int stride();
  EContextIndex indexType();
  void stride(final int stride);
  void indexType(final EContextIndex indexType);

  interface FeatureIDs {
    int BUFFERS = -1880058855;
    int STRIDE = 2088053299;
    int INDEX_TYPE = 575648146;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IBuffer, List<IBuffer>, Listener<List<IBuffer>>, Features<?>> BUFFERS = new RelationBuilder<IBuffer, List<IBuffer>, Listener<List<IBuffer>>, Features<?>>().name("buffers").many(true).id(BufferReference.FeatureIDs.BUFFERS).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    Attribute<Integer, Integer, IntListener, Features<?>> STRIDE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("stride").defaultValue("0").id(BufferReference.FeatureIDs.STRIDE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<EContextIndex, EContextIndex, Listener<EContextIndex>, Features<?>> INDEX_TYPE = new AttributeBuilder<EContextIndex, EContextIndex, Listener<EContextIndex>, Features<?>>().name("indexType").mandatory(true).id(BufferReference.FeatureIDs.INDEX_TYPE).datatype(() -> VulkanResourceModelDefinition.Enums.E_CONTEXT_INDEX).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(BUFFERS, STRIDE, INDEX_TYPE);
  }

  interface Builder extends IFeaturedObject.Builder<BufferReference> {
    Builder addBuffer(Supplier<IBuffer> buffer);
    Builder stride(int stride);
    Builder indexType(EContextIndex indexType);
    Builder addBuffers(List<IBuffer> buffers);
  }
}
