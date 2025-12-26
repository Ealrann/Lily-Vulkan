package org.sheepy.lily.vulkan.extra.model.rendering;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.MousePickConstantsBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

public interface MousePickConstants extends ConstantBuffer {
  static Builder builder() {
    return new MousePickConstantsBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  MousePickExtension mousePickExtension();
  void mousePickExtension(final MousePickExtension mousePickExtension);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DATA = ConstantBuffer.FeatureIDs.DATA;
    int MOUSE_PICK_EXTENSION = 675625192;
  }

  interface Features<T extends Features<T>> extends ConstantBuffer.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ByteBuffer, ByteBuffer, Listener<ByteBuffer>, ConstantBuffer.Features<?>> DATA = ConstantBuffer.Features.DATA;
    Relation<MousePickExtension, MousePickExtension, Listener<MousePickExtension>, Features<?>> MOUSE_PICK_EXTENSION = new RelationBuilder<MousePickExtension, MousePickExtension, Listener<MousePickExtension>, Features<?>>().name("mousePickExtension").mandatory(true).id(MousePickConstants.FeatureIDs.MOUSE_PICK_EXTENSION).concept(() -> RenderingModelDefinition.Groups.MOUSE_PICK_EXTENSION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DATA, MOUSE_PICK_EXTENSION);
  }

  interface Builder extends IFeaturedObject.Builder<MousePickConstants> {
    Builder name(String name);
    Builder data(ByteBuffer data);
    Builder mousePickExtension(Supplier<MousePickExtension> mousePickExtension);
  }
}
