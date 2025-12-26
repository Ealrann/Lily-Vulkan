package org.sheepy.lily.vulkan.extra.model.rendering;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.RenderProxyConstantBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface RenderProxyConstantBuffer extends ConstantBuffer {
  static Builder builder() {
    return new RenderProxyConstantBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ConstantBuffer constantBuffer();
  int partIndex();
  void constantBuffer(final ConstantBuffer constantBuffer);
  void partIndex(final int partIndex);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DATA = ConstantBuffer.FeatureIDs.DATA;
    int CONSTANT_BUFFER = -747953404;
    int PART_INDEX = -1686500705;
  }

  interface Features<T extends Features<T>> extends ConstantBuffer.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, ConstantBuffer.Features<?>> DATA = ConstantBuffer.Features.DATA;
    Relation<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>> CONSTANT_BUFFER = new RelationBuilder<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>>().name("constantBuffer").mandatory(true).id(RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER).build();
    Attribute<Integer, Integer, IntListener, Features<?>> PART_INDEX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("partIndex").mandatory(true).id(RenderProxyConstantBuffer.FeatureIDs.PART_INDEX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DATA, CONSTANT_BUFFER, PART_INDEX);
  }

  interface Builder extends IFeaturedObject.Builder<RenderProxyConstantBuffer> {
    Builder name(String name);
    Builder data(ByteBuffer data);
    Builder constantBuffer(Supplier<ConstantBuffer> constantBuffer);
    Builder partIndex(int partIndex);
  }
}
