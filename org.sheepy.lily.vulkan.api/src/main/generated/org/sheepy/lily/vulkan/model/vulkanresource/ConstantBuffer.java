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
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ConstantBufferBuilder;

public interface ConstantBuffer extends IVulkanResource {
  static Builder builder() {
    return new ConstantBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ByteBuffer data();
  void data(final ByteBuffer data);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DATA = 1416047701;
  }

  interface Features<T extends Features<T>> extends IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, Features<?>> DATA = new AttributeBuilder<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, Features<?>>().name("data").id(ConstantBuffer.FeatureIDs.DATA).datatype(() -> VulkanResourceModelDefinition.JavaWrappers.BYTE_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DATA);
  }

  interface Builder extends IFeaturedObject.Builder<ConstantBuffer> {
    Builder name(String name);
    Builder data(ByteBuffer data);
  }
}
