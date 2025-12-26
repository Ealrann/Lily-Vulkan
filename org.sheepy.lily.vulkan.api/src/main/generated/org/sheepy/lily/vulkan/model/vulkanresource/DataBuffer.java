package org.sheepy.lily.vulkan.model.vulkanresource;

import java.nio.ByteBuffer;
import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.DataBufferBuilder;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public interface DataBuffer extends IBuffer {
  static Builder builder() {
    return new DataBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ByteBuffer data();
  void data(final ByteBuffer data);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int USAGES = IBuffer.FeatureIDs.USAGES;
    int DATA = 258654991;
  }

  interface Features<T extends Features<T>> extends IBuffer.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, IBuffer.Features<?>> USAGES = IBuffer.Features.USAGES;
    Attribute<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, Features<?>> DATA = new AttributeBuilder<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, Features<?>>().name("data").id(DataBuffer.FeatureIDs.DATA).datatype(() -> VulkanResourceModelDefinition.JavaWrappers.BYTE_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, USAGES, DATA);
  }

  interface Builder extends IFeaturedObject.Builder<DataBuffer> {
    Builder name(String name);
    Builder addUsage(EBufferUsage usage);
    Builder data(ByteBuffer data);
    Builder addUsages(List<EBufferUsage> usages);
  }
}
